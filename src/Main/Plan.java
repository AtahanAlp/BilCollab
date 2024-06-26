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
    private Integer day;
    private Integer startTime;
    private Integer endTime;
    
    
    public Plan(String name, Integer day, Integer time, Integer endTime) {
        this.name = name;
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
    
    public boolean isIntersects(Plan other){
        boolean isIntersect;
    
        return((endTime > other.getStartTime() && startTime < other.getEndTime()) || 
               (other.getEndTime() > startTime && other.getStartTime() < endTime));
    }
    
     public boolean equals(Plan p) {
        return (name.equals(p.getName()) && day == p.getDay() && startTime == p.getStartTime() && endTime == p.getEndTime());
    }
    
}
