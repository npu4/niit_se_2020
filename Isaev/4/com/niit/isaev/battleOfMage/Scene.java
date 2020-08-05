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

    public List<Character> findAllNotDead() {
        List<Character> availableForAttack = new ArrayList<>();
        for (Character ch : charactersInGame) {
            if (ch != null) {
                availableForAttack.add(ch);
            }
        }
        return availableForAttack;
    }

    public List<Character> findAllEnemies(Character self) {
        List<Character> availableAlive = findAllNotDead();
        List<Character> availableEnemies = new ArrayList<>();
        for (Character ch : availableAlive) {
            if (ch != self) {
                availableEnemies.add(ch);
            }
        }
        return availableEnemies;
    }

    public List<Character> findAllNeighbours(Character self) {
        int position = charactersInGame.indexOf(self);
        List<Character> neighbours = new ArrayList<>();

        if (charactersInGame.get(Math.abs(position - 1)) != null) {
            neighbours.add(charactersInGame.get(Math.abs(position - 1)));
        }
        if (charactersInGame.get((position + 1) % 10) != null && charactersInGame.size() > (position + 2) % 10) {
            neighbours.add(charactersInGame.get((position + 1) % 10));
        }

        return neighbours;
    }

    boolean gameIsFinished() {
        int playersInGame = 0;
        for (Character character : charactersInGame) {
            if (character != null) {
                playersInGame++;
            }
        }
        return playersInGame < 2;
    }
}

