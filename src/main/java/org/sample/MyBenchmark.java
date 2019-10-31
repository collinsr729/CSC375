/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, cd INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.code.*;

public class MyBenchmark {

//    private class Student {
//        private Course[] courses = new Course[8];
//        public  String major;
//        public  int gradeYear;
//        public Student(String mj) {
//            major = mj;
//            gradeYear = (int)(1+Math.random()*4);
//        }
//
//        //changeMajor();
//
//        public boolean addCourse(Course c){
//            for(int i = 0; i<courses.length; i++) {
//                if(courses[i]==null) {
//                    courses[i] = c;
//                    courses[i].addStudent(this);
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        public boolean premoveCourse(Course c) {
//            for(int i = 0; i<courses.length; i++) {
//                if(courses[i]==c) {
//                    courses[i].removeStudent(this);
//                    courses[i] = null;
//                    return courses[i] ==null;
//                }
//            }
//            return false;
//        }
//        public boolean removeCourse(Course c) {
//            for(int i = 0; i<courses.length; i++) {
//                if(courses[i]==c) {
//                    courses[i] = null;
//                    return courses[i] ==null;
//                }
//            }
//            return false;
//        }
//    }
//    private class Course {
//        double startTime, endTime;
//        volatile Student[] inCourse = new Student[30];
//        String professor = "Doug Lee";
//        String courseInfo = "CSC";
//        public int courseLevel;
//
//        public Course(String c) {
//            courseInfo = c;
//            courseLevel = (int) (Math.random() * 400 + 100);
//        }
//
//        public boolean addStudent(Student s) {
//            for (int i = 0; i < inCourse.length; i++) {
//                if (CASnull(i, s).equals(s)) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        public synchronized Student CASnull(int exp, Student newStudent) {
//            Student read = inCourse[exp];
//            if (read == null)
//                inCourse[exp] = newStudent;
//            return inCourse[exp];
//        }
//
//        public synchronized Student CASreset(int exp, Student remStudent) {
//            Student read = inCourse[exp];
//            if (read == remStudent)
//                inCourse[exp] = null;
//            return inCourse[exp];
//        }
//
//        public boolean premoveStudent(Student student) {
//            for (int i = 0; i < inCourse.length; i++) {
//                if (inCourse[i].equals(student)) {
//                    inCourse[i].removeCourse(this);
//                    if (CASreset(i, student).equals(null)) {
//                        return true;
//                    }
//                }
//            }
//            return false;
//
//        }
//
//
//        public boolean removeStudent(Student student) {
//            for (int i = 0; i < inCourse.length; i++) {
//                if (inCourse[i].equals(student)) {
//                    if (CASreset(i, student).equals(null)) {
//                        return true;
//                    }
//                }
//            }
//            return false;
//
//        }
//    }
    private static Course[] createData(Student[] students, Course[] courses){
        int majors = 6;

        Random r = new Random();
        for(int i = 0; i<students.length;i++) {
            switch(r.nextInt(majors)) {
                case 0:
                    students[i] = new Student("CSC");
                    break;
                case 1:
                    students[i] = new Student("COM");
                    break;
                case 2:
                    students[i] = new Student("PHL");
                    break;
                case 3:
                    students[i] = new Student("HIS");
                    break;
                case 4:
                    students[i] = new Student("EDU");
                    break;
                case 5:
                    students[i] = new Student("MUS");
                    break;

            }

        }
        for(int i = 0; i<courses.length;i++) {
            switch(r.nextInt(majors)) {
                case 0:
                    courses[i] = new Course("CSC");
                    break;
                case 1:
                    courses[i] = new Course("COM");
                    break;
                case 2:
                    courses[i] = new Course("PHL");
                    break;
                case 3:
                    courses[i] = new Course("HIS");
                    break;
                case 4:
                    courses[i] = new Course("EDU");
                    break;
                case 5:
                    courses[i] = new Course("MUS");
                    break;

            }
        }
        return courses;
    }

@State(Scope.Thread)
public static class MyState {


      Student[] students = new Student[50];
      Course[] courses = new Course[15];
//    ThreadLocalRandom r = new ThreadLocalRandom();

    @Setup(Level.Trial)
    public void doSetup() {
//        sum = 0;
        createData(students,courses);
    }
//
//    @TearDown(Level.Trial)
//    public void doTearDown() {
//        System.out.println("Do TearDown");
//    }
//
//    public int a = 1;
//    public int b = 2;
//    public int sum ;
}

//    @Setup
//    public void setup(MyState state){
//        createData(state.students,state.courses);
//    }

    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
    @Measurement(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
    @Fork(1)
    @Benchmark
    public  void testSetup(MyState state) {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.

//        Tester.start();
//    createData(state.students,state.courses);
    testAddClasses(state);
    runThreads();
    }

//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
//    @Measurement(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
//    @Fork(2)
//    @Benchmark
    private void testAddClasses(MyState state){
        org.code.tests t = new org.code.tests(state.students,state.courses);
        t.AddCourses();

    }

    private void runThreads(){
        org.code.tests.runThreads();
    }





}
