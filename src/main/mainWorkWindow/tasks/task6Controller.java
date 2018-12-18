package main.mainWorkWindow.tasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.DAOManager;

public class task6Controller {

    @FXML private TextField tf_rno;
    @FXML private TextField tf_name;
    @FXML private TextField tf_class;
    @FXML private TextField tf_email;
    @FXML private TextField tf_contact;

    @FXML protected void addStudentAction(ActionEvent event){
        String rno = tf_rno.getText();
        String name = tf_name.getText();
        String studentClass = tf_class.getText();
        String email = tf_email.getText();
        String contact = tf_contact.getText();

        System.out.println(studentClass.length());
        System.out.println(contact.length());

        try{
            Integer.parseInt(rno);
            Integer.parseInt(contact);
            if(studentClass.length()>10 || contact.length()!=10 ) {
                throw new Exception();
            }
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("student id should be an integer\nClass should be in the format= Standard-Section ex. 10-A\nContact should be a 10 digit integer value");
            alert.showAndWait();
            return;
        }

        int status = DAOManager.addStudent(rno,name,studentClass,email,contact);

        if(status == 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Student Added Successfully");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Failed to add Student");
            alert.showAndWait();
        }
    }
}
