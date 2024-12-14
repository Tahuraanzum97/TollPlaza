package com.example.tollplazamanagmentsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class TollRateManagement
{
    @javafx.fxml.FXML
    private TextField tollRateTextField;
    @javafx.fxml.FXML
    private TableColumn<TollRate, String> tollRateCol;
    @javafx.fxml.FXML
    private TextField vehicleTypeTextField;
    @javafx.fxml.FXML
    private TableColumn<TollRate, String> vehicleTypeCol;
    @javafx.fxml.FXML
    private TableView<TollRate> rateTable;
    @javafx.fxml.FXML
    //private final ObservableList<TollRate> tollRateList;

   public TollRateManagement(ObservableList<TollRate> tollRateList) {
       this.tollRateList = tollRateList;
    }


    public void initialize() throws IOException {
        //tollRateCol.setCellValueFactory(new PropertyValueFactory<>("tollRate"));
       // vehicleTypeCol.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));




    }

    @javafx.fxml.FXML
    public void onModifyButtonClick(ActionEvent actionEvent) {
       // TollRate newTollRate = new TollRate(tollRateTextField.getText(), vehicleTypeTextField.getText());
        //tollRateList.add(newTollRate);


    }

    @javafx.fxml.FXML
    public void onReturnHomeButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainDashBoardU-5,6.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
    }
}