package com.company.repository;

import com.company.model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements IRepository {
    private List<Customer> customers;

    public CustomerRepository(){
        customers = new ArrayList<Customer>();
        readFromFile("resources/customer.csv");
    }

    @Override
    public void readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.readLine() != null){
                String[] splittedLine = reader.readLine().split(";");
                customers.add(new Customer(splittedLine[0], splittedLine[1], splittedLine[2], splittedLine[3]));
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
