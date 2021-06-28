package com.swufe.javaee.beerV1.model;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    public List<Beer> getBrands(String color) {
        List<Beer> brands = new ArrayList<>();
        //brands是一个属性为list的新变量
        if (color.equals("amber")) {
            brands.add(new Beer("Jack Amber",1950,"America"));
            brands.add(new Beer("Red Moose",1955,"British"));
        } else {
            brands.add(new Beer("Jali Pale Ale",1960,"France"));
            brands.add(new Beer("Gout Stout",1990,"Italy"));
        }
        return brands;
    }
}