package com.company.model;

public class Payment {
    private String webShopIid;
    private String paymentCustomerId;
    private enum paymentMethod {
        CARD,
        TRANSFER
    };
    private double sum;
    private String bankAccountNumber;
    private String cardNumber;
    private String paymentDate;

    public Payment() {
    }

    public Payment(String webShopIid, String paymentCustomerId, double sum, String bankAccountNumber, String cardNumber, String paymentDate) {
        this.webShopIid = webShopIid;
        this.paymentCustomerId = paymentCustomerId;
        this.sum = sum;
        this.bankAccountNumber = bankAccountNumber;
        this.cardNumber = cardNumber;
        this.paymentDate = paymentDate;
    }
}
