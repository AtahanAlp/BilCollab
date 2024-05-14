/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components.SchedulerComp;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author zuhalaksoy
 */

public class CustomTableCellRenderer extends DefaultTableCellRenderer 
{
    public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected,
       boolean hasFocus, int row, int column){
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if( !value.equals(" ") )
            {
                cell.setBackground( new Color(243,12,67) );
                // You can also customize the Font and Foreground this way

                cell.setForeground(Color.WHITE);

                //cell.setForeground(new Color(255,0,0,30));
                // cell.setFont();
            }
            else if(!value.equals(" ") ){
                 cell.setBackground( Color.WHITE );
            }

        
        return cell;
    }
}

