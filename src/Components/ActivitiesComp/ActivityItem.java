/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.ActivitiesComp;

import Components.Button;
import Main.Activity;
import Main.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Atahan
 */
public class ActivityItem extends javax.swing.JPanel {
    
    private Activity activity;
    private User user;
    
    /**
     * Creates new form activityItem
     */
    public ActivityItem() {
        initComponents();
        
        joinBtn.setBgColor(Button.RED);
        joinBtn.setColorClicked(new Color(155, 2, 17));
        joinBtn.setTextColor(Color.WHITE);
        this.description.setText("<html><p style=\"width:400px\">"+description.getText()+"</p></html>");
    }
    
    public ActivityItem(Activity activity, User user) {
        initComponents();
        
        this.activity = activity;
        this.user = user;
        
        joinBtn.setBgColor(Button.RED);
        joinBtn.setColorClicked(new Color(155, 2, 17));
        joinBtn.setTextColor(Color.WHITE);
        
        this.title.setText(activity.getTitle());
        this.description.setText("<html><p style=\"width:400px\">"+activity.getDescription()+"</p></html>");
        this.creatorName.setText(activity.getCreator().getDisplayName());
        this.activityTime.setText(activity.getStartDate().toString());
        setQuotaDisplay();
        setTitleIcon(activity.isPublic());
    }

    private void setQuotaDisplay(){
        this.quota.setText("Quota: " + activity.getAttendence() + "/" + activity.getQuota());
    }
    
    private void setTitleIcon(boolean isPublic){
        if (isPublic) {
            title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/public.png")));
        }
        else{
            title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/private.png")));
        }
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
        title = new javax.swing.JLabel();
        creatorName = new javax.swing.JLabel();
        timeDesc = new javax.swing.JLabel();
        activityTime = new javax.swing.JLabel();
        joinBtn = new Components.Button();
        quota = new javax.swing.JLabel();
        profilePic = new Components.ImageAvatar();
        roundedPanel2 = new Components.RoundedPanel();
        description = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(2000, 2000));
        setMinimumSize(new java.awt.Dimension(985, 240));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(985, 240));
        setLayout(new java.awt.BorderLayout());

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setMaximumSize(new java.awt.Dimension(985, 240));
        roundedPanel1.setMinimumSize(new java.awt.Dimension(985, 240));
        roundedPanel1.setPreferredSize(new java.awt.Dimension(985, 240));

        title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/public.png"))); // NOI18N
        title.setText("Title of Activity");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        title.setIconTextGap(16);

        creatorName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        creatorName.setForeground(new java.awt.Color(51, 51, 51));
        creatorName.setText("Creator's Username");

        timeDesc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        timeDesc.setForeground(new java.awt.Color(51, 51, 51));
        timeDesc.setText("Activity time:");
        timeDesc.setAlignmentX(1.0F);

        activityTime.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        activityTime.setForeground(new java.awt.Color(51, 204, 255));
        activityTime.setText("date of activity - hour");

        joinBtn.setBackground(new java.awt.Color(245, 12, 67));
        joinBtn.setForeground(new java.awt.Color(102, 102, 102));
        joinBtn.setText("JOIN");
        joinBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        joinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinBtnActionPerformed(evt);
            }
        });

        quota.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        quota.setForeground(new java.awt.Color(102, 102, 102));
        quota.setText("Quota: 1/10");

        profilePic.setBackground(new java.awt.Color(102, 102, 102));
        profilePic.setForeground(new java.awt.Color(204, 204, 204));
        profilePic.setBorderSize(2);
        profilePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profilePic.png"))); // NOI18N
        profilePic.setOpaque(true);

        roundedPanel2.setBackground(new java.awt.Color(46, 73, 154));
        roundedPanel2.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        description.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        description.setForeground(new java.awt.Color(102, 102, 102));
        description.setText("Description");
        description.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        description.setAlignmentY(0.0F);
        description.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(creatorName))
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addComponent(roundedPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                        .addComponent(quota, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(joinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeDesc, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(activityTime, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(40, 40, 40))))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(timeDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activityTime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(joinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quota))
                        .addGap(23, 23, 23))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roundedPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(creatorName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(profilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))))
        );

        add(roundedPanel1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void joinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinBtnActionPerformed
        user.joinActivity(activity);
    }//GEN-LAST:event_joinBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activityTime;
    private javax.swing.JLabel creatorName;
    private javax.swing.JLabel description;
    private Components.Button joinBtn;
    private Components.ImageAvatar profilePic;
    private javax.swing.JLabel quota;
    private Components.RoundedPanel roundedPanel1;
    private Components.RoundedPanel roundedPanel2;
    private javax.swing.JLabel timeDesc;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
