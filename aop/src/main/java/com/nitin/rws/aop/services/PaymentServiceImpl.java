package com.nitin.rws.aop.services;

public class PaymentServiceImpl implements PaymentService{


    @Override
    public void makePayment(int amount) {

//        Payment Code
        System.out.println(amount + " Amount Debited........");
//
//
//
        System.out.println(amount + " Amount Credited.......");
    }
}
