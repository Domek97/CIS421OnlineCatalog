package cis421onlinecatalog;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Dominic Santangelo
 */
public class Product {
    StringProperty upc;
    StringProperty name;
    StringProperty brand;
    StringProperty category;
    IntegerProperty price;
    IntegerProperty stock;
    
    Product(String upc, String name, String brand, String category, int price, int stock) {
        this.upc = new SimpleStringProperty(upc); 
        this.name = new SimpleStringProperty(name);
        this.brand = new SimpleStringProperty(brand);
        this.category = new SimpleStringProperty(category);
        this.price = new SimpleIntegerProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
    }
    
    public String getUPC() {
        return upc.get();
    }
    
    public void setUPC(String upc) {
        this.upc.set(upc);
    }
    
    public String getName() {
        return name.get();
    }
    
    public void setName (String name) {
        this.name.set(name);
    }
    
    public String getBrand () {
        return brand.get();
    }
    
    public void setBrand(String brand) {
        this.brand.set(brand);
    }
    
    public String getCategory() {
        return category.get();
    }
    
    public void setCategory(String category) {
        this.category.set(category);
    }
    
    public int getPrice() {
        return price.get();
    }
    
    public void setPrice(int price) {
        this.price.set(price);
    }
    
    public int getStock() {
        return stock.get();
    }
    
    public void setStock(int stock) {
        this.stock.set(stock);
    }

    public StringProperty nameProperty() {
       return name;
   }

    public StringProperty brandProperty() {
        return brand;
    }

    public StringProperty upcProperty() {
        return upc;
    }
    
    public StringProperty categoryProperty() {
       return category;
   }

    public IntegerProperty priceProperty() {
        return price;
    }

    public IntegerProperty stockProperty() {
        return stock;
    }
}
