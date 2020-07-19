package com.niit.isaev.BattleOfMage;

import com.niit.isaev.BattleOfMage.Characters.Mage;

import java.util.Random;

public class mainGame {
    public static void main(String[] args) {

        Mage mage = new Mage("Ivan");
        System.out.println(mage.getName());
        System.out.println(mage.getNumberPosition());


    }
}
