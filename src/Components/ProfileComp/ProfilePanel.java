/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.ProfileComp;

import Components.ActivitiesComp.ActivityItem;
import Components.AppFrame;
import Components.RefreshablePanel;
import Components.ScrollBarUI;
import Components.TextCharLimit;
import Main.Activity;
import Main.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Atahan
 */
public class ProfilePanel extends javax.swing.JPanel implements RefreshablePanel {

    private User user;
    
    public ProfilePanel() {
        initComponents();
   
        searchBar.setCharLimit(50);
        searchBar.searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadSearchProfiles();
            }
        });

        searchBar.setVisible(true);
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setBorder(new EmptyBorder(0, 0, 0, 0));
        description.setBackground(new Color(0, 0, 0, 0));
        description.setDocument(new TextCharLimit(100));

        displayName.setBorder(new EmptyBorder(0, 0, 0, 0));
        displayName.setBackground(new Color(0, 0, 0, 0));
        displayName.setDocument(new TextCharLimit(20));

        searchBar.setVisible(true);

        buttonGroup.add(yourActBtn);
        buttonGroup.add(joinedActBtn);

        editBtn.radius = 12;

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.setOpaque(false);
        scrollBar.setUnitIncrement(8);
        scrollBar.setForeground(new Color(100, 160, 239));
        scrollBar.setPreferredSize(new Dimension(12, 20));
        scrollBar.setUI(new ScrollBarUI());//change later
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setViewportBorder(null);
        
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(25);
        outputProfilePanel.setLayout(layout);
        
        

    }

    public void setUser(User user) {
        this.user = user;
    }

    public void refresh() {
        setActivityCounter();
        setFriendNo();
        yourActBtn.setSelected(false);
        yourActBtn.setSelected(true);
        displayName.setText(user.getDisplayName());
        description.setText(user.setDescription());
        searchBar.setText("");
    }

    public void setActivityCounter() {
        activityNo.setText(user.getCreatedActivities().size() + "");
    }

    public void setFriendNo() {
        System.out.println(user.getId() + "");
        friendsNo.setText(user.getFriends(user.getId()).size() + "");
    }
    
    

    public void loadSearchProfiles() {
        outputProfilePanel.removeAll();
        revalidate();
        scrollPane.getVerticalScrollBar().setValue(0);

        String searchText = searchBar.getText().trim();

        ArrayList<User> foundUsers = searchUserProfiles(searchText);
        for (int i = foundUsers.size() - 1; i >= 0; i--) {
             User profile = foundUsers.get(i);
            ProfileItem profileItem = new ProfileItem(user,profile);
            outputProfilePanel.add(profileItem);
            
            boolean isFriend = user.checkFriend(profile);
            if (isFriend) 
            {
                profileItem.getProfileButton().setText("VIEW");
                profileItem.getAddFriendButton().setText("DELETE");
                
            } 
            else 
            {
                profileItem.getProfileButton().setText("CAN'T VIEW");
                profileItem.getAddFriendButton().setText("ADD FRIEND");
            }
            
        }

        setProfileCounter(foundUsers.size());

        outputProfilePanel.revalidate();
        outputProfilePanel.repaint();
    }
   public static void switchToProfilePanel(ProfileItem item) {
    AppFrame appFrame = (AppFrame) SwingUtilities.getWindowAncestor(item);
    if (appFrame != null) {
        User desiredUser = item.getReceiverUser();
        ProfilePanel desiredProfilePanel = new ProfilePanel();
        desiredProfilePanel.setUser(desiredUser);
        appFrame.switchPanels(desiredProfilePanel);
    }
    }


    private ArrayList<User> searchUserProfiles(String searchText) {

        ArrayList<User> foundUsers = new ArrayList<>();
        for (User u : User.getAllUsers()) {
            if (u.getUsername().toLowerCase().indexOf(searchText.toLowerCase()) != -1) {
                foundUsers.add(u);
            }
    }
    return foundUsers;
    }

    public void setProfileCounter(int count) {
        profileCounter.setText("Found " + count + " profiles!");
    }

    public void loadYourActivities() {
        outputPanel.removeAll();
        revalidate();
        scrollPane.getVerticalScrollBar().setValue(0);

        ArrayList<Activity> activities = user.getCreatedActivities();
        for (int i = activities.size() - 1; i >= 0; i--) {
            ActivityItem item = new ActivityItem(activities.get(i), user);
            item.joinBtn.setVisible(false);
            outputPanel.add(item);
        }
    }

    public void loadJoinedActivities() {
        outputPanel.removeAll();
        revalidate();
        scrollPane.getVerticalScrollBar().setValue(0);

        ArrayList<Activity> activities = user.getJoinedActivities();
        for (int i = activities.size() - 1; i >= 0; i--) {
            ActivityItem item = new ActivityItem(activities.get(i), user);
            item.joinBtn.setVisible(false);
            outputPanel.add(item);
        }
    }

    public void loadProfileActivities(User userProfile) {
        outputPanel.removeAll();
        revalidate();
        scrollPane.getVerticalScrollBar().setValue(0);

        ArrayList<Activity> activities = userProfile.getCreatedActivities();
        for (int i = activities.size() - 1; i >= 0; i--) {
            ActivityItem item = new ActivityItem(activities.get(i), userProfile);
            item.joinBtn.setVisible(false);
            outputPanel.add(item);
        }
    }

    public void loadProfileJoinedActivities(User userProfile) {
        outputPanel.removeAll();
        revalidate();
        scrollPane.getVerticalScrollBar().setValue(0);

        ArrayList<Activity> activities = userProfile.getJoinedActivities();
        for (int i = activities.size() - 1; i >= 0; i--) {
            ActivityItem item = new ActivityItem(activities.get(i), userProfile);
            item.joinBtn.setVisible(false);
            outputPanel.add(item);
        }
    }

    public void enableEditing() {
        displayName.setEnabled(true);
        description.setEnabled(true);
    }

    public void disableEditingAndSave() {
        displayName.setEnabled(false);
        description.setEnabled(false);
        user.setDisplayName(displayName.getText().trim());
        user.setDescription(description.getText().trim());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        imageAvatar = new Components.ImageAvatar();
        buttonPanel = new javax.swing.JPanel();
        yourActBtn = new Components.SelectionButton();
        joinedActBtn = new Components.SelectionButton();
        scrollPane = new javax.swing.JScrollPane();
        outputPanel = new javax.swing.JPanel();
        description = new javax.swing.JTextArea();
        displayName = new javax.swing.JTextField();
        username = new javax.swing.JLabel();
        activityNo = new javax.swing.JLabel();
        activitiesTxt = new javax.swing.JLabel();
        FriendsTxt = new javax.swing.JLabel();
        friendsNo = new javax.swing.JLabel();
        editBtn = new Components.SelectionButton();
        searchBar = new Components.SearchBar();
        descriptionLbl = new javax.swing.JLabel();
        profileCounter = new javax.swing.JLabel();
        outputProfilePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setBackground(new java.awt.Color(102, 255, 255));
        setMaximumSize(new java.awt.Dimension(1150, 800));
        setMinimumSize(new java.awt.Dimension(1150, 800));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1150, 800));

        imageAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profilePic.png"))); // NOI18N

        buttonPanel.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new java.awt.GridLayout(1, 0));

        yourActBtn.setForeground(new java.awt.Color(51, 51, 51));
        yourActBtn.setText("Your Activities");
        yourActBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        yourActBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yourActBtnItemStateChanged(evt);
            }
        });
        yourActBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yourActBtnActionPerformed(evt);
            }
        });
        buttonPanel.add(yourActBtn);

        joinedActBtn.setForeground(new java.awt.Color(51, 51, 51));
        joinedActBtn.setText("Joined Activities");
        joinedActBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        joinedActBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                joinedActBtnItemStateChanged(evt);
            }
        });
        joinedActBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinedActBtnActionPerformed(evt);
            }
        });
        buttonPanel.add(joinedActBtn);

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);

        outputPanel.setBackground(new java.awt.Color(204, 255, 204));
        outputPanel.setOpaque(false);

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1177, Short.MAX_VALUE)
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(outputPanel);

        description.setColumns(20);
        description.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        description.setForeground(new java.awt.Color(100, 160, 239));
        description.setRows(3);
        description.setTabSize(5);
        description.setText("Description");
        description.setWrapStyleWord(true);
        description.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        description.setEnabled(false);
        description.setOpaque(false);

        displayName.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        displayName.setForeground(new java.awt.Color(100, 160, 239));
        displayName.setText("Username");
        displayName.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        displayName.setEnabled(false);

        username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(102, 102, 102));
        username.setText("@username");

        activityNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        activityNo.setForeground(new java.awt.Color(102, 102, 102));
        activityNo.setText("32");

        activitiesTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        activitiesTxt.setForeground(new java.awt.Color(102, 102, 102));
        activitiesTxt.setText("Activities");

        FriendsTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FriendsTxt.setForeground(new java.awt.Color(102, 102, 102));
        FriendsTxt.setText("Friends");

        friendsNo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        friendsNo.setForeground(new java.awt.Color(102, 102, 102));
        friendsNo.setText("102");

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pencil.png"))); // NOI18N
        editBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                editBtnItemStateChanged(evt);
            }
        });
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        searchBar.setHint("Search Profiles");

        descriptionLbl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descriptionLbl.setForeground(new java.awt.Color(153, 153, 153));
        descriptionLbl.setText("Description:");

        javax.swing.GroupLayout outputProfilePanelLayout = new javax.swing.GroupLayout(outputProfilePanel);
        outputProfilePanel.setLayout(outputProfilePanelLayout);
        outputProfilePanelLayout.setHorizontalGroup(
            outputProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outputProfilePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        outputProfilePanelLayout.setVerticalGroup(
            outputProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1098, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(activityNo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(activitiesTxt)
                                .addGap(55, 55, 55)
                                .addComponent(friendsNo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FriendsTxt)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayName, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profileCounter)
                            .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputProfilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(descriptionLbl)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(descriptionLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(displayName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outputProfilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(username)
                            .addComponent(profileCounter))
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(activityNo)
                            .addComponent(activitiesTxt)
                            .addComponent(friendsNo)
                            .addComponent(FriendsTxt))))
                .addGap(27, 27, 27)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void yourActBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yourActBtnItemStateChanged
        if (yourActBtn.isSelected()) {
            loadYourActivities();
        }
    }//GEN-LAST:event_yourActBtnItemStateChanged

    private void joinedActBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_joinedActBtnItemStateChanged
        if (joinedActBtn.isSelected()) {
            loadJoinedActivities();
        }
    }//GEN-LAST:event_joinedActBtnItemStateChanged

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed

    }//GEN-LAST:event_editBtnActionPerformed

    private void editBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_editBtnItemStateChanged
        if (editBtn.isSelected()) {
            enableEditing();
        } else {
            String newDescription = description.getText();
            if (newDescription != null) {
                user.setDescription(newDescription);

                description.setText(newDescription);
            }
            // Disable editing mode and save the changes
            disableEditingAndSave();
        }
    }//GEN-LAST:event_editBtnItemStateChanged

    private void yourActBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yourActBtnActionPerformed
        loadYourActivities();
    }//GEN-LAST:event_yourActBtnActionPerformed

    private void joinedActBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinedActBtnActionPerformed
        loadJoinedActivities();
    }//GEN-LAST:event_joinedActBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FriendsTxt;
    private javax.swing.JLabel activitiesTxt;
    private javax.swing.JLabel activityNo;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JTextField displayName;
    private Components.SelectionButton editBtn;
    private javax.swing.JLabel friendsNo;
    private Components.ImageAvatar imageAvatar;
    private javax.swing.JScrollPane jScrollPane1;
    private Components.SelectionButton joinedActBtn;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JPanel outputProfilePanel;
    private javax.swing.JLabel profileCounter;
    private javax.swing.JScrollPane scrollPane;
    private Components.SearchBar searchBar;
    private javax.swing.JLabel username;
    private Components.SelectionButton yourActBtn;
    // End of variables declaration//GEN-END:variables
}
