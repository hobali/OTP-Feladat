package com.company.repository;

import com.company.model.Customer;
import com.company.model.Payment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class PaymentRepository implements IRepository {
    private List<Payment> payments;
    private static Logger logger;

    public PaymentRepository(){
        payments = new ArrayList<Payment>();
        logger = Logger.getLogger(PaymentRepository.class.getName());
        readFromFile("resources/payments.csv");
    }

    @Override
    public void readFromFile(String fileName){
        FileHandler fileHandler = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            fileHandler = new FileHandler("application.log");
            logger.addHandler(fileHandler);
            String readed;
            while ((readed = reader.readLine()) != null){
                String[] splittedLine = readed.split(";");
                if(!validation(splittedLine)){
                    // TODO: LOG
                    logger.warning(readed);
                }else{
                    payments.add(new Payment(splittedLine[0], splittedLine[1], splittedLine[2], Double.parseDouble(splittedLine[3]), convertBigIntToString(splittedLine[4]), convertBigIntToString(splittedLine[5]), splittedLine[6]));
                }
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean validation(String[] input) {
        for (String s : input) {
            if (s == null) {
                return false;
            }
        }
        if (!convertBigIntToString(input[5]).equals("") && input[5].length() != 16){
            return false;
        }else if(input[2].equals("card") && !convertBigIntToString(input[5]).equals("")){
            return true;
        }else if(input[2].equals("transfer") && !convertBigIntToString(input[4]).equals("")){
            return true;
        }
        return true;
    }

    public String convertBigIntToString(String start){
        start = start.equals("") ? "" : !start.contains(",") ? start :  start.replace(",", ".");
        if (!start.equals("") && start.contains("."))
            return new BigDecimal(start).toBigInteger().toString();
        return start;
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
