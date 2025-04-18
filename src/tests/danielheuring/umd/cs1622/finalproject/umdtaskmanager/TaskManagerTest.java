package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void sortTasksByDueDate() {
        FileReader testReader = new TestingReader();
        TaskManager manager = new TaskManager( testReader );
        for (int i=0; i<manager.getTasks().size(); i++) {
            Task curr = manager.getTasks().get(i);

            System.out.println(curr.getDueDate());
        }
        manager.sortTasksByDueDate( manager.getTasks() );
        for (int i=0; i<manager.getTasks().size(); i++) {
            Task curr = manager.getTasks().get(i);

            System.out.println(curr.getDueDate());
        }
    }
}