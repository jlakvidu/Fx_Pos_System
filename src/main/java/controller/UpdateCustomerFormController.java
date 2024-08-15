package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;

public class UpdateCustomerFormController {

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
        System.out.println("Customer not found.");
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
                customer.setDob(LocalDate.parse(txtDob.getText()));
                customer.setTitle(txtTitle.getText());
                customer.setContactNumber(txtContactNumber.getText());

                customerArrayList.set(i, customer);

                System.out.println("Customer updated successfully.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }
}
