package Components.MessagePanel;

import javax.swing.JTextArea;

public class Message extends JTextArea {
    
    private String sender;
    private String content;
    private String time;

    public Message (String sender, String content, String time) {

        this.sender = sender;
        this.content = content;
        this.time = time;

        //Sets the colors of the message according to who sent it
        if (this.sender.equals ("user")) {
            this.setBackground (new java.awt.Color(245, 12, 67));
            this.setForeground (new java.awt.Color(255, 255, 255));
        } else {
            this.setBackground (new java.awt.Color(217, 217, 217));
            this.setForeground (new java.awt.Color(0, 0, 0));
        }

        this.setText (this.content);

    }

    public String getContent () {
        return this.content;
    }

    public String getSender () {
        return this.sender;
    }

}
