package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PresenterTest {

    private Presenter presenter;

    private static class DummyView implements IMPVContract.View {
        @Override
        public void updateTasks(java.util.ArrayList<ITask> tasks) {
        }
    }

    @BeforeEach
    void setUp() {
        presenter = new Presenter(new DummyView());
    }

    @Test
    void testAddTask() {
        int initialSize = presenter.getTasks().size();
        ITask task = new Task.Builder("Presenter Task")
                .setDueDate(LocalDate.now())
                .setClass("Test")
                .build();

        presenter.addTask(task);

        assertEquals(initialSize + 1, presenter.getTasks().size());
        assertTrue(presenter.getTasks().contains(task));
    }

    @Test
    void testIsComplete() {
        ITask task = new Task.Builder("Incomplete").setDueDate(LocalDate.now()).setClass("Test").build();
        assertFalse(presenter.isComplete(task));

        presenter.addTask(task);
        presenter.completeTask(task);

        assertTrue(presenter.isComplete(task));
    }

    @Test
    void testCancelTask() {
        ITask task = new Task.Builder("To Remove").setDueDate(LocalDate.now()).setClass("Test").build();
        presenter.addTask(task);
        presenter.cancelTask(task);

        assertFalse(presenter.getTasks().contains(task));
    }
}
