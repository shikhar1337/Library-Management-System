package main.mainWorkWindow.tasks;

import app.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.DAOManager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class task4Controller {

    private static Stage duesStage;
    private static String student_rno;

    @FXML private TextField tf_student_rno;
    @FXML private Button bt_check_for_dues;


    public static Stage getduesStage(){
        return duesStage;
    }

    public static String getStudentId(){
        return student_rno;
    }

    @FXML protected void checkForDuesAction(ActionEvent event) throws IOException{
        student_rno = tf_student_rno.getText();

        try{
            Integer.parseInt(student_rno);
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Student ID should be an integer value.");
            alert.showAndWait();
            return;
        }

        int status = DAOManager.checkforDues(student_rno);

        if(status == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("No dues owed");
            alert.showAndWait();
        }
        else{
            Stage task4Stage = main.mainWorkWindow.Controller.getTask4Stage();
            duesStage = new Stage();
            duesStage.initModality(Modality.APPLICATION_MODAL);
            duesStage.initOwner(task4Stage);

            Parent root = FXMLLoader.load(getClass().getResource("task4/duesView.fxml"));
            Scene duesScene = new Scene(root);
            duesScene.getStylesheets().add(getClass().getResource("task4/dues.css").toExternalForm());

            duesStage.setTitle("Dues");
            duesStage.setScene(duesScene);
            duesStage.show();
        }

    }
}
