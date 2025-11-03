package io.github.Projektgrupp01.Project_INTE.professions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import io.github.Projektgrupp01.Project_INTE.creatures.BasePlayer;


public class ProfessionTest {
	@Test
	void newDoctor() {
		Doctor doc = new Doctor();
		assertEquals("Doctor", doc.getProfessionName());
	}
	
	@Test
	void newDoctorStartingLevel() {
		Doctor doc = new Doctor(2);
		assertEquals(2, doc.getProfessionLevel());
	}
	
	@Test
	void newDoctorStartingLevelName() {
		Doctor doc = new Doctor(2);
		assertEquals( "Doctor", doc.getProfessionName());
	}
	
	@Test
	void newBakerStartingLevel() {
		Baker baker = new Baker(3);
		assertEquals(3, baker.getProfessionLevel());
	}
	
	@Test
	void newBakerStartingLevelName() {
		Baker baker = new Baker(3);
		assertEquals("Baker", baker.getProfessionName());
	}
	
	@Test
	void addProfession() {
		BasePlayer player = new BasePlayer();
		Doctor doc = new Doctor();
		player.addProfession(doc);
		HashSet<Profession> comparingSet = new HashSet<>();
		comparingSet.add(doc);
		assertEquals(comparingSet, player.getProfessions());
	}
	
	@Test
	void addTwoProfessionSameName() {
		BasePlayer player = new BasePlayer();
		Doctor doc = new Doctor();
		Doctor doc2 = new Doctor();
		player.addProfession(doc);
		player.addProfession(doc2);
		assertEquals(1, player.getProfessions().size());
		
	}
	
	@Test
	void addTwoDifferentProfessions() {
		BasePlayer player = new BasePlayer();
		Doctor doc = new Doctor();
		Baker baker = new Baker();
		player.addProfession(doc);
		player.addProfession(baker);
		assertEquals(2, player.getProfessions().size());
		
	}
	
	@Test 
	void addNullProfession() {
		BasePlayer player = new BasePlayer();
		assertThrows(IllegalArgumentException.class,() -> { 
           player.addProfession(null);});
	}
	
	@Test
	void newPlayerHasNoProfession() {
		BasePlayer player = new BasePlayer();
		assertEquals(0, player.getProfessions().size());
	}
	
	@Test
	void checktoString() {
		Doctor doc = new Doctor();
		assertEquals("Level: 0 Doctor", doc.toString());

	}
	
	@Test
	void professionLevel0() {
		Doctor doc = new Doctor();
		assertEquals(0, doc.getProfessionLevel());
	}
	
	@Test
	void professionLevelSet() {
		Doctor doc = new Doctor();
		doc.setProfessionLevel(3);
		assertEquals(3, doc.getProfessionLevel());
	}
	
	@Test
	void negativeProfessionLevelSet() {
		Doctor doc = new Doctor();
		doc.setProfessionLevel(-3);
		assertEquals(0, doc.getProfessionLevel());
	}
	
	@Test
	void levelUpProfessionFromZero() {
		Doctor doc = new Doctor();
		doc.levelUpProfession();
		assertEquals(1, doc.getProfessionLevel());
	}
	
