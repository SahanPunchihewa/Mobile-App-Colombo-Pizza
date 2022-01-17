package com.example.colombopizza;

public class MenuData{

    private String pizzaName;
    private String priceDisplay;
    private Integer pizzaImage;

    public MenuData(String pizzaName, String priceDisplay, Integer pizzaImage) {
        this.pizzaName = pizzaName;
        this.priceDisplay = priceDisplay;
        this.pizzaImage = pizzaImage;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPriceDisplay() {
        return priceDisplay;
    }

    public void setPriceDisplay(String priceDisplay) {
        this.priceDisplay = priceDisplay;
    }

    public Integer getPizzaImage() {
        return pizzaImage;
    }

    public void setPizzaImage(Integer pizzaImage) {
        this.pizzaImage = pizzaImage;
    }


}

