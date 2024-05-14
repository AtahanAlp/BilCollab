/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Atahan
 */

public class Notification {
    String description;
    User sender;
    
    public Notification(String description, User sender) {
        this.description = description;
<<<<<<< HEAD
        this.sender = sender;
=======
        this.sender = sender;               
>>>>>>> 2663ec41d95ff193ac5766f91061358fc1b5171b
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
    
}
