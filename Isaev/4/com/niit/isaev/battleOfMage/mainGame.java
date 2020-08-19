package com.niit.isaev.battleOfMage;

import com.niit.isaev.battleOfMage.characters.Character;


public class mainGame {
    static Scene scene = new Scene(10);
    public static void main(String[] args) {

        scene.getRandomCharacters();
        while (true) {
            for (Character character : scene.getCharactersInGame()) {
                if (character != null) {
                    character.attack(scene.getCharactersInGame(), scene.findAllNotDead(), scene.findAllEnemies(character), scene.findAllNeighbours(character));
                }
            }

            if (scene.gameIsFinished()) {
                if (scene.findAllNotDead().size() < 2 && scene.findAllNotDead().size() != 0) {
                    System.out.println(scene.findAllNotDead().get(0).getName() + " - победил всех!");
                } else if (scene.findAllNotDead().size() == 0) {
                    System.out.println("Все персонажи мервы...победителя нет!");
                }

            } else
                continue;
            break;
        }
        }
}

