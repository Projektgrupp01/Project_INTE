package io.github.Projektgrupp01.Project_INTE.professions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
	void newDoctorStartingLevel() {
		Doctor doc = new Doctor(2);
		assertEquals(doc.getProfessionLevel(), 2);
	}
	
	@Test
	void newDoctorStartingLevelName() {
		Doctor doc = new Doctor(2);
		assertEquals(doc.getProfessionName(), "Doctor");
	}
	
	@Test
	void newBakerStartingLevel() {
		Baker baker = new Baker(3);
		assertEquals(baker.getProfessionLevel(), 3);
	}
	
	@Test
	void newBakerStartingLevelName() {
		Baker baker = new Baker(3);
		assertEquals(baker.getProfessionName(), "Baker");
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
		assertEquals(doc.toString(),"Level: 0 Doctor");

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
	

}
