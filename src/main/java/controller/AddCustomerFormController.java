package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;


public class
AddCustomerFormController implements Initializable {

    public JFXTextField txtContactNumber;
    @FXML
    private ComboBox<String> comTitle;

    @FXML
    private DatePicker dateDOB;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    int index=1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateId();
        ObservableList<String> title = FXCollections.observableArrayList();
        title.add("Mr.");
        title.add("Miss.");
        comTitle.setItems(title);

    }

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        Customer customer = new Customer(txtId.getText(),comTitle.getValue(),txtName.getText(), txtAddress.getText(),dateDOB.getValue(),txtContactNumber.getText());
        ObservableList<Customer> customerArrayList = DBConnection.getInstance().getCustomerArrayList();
        customerArrayList.add(customer);
        onSubmit();
        cleartxt();
        generateId();

    }

    private void onSubmit() {
        if (txtId.getText().isEmpty() || comTitle.getValue() == null || txtName.getText().isEmpty() || txtAddress.getText().isEmpty() || dateDOB.getValue() == null || txtContactNumber.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Error: Please fill in all required fields.");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Customer Added Successfully.");
            alert.show();
        }
    }

    public void cleartxt(){
       txtId.setText(null);
       txtName.setText(null);
       txtAddress.setText(null);
       txtContactNumber.setText(null);
       dateDOB.setValue(null);
       comTitle.getSelectionModel().clearSelection();
    }

    public void generateId() {
        ObservableList<Customer> customerArrayList = DBConnection.getInstance().getCustomerArrayList();
        if (customerArrayList.isEmpty()) {
            txtId.setText("C001");
        } else {
            String lastId = customerArrayList.get(customerArrayList.size() - 1).getId();
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            txtId.setText(String.format("C%03d", newId));
        }
    }
}
