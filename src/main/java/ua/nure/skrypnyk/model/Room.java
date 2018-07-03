package ua.nure.skrypnyk.model;

public class Room extends Entity<Integer>{
    private int roomClassificationId;

    public Room(){

    }

    public Room(int roomClassificationId) {
        this.roomClassificationId = roomClassificationId;
    }

    public int getRoomClassificationId() {
        return roomClassificationId;
    }

    public void setRoomClassificationId(int roomClassificationId) {
        this.roomClassificationId = roomClassificationId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomClassificationId=" + roomClassificationId +
                '}';
    }
}
