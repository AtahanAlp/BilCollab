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
public class WeeklySchedule {
    public static final int HOURS_IN_PLANNER = 19;
    
    private ArrayList<Plan> plans;
    
    public WeeklySchedule(){
           plans = new ArrayList<Plan>(HOURS_IN_PLANNER);
           
    }

    public static int getHOURS_IN_PLANNER() {
        return HOURS_IN_PLANNER;
    }

    public ArrayList<Plan> getPlans() {
        return plans;
    }
    
    
}
