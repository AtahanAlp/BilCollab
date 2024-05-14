/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Atahan
 */
public class User {

    public static int count = 0;
    //public static final BufferedImage DEFAULT_PROFILE_PIC = ImageIO.read(new File("profilePic.png"));

    private int id;
    private String username;
    private String password;
    private String mail;
    private String displayName;
    private BufferedImage profilePic;
    private String description;
    private ArrayList<Activity> createdActivities;
    private ArrayList<Activity> joinedActivities;
    private ArrayList<Plan> plans;
    private ArrayList<Notification> notifications;
    private ArrayList<FriendRequest> friendRequests;
    private ArrayList<User> friends;

    public User() {
        this("ali", "mail", "123");
    }

    public User(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        displayName = username;
        // = DEFAULT_PROFILE_PIC;
        description = "";

        createdActivities = new ArrayList<Activity>();
        joinedActivities = new ArrayList<Activity>();
        plans = new ArrayList<Plan>();
        notifications = new ArrayList<Notification>();
        friendRequests = new ArrayList<FriendRequest>();
        friends = new ArrayList<User>();
    }

    private void saveToDatabase() {

        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet rSet = null;
        
        try{
            connection = DatabaseConnection.getConnection();
            
            
            String sql = "INSERT INTO user (username, password, mail) VALUES (?, ?, ?)";
            pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pStatement.setString(1, username);
            pStatement.setString(2, password);
            pStatement.setString(3, mail);
            pStatement.executeUpdate();
                    
            rSet = pStatement.getGeneratedKeys();
            if (rSet.next()) {
                id = rSet.getInt(1);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            
            DatabaseConnection.close(connection, pStatement, rSet);
        }
          

    }

    //getter methods
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
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

    public ArrayList<Activity> getAllActivities() {
        //TODO
        return new ArrayList<Activity>();
    }

    public ArrayList<Activity> getSpecificActivities(String str) {
        //TODO
        return new ArrayList<Activity>();
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

    public ArrayList<User> getFriends() {
        ArrayList<User> userFriends = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM user WHERE id != ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setInt(1, getId());

                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int friendId = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String friendPassword = rs.getString("password");

                    User friend = new User(name, email, friendPassword);
                    friend.setId(friendId);
                    userFriends.add(friend);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userFriends;
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

    private void setId(int i) {
        this.id = i;
    }

    //other methods
    public void addPlan(Plan plan) {
        //TODO
    }

    public void addActivity(Activity activity) {
        joinedActivities.add(activity);
    }

    public void removeActivity(Activity activity) {
        joinedActivities.remove(activity);
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void removeFriend(User friend) {
        friends.remove(friend);
    }

    public void removeRequest(FriendRequest request) {
        friendRequests.remove(request);
    }

    public void createNotification(Notification notification) {
        //TODO
    }

    public void checkFriend(User user) {
        //TODO
    }

    public void comparePlans(User user) {
        //TODO
    }

    public boolean createActivity(String title, String description, Date startDate, Date endDate, int quota, boolean isPublic, String category) {
        if (!title.trim().equals("") && description.trim().equals("") && checkDateCollision(startDate, endDate)) {//TODO: &&check collisions!!!
            //TODO database part!!!
            createdActivities.add(new Activity(startDate, endDate, title, this, description, category, quota, isPublic));
            return true;
        }
        return false;
    }

    private boolean checkDateCollision(Date startDate, Date endDate) {
        //TODO
        return true;
    }
}
