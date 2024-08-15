package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Customer;

public class SearchCustomerFormController {

    int index =0;
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
                return;
            }
        }
        System.out.println("Customer not found.");
    }

}
