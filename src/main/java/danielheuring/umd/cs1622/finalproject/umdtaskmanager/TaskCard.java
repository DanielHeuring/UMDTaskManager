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

        setSpacing(10);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER_LEFT);
        setStyle("-fx-border-color: #ccc; -fx-background-color: #fefefe; -fx-border-radius: 5; -fx-background-radius: 5;");

        titleLabel = new Label(task.getTitle());
        titleLabel.setStyle("-fx-font-weight: bold;");

        completeButton = new Button("✓");
        completeButton.setOnAction(e -> onComplete.run());

        removeButton = new Button("✕");
        removeButton.setOnAction(e -> onRemove.run());

        getChildren().addAll(titleLabel, completeButton, removeButton);
    }

    public ITask getTask() {
        return task;
    }
}
