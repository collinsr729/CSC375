package org.code;

public class Student {
    private Course[] courses = new Course[8];
    public static String major = "CSC";
    public static int gradeYear;
    public Student(String mj) {
        major = mj;
        gradeYear = (int)(1+Math.random()*4);
    }

    //changeMajor();

    public boolean addCourse(Course c){
        for(int i = 0; i<courses.length; i++) {
            if(courses[i]==null) {
                courses[i] = c;
                courses[i].addStudent(this);
                return true;
            }
        }
        return false;
    }

    public boolean premoveCourse(Course c) {
        for(int i = 0; i<courses.length; i++) {
            if(courses[i]==c) {
                courses[i].removeStudent(this);
                courses[i] = null;
                return courses[i] ==null;
            }
        }
        return false;
    }
    public boolean removeCourse(Course c) {
        for(int i = 0; i<courses.length; i++) {
            if(courses[i]==c) {
                courses[i] = null;
                return courses[i] ==null;
            }
        }
        return false;
    }
}
