package com.company;

import com.company.model.Customer;
import com.company.model.Payment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReportMaker {
    private List<String> webshops;

    public ReportMaker(){

    }

    public void makeReport01(String fileName, List<Payment> payments, List<Customer> customers){

    }

    public void makeReport02(String fileName, List<Payment> payments){
        webshops = payments.stream()
                .map(Payment::getWebShopId)
                .distinct()
                .collect(Collectors.toList());
        FileWriter fw = null;
        try{
            fw = new FileWriter(fileName);
            int cardSum = 0;
            int transSum = 0;
            for (String webShop: webshops) {
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
