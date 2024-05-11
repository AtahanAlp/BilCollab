/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Atahan
 */
public class TextCharLimit extends PlainDocument{
    private int limit;

    public TextCharLimit(int limit) {
        this.limit = limit;
    }
    
    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException{
        if (str == null) {
            return;
        }
        else if (getLength() + str.length() <= limit) {
            super.insertString(offset, str, set);
        }
    }
}
