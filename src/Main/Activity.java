/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import static Main.User.getUserWithId;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Atahan
 */
public class Activity {
    private String startDate;
    private String endDate;
    private String title;
    private User creator;
    private String description;
    private String category;
    private int quota;
    private ArrayList<User> participants;
    private boolean isPublic;
    private int id;

    public Activity(String startDate, String endDate, String title, User creator, String description, String category, int quota, boolean isPublic) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.creator = creator;
        this.description = description;
        this.category = category;
        this.quota = quota;
        this.participants = new ArrayList<User>();
        participants.add(creator);
        this.isPublic = isPublic;
    }
    
    public void saveToDatabase() {

        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet rSet = null;
        
        try{
            connection = DatabaseConnection.getConnection();
            
            
            String sql = "INSERT INTO activity (startDate, endDate, title,creator_id,category,quota,isPublic) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?,)";
            pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pStatement.setString(1, startDate);
            pStatement.setString(2, endDate);
            pStatement.setString(3, title);
            pStatement.setInt(4, creator.getId());
            pStatement.setString(5, category);
            pStatement.setInt(6, quota);
            pStatement.setBoolean(7, isPublic);
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

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    public User getCreator() {
        return creator;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getQuota() {
        return quota;
    }
    
    public int getAttendence() {
        return participants.size();
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    public boolean contains(User user){
        ArrayList<User> participants = getParticipants();
        int num = participants.size();
        boolean isContain = true;
        
        for(int i = 0; i < num; i ++){
            if(participants.get(i).getId() == user.getId()){
                isContain = true;
            }
            else{
                isContain = false;
            }
        }
        
        return isContain;
    }

    public void addParticipants(int userId) {
    try (Connection conn = DatabaseConnection.getConnection()) {
        String query = "UPDATE activity SET participants = CONCAT_WS('/', participants, ?) WHERE title = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, title);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User with ID " + userId + " added to participants.");
            } else {
                // Handle case where update did not occur
                System.out.println("Failed to add user with ID " + userId + " to participants.");
            }
        }
    } catch (SQLException e) {
        // Handle SQLException
        e.printStackTrace();
    }
}
    
    public ArrayList<User> getParticipants() {
        
         ArrayList<User> participants = new ArrayList<User>();

    try (Connection conn = DatabaseConnection.getConnection()) {
        String query = "SELECT participants FROM activity WHERE title = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String participantIds = rs.getString("participants");
                if (participantIds != null && !participantIds.isEmpty()) {
                    String[] ids = participantIds.split("/");
                    for (String dbId : ids) {
                        int userId = Integer.parseInt(dbId);
                        User user = getUserWithId(userId);
                        if (user != null) {
                            participants.add(user);
                        } else {
                            System.out.println("User with ID " + userId + " not found.");
                        }
                    }
                }
            }
        }
    } catch (SQLException e) {
        // Handle SQLException
        e.printStackTrace();
    }
    return participants;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublicity(boolean isPublic){
        this.isPublic = isPublic;
    }
    
    public void setQuota(int quota){
        this.quota = quota;
    }
    
    public void joinUser(User user){
        if (!participants.contains(user) && participants.size() < quota) {
            participants.add(user);
            user.addJoinedActivity(this);
        }
    }
    
    public void leaveUser(User user){
        if (participants.contains(user)) {
            participants.remove(user);
            user.removeActivity(this);
        }
    }
    
    
}
