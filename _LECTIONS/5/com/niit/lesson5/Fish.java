package com.niit.lesson5;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Fish extends Animal {

    @Override
    public void saySomething() {
        System.out.println("*рыба молчит*");
    }


    public void sayHello() {
        System.out.println("Привет, я рыба!");
    }
}
