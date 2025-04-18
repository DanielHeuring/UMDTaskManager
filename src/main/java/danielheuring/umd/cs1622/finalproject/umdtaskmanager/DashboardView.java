package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.time.LocalDate;

public class DashboardView extends BorderPane {

    private Label greetingLabel;
    private DatePicker datePicker;
    private VBox sidebar;
    private HBox classColumns;
    private VBox todayTasks;
    private Label quoteLabel;

    private final IMPVContract.Presenter presenter;

    public DashboardView(IMPVContract.Presenter presenter) {
        this.presenter = presenter;
        this.getStyleClass().add("root");
        setupTop();
        setupLeftSidebar();
        setupCenter();
        setupRightSidebar();
        setupBottom();
    }

    private void setupTop() {
        HBox topBar = new HBox(20);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER_LEFT);

        greetingLabel = new Label("Hello, Daniel");
        greetingLabel.getStyleClass().add("label-title");

        datePicker = new DatePicker();
        datePicker.setEditable(false);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        topBar.getChildren().addAll(greetingLabel, spacer, datePicker);
        this.setTop(topBar);
    }

    private void setupLeftSidebar() {
        sidebar = new VBox(10);
        sidebar.setPadding(new Insets(10));
        sidebar.setAlignment(Pos.TOP_CENTER);

        for (int i = 0; i < 7; i++) {
            Button btn = new Button();
            btn.getStyleClass().add("sidebar-button");
            sidebar.getChildren().add(btn);
        }

        Button addButton = new Button("+");
        addButton.getStyleClass().add("sidebar-button");
        addButton.setOnAction(e -> showAddTaskDialog());
        sidebar.getChildren().add(addButton);

        this.setLeft(sidebar);
    }

    private void setupCenter() {
        classColumns = new HBox(10);
        classColumns.setPadding(new Insets(10));
        classColumns.setAlignment(Pos.TOP_CENTER);

        // Placeholder for 5 class columns
        for (int i = 0; i < 5; i++) {
            VBox column = new VBox(5);
            column.setStyle("-fx-border-color: #ccc; -fx-background-color: #f9f9f9;");
            column.setPrefWidth(150);
            column.setPrefHeight(400);

            Label classLabel = new Label("Class " + (i + 1));
            classLabel.getStyleClass().add("label-section");
            column.getChildren().add(classLabel);

            for (int j = 0; j < 3; j++) {
                ITask sampleTask = new Task.Builder("Task C" + (i + 1) + "." + (j + 1)).build();
                TaskCard card = new TaskCard(
                        sampleTask,
                        () -> System.out.println("Completed: " + sampleTask.getTitle()),
                        () -> System.out.println("Removed: " + sampleTask.getTitle())
                );
                column.getChildren().add(card);
            }

            classColumns.getChildren().add(column);
        }

        this.setCenter(classColumns);
    }

    private void setupRightSidebar() {
        todayTasks = new VBox(10);
        todayTasks.setPadding(new Insets(10));
        todayTasks.setAlignment(Pos.TOP_CENTER);

        Label todayLabel = new Label("Today");
        todayLabel.getStyleClass().add("label-section");
        todayTasks.getChildren().add(todayLabel);

        LocalDate today = LocalDate.now();
        for (ITask task : presenter.getTasks()) {
            if (task.getDueDate().equals(today)) {
                TaskCard card = new TaskCard(
                        task,
                        () -> {
                            presenter.completeTask(task);
                            refreshUI();
                        },
                        () -> {
                            presenter.cancelTask(task);
                            refreshUI();
                        }
                );
                todayTasks.getChildren().add(card);
            }
        }

        this.setRight(todayTasks);
    }

    private void setupBottom() {
        quoteLabel = new Label("\"Push yourself, because no one else is going to do it for you.\"");
        quoteLabel.getStyleClass().add("quote-label");
        this.setBottom(quoteLabel);
    }

    public void refreshUI() {
        this.getChildren().clear();
        setupTop();
        setupLeftSidebar();
        setupCenter();
        setupRightSidebar();
        setupBottom();
    }

    private void showAddTaskDialog() {
        Dialog<ITask> dialog = new Dialog<>();
        dialog.setTitle("Add New Task");

        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField();

        Label dueDateLabel = new Label("Due Date:");
        DatePicker dueDatePicker = new DatePicker();

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        grid.add(titleLabel, 0, 0);
        grid.add(titleField, 1, 0);
        grid.add(dueDateLabel, 0, 1);
        grid.add(dueDatePicker, 1, 1);

        dialog.getDialogPane().setContent(grid);

        ButtonType addButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButtonType) {
                String title = titleField.getText();
                LocalDate dueDate = dueDatePicker.getValue();
                if (title != null && !title.isEmpty() && dueDate != null) {
                    return new Task.Builder(title).setDueDate(dueDate).build();
                }
            }
            return null;
        });

        dialog.showAndWait().ifPresent(task -> {
            presenter.addTask(task);
            refreshUI();
        });
    }
}