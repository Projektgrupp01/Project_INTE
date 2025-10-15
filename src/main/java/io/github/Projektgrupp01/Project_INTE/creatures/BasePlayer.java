package io.github.Projektgrupp01.Project_INTE.creatures;
import java.util.HashSet;
import java.util.Set;

import io.github.Projektgrupp01.Project_INTE.spells.Spell;
import java.util.Collections;

public class BasePlayer implements Player {
	private int health;
	private int speed;
	private int strength;
	private int energy;
	private String name;
	private HashSet<Spell> spellBook = new HashSet<>();

	public BasePlayer() {
		this.health = 100;
		this.speed = 100;
		this.strength = 100;
		this.energy = 100;
		this.name = "BasePlayer";
	}

	public BasePlayer(String name, int health, int speed, int strength, int energy) {
		this.name = name;
		this.health = health;
		this.speed = speed;
		this.strength = strength;
		this.energy = energy;
	}

	public int getHealth() {
		return health;
	}

	public int getSpeed() {
		return speed;
	}

	public int getStrength() {
		return strength;
	}

	public int getEnergy() {
		return energy;
	}

	public void takeDamage(int damage) {
		health -= damage;
	}

	public boolean isDead() {
		return health <= 0;
	}

	public void learnSpell(Spell spell) {
		if(spell == null) {
			throw new NullPointerException("spell can't be null");
		}
		if(spellBook.contains(spell)) {
			throw new IllegalArgumentException("spell already learned");
		}
		spellBook.add(spell);
	}

	public Set<Spell> getSpellBook() {
		if(spellBook.isEmpty()) {
			return Collections.emptySet();
		}
		return spellBook;
	}

	public void forgetSpell(Spell spell) {
		if(spell == null) {
			throw new NullPointerException("spell can't be null");
		}
		if(!spellBook.contains(spell)) {
			throw new IllegalArgumentException("spell not found in spell book");
		}
		spellBook.remove(spell);
	}

	@Override
	public String getName() {
		return name;
	}

}
