/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.ArrayList;
import java.util.Date;
import jdk.jfr.Description;

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
}
