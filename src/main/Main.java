package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage loginStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        loginStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("display.fxml"));
        Scene loginScene = new Scene(root);
        loginScene.getStylesheets().add(getClass().getResource("display.css").toExternalForm());

        primaryStage.setTitle("Library Management Software");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static Stage getLoginStage(){
        return loginStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
