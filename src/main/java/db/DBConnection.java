package db;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customer;

import java.util.ArrayList;

public class DBConnection {
    private static DBConnection instance;
    private ArrayList<Customer> customerArrayList;
    private ObservableList<Customer> customerList;

    private DBConnection(){
        customerArrayList = new ArrayList<>();
        customerList = FXCollections.observableArrayList();
    }


    public ObservableList<Customer> getCustomerArrayList(){
        return customerList;
    }

    public static DBConnection getInstance(){
        if(instance==null){
            instance =  new DBConnection();
        }
        return instance;
    }
}
