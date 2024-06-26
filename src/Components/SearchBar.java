/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components;

import Components.ActivitiesComp.ActivitiesPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Atahan
 */
public class SearchBar extends javax.swing.JPanel {
    
    /**
     * Creates new form searchBar
     */
    public SearchBar() {
        initComponents();
        
        hintTextField.setHint("Search");
        
        searchBtn.setBgColor(new Color(0,0,0,0));
    }
    
    public void setHint(String hint){
        hintTextField.setHint(hint);
    }
    
    public void setText(String str){
        hintTextField.setText(str);
    }
    
    public void setCharLimit(int maxCharNo){
        hintTextField.setDocument(new TextCharLimit(maxCharNo));
    }
    
    public String getText(){
        return hintTextField.getText();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalArea = new Components.RoundedPanel();
        searchBtn = new Components.Button();
        hintTextField = new Components.HintTextField();

        setOpaque(false);

        totalArea.setBackground(new java.awt.Color(255, 255, 255));

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        searchBtn.setRoundness(30);
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        hintTextField.setForeground(new java.awt.Color(47, 47, 47));
        hintTextField.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        hintTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout totalAreaLayout = new javax.swing.GroupLayout(totalArea);
        totalArea.setLayout(totalAreaLayout);
        totalAreaLayout.setHorizontalGroup(
            totalAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalAreaLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(hintTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        totalAreaLayout.setVerticalGroup(
            totalAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
            .addComponent(hintTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed

    }//GEN-LAST:event_searchBtnActionPerformed

    private void hintTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hintTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public Components.HintTextField hintTextField;
    public Components.Button searchBtn;
    private Components.RoundedPanel totalArea;
    // End of variables declaration//GEN-END:variables
}
