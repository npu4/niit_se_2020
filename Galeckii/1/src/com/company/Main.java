package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a;
        int b;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        
        System.out.println(a > b ? "Число " + a + " больше " + b : "Число " + a + " меньше " + b);
        System.out.println(a+b);
    }
}
