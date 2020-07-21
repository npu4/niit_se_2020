package com.niit.lesson5;


public class Animal {
    public String publicField;
    protected String protectedField;
    String defaultVisiblity;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void saySomething() {
        System.out.println("Я какое-то животное");
    }


}


