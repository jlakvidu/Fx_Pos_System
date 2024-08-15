package model;

import java.time.LocalDate;

public class Customer {
    private String id;
    private String name;
    private String address;
    private LocalDate dob;
    private  String title;
    private String contactNumber;

    public Customer(String id,  String title, String name, String address, LocalDate dob,String contactNumber) {
        this.id = id;
        this.title=title;
        this.name = title+name;
        this.address = address;
        this.dob = dob;
        this.contactNumber = contactNumber;
    }

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                '}';
    }
}
