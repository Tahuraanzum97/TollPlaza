package iub.demo22;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Tollplaza1controller<users> {

    @FXML
    private TextField usernamefield;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private Label errorlabel;

    private ArrayList<User> users = new ArrayList<>();
    private final String filePath = "user.txt";


    public Tollplaza1controller() throws IOException {
        loadUsersFromFile();

        // users.add(new User("Manager", "123456"));
        // users.add(new User("Operator", "operator123"));
    }

    @FXML
    public void loginbutton(ActionEvent actionEvent) {
        String username = usernamefield.getText();
        String password = passwordfield.getText();

        if (username.isEmpty() || password.isEmpty()) {
            errorlabel.setText("Username and Password cannot be empty.");
            return;
        }

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("TollPlazaDashboard.fxml"));
                    BorderPane dashboardPane = loader.load();
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(dashboardPane);
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                    errorlabel.setText("Error.");
                }
                return;
            }
        }

        errorlabel.setText("Invalid Username or Password.");
    }

    private void loadUsersFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new User(parts[0], parts[1]));

                }

            }
        } catch (FileNotFoundException e) {
            users.add(new User("Manager", "123789"));
            users.add(new User("Operator", "OP456789"));
            saveUsersToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void saveUsersToFile() throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for (User user : users){
                writer.write(user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
        }
    }

    private static class User {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
