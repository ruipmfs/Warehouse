package ggc.core.transaction;

import ggc.core.Partner;
import ggc.core.product.Product;

import java.io.Serializable;

public abstract class Transaction implements Serializable {
    private int _id;
    private int _paymentDate;
    private double _baseValue;
    private int _quantity;
    private Partner _partner;
    private Product _product;

    public Transaction(int id, double baseValue, int quantity, Partner partner, Product product, int paymentDate) {
        _id = id;
        _baseValue = baseValue;
        _quantity = quantity;
        _partner = partner;
        _product = product;
        _paymentDate = paymentDate;
    }

    public int getPaymentDate(){
        return _paymentDate;
    }

    public void setPaymentDate(int day) {
        _paymentDate = day;
    }

    public Partner getPartner(){
        return _partner;
    }

    public int getId(){
        return _id;
    }

    public Product getProduct(){
        return _product;
    }

    public int getQuantity(){
        return _quantity;
    }

    public double getBaseValue() {
        return _baseValue;
    }

    public abstract String toString();

    public abstract boolean isAcquisition();

    public abstract int getDeadline();

    public abstract boolean isPaid();

    public abstract boolean isSaleByCredit();
}
