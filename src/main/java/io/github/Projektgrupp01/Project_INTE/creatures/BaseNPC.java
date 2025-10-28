package io.github.Projektgrupp01.Project_INTE.creatures;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import io.github.Projektgrupp01.Project_INTE.quests.Quest;

public class BaseNPC implements NPC {

	private int health;
	private int speed;
	private int strength;
	private int energy;
	private String name;
	private Disposition disposition;
	private Set<Quest> offeredQuests = new HashSet<>();

	public BaseNPC(String name, int health, Disposition disposition) {
		this.name = name;
		this.health = health;
		this.disposition = disposition;
		this.speed = 100;
		this.strength = 100;
		this.energy = 100;
	}

	public BaseNPC(String name, int health, Disposition disposition, int speed, int strength, int energy) {
		this.name = name;
		this.health = health;
		this.disposition = disposition;
		this.speed = speed;
		this.strength = strength;
		this.energy = energy;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public int getStrength() {
		return strength;
	}

	@Override
	public int getEnergy() {
		return energy;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void takeDamage(int amount) {
		health -= amount;
	}

	@Override
	public boolean isDead() {
		return health <= 0;
	}

	@Override
	public Disposition getDisposition() {
		return disposition;
	}

	@Override
	public void interact(Creature otherCreature) {
		if (!(otherCreature instanceof Player player)) return;
		
		switch (disposition) {
		case FRIENDLY:
			System.out.println(name + " greets you.");
			for (Quest quest : offeredQuests) {
				if (quest.meetsRequirement(player)) {
					offerQuest(player, quest);
				}
			}
			otherCreature.takeDamage(-10);
			break;
		case NEUTRAL:
			System.out.println(name + " ignores you.");
			break;
		case HOSTILE:
			System.out.println(name + " attacks!");
			otherCreature.takeDamage(10);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + disposition);
		}

	}
	private void offerQuest(Player player, Quest quest) {
		if (!quest.meetsRequirement(player)) {
			throw new IllegalArgumentException("You do not meet the requirements.");
		}
		player.acceptQuest(quest);
	}

	@Override
	public void addQuest(Quest quest) {
		offeredQuests.add(quest);
	}

	@Override
	public Set<Quest> getQuests() {
		return Collections.unmodifiableSet(offeredQuests);
	}
	
	

}
