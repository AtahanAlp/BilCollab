/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Components.ProfileComp.ProfilePanel;
import java.sql.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;

/**
 *
 * @author Atahan
 */
public class User {
    //public static final BufferedImage DEFAULT_PROFILE_PIC = ImageIO.read(new File("profilePic.png"));
    private static User currentUser;
    private int id;
    private String username;
    private String password;
    private String mail;
    private String displayName;
    private BufferedImage profilePic;
    private String description;
    private ArrayList<Activity> allActivities;
    private ArrayList<Activity> createdActivities;
    private ArrayList<Activity> joinedActivities;
    private ArrayList<Plan> plans;
    private ArrayList<Notification> notifications;
    private ArrayList<FriendRequest> friendRequests;
    private ArrayList<User> friends;
    private ProfilePanelProvider profilePanelProvider;

  

    public User(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
        displayName = username;
        this.id = getId();
        // = DEFAULT_PROFILE_PIC;
        setDescription();

        allActivities = new ArrayList<Activity>();
        createdActivities = new ArrayList<Activity>();
        joinedActivities = new ArrayList<Activity>();
        plans = new ArrayList<Plan>();
        notifications = new ArrayList<Notification>();
        friendRequests = new ArrayList<FriendRequest>();
        friends = new ArrayList<User>();
    }
    public User(ProfilePanelProvider profilePanelProvider) {
        this.profilePanelProvider = profilePanelProvider;
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
        int id = -1; 
         
        Connection connection = null; 
        PreparedStatement stmt = null; 
        ResultSet rs = null; 
 
        try { 
            connection = DatabaseConnection.getConnection(); 
             
            String sql = "SELECT id FROM User WHERE username = ?"; 
            stmt = connection.prepareStatement(sql); 
            stmt.setString(1, username); 
            rs = stmt.executeQuery(); 
            if (rs.next()) { 
                id  = rs.getInt("id"); 
            } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } finally{            
            DatabaseConnection.close(connection, stmt, rs); 
        } 
         
        this.id = id; 
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
    
    public String getDescription() {
        return description;
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
        createdActivities = new ArrayList<Activity>();
        getAllActivities();
        for (Activity activity : allActivities) {
            if (activity.getCreator().getId() == id) {
                createdActivities.add(activity);
            }
        }
        
        return createdActivities;
    }

    public ArrayList<Activity> getJoinedActivities() {
        joinedActivities = new ArrayList<Activity>();

         try (Connection conn = DatabaseConnection.getConnection()) {
           PreparedStatement stmt = conn.prepareStatement("SELECT * FROM activity WHERE participants LIKE ?");
            stmt.setString(1, "%" +  id + "%");
            
            ResultSet resultSet = stmt.executeQuery();
               while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    String startDate = resultSet.getString("startDate");
                    String endDate = resultSet.getString("endDate");
                    int quota = resultSet.getInt("quota");
                    boolean isPublic = resultSet.getBoolean("isPublic");
                    String category = resultSet.getString("category");
                    int userId = resultSet.getInt("creator_id");

                    joinedActivities.add(new Activity(startDate, endDate, title, getUserWithId(userId), description, category, quota, isPublic));
               }
        } catch (SQLException e) {
            // Handle SQLException
            e.printStackTrace();
        }

        return joinedActivities;
    }
    
