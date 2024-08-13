package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> title = FXCollections.observableArrayList();
        title.add("Mr.");
        title.add("Miss.");
        comTitle.setItems(title);

    }

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String title = comTitle.getValue();
        String name = txtName.getText();
        String address = txtAddress.getText();
        LocalDate dob = dateDOB.getValue();
        Customer customer = new Customer(id,title,name,address,dob);
        ObservableList<Customer> customerArrayList = DBConnection.getInstance().getCustomerArrayList();
        customerArrayList.add(customer);
        System.out.println(customerArrayList);
    }
}
