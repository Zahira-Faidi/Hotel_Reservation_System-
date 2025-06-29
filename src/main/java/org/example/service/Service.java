package org.example.service;

import org.example.domain.Booking;
import org.example.domain.Room;
import org.example.domain.RoomType;
import org.example.domain.User;

import java.util.*;

public class Service {
    private List<Room> rooms = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.updateDetails(roomType, roomPricePerNight);
                return;
            }
        }
        rooms.add(new Room(roomNumber, roomType, roomPricePerNight));
    }

    public void setUser(int userId, int balance) {
        for (User user : users) {
            if (user.getUserId() == userId) return;
        }
        users.add(new User(userId, balance));
    }

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        if (!checkIn.before(checkOut)) {
            System.out.println("Invalid booking dates.");
            return;
        }

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                selectedRoom = room;
                break;
            }
        }

        User selectedUser = null;
        for (User user : users) {
            if (user.getUserId() == userId) {
                selectedUser = user;
                break;
            }
        }

        if (selectedRoom == null || selectedUser == null) {
            System.out.println("Room or User not found.");
            return;
        }

        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomNumber() == roomNumber && booking.overlaps(checkIn, checkOut)) {
                System.out.println("Room not available for given dates.");
                return;
            }
        }

        int nights = (int) ((checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24));
        int totalCost = nights * selectedRoom.getPricePerNight();

        if (selectedUser.getBalance() < totalCost) {
            System.out.println("Insufficient balance.");
            return;
        }

        selectedUser.deductBalance(totalCost);
        bookings.add(new Booking(selectedUser, selectedRoom, checkIn, checkOut));
        System.out.println("Booking successful.");
    }

    public void printAll() {
        System.out.println("Rooms:");
        ListIterator<Room> roomIter = rooms.listIterator(rooms.size());
        while (roomIter.hasPrevious()) {
            System.out.println(roomIter.previous());
        }

        System.out.println("Bookings:");
        ListIterator<Booking> bookingIter = bookings.listIterator(bookings.size());
        while (bookingIter.hasPrevious()) {
            System.out.println(bookingIter.previous().getBookingDetails());
        }
    }

    public void printAllUsers() {
        System.out.println("Users:");
        ListIterator<User> userIter = users.listIterator(users.size());
        while (userIter.hasPrevious()) {
            System.out.println(userIter.previous());
        }
    }
}

