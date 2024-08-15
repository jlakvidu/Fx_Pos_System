package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;

public class UpdateCustomerFormController {

    public JFXTextField txtContactNumber;

    public ComboBox<String> comTitle;

    public DatePicker dateDOB;
    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtDob;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    void btnSearchCustomerOnAction(ActionEvent event) {
        ObservableList<Customer> customerArrayList = DBConnection.getInstance().getCustomerArrayList();
        for (Customer customer : customerArrayList) {
            if (txtId.getText().equals(customer.getId())) {
                txtName.setText(customer.getName());
                txtAddress.setText(customer.getAddress());
                txtContactNumber.setText(customer.getContactNumber());

                ObservableList<String> title = FXCollections.observableArrayList();
                title.add(customer.getTitle());
                if(customer.getTitle().equals("Mr.")){
                    title.add("Mis.");
                }else{
                    title.add("Mr.");
                }
                comTitle.setItems(title);
                comTitle.setValue(customer.getTitle());

                dateDOB.setValue(customer.getDob());
                return;
            }
        }
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Error: This customer is does not exit.");
        alert.show();
    }

    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) {
        String customerId = txtId.getText();
        ObservableList<Customer> customerArrayList = DBConnection.getInstance().getCustomerArrayList();

        for (int i = 0; i < customerArrayList.size(); i++) {
            Customer customer = customerArrayList.get(i);

            if (txtId.getText().equals(customer.getId())) {
                customer.setName(txtName.getText());
                customer.setAddress(txtAddress.getText());
                customer.setDob(dateDOB.getValue());
                customer.setTitle(comTitle.getValue());
                customer.setContactNumber(txtContactNumber.getText());

                customerArrayList.set(i, customer);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText(" Customer Updated Sussessfully.");
                alert.show();
                cleartxt();
                return;
            }
        }
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Error: This customer is does not exit.");
        alert.show();
    }

    public void cleartxt(){
        txtId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        txtContactNumber.setText(null);
        dateDOB.setValue(null);
        comTitle.getSelectionModel().clearSelection();
    }
}
