package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private Task task;
    private final String title = "Test Task";
    private final String className = "CS1622";
    private final LocalDate dueDate = LocalDate.of(2025, 5, 10);

    @BeforeEach
    void setUp() {
        task = new Task.Builder(title)
                .setDueDate(dueDate)
                .setClass(className)
                .build();
    }

    @Test
    void testBuilderSetsFieldsCorrectly() {
        assertEquals(title, task.getTitle());
        assertEquals(dueDate, task.getDueDate());
        assertEquals(className, task.getClassName());
        assertFalse(task.isCompleted());
    }

    @Test
    void testCompleteTaskSetsCompletedTrue() {
        task.completeTask();
        assertTrue(task.isCompleted());
    }

    @Test
    void testSetAndGetTitle() {
        task.setTitle("Updated Title");
        assertEquals("Updated Title", task.getTitle());
    }

    @Test
    void testSetAndGetDueDate() {
        LocalDate newDate = LocalDate.of(2025, 6, 1);
        task.setDueDate(newDate);
        assertEquals(newDate, task.getDueDate());
    }
}
