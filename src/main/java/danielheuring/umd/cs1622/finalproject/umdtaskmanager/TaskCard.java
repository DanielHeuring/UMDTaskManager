package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TaskCard extends HBox {

    private ITask task;
    private Label titleLabel;
    private Button completeButton;
    private Button removeButton;

    public TaskCard(ITask task, Runnable onComplete, Runnable onRemove) {
        this.task = task;

        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER_LEFT);
        this.getStyleClass().add("task-card");

        titleLabel = new Label(task.getTitle());
        titleLabel.getStyleClass().add("task-title");

        completeButton = new Button("✓");
        completeButton.getStyleClass().add("task-button");
        completeButton.setOnAction(e -> onComplete.run());

        removeButton = new Button("✕");
        removeButton.getStyleClass().add("task-button");
        removeButton.setOnAction(e -> onRemove.run());

        this.getChildren().addAll(titleLabel, completeButton, removeButton);
    }

    public ITask getTask() {
        return task;
    }
}
