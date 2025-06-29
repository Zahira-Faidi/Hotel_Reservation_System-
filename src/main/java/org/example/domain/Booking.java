package org.example.domain;

import java.util.Date;

public class Booking {
    private final User user;
    private final Room room;
    private final Date checkIn;
    private final Date checkOut;

    public Booking(User user, Room room, Date checkIn, Date checkOut) {
        this.user = user;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public boolean overlaps(Date in, Date out) {
        return checkIn.before(out) && in.before(checkOut);
    }

    public Room getRoom() {
        return room;
    }

    public String getBookingDetails() {
        return "Booking{UserId=" + user.getUserId() + ", Room=" + room + ", checkIn=" + checkIn + ", checkOut=" + checkOut + '}';
    }
}

