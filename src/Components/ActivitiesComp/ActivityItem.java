/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.ActivitiesComp;

import Components.Button;
import Main.Activity;
import Main.DatabaseConnection;
import Main.User;
import static Main.User.getCurrentUser;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Atahan
 */
public class ActivityItem extends javax.swing.JPanel {
    
    public Activity activity;
    private User user;
    private DefaultListModel<String> listModel;
    
    /**
     * Creates new form activityItem
     */
    public ActivityItem() {
        initComponents();
        
        jScrollPane_Participants.setVisible(false);
        
        joinBtn.setBgColor(Button.RED);
        joinBtn.setColorClicked(new Color(155, 2, 17));
        joinBtn.setTextColor(Color.WHITE);
        this.description.setText("<html><p style=\"width:400px\">"+description.getText()+"</p></html>");
    }
    
    public ActivityItem(Activity activity, User user) {
       
        initComponents();
        //jScrollPane_Participants.setVisible(false);
        this.activity = activity;
        this.user = user;
        
        listModel = new DefaultListModel<>();
        jListParticipants.setModel(listModel);

        
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
        this.quota.setText("Quota: " + activity.getParticipants().size() + "/" + activity.getQuota());
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
        button_Participants = new Components.Button();
        jScrollPane_Participants = new javax.swing.JScrollPane();
        jListParticipants = new javax.swing.JList<>();

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

        button_Participants.setBackground(new java.awt.Color(255, 204, 204));
        button_Participants.setText("Participants");
        button_Participants.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ParticipantsActionPerformed(evt);
            }
        });

        jListParticipants.setBackground(new java.awt.Color(204, 204, 204));
        jListParticipants.setToolTipText("");
        jScrollPane_Participants.setViewportView(jListParticipants);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(quota, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(joinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane_Participants, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timeDesc, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(activityTime, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                                .addComponent(button_Participants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))))))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(timeDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel1Layout.createSequentialGroup()
                                .addComponent(activityTime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button_Participants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(joinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quota)))
                            .addComponent(jScrollPane_Participants, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
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


    
    public void addParticipant(String username) {
        listModel.addElement(username);
    }

    
    private void joinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinBtnActionPerformed
        User currentUser = getCurrentUser();
        
        if (activity.contains(user)) 
        {
            joinBtn.setText("ALREADY JOINED");
            joinBtn.setEnabled(false);
            return;
        
        }
        else if (activity.getParticipants().size() < activity.getQuota()) {
            activity.joinUser(user);
            setQuotaDisplay();

            joinBtn.setText("JOINED");
            joinBtn.setEnabled(false);
            activity.addParticipants(user.getId());
        }
        else
        {
            joinBtn.setText("FULL");
        }
        setQuotaDisplay();
        
    }//GEN-LAST:event_joinBtnActionPerformed

    private void button_ParticipantsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ParticipantsActionPerformed

        jScrollPane_Participants.setVisible(true);
        
        addListItems();
        button_Participants.setEnabled(false);
    }//GEN-LAST:event_button_ParticipantsActionPerformed
    
    public void saveArrayToDatabase() {
        String ids = "";
        for(int i = 0; i < activity.getParticipants().size() ; i++)
        {
            ids += activity.getParticipants().get(i).getId();
            
        }
        
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet rSet = null;
        
        try{
            connection = DatabaseConnection.getConnection();
           
            String sql = "INSERT INTO activity (participants) "
                    + "VALUES (?,)";
            pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, ids + "/");
            pStatement.executeUpdate();
                    
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            
            DatabaseConnection.close(connection, pStatement, rSet);
        }
          

    }
    
    public void addListItems(){
        for(int i = 0; i < activity.getParticipants().size(); i++){
            String username = activity.getParticipants().get(i).getUsername();
            addParticipant(username);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activityTime;
    private Components.Button button_Participants;
    private javax.swing.JLabel creatorName;
    private javax.swing.JLabel description;
    private javax.swing.JList<String> jListParticipants;
    private javax.swing.JScrollPane jScrollPane_Participants;
    public Components.Button joinBtn;
    private Components.ImageAvatar profilePic;
    private javax.swing.JLabel quota;
    private Components.RoundedPanel roundedPanel1;
    private Components.RoundedPanel roundedPanel2;
    private javax.swing.JLabel timeDesc;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
