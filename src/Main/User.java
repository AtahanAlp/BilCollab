/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Atahan
 */
public class User {
    //public static final BufferedImage DEFAULT_PROFILE_PIC = ImageIO.read(new File("profilePic.png"));

    
    private BilCollab app;
    private int id;
    private String username;
    private String password;
    private String eMail;
    private String displayName;
    private BufferedImage profilePic;
    private String description;
    private ArrayList<Activity> createdActivities;
    private ArrayList<Activity> joinedActivities;
    private ArrayList<Plan> plans;
    private ArrayList<Notification> notifications;
    private ArrayList<FriendRequest> friendRequests;
    private ArrayList<Friend> friends;

    
    public User(BilCollab app, int id, String username, String eMail, String password){
        this.app = app;
        this.id = id;
        this.username = username;
        this.eMail = eMail;
        this.password = password;
        displayName = username;
        // = DEFAULT_PROFILE_PIC;
        description = "";
        
        createdActivities = new ArrayList<Activity>();
        joinedActivities = new ArrayList<Activity>();
        plans = new ArrayList<Plan>();
        notifications = new ArrayList<Notification>();
        friendRequests = new ArrayList<FriendRequest>();
        friends = new ArrayList<Friend>();
    }
    
    //getter methods
    public BilCollab getApp() {
        return app;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String geteMail() {
        return eMail;
    }

    public String getDisplayName() {
        return displayName;
    }

    public BufferedImage getProfilePic() {
        return profilePic;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Activity> getCreatedActivities() {
        return createdActivities;
    }

    public ArrayList<Activity> getJoinedActivities() {
        return joinedActivities;
    }

    public ArrayList<Plan> getPlans() {
        return plans;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public ArrayList<FriendRequest> getFriendRequests() {
        return friendRequests;
    }

    public ArrayList<Friend> getFriends() {
        return friends;
    }
    
    //setter methods
    public void setPassword(String password) {
        this.password = password;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setProfilePic(BufferedImage profilePic) {
        this.profilePic = profilePic;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    //other methods
    public void addPlan(Plan plan){
        //TODO
    }
    
    public void addActivity(Activity activity){
        //TODO
    }
    
    public void addFriend(User user){
        //TODO
    }
    
    public void removeFriend(Friend friend){
        //TODO
    }
    
    public void createNotification(Notification notification){
        //TODO
    }
    
    public void checkFriend(User user){
        //TODO
    }
    
    public void comparePlans(User user){
        //TODO
    }
}
