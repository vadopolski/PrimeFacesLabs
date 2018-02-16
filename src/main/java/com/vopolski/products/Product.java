package com.vopolski.products;

import com.vopolski.car.DragDropView;

public class Product {
    String name;

    String type;

    String profile;

    String value;

    public Product(String name, String type, String profile, String value) {
        this.name = name;
        this.type = type;
        this.profile = profile;
        this.value = value;
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

//        <div style="width: 199px; overflow-x: hidden; float: left">Decimalization&nbsp;Table&nbsp;HSR&nbsp;5234&nbsp;&nbsp;&nbsp;&nbsp;</div>


        if (type == "" && profile == "") {
            return name;
        }
        else {
            int difference = DragDropView.getMax() - name.length() + 4;

            result += "<div style=\"width: 268px; overflow-x: hidden; float: left\">" + name.replace(" ", "&nbsp;") + "&nbsp;&nbsp;&nbsp;&nbsp;</div>";

//            for (int i = 0; i < difference; i++) {
//                result += "_";
//            }

        }

        if (type != "") {
            result += "<div style=\"width: 268px; float: left\">" + type + "</div>";
        }

//        if (profile != "") {
//            result += "<small>" + profile + "</small>" + "&nbsp;&nbsp;&nbsp;&nbsp;";
//        }

//        if (value != "") {
//            result += "<small>" + value + "</small>";
//        }

        return result;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
