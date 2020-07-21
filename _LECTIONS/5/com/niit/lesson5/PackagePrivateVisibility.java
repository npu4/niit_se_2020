package com.niit.lesson5;

import com.niit.lesson5.nested.Cat;

public class PackagePrivateVisibility {

    public static void main(String[] args) {
        Animal cat = new Cat();

        cat.protectedField = "protected Field value";
        cat.defaultVisiblity = "Some field";
    }
}
