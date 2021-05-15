package com.company;

import com.company.model.Customer;
import com.company.model.Payment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReportMaker {
    public ReportMaker(){

    }

    public void makeReport01(String fileName, List<Payment> payments, List<Customer> customers){
        try{
            FileWriter fw = new FileWriter(fileName);
            int sum = 0;
            for (Customer customer: customers) {
                sum = 0;
                for (Payment payment: payments){
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

    public void makeReport02(String fileName, List<Payment> payments){
        try{
            List<String> webShops = payments.stream()
                                        .map(Payment::getWebShopId)
                                        .distinct()
                                        .collect(Collectors.toList());
            FileWriter fw = new FileWriter(fileName);
            int cardSum = 0;
            int transSum = 0;
            for (String webShop: webShops) {
                cardSum = 0;
                transSum = 0;
                for(Payment p: payments){
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
