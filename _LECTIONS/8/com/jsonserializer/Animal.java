package com.jsonserializer;

import com.PersonRefl;

public class Animal {

    @JsonField(jsonName = "имя")
    public String name;

    @JsonField(jsonName = "возраст")
    public int age;

    @JsonIgnore
    public String favoriteFood;

    public Animal(String name, int age, String favoriteFood) {
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }

    public static void main(String[] args) throws IllegalAccessException {


        System.out.println(JsonSerializer.getJsonString(new Animal("Барсик", 2, "Рыба")));
        System.out.println(JsonSerializer.getJsonString(new Animal("Алиса", 3, "Курица")));
        System.out.println(JsonSerializer.getJsonString(new PersonRefl("Вася","Пупкин",18)));



        // {
        //     name : "Барсик",
        //     age: 2,
        //     favoriteFood: "Рыба"
        //}
        //
        //
        //

    }
}
