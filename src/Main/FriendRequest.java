/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Atahan
 */
public class FriendRequest {
    String description;
    User reciever;
    User sender;

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
    
    public void acceptRequest(){
        reciever.addFriend(sender);
        reciever.removeRequest(this);
    }
    
    public void denyRequest(){
        reciever.removeRequest(this);
    }
}
