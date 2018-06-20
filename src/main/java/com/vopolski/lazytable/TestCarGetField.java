package com.vopolski.lazytable;

public class TestCarGetField {

    public static void main(String[] args) throws NoSuchFieldException {
        try {
            Car car1 = new Car("asdasd", "asdasd", 1999, "asdasd", 55, true);

            String value1 = (String)Car.class.getField("brand").get(car1);

            System.out.println(value1);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
