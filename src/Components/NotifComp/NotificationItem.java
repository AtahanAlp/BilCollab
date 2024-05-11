/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.NotifComp;

import Components.ActivitiesComp.*;
import Components.Button;
import Main.Activity;
import Main.Notification;
import java.awt.Color;

/**
 *
 * @author Atahan
 */
public class NotificationItem extends javax.swing.JPanel {
    Notification notification;
    boolean over;
    /**
     * Creates new form activityItem
     */
    public NotificationItem() {
        initComponents();
        roundedPanel.setBackground(new Color(60, 60, 60, 0));  
        over = false;
    }
    
    public NotificationItem(Notification notification) {
        initComponents();
        roundedPanel.setBackground(new Color(60, 60, 60, 0));
        over = false;
        
        
        this.notification = notification;
        
        this.description.setText(notification.getDescription());
        this.senderName.setText(notification.getSender().getDisplayName());
    }

    public void setDescription(String str){
        this.description.setText(str);
    }
    
    public void setSender (String str){
        this.senderName.setText(str);
    }
    
    public void setTime (String str){
        this.timeLbl.setText(str);
    }
    
    public void setTimeDisplay(){
        //TODO
        this.timeLbl.setText("hellloooo");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanel = new Components.RoundedPanel();
        timeLbl = new javax.swing.JLabel();
        senderName = new javax.swing.JLabel();
        profilePic = new Components.ImageAvatar();
        description = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(2000, 2000));
        setMinimumSize(new java.awt.Dimension(420, 60));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(420, 60));
        setLayout(new java.awt.BorderLayout());

        roundedPanel.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel.setMaximumSize(new java.awt.Dimension(420, 60));
        roundedPanel.setMinimumSize(new java.awt.Dimension(420, 60));
        roundedPanel.setPreferredSize(new java.awt.Dimension(420, 60));
        roundedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                roundedPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                roundedPanelMouseExited(evt);
            }
        });

        timeLbl.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(102, 102, 102));
        timeLbl.setText("• 1h");
        timeLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        senderName.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        senderName.setForeground(new java.awt.Color(51, 51, 51));
        senderName.setText("Sender Name");

        profilePic.setBackground(new java.awt.Color(102, 102, 102));
        profilePic.setForeground(new java.awt.Color(204, 204, 204));
        profilePic.setBorderSize(2);
        profilePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profilePic.png"))); // NOI18N
        profilePic.setOpaque(true);

        description.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        description.setForeground(new java.awt.Color(51, 51, 51));
        description.setText("Type of the notification!");
        description.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout roundedPanelLayout = new javax.swing.GroupLayout(roundedPanel);
        roundedPanel.setLayout(roundedPanelLayout);
        roundedPanelLayout.setHorizontalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(senderName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(description)
                .addGap(18, 18, 18)
                .addComponent(timeLbl)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        roundedPanelLayout.setVerticalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLbl)
                    .addComponent(description)
                    .addComponent(senderName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(roundedPanel, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void roundedPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundedPanelMouseEntered
        roundedPanel.setBackground(new Color(60, 60, 60, 20));
    }//GEN-LAST:event_roundedPanelMouseEntered

    private void roundedPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundedPanelMouseExited
       roundedPanel.setBackground(new Color(60, 60, 60, 0));
    }//GEN-LAST:event_roundedPanelMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel description;
    private Components.ImageAvatar profilePic;
    private Components.RoundedPanel roundedPanel;
    private javax.swing.JLabel senderName;
    private javax.swing.JLabel timeLbl;
    // End of variables declaration//GEN-END:variables
}
