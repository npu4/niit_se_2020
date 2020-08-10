package battle.characters;

import battle.GameLog;
import battle.spell.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Wizard extends Character {
    List<Spell> bookOfSpells = new ArrayList<>();

    public Wizard() {
    }

    public Wizard(int position, int health, String name) {
        this.position = position;
        this.health = health;
        this.name = name;
        setBookOfSpells();
    }

    @Override
    public void attack(Character[] characters, GameLog gameLog) {
        Spell spell = bookOfSpells.get(new Random().nextInt(bookOfSpells.size()));
        isTargetDead(characters, this.getPosition(), gameLog);
        String action = spell.cast(characters, this);
        gameLog.addAction(action);
    }

    public void setBookOfSpells() {
        List<Spell> tempBook = new ArrayList<>();
        tempBook.add(new Firewall());
        tempBook.add(new Lightning());
        tempBook.add(new Migraine());
        tempBook.add(new MonsterPurge());
        tempBook.add(new ChainLight());
        Collections.shuffle(tempBook);

        for (int i = 0; i < 3; i++) {
            bookOfSpells.add(tempBook.get(i));
        }
    }
}
