/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.ProfileComp;

import Components.AppFrame;
import Main.User;
import java.awt.Color;
<<<<<<< HEAD
=======
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
>>>>>>> 88bc71bec067f7f9dc16ee7474a5ed0cf4efcaed
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author denizcaglar
 */
public class ProfileItem extends javax.swing.JPanel {
    
    private User user;
    private String username;
  
    public ProfileItem(User user) {
        initComponents();
        setBackground(Color.WHITE);
        this.user = user;
        this.userNameLabel.setText(username);
        this.nameLabel.setText(user.getDisplayName());
<<<<<<< HEAD
        profileImage.setIcon(new ImageIcon(getClass().getResource("/icons/user.png")));
=======
        addFriend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFriendActionPerformed(e);
            }

            private void addFriendActionPerformed(ActionEvent e) {
              user.sendFriendRequest(username);
            }
        });

        // Add mouse listener to profileButton
        profileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                profileButtonMouseClicked(e);
            }

            private void profileButtonMouseClicked(MouseEvent e) {
                 ProfilePanel.switchToProfilePanel(ProfileItem.this);
            }
        });
>>>>>>> 88bc71bec067f7f9dc16ee7474a5ed0cf4efcaed
        
    }
    
     public JButton getAddFriendButton() {
        return addFriend;
    }
     public JButton getProfileButton() {
        return profileButton;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileImage = new Components.ImageAvatar();
        addFriend = new Components.Button();
        userNameLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
<<<<<<< HEAD
=======
        addFriend = new Components.Button();
        profileButton = new Components.Button();
>>>>>>> 88bc71bec067f7f9dc16ee7474a5ed0cf4efcaed

        setPreferredSize(new java.awt.Dimension(445, 217));

        addFriend.setText("ADD FRIEND");
        addFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendActionPerformed(evt);
            }
        });
        profileImage.add(addFriend);
        addFriend.setBounds(0, 10, 100, 40);

        userNameLabel.setText("jLabel1");

        nameLabel.setText("jLabel1");

<<<<<<< HEAD
=======
        addFriend.setText("button1");

        profileButton.setText("button1");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

>>>>>>> 88bc71bec067f7f9dc16ee7474a5ed0cf4efcaed
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(120, 120, 120)
=======
                .addGap(89, 89, 89)
>>>>>>> 88bc71bec067f7f9dc16ee7474a5ed0cf4efcaed
                .addComponent(userNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
<<<<<<< HEAD
                .addGap(18, 18, 18)
                .addComponent(profileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
=======
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addFriend, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
>>>>>>> 88bc71bec067f7f9dc16ee7474a5ed0cf4efcaed
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(userNameLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(profileImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addFriendActionPerformed
=======
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(userNameLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addFriend, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        ProfilePanel.switchToProfilePanel(this);
    }//GEN-LAST:event_profileButtonActionPerformed
>>>>>>> 88bc71bec067f7f9dc16ee7474a5ed0cf4efcaed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.Button addFriend;
    private javax.swing.JLabel nameLabel;
    private Components.Button profileButton;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
