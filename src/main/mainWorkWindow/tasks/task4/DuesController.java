package main.mainWorkWindow.tasks.task4;

import app.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.mainWorkWindow.tasks.task4Controller;
import util.DAOManager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class DuesController implements Initializable {

    @FXML private TableView<Book> table;
    @FXML private TableColumn<Book,String> isbn;
    @FXML private TableColumn<Book,String> name;
    @FXML private TableColumn<Book,String> author;
    @FXML private TableColumn<Book,Double> price;
    @FXML private Label lbl_total_due_amount;

    public ObservableList<Book> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Book> bookList = DAOManager.getDues(task4Controller.getStudentId());
        Double total_due_amount=0.0;
        for(Book b : bookList){
            total_due_amount+=b.getPrice();
        }
        lbl_total_due_amount.setText(Double.toString(total_due_amount));
        list.addAll(bookList);
        isbn.setCellValueFactory(new PropertyValueFactory<Book,String>("isbn"));
        name.setCellValueFactory(new PropertyValueFactory<Book,String>("name"));
        author.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        price.setCellValueFactory(new PropertyValueFactory<Book,Double>("price"));
        table.setItems(list);
    }

    @FXML protected void clearDuesAction(ActionEvent event) throws IOException{
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirm");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("Are you sure ?");
        Optional<ButtonType> confirmResult = confirmAlert.showAndWait();
        if(confirmResult.get() == ButtonType.OK){
            int status = DAOManager.clearDues(task4Controller.getStudentId());
            if(status > 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Status");
                alert.setHeaderText(null);
                alert.setContentText("Dues Cleared Successfully");
                alert.showAndWait();
                cancelAction(event);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Status");
                alert.setHeaderText(null);
                alert.setContentText("Error occurred while clearing Dues");
                alert.showAndWait();
            }
        }
    }

    @FXML protected void cancelAction(ActionEvent event) throws IOException{
        task4Controller.getduesStage().close();
    }
}
