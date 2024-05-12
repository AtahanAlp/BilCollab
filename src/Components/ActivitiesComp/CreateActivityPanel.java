/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.ActivitiesComp;

import Components.SettingsComp.*;
import Components.AppFrame;
import Components.RefreshablePanel;
import Components.TextCharLimit;
import Main.User;
import java.awt.Color;
import java.util.Date;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Atahan
 */
public class CreateActivityPanel extends javax.swing.JPanel implements RefreshablePanel{
    AppFrame appFrame;
    User user;
    
    /**
     * Creates new form ActivitiesPage
     */
    public CreateActivityPanel() {
        initComponents();
        
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setBorder(new EmptyBorder(0, 0, 0, 0));
        description.setBackground(new Color(0,0,0,0));
        description.setDocument(new TextCharLimit(100));
        
        publicBtn.setColorSelected(new Color(0,0,0,0));
        privateBtn.setColorSelected(new Color(0,0,0,0));
        buttonGroup1.add(publicBtn);
        buttonGroup1.add(privateBtn);
    }
    
    public void setAppFrame(AppFrame appFrame){
        this.appFrame = appFrame;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public void refresh(){
        titleField.setText("");
        description.setText("");
        publicBtn.setSelected(true);
        //TODO
        warning.setVisible(false);
    }
    
    private String getCategory(){
        //TODO
        return "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundedPanel = new Components.RoundedPanel();
        categoryBtn = new Components.Button();
        titleField = new Components.HintTextField();
        categoryLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        description = new javax.swing.JTextArea();
        descriptionLbl = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        quotaLbl = new javax.swing.JLabel();
        createBtn = new Components.Button();
        publicBtn = new Components.SelectionButton();
        privateBtn = new Components.SelectionButton();
        jComboBox8 = new javax.swing.JComboBox<>();
        jComboBox9 = new javax.swing.JComboBox<>();
        jComboBox10 = new javax.swing.JComboBox<>();
        jComboBox11 = new javax.swing.JComboBox<>();
        jComboBox12 = new javax.swing.JComboBox<>();
        jComboBox13 = new javax.swing.JComboBox<>();
        warning = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));
        setMaximumSize(new java.awt.Dimension(1150, 800));
        setMinimumSize(new java.awt.Dimension(1150, 800));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1150, 800));

        roundedPanel.setBackground(new java.awt.Color(255, 255, 255));

        categoryBtn.setBackground(new java.awt.Color(46, 73, 154));
        categoryBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/plus.png"))); // NOI18N
        categoryBtn.setAlignmentX(0.5F);
        categoryBtn.setBgColor(new java.awt.Color(46, 73, 154));
        categoryBtn.setColorClicked(new java.awt.Color(204, 204, 204));
        categoryBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        categoryBtn.setIconTextGap(0);
        categoryBtn.setMargin(new java.awt.Insets(5, 5, 5, 5));

        titleField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titleField.setHint("Add title");

        categoryLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoryLbl.setForeground(new java.awt.Color(102, 102, 102));
        categoryLbl.setText("Select a Category");

        dateLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dateLbl.setForeground(new java.awt.Color(102, 102, 102));
        dateLbl.setText("Date:");

        description.setColumns(20);
        description.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        description.setRows(5);

        descriptionLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        descriptionLbl.setForeground(new java.awt.Color(102, 102, 102));
        descriptionLbl.setText("Description:");

        timeLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(102, 102, 102));
        timeLbl.setText("Time:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        quotaLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        quotaLbl.setForeground(new java.awt.Color(102, 102, 102));
        quotaLbl.setText("Quota:");

        createBtn.setForeground(new java.awt.Color(255, 255, 255));
        createBtn.setText("Create");
        createBtn.setBgColor(new java.awt.Color(245, 12, 67));
        createBtn.setColorClicked(new java.awt.Color(204, 204, 204));
        createBtn.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        createBtn.setTextColor(new java.awt.Color(255, 255, 255));
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        publicBtn.setForeground(new java.awt.Color(102, 102, 102));
        publicBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/public.png"))); // NOI18N
        publicBtn.setText("Public");
        publicBtn.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        publicBtn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        publicBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        publicBtn.setIconTextGap(10);
        publicBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/public.png"))); // NOI18N
        publicBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/publicRed.png"))); // NOI18N
        publicBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                publicBtnItemStateChanged(evt);
            }
        });

        privateBtn.setForeground(new java.awt.Color(102, 102, 102));
        privateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/private.png"))); // NOI18N
        privateBtn.setText("Private");
        privateBtn.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        privateBtn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        privateBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        privateBtn.setIconTextGap(10);
        privateBtn.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/private.png"))); // NOI18N
        privateBtn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/privateRed.png"))); // NOI18N
        privateBtn.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                privateBtnItemStateChanged(evt);
            }
        });

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        warning.setForeground(new java.awt.Color(51, 51, 51));
        warning.setText("This activity cannot be created!");
        warning.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout roundedPanelLayout = new javax.swing.GroupLayout(roundedPanel);
        roundedPanel.setLayout(roundedPanelLayout);
        roundedPanelLayout.setHorizontalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanelLayout.createSequentialGroup()
                        .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundedPanelLayout.createSequentialGroup()
                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundedPanelLayout.createSequentialGroup()
                        .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quotaLbl)
                            .addComponent(timeLbl)
                            .addComponent(dateLbl)
                            .addComponent(descriptionLbl)
                            .addGroup(roundedPanelLayout.createSequentialGroup()
                                .addComponent(categoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(categoryLbl))
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundedPanelLayout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                        .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(privateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(publicBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(warning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
        );
        roundedPanelLayout.setVerticalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanelLayout.createSequentialGroup()
                        .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(categoryLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(categoryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
                    .addGroup(roundedPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(publicBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(privateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descriptionLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateLbl)
                .addGap(18, 18, 18)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(timeLbl)
                .addGap(18, 18, 18)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quotaLbl)
                    .addComponent(warning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(roundedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void publicBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_publicBtnItemStateChanged
        if (publicBtn.isSelected()) {
            publicBtn.setForeground(new Color(245,12,67));
        }
        else{
             publicBtn.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_publicBtnItemStateChanged

    private void privateBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_privateBtnItemStateChanged
        if (privateBtn.isSelected()) {
            privateBtn.setForeground(new Color(245,12,67));
        }
        else{
             privateBtn.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_privateBtnItemStateChanged

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        Date startDate = new Date((int)jComboBox10.getSelectedItem(), (int)jComboBox10.getSelectedItem(), 
                        (int)jComboBox10.getSelectedItem(), (int)jComboBox10.getSelectedItem(), (int)jComboBox10.getSelectedItem());
        
        int durationHour = jComboBox10.getSelectedIndex() / 60;
        int durationMinutes = jComboBox10.getSelectedIndex() % 60;
        Date endDate = new Date((int)jComboBox10.getSelectedItem(), (int)jComboBox10.getSelectedItem(), 
                        (int)jComboBox10.getSelectedItem(), (int)jComboBox10.getSelectedItem() + durationHour, (int)jComboBox10.getSelectedItem() + durationMinutes);
        
        if (user.createActivity(titleField.getText(), description.getText(), startDate, endDate, (int)jComboBox10.getSelectedItem(), publicBtn.isSelected(), getCategory())) {//TODO: &&check collisions!!!
            appFrame.getSideMenu().setSelectedPage(appFrame.getSideMenu().profileBtn, appFrame.getProfilePanel());
            refresh();
        }
        else{
            warning.setVisible(true);
        }
    }//GEN-LAST:event_createBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private Components.Button categoryBtn;
    private javax.swing.JLabel categoryLbl;
    private Components.Button createBtn;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private Components.SelectionButton privateBtn;
    private Components.SelectionButton publicBtn;
    private javax.swing.JLabel quotaLbl;
    private Components.RoundedPanel roundedPanel;
    private javax.swing.JLabel timeLbl;
    private Components.HintTextField titleField;
    private javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables
}
