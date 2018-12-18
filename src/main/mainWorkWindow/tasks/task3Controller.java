package main.mainWorkWindow.tasks;

import app.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.DAOManager;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class task3Controller implements Initializable {

    @FXML private TableView<Student> table;
    @FXML private TableColumn<Student,String> rollNumber;
    @FXML private TableColumn<Student,String> name;
    @FXML private TableColumn<Student,String> studentClass;
    @FXML private TableColumn<Student,String> email;
    @FXML private TableColumn<Student,String> contact;

    public ObservableList<Student> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Student> studentList = DAOManager.getDefaulters();
        list.addAll(studentList);
        rollNumber.setCellValueFactory(new PropertyValueFactory<Student,String>("rollNumber"));
        name.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        studentClass.setCellValueFactory(new PropertyValueFactory<Student,String>("studentClass"));
        email.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        contact.setCellValueFactory(new PropertyValueFactory<Student,String>("contact"));
        table.setItems(list);
    }
}
