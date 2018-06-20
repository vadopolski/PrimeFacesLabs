package com.vopolski.lazytable;

public class ClassDemo {

    public String string1;

    public ClassDemo() {
    }

    public ClassDemo(String tutorialspoint) {

    }

    public static void main(String[] args) {

        ClassDemo c = new ClassDemo("tutorialspoint");

        try {
            String sField = (String)ClassDemo.class.getField("string1").get(c);
            System.out.println("Public field found: " + sField);
        }
        catch (NoSuchFieldException e) {
            System.out.println(e.toString());
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


}
