package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestingReader implements FileReader {

    // Testing Function to Supply ArrayList of Tasks
    @Override
    public ArrayList<ITask> readFile(String fileName) {
        ArrayList<ITask> tasks = new ArrayList<>();
        tasks.add(new Task.Builder( "Task 3" ).setDueDate(LocalDate.now()).build());
        tasks.add(new Task.Builder( "Task 1" ).setDueDate(LocalDate.of(2000,3,12)).build());
        tasks.add(new Task.Builder( "Task 2" ).setDueDate(LocalDate.of(2024, 4, 12)).build());

        return tasks;
    }
}
