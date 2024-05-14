/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.LoginComp;

import Components.AppFrame;
import Components.TextCharLimit;
import Main.DatabaseConnection;
import Main.User;
import javax.swing.ImageIcon;
import java.sql.*;
/**
 *
 * @author Atahan
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();

        setTitle("BilCollab");
        setIconImage(new ImageIcon(getClass().getResource("/Icons/iconLogo.png")).getImage());
        
        signupPanel.setVisible(false);
        backBtn.setVisible(false);
        
        mailField.setDocument(new TextCharLimit(30));
        passwordField.setDocument(new TextCharLimit(30));
        newUserField.setDocument(new TextCharLimit(30));
        newMailField.setDocument(new TextCharLimit(30));
        newPassField.setDocument(new TextCharLimit(30));
        againPassField.setDocument(new TextCharLimit(30));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel = new javax.swing.JPanel();
        backBtn = new Components.Button();
        infoLbl = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        loginBtn = new Components.Button();
        signupPageBtn = new Components.Button();
        mailPanel1 = new Components.RoundedPanel();
        mailField = new Components.HintTextField();
        jLabel1 = new javax.swing.JLabel();
        passwordPanel1 = new Components.RoundedPanel();
        passwordField = new Components.HintPasswordField();
        jLabel2 = new javax.swing.JLabel();
        bilCollabLogo1 = new javax.swing.JLabel();
        signupPanel = new javax.swing.JPanel();
        signUpBtn = new Components.Button();
        passwordPanel6 = new Components.RoundedPanel();
        againPassField = new Components.HintPasswordField();
        jLabel6 = new javax.swing.JLabel();
        usernamePanel = new Components.RoundedPanel();
        newUserField = new Components.HintTextField();
        jLabel4 = new javax.swing.JLabel();
        mailPanel = new Components.RoundedPanel();
        newMailField = new Components.HintTextField();
        jLabel3 = new javax.swing.JLabel();
        bilCollabLogo = new javax.swing.JLabel();
        passwordPanel7 = new Components.RoundedPanel();
        newPassField = new Components.HintPasswordField();
        jLabel5 = new javax.swing.JLabel();

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));
        infoPanel.setPreferredSize(new java.awt.Dimension(570, 60));

        backBtn.setBorder(null);
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/backArrow.png"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        infoLbl.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        infoLbl.setForeground(new java.awt.Color(51, 51, 51));
        infoLbl.setText("Login");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoLbl)
                .addContainerGap(449, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        getContentPane().add(infoPanel, java.awt.BorderLayout.NORTH);

        mainPanel.setBackground(new java.awt.Color(235, 240, 255));
        mainPanel.setMaximumSize(new java.awt.Dimension(570, 800));
        mainPanel.setMinimumSize(new java.awt.Dimension(570, 800));
        mainPanel.setLayout(new java.awt.CardLayout());

        loginPanel.setBackground(new java.awt.Color(235, 240, 255));
        loginPanel.setMaximumSize(new java.awt.Dimension(570, 800));
        loginPanel.setMinimumSize(new java.awt.Dimension(570, 800));

        jCheckBox2.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBox2.setText("Remember Me");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        loginBtn.setText("Login");
        loginBtn.setBgColor(new java.awt.Color(245, 12, 67));
        loginBtn.setColorClicked(new java.awt.Color(255, 255, 255));
        loginBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        loginBtn.setTextColor(new java.awt.Color(255, 255, 255));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        signupPageBtn.setText("Dont have an account yet? Click here to sign up.");
        signupPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupPageBtnActionPerformed(evt);
            }
        });

        mailPanel1.setBackground(new java.awt.Color(255, 255, 255));

        mailField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        mailField.setHint("e-mail");
        mailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailFieldActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/mail.png"))); // NOI18N

        javax.swing.GroupLayout mailPanel1Layout = new javax.swing.GroupLayout(mailPanel1);
        mailPanel1.setLayout(mailPanel1Layout);
        mailPanel1Layout.setHorizontalGroup(
            mailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mailField, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mailPanel1Layout.setVerticalGroup(
            mailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mailPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mailField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mailPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        passwordPanel1.setBackground(new java.awt.Color(255, 255, 255));

        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        passwordField.setHint("password");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/nonVisible.png"))); // NOI18N

        javax.swing.GroupLayout passwordPanel1Layout = new javax.swing.GroupLayout(passwordPanel1);
        passwordPanel1.setLayout(passwordPanel1Layout);
        passwordPanel1Layout.setHorizontalGroup(
            passwordPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        passwordPanel1Layout.setVerticalGroup(
            passwordPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(passwordPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bilCollabLogo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bilCollabLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N
        bilCollabLogo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signupPageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mailPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bilCollabLogo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(bilCollabLogo1)
                .addGap(136, 136, 136)
                .addComponent(mailPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addGap(40, 40, 40)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(signupPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        mainPanel.add(loginPanel, "card2");

        signupPanel.setBackground(new java.awt.Color(235, 240, 255));
        signupPanel.setMaximumSize(new java.awt.Dimension(570, 800));
        signupPanel.setMinimumSize(new java.awt.Dimension(570, 800));

        signUpBtn.setText("Sign Up");
        signUpBtn.setBgColor(new java.awt.Color(245, 12, 67));
        signUpBtn.setColorClicked(new java.awt.Color(255, 255, 255));
        signUpBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        signUpBtn.setTextColor(new java.awt.Color(255, 255, 255));
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });

        passwordPanel6.setBackground(new java.awt.Color(255, 255, 255));

        againPassField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        againPassField.setHint("password verify");
        againPassField.setName("password verify"); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/safe.png"))); // NOI18N

        javax.swing.GroupLayout passwordPanel6Layout = new javax.swing.GroupLayout(passwordPanel6);
        passwordPanel6.setLayout(passwordPanel6Layout);
        passwordPanel6Layout.setHorizontalGroup(
            passwordPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(againPassField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        passwordPanel6Layout.setVerticalGroup(
            passwordPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(againPassField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        usernamePanel.setBackground(new java.awt.Color(255, 255, 255));

        newUserField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        newUserField.setHint("username");
        newUserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserFieldActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user.png"))); // NOI18N

        javax.swing.GroupLayout usernamePanelLayout = new javax.swing.GroupLayout(usernamePanel);
        usernamePanel.setLayout(usernamePanelLayout);
        usernamePanelLayout.setHorizontalGroup(
            usernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newUserField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        usernamePanelLayout.setVerticalGroup(
            usernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernamePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(usernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newUserField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usernamePanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        mailPanel.setBackground(new java.awt.Color(255, 255, 255));

        newMailField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        newMailField.setHint("e-mail");
        newMailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMailFieldActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/mail.png"))); // NOI18N

        javax.swing.GroupLayout mailPanelLayout = new javax.swing.GroupLayout(mailPanel);
        mailPanel.setLayout(mailPanelLayout);
        mailPanelLayout.setHorizontalGroup(
            mailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newMailField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mailPanelLayout.setVerticalGroup(
            mailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newMailField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(mailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bilCollabLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bilCollabLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N
        bilCollabLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        passwordPanel7.setBackground(new java.awt.Color(255, 255, 255));

        newPassField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        newPassField.setHint("password");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/nonVisible.png"))); // NOI18N

        javax.swing.GroupLayout passwordPanel7Layout = new javax.swing.GroupLayout(passwordPanel7);
        passwordPanel7.setLayout(passwordPanel7Layout);
        passwordPanel7Layout.setHorizontalGroup(
            passwordPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        passwordPanel7Layout.setVerticalGroup(
            passwordPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newPassField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(passwordPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout signupPanelLayout = new javax.swing.GroupLayout(signupPanel);
        signupPanel.setLayout(signupPanelLayout);
        signupPanelLayout.setHorizontalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signupPanelLayout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addGroup(signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(usernamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signUpBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bilCollabLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        signupPanelLayout.setVerticalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signupPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(bilCollabLogo)
                .addGap(83, 83, 83)
                .addComponent(usernamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(signUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        mainPanel.add(signupPanel, "card3");

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    private User authenticate(String mail, String password) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        boolean authenticated = false;
        

        try {
            Connection conn = DatabaseConnection.getConnection();
            
            //probably dont need this part!
            String sql = "SELECT COUNT(*) AS count FROM User WHERE mail=? AND password=?";
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, mail);
            stmt.setString(2, password);
            
            rs = stmt.executeQuery();
            if (rs.next()) {
                int bool = rs.getInt("count");
                authenticated = (bool == 1);
            }
            
            if(authenticated){
                sql = "SELECT username FROM User WHERE mail=?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, mail);
                rs = stmt.executeQuery();
                
                if (rs.next()) {
                    String username = rs.getString("username");  
                    user = new User(username, mail, password);
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
    
    private User signUp(String username, String mail, String password){
        User user = new User(username, mail, password);
        user.saveNewUserToDatabase();
        
        return user;
    }
    
    private void newMailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newMailFieldActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        backBtn.setVisible(false);
        signupPanel.setVisible(false);
        loginPanel.setVisible(true);
        infoLbl.setText("Login");
        revalidate();
    }//GEN-LAST:event_backBtnActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void signupPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupPageBtnActionPerformed
       signupPanel.setVisible(true);
       backBtn.setVisible(true);
       loginPanel.setVisible(false);
       infoLbl.setText("Sign Up");
       revalidate();
    }//GEN-LAST:event_signupPageBtnActionPerformed

    private void mailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailFieldActionPerformed

    private void newUserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newUserFieldActionPerformed

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        User user = signUp(newUserField.getText().trim(), newMailField.getText().trim(), newPassField.getText().trim());
        if (user != null) {
            AppFrame appFrame = new AppFrame(user);
            appFrame.pack();
            appFrame.setVisible(true);
        }
    }//GEN-LAST:event_signUpBtnActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        User user = authenticate(mailField.getText().trim(), passwordField.getText().trim());
        if (user != null) {
            AppFrame appFrame = new AppFrame(user);
            appFrame.pack();
            appFrame.setVisible(true);
        }
        else{
            System.out.println("Pompaaaaaaa");
                    
        }
    }//GEN-LAST:event_loginBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.HintPasswordField againPassField;
    private Components.Button backBtn;
    private javax.swing.JLabel bilCollabLogo;
    private javax.swing.JLabel bilCollabLogo1;
    private javax.swing.JLabel infoLbl;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private Components.Button loginBtn;
    private javax.swing.JPanel loginPanel;
    private Components.HintTextField mailField;
    private Components.RoundedPanel mailPanel;
    private Components.RoundedPanel mailPanel1;
    private javax.swing.JPanel mainPanel;
    private Components.HintTextField newMailField;
    private Components.HintPasswordField newPassField;
    private Components.HintTextField newUserField;
    private Components.HintPasswordField passwordField;
    private Components.RoundedPanel passwordPanel1;
    private Components.RoundedPanel passwordPanel6;
    private Components.RoundedPanel passwordPanel7;
    private Components.Button signUpBtn;
    private Components.Button signupPageBtn;
    private javax.swing.JPanel signupPanel;
    private Components.RoundedPanel usernamePanel;
    // End of variables declaration//GEN-END:variables
}
