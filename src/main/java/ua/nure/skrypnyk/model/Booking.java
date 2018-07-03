package ua.nure.skrypnyk.model;

public class Booking extends Entity<Integer>{
    private int userId;
    private String status;

    public Booking(){

    }

    public Booking(int userId, String status) {
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
                ", statusl='" + status + '\'' +
                '}';
    }
}
