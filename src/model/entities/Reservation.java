package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date cheeckOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date cheeckOut) {

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.cheeckOut = cheeckOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheeckOut() {
		return cheeckOut;
	}

	public long duration() {
		long diff = cheeckOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.cheeckOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room" + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(cheeckOut)
				+ ", " + duration() + " nights";
	}
	// ?????????????
}
