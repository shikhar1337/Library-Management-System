package main.mainWorkWindow;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.Main;

import java.io.IOException;

public class Controller {

    public static Stage task1Stage;
    public static Stage task2Stage;
    public static Stage task3Stage;
    public static Stage task4Stage;
    public static Stage task5Stage;
    public static Stage task6Stage;

    @FXML private Button bt_task1;
    @FXML private Button bt_task2;
    @FXML private Button bt_task3;
    @FXML private Button bt_logout;

    public static Stage getTask1Stage(){
        return task1Stage;
    }
    public static Stage getTask2Stage(){
        return task2Stage;
    }
    public static Stage getTask3Stage(){
        return task3Stage;
    }
    public static Stage getTask4Stage(){
        return task4Stage;
    }
    public static Stage getTask5Stage(){
        return task5Stage;
    }
    public static Stage getTask6Stage(){
        return task6Stage;
    }

    @FXML protected void logoutAction(ActionEvent event) throws IOException {
        Stage loginStage = Main.getLoginStage();
        Stage mainWorkWindowStage = main.Controller.getMainWorkWindowStage();
        mainWorkWindowStage.close(); // hides or closes the login scene (also primaryStage.hide() works the same)

        Parent root = FXMLLoader.load(getClass().getResource("/main/display.fxml"));
        Scene mainScene = new Scene(root);
        mainScene.getStylesheets().add(getClass().getResource("/main/display.css").toExternalForm());
        loginStage.setTitle("Library Management Software");
        loginStage.setScene(mainScene);
        loginStage.show();

    }

    @FXML protected void task1Action(ActionEvent event) throws IOException {
        Stage mainWorkWindowStage = main.Controller.getMainWorkWindowStage();

        task1Stage = new Stage();
        task1Stage.initModality(Modality.APPLICATION_MODAL);
        task1Stage.initOwner(mainWorkWindowStage);

        Parent root = FXMLLoader.load(getClass().getResource("tasks/task1View.fxml"));
        Scene task1Scene = new Scene(root);
        task1Scene.getStylesheets().add(getClass().getResource("tasks/task1.css").toExternalForm());

        task1Stage.setTitle("Issue Book");
        task1Stage.setScene(task1Scene);
        task1Stage.show();
    }

    @FXML protected void task2Action(ActionEvent event) throws IOException {
        Stage mainWorkWindowStage = main.Controller.getMainWorkWindowStage();

        task2Stage = new Stage();
        task2Stage.initModality(Modality.APPLICATION_MODAL);
        task2Stage.initOwner(mainWorkWindowStage);

        Parent root = FXMLLoader.load(getClass().getResource("tasks/task2View.fxml"));
        Scene task2Scene = new Scene(root);
        task2Scene.getStylesheets().add(getClass().getResource("tasks/task2.css").toExternalForm());

        task2Stage.setTitle("Reissues & Returns");
        task2Stage.setScene(task2Scene);
        task2Stage.show();
    }

    @FXML protected void task3Action(ActionEvent event) throws IOException {
        Stage mainWorkWindowStage = main.Controller.getMainWorkWindowStage();

        task3Stage = new Stage();
        task3Stage.initModality(Modality.APPLICATION_MODAL);
        task3Stage.initOwner(mainWorkWindowStage);

        Parent root = FXMLLoader.load(getClass().getResource("tasks/task3View.fxml"));
        Scene task3Scene = new Scene(root);
        task3Scene.getStylesheets().add(getClass().getResource("tasks/task3.css").toExternalForm());

        task3Stage.setTitle("View Defaulters");
        task3Stage.setScene(task3Scene);
        task3Stage.show();
    }

    @FXML protected void task4Action(ActionEvent event) throws IOException {
        Stage mainWorkWindowStage = main.Controller.getMainWorkWindowStage();

        task4Stage = new Stage();
        task4Stage.initModality(Modality.APPLICATION_MODAL);
        task4Stage.initOwner(mainWorkWindowStage);

        Parent root = FXMLLoader.load(getClass().getResource("tasks/task4View.fxml"));
        Scene task4Scene = new Scene(root);
        task4Scene.getStylesheets().add(getClass().getResource("tasks/task4.css").toExternalForm());

        task4Stage.setTitle("No Dues Verification");
        task4Stage.setScene(task4Scene);
        task4Stage.show();
    }

    @FXML protected void task5Action(ActionEvent event) throws IOException {
        Stage mainWorkWindowStage = main.Controller.getMainWorkWindowStage();

        task5Stage = new Stage();
        task5Stage.initModality(Modality.APPLICATION_MODAL);
        task5Stage.initOwner(mainWorkWindowStage);

        Parent root = FXMLLoader.load(getClass().getResource("tasks/task5View.fxml"));
        Scene task5Scene = new Scene(root);
        task5Scene.getStylesheets().add(getClass().getResource("tasks/task5.css").toExternalForm());

        task5Stage.setTitle("Add Book");
        task5Stage.setScene(task5Scene);
        task5Stage.show();
    }

    @FXML protected void task6Action(ActionEvent event) throws IOException {
        Stage mainWorkWindowStage = main.Controller.getMainWorkWindowStage();

        task6Stage = new Stage();
        task6Stage.initModality(Modality.APPLICATION_MODAL);
        task6Stage.initOwner(mainWorkWindowStage);

        Parent root = FXMLLoader.load(getClass().getResource("tasks/task6View.fxml"));
        Scene task6Scene = new Scene(root);
        task6Scene.getStylesheets().add(getClass().getResource("tasks/task6.css").toExternalForm());

        task6Stage.setTitle("Add Student");
        task6Stage.setScene(task6Scene);
        task6Stage.show();
    }
}
