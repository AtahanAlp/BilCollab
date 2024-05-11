/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author Atahan
 */
public class SelectionButton extends JToggleButton{ 
    public static final Color SHADOW = new Color(120, 120, 120, 25);
    public static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    
    public int radius;
    public Color colorSelected;
    private boolean over;
    
    public SelectionButton(){
        this(new Color(21, 78, 250, 50));
    }
    
    public SelectionButton(Color selectedColor){
        setBorder(new EmptyBorder(10, 12, 15,12));
        setContentAreaFilled(false);

        this.colorSelected = selectedColor;
        radius = 0;
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                over = false;
            }
         });
    }

    //getter and setter methods for variables
    public Color getColorSelected() {
        return colorSelected;
    }

    public void setColorSelected(Color colorSelected) {
        this.colorSelected = colorSelected;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //create background

        setForeground(getForeground());
        if (!isSelected()) {
            g2.setColor(TRANSPARENT);
        }
        else{
            g2.setColor(colorSelected);
        }      

        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));
        g2.fill(area);
        if (over) {
            g2.setColor(SHADOW);
            g2.fill(area);
        }
        
        super.paintComponent(g);
    }   
}
