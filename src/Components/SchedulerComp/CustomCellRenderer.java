/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components.SchedulerComp;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author zuhalaksoy
 */

public class CustomCellRenderer extends DefaultTableCellRenderer 
{
    public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected,
       boolean hasFocus, int row, int column){
        Component cell = super.getTableCellRendererComponent
           (table, value, isSelected, hasFocus, row, column);
        
            if(column == 0)
            {
                cell.setBackground( Color.BLUE );
                // You can also customize the Font and Foreground this way
                cell.setForeground(Color.GRAY);
                //cell.setForeground(new Color(255,0,0,30));
                // cell.setFont();
            }

        
        return cell;
    }
}
    