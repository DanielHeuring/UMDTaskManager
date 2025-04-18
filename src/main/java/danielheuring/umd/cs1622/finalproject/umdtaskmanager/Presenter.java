package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import java.util.ArrayList;

public class Presenter implements IMPVContract.Presenter {

    private final IMPVContract.View view;
    private final TaskManager taskManager;

    public Presenter( IMPVContract.View view ) {

        this.view = view;

        FileReader reader = new TestingReader();

        this.taskManager = new TaskManager( reader );
    }

    @Override
    public void addTask(ITask task) {
        taskManager.addTask( task );
    }

    @Override
    public void completeTask(ITask task) {
        taskManager.completeTask( task );
    }

    @Override
    public void cancelTask(ITask task) {
        taskManager.removeTask( task );
    }

    @Override
    public ArrayList<ITask> getTasks() {
        return taskManager.getTasks();
    }

    @Override
    public ArrayList<ITask> getIncompleteTasks() {
        return taskManager.getIncompleteTasks();
    }

    @Override
    public ArrayList<ITask> getCompletedTasks() {
        return taskManager.getCompletedTasks();
    }
}
