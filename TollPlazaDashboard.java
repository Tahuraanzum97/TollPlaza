package iub.demo22;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TollPlazaDashboard {

    @FXML
    private BorderPane dashboardfx;

    private SceneManager sceneManager;

    public TollPlazaDashboard() {
    }
    public void SetSceneManager(SceneManager sceneManager){
        this.sceneManager =sceneManager;
    }

    private void loadFXML(String fxmlFile) {
        try {
            if (dashboardfx != null) {
                System.out.println("Load Fxml File: + fxmlFile");
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + fxmlFile));
                Node node = fxmlLoader.load();
                dashboardfx.setCenter(node);
                System.out.println(fxmlFile + "loaded Successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error" + fxmlFile + ": " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void loginEvent(String event) {
        String fileName = "event_login.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.append("Event: " + event + " occurred at " + System.currentTimeMillis() + "\n");
            System.out.println("Event Login: " + event);
        } catch (IOException e) {
            System.err.println("Error while logging the event.");
            throw new RuntimeException(e);
        }
    }
    @FXML
    private void loadScene(String fxmlFile, ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/" + fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading scene: " + fxmlFile);
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void loadLoginScreen(String fxmlFile,ActionEvent actionEvent){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tollplaza1.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            if (stage != null && scene!=null){
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
            System.err.println("Error");
            throw new RuntimeException(e);
        }

    }
    @FXML
    public void maintanancemanagementsOA(ActionEvent actionEvent) {
        loadFXML("MaintenanceManagement.fxml");
        System.out.println("MaintenanceManagement.fxml loaded successfully.");
    }

    @FXML
    public void signoutOA(ActionEvent actionEvent) {
        System.out.println("Sign Out clicked.");
        if (sceneManager != null) {
            sceneManager.switchScene("Tollplaza1.fxml");
        }
        else{
            System.err.println("Error");
        }
        loginEvent("Sign Out");
    }
    @FXML
    private void loadFxml(String fxmlfile, ActionEvent actionevent){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/loginScreen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
            if (stage!= null && scene !=null) {
                stage.setScene(scene);
                stage.show();
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void disputeresolutionOA(ActionEvent actionEvent) {
        System.out.println("Dispute Resolution clicked.");
        loadFXML("DisputeResolution.fxml");
    }

    @FXML
    public void revenuereportsOA(ActionEvent actionEvent) {
        System.out.println("Revenue Reports clicked.");
        loadFXML("RevenueReports.fxml");
    }

    @FXML
    public void tollratesmanagementsOA(ActionEvent actionEvent) {
        System.out.println("Toll Rates Management clicked.");
        loadFXML("TollRatesManagement.fxml");
    }

    @FXML
    public void perfomancemonitoringOA(ActionEvent actionEvent) {
        System.out.println("Performance Monitoring clicked.");
        loadFXML("PerformanceMonitoring.fxml");
    }

    @FXML
    public void vehiclesclassificationOA(ActionEvent actionEvent) {
        System.out.println("Vehicles Classification clicked.");
        loadFXML("VehiclesClassification.fxml");
    }

    @FXML
    public void profileOA(ActionEvent actionEvent) {
        System.out.println("Profile clicked.");
        loadFXML("Profile.fxml");
    }

    @FXML
    public void employeemanagementsOA(ActionEvent actionEvent) {
        System.out.println("Employee Management clicked.");
        loadFXML("EmployeeManagement.fxml");
    }

    @FXML
    public void tollcollectionreportsOA(ActionEvent actionEvent) {
        System.out.println("Toll Collection Reports clicked.");
        String fxmlPath = "dashboard.fxml";
        System.out.println("Load fxml File:" + fxmlPath);
        loadFXML(fxmlPath);
        System.out.println("dashboard.fxml loading Completed");
    }

    @FXML
    public void securitysettingsOA(ActionEvent actionEvent) {
        System.out.println("Security Settings clicked.");
        loadFXML("SecuritySettings.fxml");
    }

    @FXML
    public void trafficmonitoringOA(ActionEvent actionEvent) {
        System.out.println("Traffic Monitoring clicked.");
        loadFXML("TrafficMonitoring.fxml");
    }

    @FXML
    public void gatemanagementsOA(ActionEvent actionEvent) {
        System.out.println("Gate Management clicked.");
        loadFXML("GateManagement.fxml");
    }

    @FXML
    public void dashboardOA(ActionEvent actionEvent) {
        System.out.println("Dashboard clicked.");
        loadFXML("Dashboard.fxml");
    }
}