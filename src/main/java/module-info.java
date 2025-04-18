module danielheuring.umd.cs1622.finalproject.umdtaskmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens danielheuring.umd.cs1622.finalproject.umdtaskmanager to javafx.fxml;
    exports danielheuring.umd.cs1622.finalproject.umdtaskmanager;
}