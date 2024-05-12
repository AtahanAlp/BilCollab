/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components.SchedulerComp;

/**
 *
 * @author zuhalaksoy
 */
public class Plan {
    // Plan with name, time, day and whether it is completed
    
    private String name;
    private Boolean completed;
    private Integer day;
    private Integer time;
    
    public Plan(String name, Integer day, Integer time) {
        this.name = name;
        completed = false;
        this.day = day;
        this.time = time;
    }
    
      public String getName() {
        return name;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getTime() {
        return time;
    }

    public Boolean getCompleted() {
        return completed;
    }
    
     public void complete() {
        completed = true;
    }
     
     public boolean equals(Plan compare) {
        return (name.equals(compare.getName()) && completed == compare.getCompleted()
                && day == compare.getDay() && time == compare.getTime());
    }
    
}
