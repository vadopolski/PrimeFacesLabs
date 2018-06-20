package com.vopolski.lazytable;

import com.vopolski.car.DragDropView;

public class Car {

    private String id;
    private int year;
    private String color;
    private String brand;
    private String model;
    private int price;
    private boolean state;

    public Car(String id, String brand, int year, String color, int price, boolean state) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.color = color;
        this.price = price;
        this.state = state;
    }


    @Override public String toString() {
        String result = "";

        if (year == 0 && color == "") {
            return brand;
        }
        else {
            int difference = DragDropView.getMax() - brand.length() + 4;

            result += "<small>" + brand + "</small>";

            for (int i = 0; i < difference; i++) {
                result += "_";
            }

        }

        if (model != "") {
            result += "<small>" + model + "</small>" + "&nbsp;&nbsp;&nbsp;&nbsp;";
        }

        if (color != "") {
            result += "<small>" + color + "</small>" + "&nbsp;&nbsp;&nbsp;&nbsp;";
        }

        if (year != 0) {
            result += "<small>" + year + "</small>";
        }

        return result;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}