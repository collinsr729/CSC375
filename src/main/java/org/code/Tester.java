package org.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Tester {
    static JPanel panel = new JPanel();
    static Student[] students = new Student[20];
    static Course[] courses = new Course[50];
    public static void start() {		//get jmh running first
        createStudentsAndCourses();
        createGUI(new JFrame());
    }

    private static void createStudentsAndCourses() {
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

    }

    public static void createGUI(JFrame frame) {		//want to add a bunch of buttons to this to access different functions mostly views
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        panel = new JPanel();
        panel.setSize(500, 250);
        JPanel pan2 = new JPanel();
        pan2.setSize(500, 50);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        String[] searchExamples = { "Sonos", "Sony", "Samsung", "Asus", "LG", "HTC" };
        panel.setLayout(new BorderLayout());
        JTextField text = new JTextField("Welcome to the Amazon search database");
        text.setEditable(false);
        panel.add(text);

        JTextArea text2 = new JTextArea(
                "\n\nYou can choose from pre-selected search options\n or create your own\n\nTo exit, simply close the window.");
        text2.setEditable(false);
        panel.add(text2);

        JComboBox searchList = new JComboBox(searchExamples);
        searchList.setEditable(true);
        pan2.add(searchList);

        JButton dbButton = new JButton();
        dbButton.setText("View Students");
        Font newButtonFont = new Font(dbButton.getFont().getName(), Font.BOLD, dbButton.getFont().getSize());
        dbButton.setFont(newButtonFont);
        dbButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.removeAll();
                panel.removeAll();
                panelStudents();
                //clickDB(new JFrame(), (String) searchList.getSelectedItem());
            }

            private void panelStudents() {
                // TODO Auto-generated method stub

            }
        });
        pan2.add(dbButton);

        JButton webButton = new JButton();
        webButton.setText("View Students by Class Section");
        webButton.setFont(newButtonFont);
        webButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                frame.setVisible(false);
                frame.removeAll();
                panel.removeAll();
                panelClasses();
//				panelClasses();
                //clickWeb(new JFrame(), (String) searchList.getSelectedItem());
            }

            private void panelClasses() {
                // TODO Auto-generated method stub

            }
        });
        pan2.add(webButton);

        frame.add(text, BorderLayout.PAGE_START);
        frame.add(text2, BorderLayout.CENTER);
        frame.add(pan2, BorderLayout.PAGE_END);

        frame.setVisible(true);
        pan2.setVisible(true);

    }



}
