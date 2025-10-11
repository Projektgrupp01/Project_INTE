package io.github.Projektgrupp01.Project_INTE;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DateTest {
	private static final Date DEFAULT_DATE = new Date(2000, 1, 1);
	private static final Date DEFAULT_DATE_YEAR = new Date(2001, 1, 1);
	private static final Date DEFAULT_DATE_MONTH = new Date(2000, 2, 1);
	private static final Date DEFAULT_DATE_DAY = new Date(2000, 1, 2);
	private static final Date DEFAULT_STRING_DATE = new Date("2000-01-01");

	private static final Date[] DATES = { DEFAULT_DATE, DEFAULT_DATE_YEAR, DEFAULT_DATE_MONTH, DEFAULT_DATE_DAY,
			DEFAULT_STRING_DATE };

	@Test
	public void equalDates() {
		assertTrue(DEFAULT_DATE.equals(DEFAULT_DATE));
	}

	@Test
	public void assertCompareToWorks() {
		for (Date a : DATES) {
			assertTrue(a.compareTo(a) == 0, "The same dates should be equal");

			for (Date b : DATES) {
				int AB = Integer.signum(a.compareTo(b));
				int BA = Integer.signum(b.compareTo(a));
				assertEquals(-AB, BA, "Antisymmetry test: " + a + " vs " + b + " ");

				if (a.equals(b)) {
					assertEquals(0, a.compareTo(b), "Consistency with equals failed: " + a + " vs " + b);
				}

				for (Date c : DATES) {
					if (a.compareTo(b) > 0 && b.compareTo(c) > 0) {
						assertTrue(a.compareTo(c) > 0, "Transivity-test (if " + a + " is later than " + b + " and " + b
								+ " is later than " + c + ", then " + a + " should be later than " + c + ")");
					}
				}
			}
		}
	}

	@Test
	public void assertEqualsWorks() {
		assertEquals(2, 1 + 1);
	}

	@Test
	public void testYearTooEarly() {
		assertThrows(Exception.class, () -> {
			new Date(1581, 12, 1);
		});
	}

	@Test
	public void testYear1582MonthTooEarly() {
		assertThrows(Exception.class, () -> {
			new Date(1582, 9, 15);
		});
	}

	@Test
	public void testYear1582MonthOctoberDayTooEarly() {
		assertThrows(Exception.class, () -> {
			new Date(1582, 10, 14);
		});
	}

	@Test
	void testEarliestValidGregorianDate() {
		assertDoesNotThrow(() -> {
			new Date(1582, 10, 15);
		});
	}

	@Test
	void testMinMax() {
		assertThrows(Exception.class, () -> {
			new Date(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
		});
		assertDoesNotThrow(() -> {
			new Date(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
		});
	}

	@Disabled
	@Test
	void jupiterVersion() {
		String version = Test.class.getPackage().getImplementationVersion();
		System.out.println("JUnit Jupiter API version: " + version);

		String wantedVersion = "5.12.2";
		assertEquals(wantedVersion, version, "JUnit Jupiter version should be " + wantedVersion);
	}
}
