package com.niit.isaev.battleOfMage;

import com.niit.isaev.battleOfMage.characters.Character;


public class mainGame {

    static Scene scene = new Scene(10);

    static {
        scene.getRandomCharacters();
    }

    public static void main(String[] args) {
        scene.getRandomCharacters();
        while (true) {
            for (Character character : scene.getCharactersInGame()) {
                if (scene.charactersInGame.get(scene.charactersInGame.indexOf(character)) != null) {
                    character.attack(scene.getCharactersInGame());
                }
            }

            if (gameIsFinished()) {
                for (Character character : scene.charactersInGame) {
                    if (character != null) {
                        System.out.println(character.getName() + " - победил всех!");
                    }
                }
                break;
            }
        }
    }

    static boolean gameIsFinished() {
        int playersInGame = 0;
        for (Character character : scene.getCharactersInGame()) {
            if (character != null) {
                playersInGame++;
            }
        }
        return playersInGame == 1;
    }
}

