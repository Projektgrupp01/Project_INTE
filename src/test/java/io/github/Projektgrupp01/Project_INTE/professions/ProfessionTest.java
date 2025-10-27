package io.github.Projektgrupp01.Project_INTE.professions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;


public class ProfessionTest {
	@Test
	void newDoctor() {
		Doctor doc = new Doctor();
		assertEquals(doc.getProfessionName(),"Doctor");
	}
	
	@Test
	void addProfession() {
		BasePlayer player = new BasePlayer();
		Doctor doc = new Doctor();
		player.addProfession(doc);
		HashSet<Profession> comparingSet = new HashSet<>();
		comparingSet.add(doc);
		assertEquals(player.getProfessions(),comparingSet);
	}
	
	@Test
	void addTwoSameProfession() {
		BasePlayer player = new BasePlayer();
		Doctor doc = new Doctor();
		Doctor doc2 = new Doctor();
		player.addProfession(doc);
		player.addProfession(doc2);
		assertEquals(1, player.getProfessions().size());
		
	}
	
	@Test
	void checktoString() {
		Doctor doc = new Doctor();
		assertEquals(doc.toString(),"Level: 0 Doctor");

	}
	
	@Test
	void professionLevel0() {
		Doctor doc = new Doctor();
		assertEquals(doc.getProfessionLevel(), 0);
	}
	
	@Test
	void professionLevelSet() {
		Doctor doc = new Doctor();
		doc.setProfessionLevel(3);
		assertEquals(doc.getProfessionLevel(), 3);
	}
	
	@Test
	void levelUpProfessionFromZero() {
		Doctor doc = new Doctor();
		doc.levelUpProfession();
		assertEquals(doc.getProfessionLevel(), 1);
	}
	
	@Test
	void setAndThenLevelUpProfession() {
		Doctor doc = new Doctor();
		doc.setProfessionLevel(3);
		doc.levelUpProfession();
		assertEquals(doc.getProfessionLevel(), 4);
	}
	
	@Test
	void levelUpByNameFrom0() {
		BasePlayer player = new BasePlayer();
		Doctor doc = new Doctor();
		player.addProfession(doc);
		Profession.levelUpNamedProfession(player, "Doctor");
		assertEquals(1, doc.getProfessionLevel());
	}
	
	@Test
	void basicSelfHealOnNonDoctor() {
		BasePlayer player = new BasePlayer();
		player.takeDamage(1);
		int healthBefore = player.getHealth();
		Doctor.basicSelfHeal(player);
		assertEquals(player.getHealth(), healthBefore); //the heal is just supposed to do nothing
	}
	
	@Test 
	void basicSelfHealOnLevel1Doctor() {
		BasePlayer player = new BasePlayer();
		player.takeDamage(1);
		int healthBefore = player.getHealth();
		Doctor doc = new Doctor();
		doc.levelUpProfession();
		player.addProfession(doc);
		Doctor.basicSelfHeal(player);
		assertTrue(player.getHealth() > healthBefore);
	}
	

}
