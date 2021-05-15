package com.company.repository;

import com.company.model.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomerRepository implements IRepository {
    private List<Customer> customers;
    private static Logger logger;

    public CustomerRepository(){
        customers = new ArrayList<Customer>();
        logger = Logger.getLogger("application.log");
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

    @Override
    public boolean validation(String[] input) {
        return false;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
