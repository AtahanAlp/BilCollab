/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author zuhalaksoy
 */
public class Plan {
    // Plan with name, time, day and whether it is completed
    
    private String name;
    private Boolean completed;
    private Integer day;
    private Integer startTime;
    private Integer endTime;
    
    
    public Plan(String name, Integer day, Integer time, Integer endTime) {
        this.name = name;
        completed = false;
        this.day = day;
        this.startTime = time;
        this.endTime = endTime;
    }
    
      public String getName() {
        return name;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getStartTime() {
        return startTime;
    }
    public Integer getEndTime() {
        return endTime;
    }

      public void setName(String name) {
        this.name = name;
    }

    public void setDay(int day) {
        this.day = day;
    }
    
    public Boolean getCompleted() {
        return completed;
    }
    
     public void complete() {
        completed = true;
    }
     
     public boolean equals(Plan compare) {
        return (name.equals(compare.getName()) && completed == compare.getCompleted()
                && day == compare.getDay() && startTime == compare.getStartTime() && endTime == compare.getEndTime());
    }
    
}
