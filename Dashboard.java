package iub.demo22;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dashboard {

    @FXML
    private Label tollcollectionreportsFx;

    @FXML
    private Label errorlabelFx;

    @FXML
    private DatePicker datepickerfx;

    private static final String FILE_NAME = "toll_reports.dat";
    @FXML
    private Label selectdateFx;
    @FXML
    private TableColumn <Report, String>Vehiclecatagoryfx;
    @FXML
    private TableColumn<Report, String> transactionfx;
    @FXML
    private TableColumn<Report,  String> timerangefx;
    @FXML
    private TableColumn<Report, String> totalammountfx;
    @FXML
    private TableView tableviewreportsFx;

    @FXML
    public void initialize() {
        Vehiclecatagoryfx.setCellValueFactory(new PropertyValueFactory<>("vehicleCategory"));
        transactionfx.setCellValueFactory(new PropertyValueFactory<>("transactions"));
        timerangefx.setCellValueFactory(new PropertyValueFactory<>("timeRange"));
        totalammountfx.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        errorlabelFx.setText("");
        tableviewreportsFx.getItems().clear();
    }


    @FXML
    public void loadreportsOA(ActionEvent event) {
        LocalDate selectedDate = datepickerfx.getValue();
        if (selectedDate == null) {
            errorlabelFx.setText("select a date");
            return;
        }
        errorlabelFx.setText("");
        List<Report> allReports = readReportsFromFile();
        List<Report> filterReports = new ArrayList<>();
        for (Report report: allReports){
            if (report.ReportDate().equals(selectedDate)) {
                filterReports.add(report);
            }
        }
        tableviewreportsFx.getItems().setAll(filterReports);
    }

    public void writeSampleReportsToFile() {
        List<Report> reports = new ArrayList<>();
        reports.add(new Report("Car", 120, "08:00 AM - 08:00 PM", 6000.0, LocalDate.of(2024, 12, 14)));
        reports.add(new Report("Truck", 45, "08:00 AM - 08:00 PM", 9000.0, LocalDate.of(2024, 12, 14)));
        reports.add(new Report("Bike", 200, "08:00 AM - 08:00 PM", 3000.0, LocalDate.of(2024, 12, 13)));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(reports);
            System.out.println("reports written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Report> readReportsFromFile() {
        List<Report> reports = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            reports = (List<Report>) ois.readObject();
            System.out.println("Reports read from file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            writeSampleReportsToFile();
            reports = readReportsFromFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return reports;
    }

    public static class Report implements Serializable {
        private String vehicleCategory;
        private int transactions;
        private String timeRange;
        private double totalAmount;
        private LocalDate reportDate;

        public Report(String vehicleCategory, int transactions, String timeRange, double totalAmount, LocalDate Date) {
            this.vehicleCategory = vehicleCategory;
            this.transactions = transactions;
            this.timeRange = timeRange;
            this.totalAmount = totalAmount;
            this.reportDate = reportDate;
        }

        public String getVehicleCategory() {
            return vehicleCategory;
        }

        public void setVehicleCategory(String vehicleCategory) {
            this.vehicleCategory = vehicleCategory;
        }

        public int getTransactions() {
            return transactions;
        }

        public void setTransactions(int transactions) {
            this.transactions = transactions;
        }

        public String getTimeRange() {
            return timeRange;
        }

        public void setTimeRange(String timeRange) {
            this.timeRange = timeRange;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public Object ReportDate() {
            return reportDate;
        }
    }
}
