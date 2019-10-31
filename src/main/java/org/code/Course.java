package org.code;

public class Course {
    double startTime,endTime;
    volatile Student[] inCourse = new Student[30];
    String professor = "Doug Lee";
    String courseInfo = "CSC";
    public int courseLevel = 375;
    public Course(String c) {
        courseInfo = c;
        courseLevel = (int)(Math.random()*400+100);
    }

    public boolean addStudent(Student s) {
        for(int i = 0; i<inCourse.length; i++) {
            if(CASnull(i,s).equals(s)) {
                return true;
            }
        }
        return false;
    }

    public synchronized Student CASnull(int exp, Student newStudent) {
        Student read = inCourse[exp];
        if(read == null)
            inCourse[exp] = newStudent;
        return inCourse[exp];
    }
    public synchronized Student CASreset(int exp, Student remStudent) {
        Student read = inCourse[exp];
        if(read == remStudent)
            inCourse[exp] = null;
        return inCourse[exp];
    }

    public boolean premoveStudent(Student student) {
        for(int i = 0; i<inCourse.length; i++) {
            if(inCourse[i].equals(student)) {
                inCourse[i].removeCourse(this);
                if(CASreset(i,student).equals(null)) {
                    return true;
                }}
        }
        return false;

    }


    public boolean removeStudent(Student student) {
        for(int i = 0; i<inCourse.length; i++) {
            if(inCourse[i].equals(student)) {
                if(CASreset(i,student).equals(null)) {
                    return true;
                }}
        }
        return false;

    }
}
