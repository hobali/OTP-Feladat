package com.company.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Payment {
    private String webShopIid;
    private String paymentCustomerId;
    private String paymentMethod;
    private double sum;
    private String bankAccountNumber;
    private String cardNumber;
    private String paymentDate;

    public Payment() {
    }

    public Payment(String webShopIid, String paymentCustomerId, String paymentMethod, double sum, String bankAccountNumber, String cardNumber, String paymentDate) {
        this.webShopIid = webShopIid;
        this.paymentCustomerId = paymentCustomerId;
        this.paymentMethod = paymentMethod;
        this.sum = sum;
        this.bankAccountNumber = bankAccountNumber;
        this.cardNumber = cardNumber;
        this.paymentDate = paymentDate;
    }

    public String getWebShopIid() {
        return webShopIid;
    }

    public String getPaymentCustomerId() {
        return paymentCustomerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getSum() {
        return sum;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getPaymentDate() {
        return paymentDate;
    }
}
