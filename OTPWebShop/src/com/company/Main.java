package com.company;

import com.company.model.Customer;
import com.company.model.Payment;
import com.company.repository.CustomerRepository;
import com.company.repository.PaymentRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        PaymentRepository paymentRepository = new PaymentRepository();

        paymentRepository.writeToFile("report02.csv");
        customerRepository.writeToFile("report01.csv");
    }
}
