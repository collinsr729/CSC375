package org.code;

import java.util.concurrent.*;

public class tests{
    Student[] studs;
    Course[] cos;
    public tests(Student[] s, Course[] c){
        studs = s;
        cos = c;
    }

    public void AddCourses(){
        for(Course c : cos)
            for(Student s : studs){
                if(c.courseInfo.equals(s.major)){
                    s.addCourse(c);
                }
            }
    }
}