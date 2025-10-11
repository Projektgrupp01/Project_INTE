package io.github.Projektgrupp01.Project_INTE;


import java.time.*;

public final class Date implements Comparable<Date> {

	private final int year, month, day;

	public static class IllegalDateException extends RuntimeException {
		public IllegalDateException(int year, int month, int day) {
			super(String.format("Illegal Date: " + year + "-" + month + "-" + day));
		}
	}

	public Date(int year, int month, int day) {
		if (year < 1582) {
			throw new IllegalDateException(year, month, day);
		}
		this.year = year;
		if (year <= 1582 && month < 10) {
			throw new IllegalDateException(year, month, day);
		}
		this.month = month;
		if (year <= 1582 && month <= 10 && day < 15) {
			throw new IllegalDateException(year, month, day);
		}
		this.day = day;
	}

	public Date(int month, int day) {
		int defaultYear = LocalDate.now().getYear();
		this.year = defaultYear;
		this.month = month;
		this.day = day;
	}

	public Date(String date) {
		try {
			String[] dateArray = date.split("-");
			int year = Integer.parseInt(dateArray[0]);
			int month = Integer.parseInt(dateArray[1]);
			int day = Integer.parseInt(dateArray[2]);
			if (year < 1582) {
				throw new IllegalDateException(year, month, day);
			}
			this.year = year;
			if (year <= 1582 && month < 10) {
				throw new IllegalDateException(year, month, day);
			}
			this.month = month;
			if (year <= 1582 && month <= 10 && day < 15) {
				throw new IllegalDateException(year, month, day);
			}
			this.day = day;
		} catch (NumberFormatException e) {
			throw new NumberFormatException("String did not contain numbers.");
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Wrong amount of integers in String");
		}

	}

	public String getMonthName() {
		switch (month) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			throw new IllegalStateException(String.format("The month you have chosen (" + month + ") does not exist."));
		}
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public final int getYear() {
		return year;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) { // is it the same object
			return true;
		}
		if (obj instanceof Date d) { // is it a Date rather than some other object
			return (d.getYear() == this.getYear() && d.getMonth() == this.getMonth() && d.getDay() == this.getDay());
		}
		return false;
	}

	@Override
	public int compareTo(Date d) {
//		if (year < d.year) {
//			return -1;
//		}
//		if (year > d.year) {
//			return 1;
//		}
//		if (month < d.month) {
//			return -1;
//		}
//		if (month > d.month) {
//			return 1;
//		}
//		if (day < d.day) {
//			return -1;
//		}
//		if (day > d.day) {
//			return 1;
//		}
//		return 0;
		int compare;
		return (compare = Integer.compare(year, d.year)) != 0 ? compare
				: (compare = Integer.compare(month, d.month)) != 0 ? compare : Integer.compare(day, d.day);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(year, month, day);
	}

	public String toString() {
		return String.format("%d %s %d", day, getMonthName(), year);
	}
}
