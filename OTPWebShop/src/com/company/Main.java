package com.company;

import com.company.repository.CustomerRepository;
import com.company.repository.PaymentRepository;

public class Main {

    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        PaymentRepository paymentRepository = new PaymentRepository();

        System.out.println(customerRepository.getCustomers().get(0));
        System.out.println(paymentRepository.getPayments().get(0));
    }
}
