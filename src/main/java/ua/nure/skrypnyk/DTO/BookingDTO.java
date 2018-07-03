package ua.nure.skrypnyk.DTO;

import ua.nure.skrypnyk.model.Entity;

public class BookingDTO extends Entity<Integer> {
    private int userId;
    private String status;

    public BookingDTO(){

    }

    public BookingDTO(int userId, String status) {
        this.userId = userId;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userId=" + userId +
                ", status='" + status + '\'' +
                '}';
    }
}
