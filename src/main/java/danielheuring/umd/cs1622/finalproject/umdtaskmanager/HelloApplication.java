package danielheuring.umd.cs1622.finalproject.umdtaskmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application implements IMPVContract.View {
    @Override
    public void start(Stage stage) throws IOException {

        IMPVContract.Presenter presenter = new Presenter(this);

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 1440, 900);
        stage.setTitle("UMD Task Manager");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void updateTasks(ArrayList<ITask> tasks) {

    }
}