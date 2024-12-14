package iub.demo22;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneManager {

    private Stage stage;

    public SceneManager(Stage stage) {
        this.stage = stage;
    }

    public void switchScene(String fxmlFile) {
        try {
            // Load the new scene from the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/" + fxmlFile));
            Parent root = loader.load();

            // Set the new scene to the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            System.out.println(fxmlFile + " loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading scene: " + fxmlFile);
        }
    }
}
