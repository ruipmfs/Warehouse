package ggc.core.product;

import java.util.List;
import ggc.core.Batch;

public abstract class Product {
    private double _maxPrice;
    private String _id;
    private List<Batch> _batches;

    public Product(){

    }

    public List<Batch> breakdown(){
        _batches = new ArrayList<>();
        return _batches; //TO DO
    }

    public String getBatchesBelowLimit(int value){
        return ""; //TO DO
    }

    public String toString(){
        return ""; //TO DO
    }

    public abstract void checkQuantity(int quantity, Partner p){
        return; //TO DO
    }
}