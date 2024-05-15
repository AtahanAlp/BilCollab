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
        setDescription();

        createdActivities = new ArrayList<Activity>();
        joinedActivities = new ArrayList<Activity>();
        plans = new ArrayList<Plan>();
        notifications = new ArrayList<Notification>();
        friendRequests = new ArrayList<FriendRequest>();
        friends = new ArrayList<User>();
    }

    public void saveToDatabase() {

        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet rSet = null;
        
        try{
            connection = DatabaseConnection.getConnection();
            
            
            String sql = "INSERT INTO user (username, password, mail,name) VALUES (?, ?, ?, ?)";
            pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pStatement.setString(1, username);
            pStatement.setString(2, password);
            pStatement.setString(3, mail);
            pStatement.setString(4, username);
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
    
    public static User getUserWithId(int id){ 
        User user = null; 
         
        Connection connection = null; 
        PreparedStatement stmt = null; 
        ResultSet rs = null; 
 
        try { 
            connection = DatabaseConnection.getConnection(); 
             
            String sql = "SELECT * FROM User WHERE id = ?"; 
            stmt = connection.prepareStatement(sql); 
            stmt.setInt(1, id); 
            rs = stmt.executeQuery(); 
            if (rs.next()) { 
                String username = rs.getString("username"); 
                String mail = rs.getString("mail"); 
                String password = rs.getString("password"); 
                 
                user = new User(username, mail, password); 
                user.setId(id); 
            } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } finally{            
            DatabaseConnection.close(connection, stmt, rs); 
        } 
         
        return user; 
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

    public String setDescription() { 
        String description = ""; 
         
        Connection connection = null; 
        PreparedStatement stmt = null; 
        ResultSet rs = null; 
 
        try { 
            connection = DatabaseConnection.getConnection(); 
             
            String sql = "SELECT description FROM User WHERE username = ?"; 
            stmt = connection.prepareStatement(sql); 
            stmt.setString(1, username); 
            rs = stmt.executeQuery(); 
            if (rs.next()) { 
                description  = rs.getString("description"); 
            } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } finally{            
            DatabaseConnection.close(connection, stmt, rs); 
        } 
         
        this.description = description; 
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
         notifications = new ArrayList<Notification>(); 
         
        Connection connection = null; 
        PreparedStatement stmt = null; 
        ResultSet rs = null; 
 
        try { 
            connection = DatabaseConnection.getConnection(); 
             
            String sql = "SELECT information, sender_id FROM notification WHERE receiver_id = ?"; 
            stmt = connection.prepareStatement(sql); 
            stmt.setInt(1, id); 
            rs = stmt.executeQuery(); 
            while (rs.next()) { 
                String info = rs.getString("information"); 
                int senderId = rs.getInt("sender_id"); 
                User sender = getUserWithId(senderId); 
                notifications.add(new Notification(info, sender)); 
            } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } finally{            
            DatabaseConnection.close(connection, stmt, rs); 
        } 
         
        return notifications; 
    }

    public ArrayList<FriendRequest> getFriendRequests() {
        return friendRequests;
    }

    public ArrayList<User> getFriends() {
        
        ArrayList<User> userFriends = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM user WHERE id IN (SELECT CAST(value AS UNSIGNED) FROM STRING_SPLIT(friends, '/'))";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                ResultSet rs = stmt.executeQuery();
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

    public void setId(int i) {
        this.id = i;
    }

    //other methods
    public void addPlan(Plan plan) {
        //TODO
    }
    
    public void acceptRequest (FriendRequest request) {
       addFriend(request.getSender());
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE users SET friends = CONCAT(COALESCE(friends, ''), ?) WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
            // Add sender to reciever
            stmt.setString(1, "/" + request.getSender().getId());
            stmt.setInt(2, getId());
            stmt.executeUpdate();

            // Add reciever to sender
            stmt.setString(1, "/" + getId());
            stmt.setInt(2, request.getSender().getId());
            stmt.executeUpdate();
            }
        } catch (SQLException e) {
        e.printStackTrace();
        }
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

    public boolean checkFriend(User user) {
        for(User u: this.getFriends()){
            if(u.getId() == user.getId()){
                return true;
            }
            
        }
        return false;
    }


    public boolean createActivity(String title, String description, String startDate, String endDate, int quota, boolean isPublic, String category) {
        if (!title.trim().equals("") && description.trim().equals("") ) {//TODO: &&check collisions!!!
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
