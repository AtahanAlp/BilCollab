/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Atahan
 */
public class intComboBox extends JComboBox<Integer>{
    private int itemNo;
    private int incrementValue;
    private int startValue;

    public intComboBox() {
        this.startValue = 1;
        this.itemNo = 15;
        this.incrementValue = 1;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
        setItems();
    }

    public int getIncrementValue() {
        return incrementValue;
    }

    public void setIncrementValue(int incrementValue) {
        this.incrementValue = incrementValue;
        setItems();
    }

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
        setItems();
    }
    
    public void setItems(){
        Integer[] items = new Integer[itemNo];
        
        for(int i = 0; i < itemNo; i++){
            items[i]= startValue + (i * incrementValue);
        }
        this.setModel(new DefaultComboBoxModel<Integer>(items));
    }  
}
