/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Atahan
 */
public class Activity {
    private Date startDate;
    private Date endDate;
    private String title;
    private User creator;
    private String description;
    private String category;
    private int quota;
    private ArrayList<User> participants;
    private boolean isPublic;

    public Activity(Date startDate, Date endDate, String title, User creator, String description, String category, int quota, boolean isPublic) {
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
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

    public ArrayList<User> getParticipants() {
        return participants;
    }

    public boolean isIsPublic() {
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
            user.addActivity(this);
        }
    }
    
    public void leaveUser(User user){
        if (participants.contains(user)) {
            participants.remove(user);
            user.removeActivity(this);
        }
    }
    
    
}
