package io.github.Projektgrupp01.Project_INTE.creatures;

import java.util.HashSet;
import java.util.Set;

import io.github.Projektgrupp01.Project_INTE.quests.Quest;
import io.github.Projektgrupp01.Project_INTE.quests.Quest.Status;
import io.github.Projektgrupp01.Project_INTE.spells.Spell;
import java.util.Collections;

public class BasePlayer implements Player {
	private int health;
	private int speed;
	private int strength;
	private int energy;
	private String name;
	private Set<Spell> spellBook = new HashSet<>();
	private Set<Quest> startedQuests = new HashSet<>();
	private Set<Quest> completedQuests = new HashSet<>();
	private int level = 1;
	private long experience = 0;
	private final long baseExp = 100;
	private final double growthExponent = 2;

	public BasePlayer() {
		this.name = "BasePlayer";
		this.health = 100;
		this.speed = 100;
		this.strength = 100;
		this.energy = 100;
	}

	public BasePlayer(String name, int health, int speed, int strength, int energy, int level) {
		this.name = name;
		this.health = health;
		this.speed = speed;
		this.strength = strength;
		this.energy = energy;
		this.level = level;
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
		if (health < 0) {
			health = 0;
		}
	}

	public boolean isDead() {
		return health <= 0;
	}

	public void learnSpell(Spell spell) {
		if (spell == null) {
			throw new NullPointerException("spell can't be null");
		}
		if (spellBook.contains(spell)) {
			throw new IllegalArgumentException("spell already learned");
		}
		spellBook.add(spell);
	}

	public Set<Spell> getSpellBook() {
		if (spellBook.isEmpty()) {
			return Collections.emptySet();
		}
		return spellBook;
	}

	public void forgetSpell(Spell spell) {
		if (spell == null) {
			throw new NullPointerException("spell can't be null");
		}
		if (!spellBook.contains(spell)) {
			throw new IllegalArgumentException("spell not found in spell book");
		}
		spellBook.remove(spell);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public long getExperience() {
		return experience;
	}

	@Override
	public long getExperienceToNextLevel() {
		return (long) (baseExp * Math.pow(growthExponent, level - 1));
	}

	@Override
	public void addExperience(long amount) {
		experience += amount;
		while (experience >= getExperienceToNextLevel()) {
			experience -= getExperienceToNextLevel();
			level++;
		}
	}

	public Set<Quest> getActiveQuests() {
		return Collections.unmodifiableSet(startedQuests);
	}
	
	public Set<Quest> getCompletedQuest() {
		return Collections.unmodifiableSet(completedQuests);
	}

	public void acceptQuest(Quest quest) {
		if (quest == null) {
			throw new NullPointerException("Quest cannot be null");
		}
		if (startedQuests.contains(quest) || completedQuests.contains(quest)) {
			throw new IllegalStateException("Quest is already started or completed.");
		}
		startedQuests.add(quest);
		quest.start();
	}

	public void completeQuest(Quest quest) {
		if (quest == null) {
			throw new NullPointerException("Quest cannot be null");
		}
		if (!startedQuests.contains(quest)) {
			throw new IllegalStateException("Quest has not been accepted yet.");
		}
		if (completedQuests.contains(quest)) {
			throw new IllegalStateException("Quest has already been completed.");
		}
		startedQuests.add(quest);
		addExperience(quest.getReward());
		quest.complete();
	}

}
