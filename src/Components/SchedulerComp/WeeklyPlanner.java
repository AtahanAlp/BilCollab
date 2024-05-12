/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components.SchedulerComp;

import java.util.ArrayList;

/**
 *
 * @author zuhalaksoy
 */
public class WeeklyPlanner {
        private ArrayList<DaySchedule> schedule;

    
    public WeeklyPlanner() {
        schedule = new ArrayList<DaySchedule>();
        for (int i = 0; i < 7; i++) {
            DaySchedule day = new DaySchedule();
            schedule.add(day);
        }
    }
    
     public void addEvent(int dayIndex, int time, Plan plannerEvent) {
        schedule.get(dayIndex).addEvent(time, plannerEvent);
    }
     
     public void addEvent(int dayIndex, int time, String eventName) {
        Plan plan = new Plan(eventName, dayIndex, time);
        addEvent(dayIndex, time, plan);
    }
     
      public void removeEvent(int dayIndex, int time) {
        schedule.get(dayIndex).removeEvent(time);
    }
  
    public String completeEvent(int dayIndex, String eventName) {
        return schedule.get(dayIndex).completeEvent(eventName);
    }
    
    public ArrayList<DaySchedule> getSchedule(){
        return schedule;
    }

}
