package ggc.core;

import java.io.Serializable;

public class Partner implements Serializable {
    private String _id;
    private String _name;
    private String _address;
    private String _status;
    private double _points;
    private double _acquisitionsValue;
    private double _effectiveSalesValue;
    private double _paidSalesValue;


    public Partner(String id, String name, String address){
        _id = id;
        _name = name;
        _address = address;
        _status = "Normal";
    }

    public void manageProductNotifications(String partnerId, String productId){
        return; //TO DO
    }

    public String getId(){
        return _id;
    }

    public String getName(){
        return _name;
    }

    public String getAddress(){
        return _address;
    }

    public String getStatus() {
        return _status;
    }

    public double getPoints() {
        return _points;
    }

    public double getAcquisitionsValue() {
        return _acquisitionsValue;
    }

    public double getEffectiveSalesValue() {
        return _effectiveSalesValue;
    }

    public double getPaidSalesValue() {
        return _paidSalesValue;
    }
}