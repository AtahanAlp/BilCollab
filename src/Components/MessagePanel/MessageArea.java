package Components.MessagePanel;

import javax.swing.*;
import java.awt.*;

public class MessageArea extends JPanel {

    private JTextArea textArea;
    private JButton sendButton;
    private MessagePanel msgPanel;

    public MessageArea (MessagePanel msgPanel) {

        this.msgPanel = msgPanel;
        setLayout(new BorderLayout());

        //Initialize the actual text area
        textArea = new JTextArea ();
        textArea.setPreferredSize (new Dimension (500, 40));
        textArea.setOpaque (false);
        setBackground (new java.awt.Color (217, 217, 217));
        textArea.setForeground (Color.BLACK);
        textArea.setFont (new Font ("Arial", Font.PLAIN, 14));
        textArea.setLineWrap (true);
        textArea.setWrapStyleWord (true);
        textArea.setMargin (new Insets (10, 10, 10, 10));

        sendButton = new JButton ("Send");

        //Adding components
        JPanel inputPanel = new JPanel (new BorderLayout ());
        inputPanel.add (textArea, BorderLayout.CENTER);
        inputPanel.add (sendButton, BorderLayout.EAST);
        add (inputPanel, BorderLayout.CENTER);

        //Action listener
        sendButton.addActionListener (e -> sendMessage ("user", textArea.getText(), "date"));
        textArea.addKeyListener (new java.awt.event.KeyAdapter () {
            public void keyPressed (java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode () == java.awt.event.KeyEvent.VK_ENTER) {
                    sendMessage ("user", textArea.getText(), "date");
                    evt.consume ();
                }
            }
        });
    }

    //Method to send messages
    private void sendMessage (String sender, String content, String time) {
        Message message = new Message (sender, content, time);
        msgPanel.addMsgToDisplay (message);
        textArea.setText("");
    }
}
