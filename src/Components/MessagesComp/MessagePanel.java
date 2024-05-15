package Components.MessagesComp;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import Components.ScrollBarUI;
import Main.User;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import Main.DatabaseConnection;

/**
 *
 * @author aeren
 */
public class MessagePanel extends javax.swing.JPanel {

    private int messageCount = 0;
    private MessagesPanel m;
    private User friend;
    private User currentUser;
    private List<Message> messages = new ArrayList<>();
    
    public MessagePanel(MessagesPanel m, User friend) {
        this.m = m;
        this.friend = friend;
        this.currentUser = m.getAppFrame().getCurrentUser();
        setLayout (new BorderLayout ());
        initComponents();
        initMessageArea ();
        
        MessageArea.setBorder(null);
        MessageDisplayPane.setBorder(null);
        setBorder(null);
        
        MessageDisplay.setLayout(new GridBagLayout());
        MessageDisplayPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        MessageDisplayPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        MessageDisplayPane.getVerticalScrollBar().setUI(new ScrollBarUI());
        MessageDisplayPane.getViewport().setBackground(new Color(255, 255, 255));
        MessageArea.requestFocusInWindow();
        
        button1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        
        jLabel1.setText(friend.getDisplayName());
        List<Message> lastMessages = loadLastMessages(currentUser.getId(), friend.getId());
        for (Message msg : lastMessages) {
            addMsgToDisplay(msg);
        }
    }
    
    public List<Message> loadLastMessages(int currentUserID, int friendID) {
        List<Message> dbMessages = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM message WHERE (sender_id = ? AND receiver_id = ?) OR (sender_id = ? AND receiver_id = ?) ORDER BY creationDate DESC LIMIT 20";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, currentUserID);
                stmt.setInt(2, friendID);
                stmt.setInt(3, friendID);
                stmt.setInt(4, currentUserID);

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    int messageId = rs.getInt("id");
                    int senderId = rs.getInt("sender_id");
                    int receiverId = rs.getInt("receiver_id");
                    String messageText = rs.getString("content");
                    String sentAt = rs.getString("creationDate");
                    boolean isSeen = rs.getBoolean("isSeen");

                    Message message = new Message(senderId, receiverId, messageText, messageId, sentAt, isSeen);
                    dbMessages.add(message);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dbMessages;
    }
    
    public void addMsgToDisplay (Message m) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = messageCount++;

        if (m.getSenderId() == currentUser.getId()) {
            m.setBackground (Color.decode("#F50C43"));
            m.getTextArea().setForeground (Color.WHITE);
            m.getTextArea().setBackground(Color.decode("#F50C43"));
            m.getRoundedPanel().setBackground(Color.decode("#F50C43"));
            m.setTimeColor(Color.decode("#9C2947"));
            gbc.anchor = GridBagConstraints.LINE_END; 
        } else {
            m.setBackground (Color.decode("#F50C43"));
            m.getTextArea().setForeground (Color.BLACK);
            m.getTextArea().setBackground(Color.decode("#D9D9D9"));
            m.getRoundedPanel().setBackground(Color.decode("#D9D9D9"));
            gbc.anchor = GridBagConstraints.LINE_START;
        }
        
        gbc.weightx = 1.0;
        gbc.insets = new Insets(2, 2, 2, 2);
        MessageDisplay.add(m, gbc);
        
        SwingUtilities.invokeLater(() -> {
            JScrollBar verticalScrollBar = MessageDisplayPane.getVerticalScrollBar();
            verticalScrollBar.setValue(verticalScrollBar.getMaximum());
        });
    }
    
    private void initMessageArea () {
        MessageArea.setText("Enter your message here");
        
        MessageArea.addKeyListener (new java.awt.event.KeyAdapter () {
            @Override
            public void keyPressed (java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode () == java.awt.event.KeyEvent.VK_ENTER) {
                    sendMessage (currentUser, friend, MessageArea.getText());
                    evt.consume ();
                }
            }
        });
        
        MessageArea.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (MessageArea.getText().equals("Enter your message here")) {
                    MessageArea.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (MessageArea.getText().isEmpty()) {
                    MessageArea.setText("Enter your message here");
                }
            }
        });
        
    }
    
    private void sendMessage(User sender, User receiver, String content) {

        Message message = new Message(sender.getId(), receiver.getId(), content);

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO message (id, content, creationDate, sender_id, receiver_id, isSeen) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, message.getId());
                stmt.setString(2, message.getContent());
                stmt.setString(3, message.getTime());
                stmt.setInt(4, currentUser.getId());
                stmt.setInt(5, friend.getId());
                stmt.setBoolean(6, false);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        receiver.createNotification(null);
        addMsgToDisplay(message);
        MessageArea.setText("");
        MessageDisplay.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanel1 = new Components.RoundedPanel();
        imageAvatar1 = new Components.ImageAvatar();
        button1 = new Components.Button();
        jLabel1 = new javax.swing.JLabel();
        MessageDisplayPane = new javax.swing.JScrollPane();
        MessageDisplay = new javax.swing.JPanel();
        roundedPanel2 = new Components.RoundedPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MessageArea = new javax.swing.JTextArea();
        button2 = new Components.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(900, 700));

        roundedPanel1.setBackground(new java.awt.Color(220, 220, 220));

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profilePic.png"))); // NOI18N

        button1.setBackground(new java.awt.Color(220, 220, 220));
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backArrow.png"))); // NOI18N
        button1.setBgColor(new java.awt.Color(220, 220, 220));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel1.setText("NAME");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        MessageDisplayPane.setBackground(new java.awt.Color(255, 255, 255));

        MessageDisplay.setBackground(new java.awt.Color(255, 255, 255));
        MessageDisplay.setOpaque(false);

        javax.swing.GroupLayout MessageDisplayLayout = new javax.swing.GroupLayout(MessageDisplay);
        MessageDisplay.setLayout(MessageDisplayLayout);
        MessageDisplayLayout.setHorizontalGroup(
            MessageDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 982, Short.MAX_VALUE)
        );
        MessageDisplayLayout.setVerticalGroup(
            MessageDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        MessageDisplayPane.setViewportView(MessageDisplay);

        roundedPanel2.setBackground(new java.awt.Color(220, 220, 220));

        jScrollPane2.setBorder(null);

        MessageArea.setBackground(new java.awt.Color(220, 220, 220));
        MessageArea.setColumns(20);
        MessageArea.setRows(5);
        jScrollPane2.setViewportView(MessageArea);

        button2.setBackground(new java.awt.Color(220, 220, 220));
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/up.png"))); // NOI18N
        button2.setBgColor(new java.awt.Color(220, 220, 220));
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MessageDisplayPane, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
                    .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundedPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MessageDisplayPane, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        m.updateDisplay(null);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        sendMessage (currentUser, friend, MessageArea.getText());
    }//GEN-LAST:event_button2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea MessageArea;
    private javax.swing.JPanel MessageDisplay;
    private javax.swing.JScrollPane MessageDisplayPane;
    private Components.Button button1;
    private Components.Button button2;
    private Components.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private Components.RoundedPanel roundedPanel1;
    private Components.RoundedPanel roundedPanel2;
    // End of variables declaration//GEN-END:variables
}
