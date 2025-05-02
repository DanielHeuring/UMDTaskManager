package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import java.time.LocalDate;

public class Task implements ITask {
    private String title;
    private LocalDate dueDate;
    private boolean isCompleted;
    private String className;

    // Task Builder
    public Task( Builder builder ) {
        this.title = builder.title;
        this.dueDate = builder.dueDate;
        this.isCompleted = builder.isCompleted;
        this.className = builder.className;
    }

    public static class Builder {
        private String title;
        private LocalDate dueDate;
        private boolean isCompleted;
        private String className;

        public Builder( String title ) {
            this.title = title;
            this.isCompleted = false;
        }

        public Builder setDueDate( LocalDate dueDate ) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder setClass( String className ) {
            this.className = className;
            return this;
        }

        public Task build() {
            return new Task( this );
        }
    }

    // ITask Member Functions
    @Override
    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public void completeTask() {
        this.isCompleted = true;
    }

    @Override
    public void cancelTask() {

    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String getClassName() { return className; }
}
