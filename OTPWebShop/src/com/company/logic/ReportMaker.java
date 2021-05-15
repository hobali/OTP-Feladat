package com.company.logic;

import com.company.model.Customer;
import com.company.model.Payment;
import com.company.repository.CustomerRepository;
import com.company.repository.PaymentRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReportMaker {
    private PaymentRepository paymentRepository;
    private CustomerRepository customerRepository;

    public ReportMaker(){
        this.paymentRepository = new PaymentRepository();
        this.customerRepository = new CustomerRepository();
    }

    public void makeReport01(String fileName){
        try{
            FileWriter fw = new FileWriter(fileName);
            int sum = 0;
            for (Customer customer: customerRepository.getCustomers()) {
                sum = 0;
                for (Payment payment: paymentRepository.getPayments()){
                    if(customer.getWebId().equals(payment.getWebShopId()) && customer.getCustomerId().equals(payment.getPaymentCustomerId())){
                        sum += payment.getSum();
                    }
                }
                fw.write(String.format("Név: %s Cím: %s Költség összesen: %d\n", customer.getName(), customer.getAddress(), sum));
            }
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void makeReport02(String fileName){
        try{
            List<String> webShops = paymentRepository.getPayments().stream()
                                        .map(Payment::getWebShopId)
                                        .distinct()
                                        .collect(Collectors.toList());
            FileWriter fw = new FileWriter(fileName);
            int cardSum = 0;
            int transSum = 0;
            for (String webShop: webShops) {
                cardSum = 0;
                transSum = 0;
                for(Payment p: paymentRepository.getPayments()){
                    if(webShop.equals(p.getWebShopId())){
                        if(p.getPaymentMethod().equals("card"))
                            cardSum += p.getSum();
                        else
                            transSum += p.getSum();
                    }

                }
                fw.write(String.format("Webshop: %s Kártyás vásárlások összege: %d Átutalásos vásárlások összege: %d\n", webShop, cardSum, transSum));
            }
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
