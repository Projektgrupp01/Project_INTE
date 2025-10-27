package io.github.Projektgrupp01.Project_INTE.creatures;

import java.util.HashSet;
import java.util.Set;

import io.github.Projektgrupp01.Project_INTE.quests.Quest;
import io.github.Projektgrupp01.Project_INTE.quests.Quest.Status;
import io.github.Projektgrupp01.Project_INTE.spells.Spell;
import io.github.Projektgrupp01.Project_INTE.races.Race;
import io.github.Projektgrupp01.Project_INTE.professions.Profession;
import java.util.Collections;

public class BasePlayer implements Player {
	private int maxHealth;
	private int health;
	private int speed;
	private int strength;
	private int maxEnergy;
	private int energy;
	private String name;
	private Set<Spell> spellBook = new HashSet<>();
	private Set<Quest> startedQuests = new HashSet<>();
	private Set<Quest> completedQuests = new HashSet<>();
	private Set<Race> races = new HashSet<>();
	private Set<Profession> professions = new HashSet<>();
	private int level = 1;
	private long experience = 0;
	private final long baseExp = 100;
	private final double growthExponent = 2;

	public BasePlayer() {
		this.name = "BasePlayer";
		this.health = 100;
		this.maxHealth = 100;
		this.speed = 100;
		this.strength = 100;
		this.energy = 100;
		this.maxEnergy = 100;
	}

	public BasePlayer(String name, int maxHealth, int speed, int strength, int maxEnergy, int level) {
		this.name = name;
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		this.speed = speed;
		this.strength = strength;
		this.maxEnergy = maxEnergy;
		this.energy = maxEnergy;
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
		setHealth(health - damage);
	}
	public void useEnergy(int energy){
		setEnergy(this.energy - energy);
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

	public void addRace(Race race) {
		if (race == null) {
			throw new IllegalArgumentException("Race cannot be null");
		}
		int duplicate = 0;
		for (Race raceInSet : races) {
			if (race.getRaceName().equals(raceInSet.getRaceName())) {
				duplicate = 1;
			}
		}
		if (duplicate == 0) {
			races.add(race);
		}
	}

	public Set<Race> getRaces() {
		return Collections.unmodifiableSet(races);
	}

	public void addProfession(Profession profession) {
		if (profession == null) {
			throw new IllegalArgumentException("Profession cannot be null");
		}
		int duplicate = 0;
		for (Profession prof : professions) {
			if (prof.getProfessionName().equals(profession.getProfessionName())) {
				duplicate = 1;
			}
		}
		if (duplicate == 0) {
			professions.add(profession);
		}
	}

	public Set<Profession> getProfessions() {
		return Collections.unmodifiableSet(professions);
	}
	
	public boolean containsRace(String raceName) {
		boolean contains = false;
		for (Race race : races) {
			if (race.getRaceName().equals(raceName)) {
				contains = true;
			}
		}
		return contains;
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

	public void setEnergy(int newEnergy) {
		if (newEnergy > maxEnergy) {
			throw new IllegalStateException("Energy can't be higher than max Energy");
		}
		if(newEnergy <= 0){
			energy = 0;
			return;
		}
		energy = newEnergy;
	}

	public void setMaxEnergy(int newEnergy) {
		if(newEnergy <= 0){
			throw new IllegalStateException("max energy can't be <=0");
		}
		maxEnergy = newEnergy;
	}

	public void setHealth(int newHealth) {
		if (newHealth > maxHealth) {
			throw new IllegalStateException("Health can't be higher than max Health");
		}
		if(newHealth <= 0){
			health = 0;
			return;
		}
		health = newHealth;
	}

	public void setMaxHealth(int newHealth) {
		if(newHealth <= 0){
			throw new IllegalStateException("max health can't be <=0");
		}
		maxHealth = newHealth;
	}

	public void setStrength(int newStrength) {
		if(newStrength <= 0){
			throw new IllegalStateException("Strength can't be <=0");
		}
		strength = newStrength;
	}

	public void setSpeed(int newSpeed) {
		if(newSpeed <= 0){
			throw new IllegalStateException("Speed can't be <=0");
		}
		speed = newSpeed;

	}

}
