package ggc.core;

import java.util.ArrayList;

import ggc.core.product.Product;
import ggc.core.transaction.sale.BreakdownSale;

import java.io.Serializable;

public class Recipe implements Serializable {

    private double _alpha;
    private ArrayList<Product> _products;
    private ArrayList<Integer> _quantities;

    public Recipe(double alpha, ArrayList<Product> products, ArrayList<Integer> quantities) {
        _alpha = alpha;
        _products = new ArrayList<Product>(products);
        _quantities = new ArrayList<Integer>(quantities);
    }

    public double getAlpha() {
        return _alpha;
    }

    public ArrayList<Product> getComponents() {
        return _products;
    }

    public ArrayList<Integer> getQuantities() {
        return _quantities;
    }

    public String toString(){
        String recipe = new String();

        for (int i = 0; i < _products.size(); i++) {
            recipe += (_products.get(i).getId() + ":" + _quantities.get(i) + "#");
        }

        recipe = recipe.substring(0, recipe.length() - 1);

        return recipe;
    }

}