package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestingReader implements FileReader {

    // Testing Function to Supply ArrayList of Tasks
    @Override
    public ArrayList<ITask> readFile(String fileName) {
        ArrayList<ITask> tasks = new ArrayList<>();
        tasks.add(new Task.Builder("HW 1")
                .setDueDate(LocalDate.now().plusDays(1))
                .setClass("CS 1622")
                .build());

        tasks.add(new Task.Builder("Lab Report")
                .setDueDate(LocalDate.now().plusDays(2))
                .setClass("CE 1000")
                .build());

        tasks.add(new Task.Builder("Study MIDTERM")
                .setDueDate(LocalDate.now().plusDays(3))
                .setClass("CS 2531")
                .build());

        tasks.add(new Task.Builder("Sketchbook")
                .setDueDate(LocalDate.now().plusDays(0))
                .setClass("ART 1900")
                .build());

        tasks.add(new Task.Builder("Website Draft")
                .setDueDate(LocalDate.now().plusDays(5))
                .setClass("Personal")
                .build());

        tasks.add(new Task.Builder("Group Project")
                .setDueDate(LocalDate.now().plusDays(6))
                .setClass("CS 1622")
                .build());

        tasks.add(new Task.Builder("Essay")
                .setDueDate(LocalDate.now().plusDays(7))
                .setClass("ART 1900")
                .build());

        tasks.add(new Task.Builder("Code Review")
                .setDueDate(LocalDate.now().plusDays(8))
                .setClass("CS 2531")
                .build());
        return tasks;
    }

    @Override
    public ArrayList<Course> readCourses(String fileName) {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add( new Course( "CS 1622" , "Willemsen" ));
        courses.add( new Course( "CS 2531" , "Knight" ));
        courses.add( new Course( "CE 1000" , "Schokker" ));
        courses.add( new Course( "ART 1900" , "Klug" ));
        courses.add( new Course( "Personal" , "Heuring" ));
        return courses;
    }
}
