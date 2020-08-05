package com.niit.isaev.battleOfMage;

import com.niit.isaev.battleOfMage.characters.Character;
import com.niit.isaev.battleOfMage.characters.Mage;
import com.niit.isaev.battleOfMage.characters.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scene {
    private int numberOfPlayers;
    List<Character> charactersInGame = new ArrayList<>(numberOfPlayers);

    public Scene(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    void getRandomCharacters() {
        while (charactersInGame.size() != numberOfPlayers) {

            int characterNumber = new Random().nextInt(2);
            switch (characterNumber) {
                case 1:
                    charactersInGame.add(new Mage());
                case 2:
                    charactersInGame.add(new Monster());
            }
        }
    }

    public List<Character> getCharactersInGame() {
        return charactersInGame;
    }

    public void setCharactersInGame(List<Character> charactersInGame) {
        this.charactersInGame = charactersInGame;
    }
}

