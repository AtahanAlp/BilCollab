package Components.MessagesComp;

import Components.RoundedPanel;
import java.awt.Color;
import javax.swing.JTextArea;

/**
 *
 * @author aeren
 */
public class Message extends javax.swing.JPanel {

    private String content;
    private String sender;
    private String time;
    private boolean isSeen;
    
    /**
     * Creates new form Message
     */
    public Message(String sender, String content, String time) {
        initComponents();
        this.sender = sender;
        this.content = content;
        this.time = time;
        this.isSeen = false;
        MessageContent.setText (this.content);
        
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 20, 0));
        timeLabel.setText (time);
    }
    
    //Second constructor
    public Message (int messageId, int senderId, int receiverId, String messageText, String sentAt, boolean isSeen) {
        initComponents();
        
    }
    
    public String getContent () {
        return this.content;
    }

    public String getSender () {
        return this.sender;
    }
    
    public String getTime () {
        return this.time;
    }
    
    public JTextArea getTextArea () {
        return this.MessageContent;
    }
    
    public RoundedPanel getRoundedPanel () {
        return this.roundedPanel1;
    }
    
    public void setTimeColor (Color c) {
        timeLabel.setForeground(c);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        MessageContent = new javax.swing.JTextArea();
        timeLabel = new javax.swing.JLabel();

        setOpaque(false);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        MessageContent.setColumns(20);
        MessageContent.setRows(5);
        MessageContent.setText("your message here");
        MessageContent.setBorder(null);
        MessageContent.setMaximumSize(new java.awt.Dimension(232, 84));
        MessageContent.setMinimumSize(new java.awt.Dimension(232, 84));
        jScrollPane1.setViewportView(MessageContent);

        timeLabel.setForeground(new java.awt.Color(102, 102, 102));
        timeLabel.setText("jLabel1");

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(timeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea MessageContent;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.RoundedPanel roundedPanel1;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
