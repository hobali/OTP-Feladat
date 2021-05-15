package com.company;

import com.company.model.Payment;
import com.company.repository.CustomerRepository;
import com.company.repository.PaymentRepository;

public class Main {

    public static void main(String[] args) {
        //CustomerRepository customerRepository = new CustomerRepository();
        PaymentRepository paymentRepository = new PaymentRepository();

        for (Payment p: paymentRepository.getPayments()) {
            System.out.println(p.getWebShopIid());
        }
    }
}