	@Test
	void setAndThenLevelUpProfession() {
		Doctor doc = new Doctor();
		doc.setProfessionLevel(3);
		doc.levelUpProfession();
		assertEquals(4, doc.getProfessionLevel());
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
	void levelUpWrongName() {
		BasePlayer player = new BasePlayer();
		Doctor doc = new Doctor();
		player.addProfession(doc);
		Profession.levelUpNamedProfession(player, "Baker");
		assertEquals(0, doc.getProfessionLevel());
	}
	
	@Test
	void basicSelfHealOnNonDoctor() {
		BasePlayer player = new BasePlayer();
		player.takeDamage(1);
		int healthBefore = player.getHealth();
		Doctor.basicSelfHeal(player);
		assertEquals(healthBefore, player.getHealth());
	}
	
	@Test
	void basicSelfHealOnLevel0Doctor() {
		BasePlayer player = new BasePlayer();
		player.takeDamage(1);
		int healthBefore = player.getHealth();
		Doctor doc = new Doctor();
		player.addProfession(doc);
		Doctor.basicSelfHeal(player);
		assertEquals(healthBefore, player.getHealth());
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
	
	@Test
	void basicHealAfterAddingWrongProfession() {
		BasePlayer player = new BasePlayer();
		player.takeDamage(1);
		int healthBefore = player.getHealth();
		Baker baker = new Baker();
		baker.levelUpProfession();
		player.addProfession(baker);
		Doctor.basicSelfHeal(player);
		assertEquals(healthBefore, player.getHealth());
	}
	
	@Test 
	void doesContainProfession() {
		BasePlayer player = new BasePlayer();
		Doctor doc = new Doctor();
		player.addProfession(doc);
		assertTrue(player.containsProfession("Doctor"));
	}
	
	@Test 
	void doesNotContainProfession() {
		BasePlayer player = new BasePlayer();
		Doctor doc = new Doctor();
		player.addProfession(doc);
		assertFalse(player.containsProfession("Baker"));
	}
	
	@Test 
	void doesContainProfessionWithTwoInSet() {
		BasePlayer player = new BasePlayer();
		Doctor doc = new Doctor();
		Baker baker = new Baker();
		player.addProfession(doc);
		player.addProfession(baker);
		assertTrue(player.containsProfession("Doctor"));
	}
	
	@Test
	void maxHealthBuffSuccess() {
		BasePlayer givingPlayer = new BasePlayer();
		BasePlayer receivingPlayer = new BasePlayer();
		Doctor doc = new Doctor();
		doc.setProfessionLevel(2);
		givingPlayer.addProfession(doc);
		int healthBefore = receivingPlayer.getHealth();
		Doctor.giveHealthBuff(givingPlayer, receivingPlayer);
		receivingPlayer.takeDamage(-1);
		assertTrue(receivingPlayer.getHealth() > healthBefore);
	}
	
	@Test
	void maxHealthBuffNotDoctor() {
		BasePlayer givingPlayer = new BasePlayer();
		BasePlayer receivingPlayer = new BasePlayer();
		Baker baker = new Baker();
		baker.setProfessionLevel(2);
		givingPlayer.addProfession(baker);
		int healthBefore = receivingPlayer.getHealth();
		Doctor.giveHealthBuff(givingPlayer, receivingPlayer);
		receivingPlayer.takeDamage(-1);
		assertFalse(receivingPlayer.getHealth() > healthBefore);
	}
	
	@Test
	void maxHealthBuffTooLowLevelDoctor() {
		BasePlayer givingPlayer = new BasePlayer();
		BasePlayer receivingPlayer = new BasePlayer();
		Doctor doc = new Doctor();
		doc.setProfessionLevel(1);
		givingPlayer.addProfession(doc);
		int healthBefore = receivingPlayer.getHealth();
		Doctor.giveHealthBuff(givingPlayer, receivingPlayer);
		receivingPlayer.takeDamage(-1);
		assertFalse(receivingPlayer.getHealth() > healthBefore);
	}
	
	@Test
	void maxHealthBuffAndThenHealInjuredPlayer() {
		BasePlayer givingPlayer = new BasePlayer();
		BasePlayer receivingPlayer = new BasePlayer();
		Doctor doc = new Doctor();
		doc.setProfessionLevel(2);
		givingPlayer.addProfession(doc);
		receivingPlayer.takeDamage(50);
		int prevMaxHealth = receivingPlayer.getMaxHealth();
		Doctor.giveHealthBuff(givingPlayer, receivingPlayer);
		receivingPlayer.takeDamage(-60);
		assertTrue(receivingPlayer.getHealth() > prevMaxHealth);
	}

}
