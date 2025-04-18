package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import java.time.LocalDate;
import java.util.Date;

public interface ITask {
    public LocalDate getDueDate();
    public void setDueDate(LocalDate dueDate);
    public void completeTask();
    public void cancelTask();
    public String getTitle();
    public void setTitle(String title);
    public boolean isCompleted();

}
