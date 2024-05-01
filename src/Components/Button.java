/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author Atahan
 */
public class Button extends JButton{
    public static final Color SHADOW = new Color(120, 120, 120, 20);
    public static final Color WHITE = Color.WHITE;
    public static final Color RED = new Color(245, 12, 67);
    public static final Color GREY = new Color(47, 47, 47);
    
    private int roundness;
    private Color bgColor; 
    private Color colorClicked;
    private Color textColor;
    private Color textColorClicked;
    private boolean pressed;
    private boolean over;
    
    public Button(){
        this(WHITE, RED, GREY, WHITE, 15);
    }
    
    public Button(Color bgColor, Color colorClicked, Color textColor, Color textColorClicked, int roundness){
        setBorder(new EmptyBorder(10, 12, 15,12));
        setContentAreaFilled(false);
        setBgColor(bgColor);
        setTextColor(textColor);
        this.textColorClicked = textColorClicked;
        this.colorClicked = colorClicked;
        this.roundness = roundness;
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                over = false;
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setBackground(colorClicked);
                pressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                setBackground(bgColor);
                pressed = false;
            }
         });
    }

    //getter and setter methods for variables
     public int getRoundness() {
        return roundness;
    }

    public void setRoundness(int roundness) {
        this.roundness = roundness;
    }
    
    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color defaultColor) {
        this.bgColor = defaultColor;
        setBackground(defaultColor);
    }

    public Color getColorClicked() {
        return colorClicked;
    }

    public void setColorClicked(Color colorClicked) {
        this.colorClicked = colorClicked;
    }
    
    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
        setForeground(textColor);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //create background
        if (pressed) {
            setForeground(textColorClicked);
            g2.setColor(colorClicked);
        }
        else{
            setForeground(textColor);
            g2.setColor(bgColor);
        }
        Area area = new Area(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), roundness, roundness));
        g2.fill(area);
        if (over && !pressed) {
            g2.setColor(SHADOW);
            g2.fill(area);
        }
        super.paintComponent(g);
    }   
}
