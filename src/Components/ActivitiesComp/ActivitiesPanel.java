/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components.ActivitiesComp;

import Components.RefreshablePanel;
import Components.ScrollBarUI;
import Main.Activity;
import Main.User;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JScrollBar;

/**
 *
 * @author Atahan
 */
public class ActivitiesPanel extends javax.swing.JPanel implements RefreshablePanel{
    private User user;
    private boolean ascendingDate;
    
    /**
     * Creates new form ActivitiesPage
     */
    public ActivitiesPanel() {
        initComponents();
        
        searchBar.setCharLimit(50);
        
        setOpaque(false);
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
        outputPanel.setLayout(layout);
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public void refresh(){
        searchBar.setText("");
        ascendingDate  = true;
        loadActivities();
    }

    public void loadActivities(){
        outputPanel.removeAll();        
        scrollPane.getVerticalScrollBar().setValue(0);
        
        ArrayList<Activity> activities = user.getAllActivities();
        
        if (ascendingDate) {
            for (int i = activities.size()-1; i >= 0; i--) {
                outputPanel.add(new ActivityItem(activities.get(i)));
            }
        }
        else{
            for (int i = 0; i < activities.size(); i++) {
               outputPanel.add(new ActivityItem(activities.get(i)));
            }
        }
        
        setactivityCounter(activities.size());
    }
    
    public void loadSearchActivities(){
        outputPanel.removeAll();        
        scrollPane.getVerticalScrollBar().setValue(0);
        
        ArrayList<Activity> activities = user.getSpecificActivities(searchBar.getText().trim());
        
        for (int i = activities.size()-1; i >= 0; i--) {
            outputPanel.add(new ActivityItem(activities.get(i)));
        }

        setactivityCounter(activities.size());
    }
    
    public void setactivityCounter(int count){
        activityCounter.setText("We've found " + count + " activities!");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        centererPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        activityCounter = new javax.swing.JLabel();
        sortDesc = new javax.swing.JLabel();
        sortBtn = new Components.Button();
        filterBtn = new Components.Button();
        searchBar = new Components.SearchBar();
        belowPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        outputPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(235, 240, 255));
        setMaximumSize(new java.awt.Dimension(1150, 800));
        setMinimumSize(new java.awt.Dimension(1150, 800));
        setPreferredSize(new java.awt.Dimension(1150, 800));

        centererPanel.setBackground(new java.awt.Color(255, 204, 204));
        centererPanel.setMaximumSize(new java.awt.Dimension(1100, 4000));
        centererPanel.setMinimumSize(new java.awt.Dimension(1100, 300));
        centererPanel.setOpaque(false);
        centererPanel.setPreferredSize(new java.awt.Dimension(1100, 600));

        searchPanel.setBackground(new java.awt.Color(204, 204, 255));
        searchPanel.setOpaque(false);

        activityCounter.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        activityCounter.setForeground(new java.awt.Color(102, 102, 102));
        activityCounter.setText("We've found -- activities!");

        sortDesc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sortDesc.setForeground(new java.awt.Color(102, 102, 102));
        sortDesc.setText("Sort by:");

        sortBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/down.png"))); // NOI18N
        sortBtn.setText("Date");
        sortBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sortBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        sortBtn.setIconTextGap(2);
        sortBtn.setMargin(new java.awt.Insets(2, 14, 3, 8));

        filterBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/filter.png"))); // NOI18N
        filterBtn.setText("Filter");
        filterBtn.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        filterBtn.setIconTextGap(5);
        filterBtn.setMargin(new java.awt.Insets(2, 10, 3, 18));

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(activityCounter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortDesc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchBar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(filterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activityCounter)
                    .addComponent(sortDesc)
                    .addComponent(sortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        belowPanel.setOpaque(false);

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setOpaque(false);

        outputPanel.setBackground(new java.awt.Color(204, 255, 204));
        outputPanel.setOpaque(false);

        javax.swing.GroupLayout outputPanelLayout = new javax.swing.GroupLayout(outputPanel);
        outputPanel.setLayout(outputPanelLayout);
        outputPanelLayout.setHorizontalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        outputPanelLayout.setVerticalGroup(
            outputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(outputPanel);

        javax.swing.GroupLayout belowPanelLayout = new javax.swing.GroupLayout(belowPanel);
        belowPanel.setLayout(belowPanelLayout);
        belowPanelLayout.setHorizontalGroup(
            belowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane)
        );
        belowPanelLayout.setVerticalGroup(
            belowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        scrollPane.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout centererPanelLayout = new javax.swing.GroupLayout(centererPanel);
        centererPanel.setLayout(centererPanelLayout);
        centererPanelLayout.setHorizontalGroup(
            centererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(belowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        centererPanelLayout.setVerticalGroup(
            centererPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centererPanelLayout.createSequentialGroup()
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(belowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(centererPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(centererPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activityCounter;
    private javax.swing.JPanel belowPanel;
    private javax.swing.JPanel centererPanel;
    private Components.Button filterBtn;
    private javax.swing.JPanel outputPanel;
    private javax.swing.JScrollPane scrollPane;
    private Components.SearchBar searchBar;
    private javax.swing.JPanel searchPanel;
    private Components.Button sortBtn;
    private javax.swing.JLabel sortDesc;
    // End of variables declaration//GEN-END:variables
}
