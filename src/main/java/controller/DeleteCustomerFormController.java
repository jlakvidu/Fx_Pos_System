package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import model.Customer;

public class DeleteCustomerFormController {

    public JFXTextField txtContactNumber;
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
                txtDob.setText(String.valueOf(customer.getDob()));
                txtTitle.setText(customer.getTitle());
                txtContactNumber.setText(customer.getContactNumber());
                return;
            }
        }
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Error: This customer is does not exit.");
        alert.show();
    }

    @FXML
    void btnDeleteCustomerOnAction(ActionEvent event) {
        ObservableList<Customer> customerArrayList = DBConnection.getInstance().getCustomerArrayList();
        for (int i = 0; i < customerArrayList.size(); i++) {
            Customer customer = customerArrayList.get(i);
            if (txtId.getText().equals(customer.getId())) {
                customerArrayList.remove(i);
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText(" Customer deleted successfully. ");
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
        txtDob.setText(null);
        txtTitle.setText(null);
    }
}
