package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import java.util.ArrayList;

public interface IMPVContract {

    interface View {

        public void updateTasks( ArrayList<ITask> tasks );

    }

    interface Presenter {

        public void addTask( ITask task );
        public void completeTask( ITask task );
        public void cancelTask( ITask task );
        public ArrayList<ITask> getTasks();
        public ArrayList<ITask> getIncompleteTasks();
        public ArrayList<ITask> getCompletedTasks();

    }

}

