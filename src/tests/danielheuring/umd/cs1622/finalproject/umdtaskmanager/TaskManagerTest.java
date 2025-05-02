package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        FileReader reader = new TestingReader();  // uses predefined tasks
        taskManager = new TaskManager(reader);
    }

    @Test
    void testAddTask() {
        int initialSize = taskManager.getTasks().size();
        ITask task = new Task.Builder("JUnit Task")
                .setDueDate(LocalDate.now())
                .setClass("Test")
                .build();

        taskManager.addTask(task);

        assertEquals(initialSize + 1, taskManager.getTasks().size());
        assertTrue(taskManager.getTasks().contains(task));
    }

    @Test
    void testCompleteTask() {
        ITask task = taskManager.getIncompleteTasks().get(0);
        taskManager.completeTask(task);

        assertTrue(task.isCompleted());
    }

    @Test
    void testRemoveTask() {
        ITask task = taskManager.getTasks().get(0);
        taskManager.removeTask(task);

        assertFalse(taskManager.getTasks().contains(task));
    }

    @Test
    void testGetCompletedTasks() {
        ITask task = taskManager.getIncompleteTasks().get(0);
        taskManager.completeTask(task);

        assertTrue(taskManager.getCompletedTasks().contains(task));
    }

    @Test
    void testSortTasksByDueDate() {
        ArrayList<ITask> tasks = taskManager.getTasks();
        for (int i = 0; i < tasks.size() - 1; i++) {
            assertTrue(tasks.get(i).getDueDate().compareTo(tasks.get(i + 1).getDueDate()) <= 0);
        }
    }
}
