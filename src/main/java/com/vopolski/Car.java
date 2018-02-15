package com.vopolski;

public class Car {

    private String id;
    private String year;
    private String color;
    private String brand;
    private String itemName;
    private String model;

    public Car(String id, String year, String color, String brand, String model) {
        this.id = id;
        this.year = year;
        this.color = color;
        this.brand = brand;
        this.model = model;
    }

    @Override public String toString() {
        String result = "";

//        if(year == "" && color == ""){
//            return brand;
//        } else {
//
//            int difference = DragDropView.getMax() - brand.length() + 4;
//
//            result += "<small>" + brand + "</small>" + "&nbsp; &nbsp; &nbsp; &nbsp;";
//        }

        if (year == "" && color == "") {
            return brand;
        }
        else {
            int difference = DragDropView.getMax() - brand.length() + 4;

            result += "<small>" + brand + "</small>";

            for (int i = 0; i < difference; i++) {
                result += "&nbsp;";
            }

        }

        if (model != "") {
            result += "<small>" + model + "</small>" + "&nbsp; &nbsp; &nbsp; &nbsp;";
        }

        if (color != "") {
            result += "<small>" + color + "</small>" + "&nbsp; &nbsp; &nbsp; &nbsp;";
        }

        if (year != "") {
            result += "<small>" + year + "</small>";
        }

        return result;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
}
