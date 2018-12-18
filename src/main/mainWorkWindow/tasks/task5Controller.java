package main.mainWorkWindow.tasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.DAOManager;

public class task5Controller {

    @FXML private Button bt_addBook;
    @FXML private TextField tf_isbn;
    @FXML private TextField tf_name;
    @FXML private TextField tf_author;
    @FXML private TextField tf_price;

    @FXML protected void addBookAction(ActionEvent event){
        String isbn = tf_isbn.getText();
        String name = tf_name.getText();
        String author = tf_author.getText();
        Double price=0.0;

        try{
            price = Double.parseDouble(tf_price.getText());
        }
        catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Price should be a double value.");
            alert.showAndWait();
            return;
        }

        int status = DAOManager.addBook(isbn,name,author,price);

        if(status == 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Book Added Successfully");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Failed to add Book");
            alert.showAndWait();
        }
    }
}
