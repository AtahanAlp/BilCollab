package Components.MessagesComp;

import Main.DatabaseConnection;
import Main.User;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import javax.swing.JPanel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author aeren
 */
public class Chat extends JPanel {

    private int unseenMessages;
    private MessagesPanel messagesPanel;
    
    public Chat (User friend, String pfp, String message, MessagesPanel m) {
        initComponents();
        this.messagesPanel = m;
        
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                m.updateDisplay(new MessagePanel(m, friend));
                
            }
        });
        
        jLabel2.setText("Last sent message");
        jLabel3.setText(friend.getDisplayName());
        repaint();
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        
        int width = getWidth();
        int height = getHeight();
        int arc = 30;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0, 0, 0, 40));
        g2d.fill(new RoundRectangle2D.Double(2, 2, width, height, arc, arc));

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arc, arc));

        g2d.dispose();
    }

/*    
    private void loadLastMessage(int friendID) {
        
        String lastSentMessage = "";
        
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT message_text FROM messages WHERE (sender_id = ? AND receiver_id = ?) OR (sender_id = ? AND receiver_id = ?) ORDER BY sent_at DESC LIMIT 1";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, messagesPanel.getCurrentUser().getId());
                stmt.setInt(2, friendID);
                stmt.setInt(3, friendID);
                stmt.setInt(4, messagesPanel.getCurrentUser().getId());

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    lastSentMessage = rs.getString("message_text");
                    jLabel2.setText(lastSentMessage);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imageAvatar1 = new Components.ImageAvatar();

        setBackground(new java.awt.Color(250, 250, 250));
        setOpaque(false);

        jLabel2.setText("LAST_SENT_MESSAGE");

        jLabel3.setText("NAME");

        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profilePic.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
