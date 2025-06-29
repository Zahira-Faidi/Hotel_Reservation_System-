package org.example.domain;

public class Room {
    private final int roomNumber;
    private RoomType type;
    private int pricePerNight;

    public Room(int roomNumber, RoomType type, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void updateDetails(RoomType type, int pricePerNight) {
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Room{" + "roomNumber=" + roomNumber + ", type=" + type + ", pricePerNight=" + pricePerNight + '}';
    }
}

