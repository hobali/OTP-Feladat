package com.company.repository;

import com.company.model.Customer;
import com.company.model.Payment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements IRepository {
    private List<Payment> payments;

    public PaymentRepository(){
        payments = new ArrayList<Payment>();
        readFromFile("resources/payments.csv");
    }

    @Override
    public void readFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.readLine() != null){
                String[] splittedLine = reader.readLine().split(";");
                payments.add(new Payment(splittedLine[0], splittedLine[1], Double.parseDouble(splittedLine[2]), splittedLine[3], splittedLine[4], splittedLine[5]));
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
