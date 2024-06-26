/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.SchedulerComp;

import Main.Plan;
import Main.User;

/**
 *
 * @author zuhalaksoy
 */
public class Synchronized extends javax.swing.JPanel {
    
    User user;
    User other;
    
    public void setUsers(User user, User other){
    this.user = user;
    this.other = other;
    }
    
    int userPlans = user.getPlans().size();
    int otherPlans = other.getPlans().size();
    
    
    
    public void intersect(){
        for(int i = 0; i < userPlans; i++){
            for(int j = 0; j < otherPlans; j++){
                if( user.getPlans().get(i).isIntersects(other.getPlans().get(j))){
                    
                }
            }
        }
    }
    
    
    
    
    /**
     * Creates new form Synchronized
     */
    public Synchronized() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Synchronized = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1000, 800));

        jTable_Synchronized.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable_Synchronized.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"08.00-09.00", null, null, null, null, null, null, null},
                {"09.00-10.00", null, null, null, null, null, null, null},
                {"10.00-11.00", null, null, null, null, null, null, null},
                {"11.00-12.00", null, null, null, null, null, null, null},
                {"12.00-13.00", null, null, null, null, null, null, null},
                {"13.00-14.00", null, null, null, null, null, null, null},
                {"14.00-15.00", null, null, null, null, null, null, null},
                {"15.00.16.00", null, null, null, null, null, null, null},
                {"16.00.17.00", null, null, null, null, null, null, null},
                {"17.00.18.00", null, null, null, null, null, null, null},
                {"18.00-19.00", null, null, null, null, null, null, null},
                {"19.00.20.00", null, null, null, null, null, null, null},
                {"20.00.21.00", null, null, null, null, null, null, null},
                {"21.00-22.00", null, null, null, null, null, null, null},
                {"22.00-23.00", null, null, null, null, null, null, null},
                {"23.00-00.00", null, null, null, null, null, null, null}
            },
            new String [] {
                "Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ));
        jTable_Synchronized.setEnabled(false);
        jTable_Synchronized.setGridColor(new java.awt.Color(153, 153, 153));
        jTable_Synchronized.setRowHeight(40);
        jTable_Synchronized.setSelectionBackground(new java.awt.Color(255, 204, 204));
        jTable_Synchronized.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable_Synchronized.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jTable_Synchronized.setShowGrid(true);
        jScrollPane1.setViewportView(jTable_Synchronized);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel1.setText("Your Calendar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(49, 49, 49))
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jLabel2.setText("Your Friend's Calendar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Synchronized;
    // End of variables declaration//GEN-END:variables
}
