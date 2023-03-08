package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		Duration duration = Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
		long days = duration.toDays();
		return days;
	
	}
	public String updateDates(LocalDate checkIn, LocalDate checkOut) {
		
		LocalDate now = LocalDate.now();
		
		System.out.println(now);
		System.out.println(checkOut);
		System.out.println(checkIn);
		
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			return "Reservation dates for uptade must be futurde dates";

		}
		
		if (!checkOut.isAfter(checkIn)){
			return "Error in reservation: Check-out date must be after check-in date";

		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + checkIn.format(fmt) + ", check-Out: " + checkOut.format(fmt) + ", " + duration() + " nights";
	}
	
}
