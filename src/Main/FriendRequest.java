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
    User receiver;
    User sender;

    public FriendRequest(User receiver, User sender) {
        this.description = sender.getDisplayName() + "sent you a friend request.";
        this.receiver = receiver;
        this.sender = sender;
        receiver.createNotification(this.description, sender);
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
    
    public void acceptRequest(){
        receiver.acceptRequest(this);
        receiver.addFriend(sender);
        receiver.removeRequest(this);
    }
    
    public void denyRequest(){
        receiver.removeRequest(this);
    }
}
