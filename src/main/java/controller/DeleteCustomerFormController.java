package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Customer;

public class DeleteCustomerFormController {

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

    @FXML
    void btnDeleteCustomerOnAction(ActionEvent event) {
        ObservableList<Customer> customerArrayList = DBConnection.getInstance().getCustomerArrayList();
        for (int i = 0; i < customerArrayList.size(); i++) {
            Customer customer = customerArrayList.get(i);
            if (customer.getId().equals(customer.getId())) {
                customerArrayList.remove(i);
                System.out.println("Customer deleted successfully.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }
}
