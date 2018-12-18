package main.mainWorkWindow.tasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.DAOManager;

import java.net.URL;
import java.util.ResourceBundle;

public class task1Controller {

    @FXML private Button bt_issueBook;
    @FXML private TextField tf_student_rno;
    @FXML private TextField tf_book_isbn;

    @FXML protected void issueBookAction(ActionEvent event){
        String student_rno = tf_student_rno.getText();

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

        String book_isbn = tf_book_isbn.getText();
        int status = DAOManager.assignBook(student_rno,book_isbn);

       if(status == 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Book Issued Successfully");
            alert.showAndWait();
       }
       else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Failed to issue Book");
            alert.showAndWait();
       }
    }
}
