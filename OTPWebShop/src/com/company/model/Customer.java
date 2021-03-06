package com.company.model;

public class Customer {
    private String webId;
    private String customerId;
    private String name;
    private String address;

    public Customer() {
    }

    public Customer(String webId, String customerId, String name, String address) {
        this.webId = webId;
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    public String getWebId() {
        return webId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
