package Components.MessagePanel;

import javax.swing.JFrame;

/**
 *
 * @author aeren
 */
public class MessagePanel extends javax.swing.JPanel {

    /**
     * Creates new form MessagePanel
     */
    public MessagePanel() {
        initComponents();
    }

    //Method to initialize the components
    private void initComponents() {

        messageBox = new javax.swing.JTextArea();
        MessageArea = new javax.swing.JTextField();
        MessageTitle = new javax.swing.JPanel();
        backButton = new javax.swing.JLabel();
        profilePic = new javax.swing.JLabel();
        friendName = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        messageBox.setBackground(new java.awt.Color(245, 12, 67));
        messageBox.setColumns(20);
        messageBox.setForeground(new java.awt.Color(255, 255, 255));
        messageBox.setRows(5);
        messageBox.setText("yoo what uppp");

        MessageArea.setText("Enter your message here");
        MessageArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MessageAreaActionPerformed(evt);
            }
        });

        backButton.setText("go back");

        profilePic.setText("PFP");

        friendName.setColumns(20);
        friendName.setRows(5);
        friendName.setText("your friends name");

        javax.swing.GroupLayout MessageTitleLayout = new javax.swing.GroupLayout(MessageTitle);
        MessageTitle.setLayout(MessageTitleLayout);
        MessageTitleLayout.setHorizontalGroup(
            MessageTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessageTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profilePic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(friendName, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        MessageTitleLayout.setVerticalGroup(
            MessageTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessageTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MessageTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profilePic)
                    .addGroup(MessageTitleLayout.createSequentialGroup()
                        .addComponent(friendName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(messageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MessageTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MessageArea))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MessageTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                .addComponent(messageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MessageArea, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }

    private void MessageAreaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO
    }

    // Variables declaration
    private javax.swing.JTextField MessageArea;
    private javax.swing.JPanel MessageTitle;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel profilePic;
    private javax.swing.JTextArea friendName;
    private javax.swing.JTextArea messageBox;
    // End of variables declaration

    public static void main(String[] args) {
        JFrame test = new JFrame();
        test.add (new MessagePanel());
        test.pack();
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
