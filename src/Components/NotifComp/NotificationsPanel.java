/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.NotifComp;

import Components.ScrollBarUI;
import Main.FriendRequest;
import Main.Notification;
import Main.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

/**
 *
 * @author Atahan
 */
public class NotificationsPanel extends JPanel {
    private User user;
    private boolean over;
    /**
     * Creates new form NotificationsPanel
     */
    public NotificationsPanel() {
        initComponents();
        over = false;
          
        setOpaque(false);
        setVisible(false);
        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.setOpaque(false);
        scrollBar.setUnitIncrement(1);
        scrollBar.setForeground(new Color(100, 160, 239));
        scrollBar.setPreferredSize(new Dimension(12, 14));
        scrollBar.setUI(new ScrollBarUI());//change later
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setViewportBorder(null);
        
        friendReqBtn.setBgColor(new Color(0,0,0,0));
        
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(5);
        notifOutput.setLayout(layout);
    }
    
    public void setUser(User user){
        this.user = user;
    }

    public void loadNotifications(){
        notifOutput.removeAll();
        revalidate();
        scrollPane.getVerticalScrollBar().setValue(0);
        notifOutput.add(friendReqBtn);
        infoText.setText("Recent Notifications");
        notifOutput.add(infoText);
        
        ArrayList<Notification> notifications = user.getNotifications();
        for (int i = notifications.size()-1; i >= 0; i--) {
            notifOutput.add(new NotificationItem(notifications.get(i)));
        }
    }
    
    public void loadFriendReqs(){
        notifOutput.removeAll();
        revalidate();
        scrollPane.getVerticalScrollBar().setValue(0);
        infoText.setText("Friend Requests");
        notifOutput.add(infoText);
        
        ArrayList<FriendRequest> friendReqs = user.getFriendRequests();
        for (int i = friendReqs.size()-1; i >= 0; i--) {
            notifOutput.add(new FriendRequestItem(friendReqs.get(i), this));
        }
    }
    
    public void openNotifications(){
        setVisible(true);
        loadNotifications();
    }
    
    public void removeItem(JPanel panel){
        notifOutput.remove(panel);
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centeredPanel = new javax.swing.JPanel();
        roundedPanel = new Components.RoundedPanel();
        scrollPane = new javax.swing.JScrollPane();
        notifOutput = new javax.swing.JPanel();
        infoText = new javax.swing.JLabel();
        friendReqBtn = new Components.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(11000, 10000));
        setMinimumSize(new java.awt.Dimension(725, 725));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1640, 1024));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        centeredPanel.setBackground(new java.awt.Color(255, 51, 51));
        centeredPanel.setMaximumSize(new java.awt.Dimension(525, 625));
        centeredPanel.setMinimumSize(new java.awt.Dimension(525, 625));
        centeredPanel.setOpaque(false);
        centeredPanel.setPreferredSize(new java.awt.Dimension(525, 625));

        roundedPanel.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel.setMaximumSize(new java.awt.Dimension(500, 500));
        roundedPanel.setMinimumSize(new java.awt.Dimension(500, 500));
        roundedPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        roundedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                roundedPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                roundedPanelMouseExited(evt);
            }
        });

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setName(""); // NOI18N
        scrollPane.setOpaque(false);

        notifOutput.setBackground(new java.awt.Color(204, 255, 204));
        notifOutput.setOpaque(false);

        infoText.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        infoText.setForeground(new java.awt.Color(102, 102, 102));
        infoText.setText("   Recent Notifications");
        infoText.setAlignmentX(1.0F);

        friendReqBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addFriend.png"))); // NOI18N
        friendReqBtn.setText("Friend Requests");
        friendReqBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        friendReqBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        friendReqBtn.setIconTextGap(24);
        friendReqBtn.setMargin(new java.awt.Insets(5, 14, 5, 14));
        friendReqBtn.setMaximumSize(new java.awt.Dimension(500, 60));
        friendReqBtn.setMinimumSize(new java.awt.Dimension(500, 60));
        friendReqBtn.setPreferredSize(new java.awt.Dimension(500, 60));
        friendReqBtn.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        friendReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendReqBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout notifOutputLayout = new javax.swing.GroupLayout(notifOutput);
        notifOutput.setLayout(notifOutputLayout);
        notifOutputLayout.setHorizontalGroup(
            notifOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notifOutputLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(infoText, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(notifOutputLayout.createSequentialGroup()
                .addComponent(friendReqBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        notifOutputLayout.setVerticalGroup(
            notifOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notifOutputLayout.createSequentialGroup()
                .addComponent(friendReqBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoText)
                .addGap(0, 392, Short.MAX_VALUE))
        );

        scrollPane.setViewportView(notifOutput);

        javax.swing.GroupLayout roundedPanelLayout = new javax.swing.GroupLayout(roundedPanel);
        roundedPanel.setLayout(roundedPanelLayout);
        roundedPanelLayout.setHorizontalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        roundedPanelLayout.setVerticalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout centeredPanelLayout = new javax.swing.GroupLayout(centeredPanel);
        centeredPanel.setLayout(centeredPanelLayout);
        centeredPanelLayout.setHorizontalGroup(
            centeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centeredPanelLayout.createSequentialGroup()
                .addContainerGap(1093, Short.MAX_VALUE)
                .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        centeredPanelLayout.setVerticalGroup(
            centeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centeredPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(centeredPanel, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void roundedPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundedPanelMouseEntered
       over = true;
    }//GEN-LAST:event_roundedPanelMouseEntered

    private void roundedPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundedPanelMouseExited
        over = false;
    }//GEN-LAST:event_roundedPanelMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (!over) {
            setVisible(false);
        }
    }//GEN-LAST:event_formMousePressed

    private void friendReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendReqBtnActionPerformed
        loadFriendReqs();
        revalidate();
    }//GEN-LAST:event_friendReqBtnActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centeredPanel;
    private Components.Button friendReqBtn;
    private javax.swing.JLabel infoText;
    private javax.swing.JPanel notifOutput;
    private Components.RoundedPanel roundedPanel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
