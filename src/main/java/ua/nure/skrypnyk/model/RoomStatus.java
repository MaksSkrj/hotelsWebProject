package ua.nure.skrypnyk.model;

import java.time.LocalDateTime;

public class RoomStatus extends Entity<Integer> {
    private int roomId;
    private int bookingId;
    private LocalDateTime arrival;
    private LocalDateTime departure;
    private int employeeId;
    private double fullPrice;

    public RoomStatus(){

    }

    public RoomStatus(int roomId, int bookingId, LocalDateTime arrival, LocalDateTime departure, int employeeId, double fullPrice) {
        this.roomId = roomId;
        this.bookingId = bookingId;
        this.arrival = arrival;
        this.departure = departure;
        this.employeeId = employeeId;
        this.fullPrice = fullPrice;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    @Override
    public String toString() {
        return "RoomStatus{" +
                "roomId=" + roomId +
                ", bookingId=" + bookingId +
                ", arrival=" + arrival +
                ", departure=" + departure +
                ", employeeId=" + employeeId +
                ", fullPrice=" + fullPrice +
                '}';
    }
}
