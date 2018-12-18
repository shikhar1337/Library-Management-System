package main.mainWorkWindow.tasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import util.DAOManager;

import java.util.Optional;


public class task2Controller {
    @FXML private TextField tf_book_isbn;
    @FXML private Button bt_reissueBook;
    @FXML private Button bt_returnBook;

    @FXML protected void reissueBookAction(ActionEvent event){
        String book_isbn = tf_book_isbn.getText();
        int status = DAOManager.reissueBook(book_isbn);

        if(status == 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Book Reissued Successfully");
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Failed to reissue Book");
            alert.showAndWait();
        }

    }

    @FXML protected void returnBookAction(ActionEvent event){
        String book_isbn = tf_book_isbn.getText();
        int ifFine = DAOManager.getFine(book_isbn);
        int fine = 10*ifFine;
        if(fine > 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Late Return");
            alert.setHeaderText(null);
            alert.setContentText("Late return of book." + "\n" + "A fine of Rs." + fine + " is applicable.\n" + "Proceed ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                int status = DAOManager.returnBook(book_isbn);

                if (status == 1) {
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    alert2.setTitle("Status");
                    alert2.setHeaderText(null);
                    alert2.setContentText("Book Returned to Library");
                    alert2.showAndWait();
                } else {
                    Alert alert2 = new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("Status");
                    alert2.setHeaderText(null);
                    alert2.setContentText("Failed to return book");
                    alert2.showAndWait();
                }

            } else
                return;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Failed to get Fine detail.");
            alert.showAndWait();
        }
    }
}
