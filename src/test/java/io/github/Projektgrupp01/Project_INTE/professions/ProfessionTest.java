package io.github.Projektgrupp01.Project_INTE.professions;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
