package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//JDK option with 1.8_221 works

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("ExampleLayoutAlex.fxml"));
        primaryStage.setTitle("Hello Agent");
        primaryStage.setScene(new Scene(root, 1280, 700));
        primaryStage.show();
        primaryStage.setResizable(true);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
