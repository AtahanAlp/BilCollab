package Components.MessagePanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author aeren
 */
public class MessagePanel extends javax.swing.JPanel {

    // Variables declaration
    private javax.swing.JPanel MessageTitle;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel profilePic;
    private javax.swing.JTextArea friendName;
    private javax.swing.JPanel messageDisplay;
    private javax.swing.JScrollPane scrollPane;
    private MessageArea msgArea;

    //Constructor
    public MessagePanel() {
        setLayout (new BorderLayout ());
        initComponents();
    }

    //Method to initialize the components
    private void initComponents() {

        messageDisplay = new javax.swing.JPanel();
        messageDisplay.setLayout (new BoxLayout (messageDisplay, BoxLayout.Y_AXIS));
        messageDisplay.setPreferredSize (new Dimension(800, 500));
        messageDisplay.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        scrollPane = new JScrollPane(messageDisplay);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(800, 500));

        msgArea = new MessageArea (this);

        //Adding the message title area
        backButton = new javax.swing.JLabel ();
        backButton.setText ("go back");
        profilePic = new javax.swing.JLabel ();
        profilePic.setText ("PFP");
        friendName = new javax.swing.JTextArea ();
        friendName.setEditable (false);
        friendName.setFocusable (false);
        friendName.setText ("your friends name");

        MessageTitle = new javax.swing.JPanel();
        MessageTitle.setBorder (BorderFactory.createLineBorder (new Color (0,0,0), 1));
        MessageTitle.setLayout (new FlowLayout (FlowLayout.LEFT, 10, 10));

        MessageTitle.add (backButton);
        MessageTitle.add (profilePic);
        MessageTitle.add (friendName);
        //Message title area complete

        this.setPreferredSize (new Dimension (800, 600));
        setBackground (new java.awt.Color (255, 255, 255));

        add (MessageTitle, BorderLayout.NORTH);
        add (scrollPane, BorderLayout.CENTER);
        add (msgArea, BorderLayout.SOUTH);

        msgArea.requestFocusInWindow();

    }

    public void addMsgToDisplay (Message message) {

        JLabel msg = new JLabel ();

        msg.setText (message.getContent ());
        msg.setBorder (BorderFactory.createEmptyBorder(5, 5, 5, 5));
        msg.setOpaque (true);

        if (message.getSender().equals("user")) {

            msg.setForeground (Color.WHITE);
            msg.setBackground (new java.awt.Color(245, 12, 67));
            msg.setHorizontalAlignment(SwingConstants.RIGHT);
            

        } else {
            
            msg.setForeground (Color.BLACK);
            msg.setBackground (new java.awt.Color (217, 217, 217));
            msg.setHorizontalAlignment(SwingConstants.LEFT);

        }

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setValue(0);

        messageDisplay.add (msg);
        messageDisplay.add(Box.createRigidArea(new Dimension(0, 5)));
        messageDisplay.revalidate ();
    }

    public static void main(String[] args) {
        JFrame test = new JFrame();
        test.add (new MessagePanel());
        test.pack();
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
