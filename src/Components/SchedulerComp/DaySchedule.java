/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*package Components.SchedulerComp;

import Main.Plan;
import java.util.ArrayList;*/

/**
 *
 * @author zuhalaksoy
 */
/*public class DaySchedule {
    private ArrayList<Plan> plans;
    public static final int HOURS_IN_PLANNER = 19;
    
    // Creates day planner with HOURS_IN_PLANNER slots
    public DaySchedule() {
        plans = new ArrayList<>(HOURS_IN_PLANNER);
        for (int i = 0; i < HOURS_IN_PLANNER; i++) {
            plans.add(null);
        }
    }
    
    public ArrayList<Plan> getEvents() {
        return plans;
    }
    
     public void addEvent(int time, Plan plannerEvent) {
        if (plans.get(time) == null) {
            plans.set(time, plannerEvent);
        } else {
            System.out.println("Already an event at that time");
        }
    }
     
     public void removeEvent(int time) {
        plans.set(time, null);
    }
     
     public String completeEvent(String name) {
        Boolean found = false;
        for (Plan p: plans) {
            if (p != null && p.getName().equals(name)) {
                p.complete();
                found = true;
                plans.remove(p);
            }
        }
        if (found) {
            return "Congratulations, you have completed an event!";
        }
        return "Could not find that event on that day";
    }
     
    
}*/