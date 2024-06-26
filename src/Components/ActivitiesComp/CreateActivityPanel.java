/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.ActivitiesComp;

import Components.AppFrame;
import Components.RefreshablePanel;
import Components.TextCharLimit;
import Main.Notification;
import Main.User;
import java.awt.Color;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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
        
        monthBox.setItemNo(12);
        dayBox.setItemNo(31);
        yearBox.setStartValue(2024);
        yearBox.setItemNo(3);
        minuteBox.setItemNo(59);
        hourBox.setItemNo(23);
        durationBox.setStartValue(5);
        durationBox.setItemNo(24);
        durationBox.setIncrementValue(5);
        quotaBox.setStartValue(2);
        quotaBox.setItemNo(20);
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
          
        warning.setVisible(false);
    }
    
    private String getCategory(){
        return (String)categoryBox.getSelectedItem();
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
        quotaLbl = new javax.swing.JLabel();
        createBtn = new Components.Button();
        publicBtn = new Components.SelectionButton();
        privateBtn = new Components.SelectionButton();
        warning = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        monthBox = new Components.intComboBox();
        dayBox = new Components.intComboBox();
        yearBox = new Components.intComboBox();
        hourBox = new Components.intComboBox();
        minuteBox = new Components.intComboBox();
        durationBox = new Components.intComboBox();
        quotaBox = new Components.intComboBox();
        categoryBox = new javax.swing.JComboBox<>();

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
        categoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBtnActionPerformed(evt);
            }
        });

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
        publicBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicBtnActionPerformed(evt);
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

        warning.setForeground(new java.awt.Color(245, 12, 67));
        warning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        warning.setText("This activity cannot be created!");
        warning.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Month");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Day");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Year");

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Hour");

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Minute");

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Duration (min)");

        monthBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthBoxActionPerformed(evt);
            }
        });

        categoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chill", "Food", "Hobby", "Sport", "Study", "Outdoor", "Other" }));
        categoryBox.setSelectedIndex(-1);
        categoryBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundedPanelLayout = new javax.swing.GroupLayout(roundedPanel);
        roundedPanel.setLayout(roundedPanelLayout);
        roundedPanelLayout.setHorizontalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(categoryLbl)
                                    .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(roundedPanelLayout.createSequentialGroup()
                                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(monthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundedPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(134, 134, 134)
                                        .addComponent(jLabel3))
                                    .addGroup(roundedPanelLayout.createSequentialGroup()
                                        .addComponent(dayBox, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(quotaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                        .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(privateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(publicBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(warning, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))
                    .addGroup(roundedPanelLayout.createSequentialGroup()
                        .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(durationBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(roundedPanelLayout.createSequentialGroup()
                                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundedPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(127, 127, 127))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelLayout.createSequentialGroup()
                                        .addComponent(hourBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(minuteBox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        roundedPanelLayout.setVerticalGroup(
            roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanelLayout.createSequentialGroup()
                        .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roundedPanelLayout.createSequentialGroup()
                                .addComponent(categoryLbl)
                                .addGap(4, 4, 4)
                                .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(5, 5, 5)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(timeLbl)
                .addGap(5, 5, 5)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(3, 3, 3)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hourBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minuteBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(durationBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quotaLbl)
                    .addComponent(warning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quotaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
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
        /*else{
             publicBtn.setForeground(new Color(102, 102, 102));
        }*/
    }//GEN-LAST:event_publicBtnItemStateChanged

    private void privateBtnItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_privateBtnItemStateChanged
        if (privateBtn.isSelected()) {
            privateBtn.setForeground(new Color(245,12,67));
        }
        /*else{
             privateBtn.setForeground(new Color(102, 102, 102));
        }*/
    }//GEN-LAST:event_privateBtnItemStateChanged

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        String pattern = "MM/dd/yyyy HH:mm:ss";
        Date startDate = new Date((int)yearBox.getSelectedItem(), (int)monthBox.getSelectedItem(), 
                        (int)dayBox.getSelectedItem(), (int)hourBox.getSelectedItem(), (int)minuteBox.getSelectedItem(), 0);
        
        int durationHour = hourBox.getSelectedIndex() / 60;
        int durationMinutes = hourBox.getSelectedIndex() % 60;
        
        Date endDate = new Date((int)yearBox.getSelectedItem(), (int)monthBox.getSelectedItem(), 
                        (int)dayBox.getSelectedItem(), (int)hourBox.getSelectedItem() + durationHour, (int)minuteBox.getSelectedItem() + durationMinutes, 0);
  
        DateFormat df = new SimpleDateFormat(pattern);
        String startDateString = df.format(startDate);
        String endDateString = df.format(startDate);
        
        if (user.createActivity(titleField.getText(), description.getText(), startDateString, endDateString, (int)quotaBox.getSelectedItem(), publicBtn.isSelected(), getCategory())) {//TODO: &&check collisions!!!
            appFrame.getSideMenu().setSelectedPage(appFrame.getSideMenu().profileBtn, appFrame.getProfilePanel());
            refresh();
        }
        else{
            warning.setVisible(true);
        }
        
    }//GEN-LAST:event_createBtnActionPerformed

    private void categoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryBtnActionPerformed
     private void setButtonIcon(String category) {
    String imagePath = "/icons/" + category + ".png";
    ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
    categoryBtn.setIcon(icon);

    }
     
     private String getCategoryImagePath(String category) {
   
        return  category + ".png";
    }
     
    private void categoryBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryBoxActionPerformed
       JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
       String selectedCategory = (String) comboBox.getSelectedItem();
       setButtonIcon(selectedCategory);
    }//GEN-LAST:event_categoryBoxActionPerformed

    private void monthBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthBoxActionPerformed

    private void publicBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publicBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> categoryBox;
    private Components.Button categoryBtn;
    private javax.swing.JLabel categoryLbl;
    private Components.Button createBtn;
    private javax.swing.JLabel dateLbl;
    private Components.intComboBox dayBox;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel descriptionLbl;
    private Components.intComboBox durationBox;
    private Components.intComboBox hourBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private Components.intComboBox minuteBox;
    private Components.intComboBox monthBox;
    private Components.SelectionButton privateBtn;
    private Components.SelectionButton publicBtn;
    private Components.intComboBox quotaBox;
    private javax.swing.JLabel quotaLbl;
    private Components.RoundedPanel roundedPanel;
    private javax.swing.JLabel timeLbl;
    private Components.HintTextField titleField;
    private javax.swing.JLabel warning;
    private Components.intComboBox yearBox;
    // End of variables declaration//GEN-END:variables
}
