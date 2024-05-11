/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.MessagesComp;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 *
 * @author Atahan
 */
public class MessagesPanel extends javax.swing.JPanel {

    /**
     * Creates new form ActivitiesPage
     */
    public MessagesPanel() {
        initComponents();
        Chats.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        Chats.setVisible(true);
        Chats.setLayout(new BoxLayout(Chats, BoxLayout.Y_AXIS));
        addChat ("Eren");
    }
    
    public static void main(String[] args) {
        JFrame test = new JFrame();
        test.add (new MessagesPanel());
        test.pack();
        test.setVisible(true);
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //For testing purposes
    private void addChat (String name) {
        Chat c = new Chat (name, "e", "e", this);
        c.setMaximumSize (new Dimension (942, 171));
        c.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Chats.add (c);
        Chats.revalidate();
    }
    
    public void displayChat (MessagePanel m) {
        Chats.removeAll();
        m.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        m.setVisible(true);
        Chats.add(m);
        Chats.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChatsScrollPane = new javax.swing.JScrollPane();
        Chats = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 204, 204));
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setPreferredSize(new java.awt.Dimension(1000, 800));

        javax.swing.GroupLayout ChatsLayout = new javax.swing.GroupLayout(Chats);
        Chats.setLayout(ChatsLayout);
        ChatsLayout.setHorizontalGroup(
            ChatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
        );
        ChatsLayout.setVerticalGroup(
            ChatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
        );

        ChatsScrollPane.setViewportView(Chats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChatsScrollPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ChatsScrollPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Chats;
    private javax.swing.JScrollPane ChatsScrollPane;
    // End of variables declaration//GEN-END:variables
}
