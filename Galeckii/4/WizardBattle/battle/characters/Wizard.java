package battle.characters;

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
    public void attack(Character[] characters) {
        bookOfSpells.get(new Random().nextInt(bookOfSpells.size())).cast(characters, this);
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
