package org.personal.iims.model;

public class Customer {
    private int id;
    private String customerName;
    private String customerContact;
    private String customerAddress;
    private String customerEmail;

    public Customer() {
    }

    public Customer(String customerName, String customerContact, String customerAddress, String customerEmail) {
//        this.id = id;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
