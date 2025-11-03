package io.github.Projektgrupp01.Project_INTE.equipment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class EquipmentTest {

    @Test
    void equipmentHasName() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        assertEquals("Sword", sword.getName());
    }

    @Test
    void equipmentHasType() {
        Equipment helmet = new Equipment("Helmet", EquipmentType.HELMET);
        assertEquals(EquipmentType.HELMET, helmet.getType());
    }

    // equipment weight tests

    @Test
    void equipmentHasZeroWeight() {
        Equipment ring = new Equipment("Ring", EquipmentType.RING);
        assertEquals(0.0, ring.getWeight());
    }

    @Test
    void equipmentWeightCannotBeNegative() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);

        try {
            sword.setWeight(-5.0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void equipmentWeightCanBeSmall() {
        Equipment leafRing = new Equipment("Leaf Ring", EquipmentType.RING);
        leafRing.setWeight(0.1);
        assertEquals(0.1, leafRing.getWeight(), 0.001);
    }

    @Test
    void equipmentWeightBeLarge() {
        Equipment rustyChest = new Equipment("Rusty Chest Plate", EquipmentType.CHEST);
        rustyChest.setWeight(999.9);
        assertEquals(999.9, rustyChest.getWeight(), 0.001);
    }

    // durability tests

    @Test
    void equipmentHasDurability() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        assertTrue(sword.hasDurability());
        assertEquals(100, sword.getDurability());

    }

    @Test
    void ringDoesNotHaveDurability() {
        Equipment ring = new Equipment("Ring", EquipmentType.RING);
        assertFalse(ring.hasDurability());
        assertNull(ring.getDurability());
    }

    @Test
    void equipmentBreaksAtZero() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        sword.takeDamage(100);
        assertTrue(sword.isBroken());
        assertEquals(0, sword.getDurability());
    }

    @Test
    void equipmentDoesNotBreakAtOne() {
        Equipment bow = new Equipment("Bow", EquipmentType.WEAPON);
        bow.takeDamage(99);
        assertFalse(bow.isBroken());
        assertEquals(1, bow.getDurability());
    }

    @Test
    void equipmentTakesDamage() {
        Equipment chestplate = new Equipment("Chest Plate", EquipmentType.CHEST);
        chestplate.takeDamage(30);
        assertEquals(70, chestplate.getDurability());
    }

    @Test
    void equipmentTakingNegativeDamage() {
        Equipment legs = new Equipment("Leg Armor", EquipmentType.LEGS);
        try {
            legs.takeDamage(-50);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void cannotDamageAmulet() {
        Equipment amulet = new Equipment("Amulet", EquipmentType.AMULET);
        try {
            amulet.takeDamage(1);
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {

        }
    }

    // repairing equipment
    @Test
    void equipmentCanBeRepaired() {
        Equipment helmet = new Equipment("Iron Helmet", EquipmentType.HELMET);
        helmet.takeDamage(67);
        helmet.repair(66);
        assertEquals(99, helmet.getDurability());
    }

    @Test
    void cantRepairBeyond100() {
        Equipment boots = new Equipment("Leather boots", EquipmentType.BOOTS);
        boots.takeDamage(5);
        boots.repair(10);
        assertEquals(100, boots.getDurability());
    }

    @Test
    void cannotRepairWithNegativeValues() {
        Equipment gloves = new Equipment("Iron Gloves", EquipmentType.GLOVES);
        gloves.takeDamage(15);
        try {
            gloves.repair(-15);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void cannotRepairAmulet() {
        Equipment amulet = new Equipment("Fire Amulet", EquipmentType.AMULET);
        try {
            amulet.repair(50);
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
        }
    }

    // Equipment stats tests

    // Attack tests
    @Test
    void weaponDealsAttackDamage() {
        Equipment sword = new Equipment("Iron Sword", EquipmentType.WEAPON);
        sword.setAttackDamage(30);
        assertEquals(30, sword.getAttackDamage());

    }

    @Test
    void weaponCannotDealNegativeDamage() {
        Equipment spear = new Equipment("Spear", EquipmentType.WEAPON);
        try {
            spear.setAttackDamage(-15);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void weaponDealsMagicDamage() {

        Equipment magicSword = new Equipment("Magic Sword", EquipmentType.WEAPON);
        magicSword.setMagicDamage(25);
        assertEquals(25, magicSword.getMagicDamage());
    }

    @Test
    void weaponCanDealHybridDamage() {

        Equipment soulBlade = new Equipment("Soul Blade", EquipmentType.WEAPON);
        soulBlade.setAttackDamage(10);
        soulBlade.setMagicDamage(10);
        assertEquals(10, soulBlade.getAttackDamage());
        assertEquals(10, soulBlade.getMagicDamage());
        assertEquals(20, soulBlade.getTotalDamage());
    }

    @Test
    void weaponCanDealZeroDamage() {
        Equipment soulBlade = new Equipment("Soul Blade", EquipmentType.WEAPON);
        soulBlade.setAttackDamage(0);
        soulBlade.setMagicDamage(0);
        assertEquals(0, soulBlade.getAttackDamage());
        assertEquals(0, soulBlade.getMagicDamage());
    }

    @Test
    void weaponWithoutDamageTypeReturnsNull() {
        Equipment stick = new Equipment("Stick", EquipmentType.WEAPON);
        assertNull(stick.getAttackDamage());
        assertNull(stick.getMagicDamage());
    }

    // Defense tests

    @Test
    void helmetWithPhysicalDefense() {
        Equipment helmet = new Equipment("Iron Helmet", EquipmentType.HELMET);
        helmet.setPhysicalDefense(5);
        assertEquals(5, helmet.getPhysicalDefense());
    }

    @Test
    void chestWithPhysicalDefense() {
        Equipment chest = new Equipment("Iron Chest", EquipmentType.CHEST);
        chest.setPhysicalDefense(6);
        assertEquals(6, chest.getPhysicalDefense());
    }

    @Test
    void legsWithMagicDefense() {
        Equipment legs = new Equipment("Warded Legplates", EquipmentType.LEGS);
        legs.setMagicDefense(5);
        assertEquals(5, legs.getMagicDefense());
    }

    @Test
    void bootsWithMagicDefense() {
        Equipment boots = new Equipment("Warded Boots", EquipmentType.BOOTS);
        boots.setMagicDefense(6);
        assertEquals(6, boots.getMagicDefense());
    }

    @Test
    void armorCanHaveHybridDefense() {
        Equipment chestplate = new Equipment("Voidsteel Chestplate", EquipmentType.CHEST);
        chestplate.setPhysicalDefense(5);
        chestplate.setMagicDefense(10);

        assertEquals(5, chestplate.getPhysicalDefense());
        assertEquals(10, chestplate.getMagicDefense());
        assertEquals(15, chestplate.getTotalDefense());
    }

    @Test
    void magicDefenseCannotBeNegative() {
        Equipment gloves = new Equipment("Voidsteel Gloves", EquipmentType.GLOVES);
        try {
            gloves.setMagicDefense(-6);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void physicalDefenseCannotBeNegative() {
        Equipment gloves = new Equipment("Voidsteel Gloves", EquipmentType.GLOVES);
        try {
            gloves.setPhysicalDefense(-5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void weaponsCannotHaveMagicDefenseStats() {
        Equipment sword = new Equipment("Iron Sword", EquipmentType.WEAPON);
        try {
            sword.setMagicDefense(6);
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    void weaponsCannotHavePhysicalDefenseStats() {
        Equipment sword = new Equipment("Iron Sword", EquipmentType.WEAPON);
        try {
            sword.setPhysicalDefense(5);
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    void ringsCannotHaveDefenseStats() {
        Equipment ring = new Equipment("Magic Ring", EquipmentType.RING);
        try {
            ring.setPhysicalDefense(5);
            ring.setMagicDefense(6);
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    void defenseCanBeZero() {
        Equipment hat = new Equipment("Velvet Hat", EquipmentType.HELMET);
        hat.setPhysicalDefense(0);
        assertEquals(0, hat.getPhysicalDefense());
    }

    @Test
    void armorWithoutDefenseReturnsNull() {
        Equipment robe = new Equipment("Velvet Robe", EquipmentType.CHEST);
        assertNull(robe.getPhysicalDefense());
    }

    // Amulet and rings stats tests

    @Test
    void ringCanGiveHealthBonus() {
        Equipment ring = new Equipment("Ring of Life", EquipmentType.RING);
        ring.setHealthBonus(20);
        assertEquals(20, ring.getHealthBonus());
    }

    @Test
    void amuletCanGiveHealthBonus() {
        Equipment amulet = new Equipment("Amulet of Life", EquipmentType.AMULET);
        amulet.setHealthBonus(10);
        assertEquals(10, amulet.getHealthBonus());
    }

    @Test
    void healthBonusCannotBeNegative() {
        Equipment ring = new Equipment("Ring", EquipmentType.RING);
        try {
            ring.setHealthBonus(-10);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void healthBonusCanBeZero() {
        Equipment ring = new Equipment("Cosmetic Ring", EquipmentType.RING);
        ring.setHealthBonus(0);
        assertEquals(0, ring.getHealthBonus());
    }

    @Test
    void ringWithoutHealthBonusReturnsNull() {
        Equipment ring = new Equipment("Ring", EquipmentType.RING);
        assertNull(ring.getHealthBonus());
    }

    @Test
    void ringCanGiveEnergyBonus() {
        Equipment ring = new Equipment("Ring of Energy", EquipmentType.RING);
        ring.setEnergyBonus(15);
        assertEquals(15, ring.getEnergyBonus());
    }

    @Test
    void amuletCanGiveEnergyBonus() {
        Equipment amulet = new Equipment("Amulet of Energy", EquipmentType.AMULET);
        amulet.setEnergyBonus(25);
        assertEquals(25, amulet.getEnergyBonus());
    }

    @Test
    void energyBonusCannotBeNegative() {
        Equipment amulet = new Equipment("Amulet", EquipmentType.AMULET);
        try {
            amulet.setEnergyBonus(-10);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void energyBonusCanBeZero() {
        Equipment ring = new Equipment("Cosmetic Ring", EquipmentType.RING);
        ring.setEnergyBonus(0);
        assertEquals(0, ring.getEnergyBonus());
    }

    @Test
    void weaponsCannotGiveEnergyBonus() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        try {
            sword.setEnergyBonus(60);
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    void ringCanGiveMagicBonus() {
        Equipment ring = new Equipment("Ring of Magic", EquipmentType.RING);
        ring.setMagicBonus(15);
        assertEquals(15, ring.getMagicBonus());
    }

    @Test
    void amuletCanGiveMagicBonus() {
        Equipment amulet = new Equipment("Amulet of Magic", EquipmentType.AMULET);
        amulet.setMagicBonus(25);
        assertEquals(25, amulet.getMagicBonus());
    }

    @Test
    void magicBonusCannotBeNegative() {
        Equipment amulet = new Equipment("Amulet", EquipmentType.AMULET);
        try {
            amulet.setMagicBonus(-10);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void ringCanHaveMoreThanOneBonus() {
        Equipment ring = new Equipment("Legendary Ring", EquipmentType.RING);
        ring.setMagicBonus(20);
        ring.setHealthBonus(15);
        ring.setEnergyBonus(25);

        assertEquals(20, ring.getMagicBonus());
        assertEquals(15, ring.getHealthBonus());
        assertEquals(25, ring.getEnergyBonus());
    }

    @Test
    void amuletCanHaveMoreThanOneBonus() {
        Equipment amulet = new Equipment("Divine Amulet", EquipmentType.AMULET);
        amulet.setMagicBonus(30);
        amulet.setHealthBonus(50);
        amulet.setEnergyBonus(40);

        assertEquals(30, amulet.getMagicBonus());
        assertEquals(50, amulet.getHealthBonus());
        assertEquals(40, amulet.getEnergyBonus());
    }

    // Level requirements tests
    @Test
    void equipmentWithoutLevelRequirement() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        assertEquals(0, sword.getLevelRequirement());
    }

    @Test
    void equipmentWithLevelRequirement() {
        Equipment sword = new Equipment("Samurai Sword", EquipmentType.WEAPON);
        sword.setLevelRequirement(10);
        assertEquals(10, sword.getLevelRequirement());
    }

    @Test
    void levelRequirementCannotBeNegative() {
        Equipment sword = new Equipment("Negative Sword", EquipmentType.WEAPON);
        try {
            sword.setLevelRequirement(-5);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void levelRequirementCannotExceedMaxPlayerLevel() {
        Equipment sword = new Equipment("Impossible Sword", EquipmentType.WEAPON);

        try {
            sword.setLevelRequirement(11);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }

    // Tests for validating name of equipment

    // P1
    @Test
    void nameIsNullThrowsException() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new Equipment(null, EquipmentType.WEAPON));
        assertTrue(e.getMessage().contains("Name cant be null"));
    }

    @Test
    void emptyNameThrowsException() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new Equipment("", EquipmentType.WEAPON));
        assertTrue(e.getMessage().contains("Name cannot be empty or only whitespace"));
    }

    @Test
    void nameConsistsOfOnlyWhiteSpacesThrowsException() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new Equipment("   ", EquipmentType.WEAPON));
        assertTrue(e.getMessage().contains("Name cannot be empty or only whitespace"));
    }

    // P2

    @Test
    void nameTooShortThrowsException() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new Equipment("A", EquipmentType.WEAPON));
        assertTrue(e.getMessage().contains("at least 2 characters"));
    }

    @Test
    void nameWithinMinAndMaxLengthIsValid() {
        Equipment sword = new Equipment("Legendary Sword", EquipmentType.WEAPON);
        assertEquals("Legendary Sword", sword.getName());
    }

    @Test
    void nameIsTooLongThrowsException() {
        String tooLong = "Super duper long named Iron Axe";
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new Equipment(tooLong, EquipmentType.WEAPON));
        assertTrue(e.getMessage().contains("cannot exceed 30 characters"));
    }

    // P3

    @Test
    void nameWithOnlyLettersIsValid() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        assertEquals("Sword", sword.getName());
    }

    @Test
    void nameWithLettersAndNumberIsValid() {
        Equipment sword = new Equipment("Sword2000", EquipmentType.WEAPON);
        assertEquals("Sword2000", sword.getName());
    }

    @Test
    void nameWithLettersAndSpaceBetweenWordsIsValid() {
        Equipment sword = new Equipment("Iron Sword", EquipmentType.WEAPON);
        assertEquals("Iron Sword", sword.getName());
    }

    @Test
    void nameWithHyphenIsValid() {
        Equipment sword = new Equipment("Monster-Hunter", EquipmentType.WEAPON);
        assertEquals("Monster-Hunter", sword.getName());
    }

    @Test
    void nameWithApostropheIsValid() {
        Equipment sword = new Equipment("Hero's sword", EquipmentType.WEAPON);
        assertEquals("Hero's sword", sword.getName());
    }

    @Test
    void nameWithSwedishLettersIsValid() {
        Equipment bow = new Equipment("Ostbågen", EquipmentType.WEAPON);
        assertEquals("Ostbågen", bow.getName());
    }

    @Test
    void nameWithCombinationOfSpecialCharactersIsValid() {
        Equipment sword = new Equipment("Drägån-1", EquipmentType.WEAPON);
        assertEquals("Drägån-1", sword.getName());
    }

    @Test
    void nameWithInvalidCharactersThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Equipment("Sword!", EquipmentType.WEAPON));

        assertThrows(IllegalArgumentException.class,
                () -> new Equipment("Sword@", EquipmentType.WEAPON));

        assertThrows(IllegalArgumentException.class,
                () -> new Equipment("Sword_", EquipmentType.WEAPON));
    }

    // P4

    @Test
    void nameWithInternalSpacesIsValid() {
        Equipment sword = new Equipment("Sword with spaces", EquipmentType.WEAPON);
        assertEquals("Sword with spaces", sword.getName());
    }

    @Test
    void nameWithLeadingSpaceThrowsException() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new Equipment(" Sword", EquipmentType.WEAPON));
        assertTrue(e.getMessage().contains("Name cannot have leading or trailing spaces"));
    }

    @Test
    void nameWithTrailingSpaceThrowsException() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new Equipment("Sword ", EquipmentType.WEAPON));
        assertTrue(e.getMessage().contains("Name cannot have leading or trailing spaces"));
    }

    @Test
    void nameWithBothLeadingAndTrailingThrowsException() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new Equipment(" Sword ", EquipmentType.WEAPON));
        assertTrue(e.getMessage().contains("Name cannot have leading or trailing spaces"));
    }

    // P5

    @Test
    void minNameLengthIsValid() {
        Equipment sword = new Equipment("M8", EquipmentType.WEAPON);
        assertEquals("M8", sword.getName());
    }

    @Test
    void nameWithMaxLengthIsValid() {
        Equipment sword = new Equipment("Super duper long named Iron Ax", EquipmentType.WEAPON);

        assertEquals("Super duper long named Iron Ax", sword.getName());
    }

    @Test
    void validNameAndTypeCreatesEquipment() {
        Equipment sword = new Equipment("Sword", EquipmentType.WEAPON);
        assertEquals("Sword", sword.getName());
        assertEquals(EquipmentType.WEAPON, sword.getType());
    }

    @Test
    void nameIsValidButTypeIsNullThrowsException() {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new Equipment("Sword", null));
        assertTrue(e.getMessage().contains("Type cant be null"));
    }

}
