package model;

import java.util.HashMap;
import java.util.Map;

/**
 * INVARIANT: course list and grade list are the same size
 * each course has a grade associated, and vice versa, at matching indices
 */
public class Transcript {
    String studentName;
    int studentID;
    Map<String, Double> courseGrades = new HashMap<>();
    public Transcript(String studentName, int studentID){
        this.studentName = studentName;
        this.studentID = studentID;
    }

    //getters and setters
    public String getStudentName(){return studentName;}
    public int getStudentID(){return studentID;}
    public Map<String, Double> getCourseGrades(){return courseGrades;}

    //REQUIRES: grade between 0.0 and 4.0, course not null
    //MODIFIES: this
    //EFFECTS: add corresponding grade and course name to transcript
    public void addGrade(String course, double grade){
        if(grade >= 0.0 && grade <= 4.0){
            courseGrades.put(course,grade);
        }
        else{
            System.out.println("Enter valid grade");
        }
    }

    //REQUIRES: a course the student has already taken.
    //EFFECTS: return course name and grade in format CourseName: Grade
    public String getCourseAndGrade(String course){
        return course + ": " + courseGrades.get(course) + ", ";
    }

    //EFFECTS: prints course names with grades earned
    public void printTranscript(){
        for(String key : courseGrades.keySet()){
            System.out.print(getCourseAndGrade(key));
        }
        System.out.println("");
    }

    //EFFECTS: return student GPA
    public double getGPA(){
        double ans = 0.0;
        if(courseGrades.size() == 0){
            return 0.0;
        }
        for(String key : courseGrades.keySet()){
            ans += courseGrades.get(key);
        }
        System.out.print("GPA: " );
        return ans/courseGrades.size();
    }

}
