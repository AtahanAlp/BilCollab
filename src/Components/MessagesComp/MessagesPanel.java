/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.MessagesComp;

import Components.RefreshablePanel;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import Components.ScrollBarUI;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 *
 * @author Atahan
 */
public class MessagesPanel extends javax.swing.JPanel implements RefreshablePanel{

    /**
     * Creates new form ActivitiesPage
     */
    public MessagesPanel() {
        initComponents();
        Chats.setLayout(new GridBagLayout());
        Chats.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ChatsScrollPane.setBorder(null);
        ChatsScrollPane.setViewportView(Chats);
        ChatsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ChatsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ChatsScrollPane.getVerticalScrollBar().setUI(new ScrollBarUI());
        ChatsScrollPane.getViewport().setBackground(new Color(255, 255, 255));
        
        addChat ("Eren");   
        addChat ("Atahan");
        addChat ("Emir");
        addChat ("Deniz");
        addChat ("Zuhal");
        
    }
    
    public void refresh(){
        //TODO
    }
    
    private void addChat (String name) {
        Chat c = new Chat (name, "e", "e", this);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        Chats.add(c, gbc);
        Chats.revalidate();
    }
    
    public void displayChat (MessagePanel m) {
        Chats.removeAll();
        if (m != null) {
            m.setBorder(BorderFactory.createLineBorder(null));
            m.setVisible(true);
            Chats.add(m);
            ChatsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        } else {
            addChat("Eren");
            addChat("Atahan");
            addChat("Emir");
            addChat("Deniz");
            addChat("Zuhal");
            ChatsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        }
        
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
        Chats = new Components.RoundedPanel();

        setBackground(new java.awt.Color(255, 204, 204));
        setMaximumSize(new java.awt.Dimension(1150, 800));
        setMinimumSize(new java.awt.Dimension(1150, 800));
        setPreferredSize(new java.awt.Dimension(1150, 800));

        ChatsScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        ChatsScrollPane.setBorder(null);

        Chats.setBackground(new java.awt.Color(255, 255, 255));
        Chats.setMaximumSize(new java.awt.Dimension(1050, 700));
        Chats.setMinimumSize(new java.awt.Dimension(1050, 700));

        javax.swing.GroupLayout ChatsLayout = new javax.swing.GroupLayout(Chats);
        Chats.setLayout(ChatsLayout);
        ChatsLayout.setHorizontalGroup(
            ChatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ChatsLayout.setVerticalGroup(
            ChatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        ChatsScrollPane.setViewportView(Chats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(ChatsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(ChatsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.RoundedPanel Chats;
    private javax.swing.JScrollPane ChatsScrollPane;
    // End of variables declaration//GEN-END:variables
}
