package com.example.tollplazamanagmentsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDashBoardU56Controller
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @FXML
    public void onFinanceOfficerButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TollRateManagement.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }


}