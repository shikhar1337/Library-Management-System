package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {

    @FXML private Label lbl_username;
    @FXML private Label lbl_password;
    @FXML private TextField tf_username;
    @FXML private PasswordField pwf_password;
    @FXML private Button bt_login;

    private static Stage mainWorkWindowStage;

    public static Stage getMainWorkWindowStage(){
        return mainWorkWindowStage;
    }

    @FXML protected void loginAction(ActionEvent event) throws IOException {
        if(tf_username.getText().equals("admin") && pwf_password.getText().equals("admin")){
            Stage loginStage = Main.getLoginStage();
            loginStage.close(); // hides or closes the login scene (also primaryStage.hide() works the same)

            mainWorkWindowStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("mainWorkWindow/display.fxml"));
            Scene mainWorkWindowScene = new Scene(root);
            mainWorkWindowScene.getStylesheets().add(getClass().getResource("mainWorkWindow/display.css").toExternalForm());
            mainWorkWindowStage.setTitle("Library Admin Panel");
            mainWorkWindowStage.setScene(mainWorkWindowScene);
            mainWorkWindowStage.show();

        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Status");
            alert.setHeaderText(null);
            alert.setContentText("Incorrect username or password");
            alert.showAndWait();
        }
    }
}
