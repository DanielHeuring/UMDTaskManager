package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import java.util.ArrayList;
import java.util.Comparator;

public class TaskManager {
    private ArrayList<ITask> tasks;
    private ArrayList<Course> courses;

    public TaskManager( FileReader fileReader ) {
        tasks = fileReader.readFile("tasks.txt");
        courses = fileReader.readCourses("tasks.txt");
        sortTasksByDueDate( tasks );
        }


    public static void sortTasksByDueDate(ArrayList<ITask> taskList) {
        taskList.sort(Comparator.comparing(ITask::getDueDate));
    }

    public ArrayList<ITask> getTasks() {
        return tasks;
    }

    public ArrayList<ITask> getIncompleteTasks() {
        ArrayList<ITask> incompleteTasks = new ArrayList<>();
        for (ITask curr : tasks) {
            if (!curr.isCompleted()) {
                incompleteTasks.add(curr);
            }
        }
        return incompleteTasks;
    }

    public ArrayList<ITask> getCompletedTasks() {
        ArrayList<ITask> completedTasks = new ArrayList<>();
        for (ITask curr : tasks) {
            if (curr.isCompleted()) {
                completedTasks.add(curr);
            }
        }
        return completedTasks;
    }

    public void addTask(ITask task) {
        tasks.add(task);
    }

    public void completeTask(ITask task) {
        task.completeTask();
    }

    public void removeTask(ITask task) {
        tasks.remove(task);
    }

    public ArrayList<Course> getCourses() { return courses; }
}