        public void addParticipantToActivity(Activity activity) {
        String participants = "";
            
        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet rSet = null;
        
        try{
            connection = DatabaseConnection.getConnection();
           
            PreparedStatement fetchStatement = connection.prepareStatement("SELECT participants FROM activity WHERE title = ?");
            fetchStatement.setString(1, activity.getTitle());
            ResultSet resultSet = fetchStatement.executeQuery();

            if (resultSet.next()) {
                participants = resultSet.getString("participants");

                participants += id + "/";
                
                // Update the participants string in the database
                PreparedStatement updateStatement = connection.prepareStatement("UPDATE activity SET participants = ? WHERE title = ?");
                updateStatement.setString(1, participants);
                updateStatement.setString(2, activity.getTitle());
                updateStatement.executeUpdate();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            
            DatabaseConnection.close(connection, pStatement, rSet);
        }
          

    }
    
    public void joinActivity(Activity activity){
        
        ArrayList<User> participants = activity.getParticipants();
        participants.add(this);
        this.addParticipantToActivity(activity);
        
    }

    public ArrayList<Activity> getAllActivities() {
        allActivities = new ArrayList<Activity>();
        
        try {
                Connection connect = DatabaseConnection.getConnection();

                Statement statement = connect.createStatement();

                // Result set get the result of the SQL query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM activity");

                // Iterate over the ResultSet, adding each activity to the ArrayList
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    String startDate = resultSet.getString("startDate");
                    String endDate = resultSet.getString("endDate");
                    int quota = resultSet.getInt("quota");
                    boolean isPublic = resultSet.getBoolean("isPublic");
                    String category = resultSet.getString("category");
                    int userId = resultSet.getInt("creator_id");

                    allActivities.add(new Activity(startDate, endDate, title, getUserWithId(userId), description, category, quota, isPublic));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return allActivities;
    }

    public ArrayList<Activity> getSpecificActivities(String str) {
        ArrayList<Activity> activities = new ArrayList<Activity>();
        
        try {
                Connection connect = DatabaseConnection.getConnection();

                Statement statement = connect.createStatement();

                PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM activity WHERE title LIKE ? OR description LIKE ?");
                preparedStatement.setString(1, "%" + str + "%");
                preparedStatement.setString(2, "%" + str + "%");

                ResultSet resultSet = preparedStatement.executeQuery();

                // Iterate over the ResultSet, adding each activity to the ArrayList
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    String startDate = resultSet.getString("startDate");
                    String endDate = resultSet.getString("endDate");
                    int quota = resultSet.getInt("quota");
                    boolean isPublic = resultSet.getBoolean("isPublic");
                    String category = resultSet.getString("category");

                    activities.add(new Activity(startDate, endDate, title, this, description, category, quota, isPublic));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return activities;
    }
    
    public ArrayList<Activity> getSpecificActivitiesByCategory(String category) {
        ArrayList<Activity> activities = new ArrayList<Activity>();
        
        try {
                Connection connect = DatabaseConnection.getConnection();

                Statement statement = connect.createStatement();
                category = "%" + category + "%"; // The '%' is a wildcard character that matches any number of characters

                PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM activity WHERE category LIKE ?");;
                preparedStatement.setString(1, category);

                ResultSet resultSet = preparedStatement.executeQuery();

                // Iterate over the ResultSet, adding each activity to the ArrayList
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String description1 = resultSet.getString("description");
                    String startDate = resultSet.getString("startDate");
                    String endDate = resultSet.getString("endDate");
                    int quota = resultSet.getInt("quota");
                    boolean isPublic = resultSet.getBoolean("isPublic");
                    String category1 = resultSet.getString("category");

                    activities.add(new Activity(startDate, endDate, title, this, description1, category1, quota, isPublic));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return activities;
    }
    
    

    public ArrayList<Plan> getPlans() {
        return plans;
    }
     public static User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<Notification> getNotifications() {
    ArrayList<Notification> notifications = new ArrayList<>();
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        connection = DatabaseConnection.getConnection();

        String sql = "SELECT id, creationDate, information, isSeen, sender_id, receiver_id FROM notification WHERE receiver_id = ?";
        stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        
        while (rs.next()) {
            int notificationId = rs.getInt("id");
            String creationDate = rs.getString("creationDate");
            String description = rs.getString("information");
            boolean isSeen = rs.getBoolean("isSeen");
            int senderId = rs.getInt("sender_id");
            int receiverId = rs.getInt("receiver_id");

            User sender = getUserWithId(senderId);
            User receiver = getUserWithId(receiverId);

            Notification notification = new Notification(description, sender);
            notifications.add(notification);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        DatabaseConnection.close(connection, stmt, rs);
    }

    return notifications;
}

    public ArrayList<FriendRequest> getFriendRequests() {
        
         ArrayList<FriendRequest> friendRequests = new ArrayList<FriendRequest>();

    try (Connection conn = DatabaseConnection.getConnection()) {
        String query = "SELECT sender_id FROM FriendRequests WHERE reciever_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                    int senderId = rs.getInt("sender_id");
                    friendRequests.add(new FriendRequest(this, getUserWithId(id)));
            }
        }
    } catch (SQLException e) {
        // Handle SQLException
        e.printStackTrace();
    }
    return friendRequests;
    }
    
    public boolean sendFriendRequest(String username) {
    User recipient = getUserByUsername(username);
    if (recipient == null) {
        System.out.println("User not found.");
        return false;
    }
    
    if (isFriendOrRequestPending(recipient.getId())) {
        System.out.println("Friend request already sent or you are already friends.");
        return false;
    }

    String sql = "INSERT INTO FriendRequest (sender_id, receiver_id) VALUES (?, ?)";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, this.id);
        stmt.setInt(2, recipient.getId());
        stmt.executeUpdate();
        
         String description = this.username + " has sent you a friend request!";
        recipient.createNotification(description, this);
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

private User getUserByUsername(String username) {
    String sql = "SELECT * FROM User WHERE username = ?";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, username);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                String mail = rs.getString("mail");
                String password = rs.getString("password");
                User user = new User(username, mail, password);
                user.setId(rs.getInt("id")); // for the id of the user
                return user;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

private boolean isFriendOrRequestPending(int userId) {
    String sql = "SELECT * FROM FriendRequest WHERE (sender_id = ? AND receiver_id = ?) OR (sender_id = ? AND receiver_id = ?)";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, this.id);
        stmt.setInt(2, userId);
        stmt.setInt(3, userId);
        stmt.setInt(4, this.id);
        try (ResultSet rs = stmt.executeQuery()) {
            return rs.next();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
private boolean isFriendRequestSent(int userId) {
    String sql = "SELECT * FROM FriendRequest WHERE sender_id = ? AND receiver_id = ?";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, this.id);
        stmt.setInt(2, userId);
        try (ResultSet rs = stmt.executeQuery()) {
            return rs.next();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    
public ArrayList<User> getFriends(int userId) {
    ArrayList<User> friendsList = new ArrayList<>();

    try (Connection conn = DatabaseConnection.getConnection()) {
        String query = "SELECT friends FROM user WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String friendIds = rs.getString("friends");
                if (friendIds != null && !friendIds.isEmpty()) {
                    String[] ids = friendIds.split("/");
                    for (String dbId : ids) {
                        int friendId = Integer.parseInt(dbId);
                        User friend = getUserWithId(friendId);
                        if (friend != null) {
                            friendsList.add(friend);
                        } else {
                            System.out.println("User with ID " + friendId + " not found.");
                        }
                    }
                }
            }
        }
    } catch (SQLException e) {
        // Handle SQLException
        e.printStackTrace();
    }

    return friendsList;
}
public interface ProfilePanelProvider {
    JPanel getProfilePanel();
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
            String query = "UPDATE user SET friends = CONCAT(COALESCE(friends, ''), ?) WHERE id = ?";
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

    public void removeActivity(Activity activity) {
        joinedActivities.remove(activity);
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public void removeFriend(User friend) {
        friends.remove(friend);
    }


    public void createNotification(String description, User sender) {
    Notification notification = new Notification(description, sender);

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement pStatement = connection.prepareStatement(
                 "INSERT INTO notification (information, sender_id, receiver_id) VALUES (?, ?, ?)")) {

        pStatement.setString(1, description);
        pStatement.setInt(2, sender.getId());
        pStatement.setInt(3, this.id);
        pStatement.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Add the notification to the user's notifications list
    this.notifications.add(notification);
}

    public boolean checkFriend(User user) {
        for(User u: getFriends(this.getId())){
            if(u.getId() == user.getId()){
                return true;
            }
            
        }
        return false;
    }


    public void addJoinedActivity(Activity activity){
        
    }
    
    public boolean createActivity(String title, String description, String startDate, String endDate, int quota, boolean isPublic, String category) {
        if (!title.trim().equals("") && !description.trim().equals("")) {//TODO: &&check collisions!!!

            try {
                Connection connect = DatabaseConnection.getConnection();

            // PreparedStatements can use variables and are more efficient
                PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO activity (title, description, startDate, endDate, quota, isPublic, category, creator_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            // Parameters start with 1
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, description);
                preparedStatement.setString(3, startDate);
                preparedStatement.setString(4, endDate);
                preparedStatement.setInt(5, quota);
                preparedStatement.setBoolean(6, isPublic);
                preparedStatement.setString(7, category);
                preparedStatement.setInt(8, getId());

                preparedStatement.executeUpdate();

                createdActivities.add(new Activity(startDate, endDate, title, this, description, category, quota, isPublic));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public static ArrayList<User> getAllUsers() {
    ArrayList<User> users = new ArrayList<>();

    try (Connection conn = DatabaseConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM User")) {

        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String mail = rs.getString("mail");
            String password = rs.getString("password");
            User user = new User(username, mail, password);
            user.setId(id);
            users.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return users;
}

    public void switchToProfilePanel() {
        JPanel profilePanel = profilePanelProvider.getProfilePanel();
        
    }
    
    public JPanel getProfilePanel(User user) {
        ProfilePanel profilePanel = new ProfilePanel();
        return profilePanel;
    }
}
