package com.example.nancyprojects.product;

import com.orm.SugarApp;
import com.orm.SugarRecord;
/**
 * Created by Nancy on 02/09/2016.
 */
public class Product extends SugarRecord {

    private String Name="";
    private String Category="";
    private Double Price=0.0;

    public Product( ){


    }

    public Product(String edName,String edCategory,Double edPrice)
    {

        this.Category=edCategory;
        this.Name=edName;
        this.Price=edPrice;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

}
