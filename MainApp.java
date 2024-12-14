package iub.demo22;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/iub/demo22/Tollplaza1.fxml"));
            Parent root = loader.load();
            Tollplaza1controller controller = loader.getController();
            primaryStage.setTitle("Toll Plaza Login");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
