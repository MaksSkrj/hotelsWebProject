package ua.nure.skrypnyk.DTO;

import ua.nure.skrypnyk.model.Entity;

public class RoomDTO extends Entity<Integer> {
    private int roomClassificationId;

    public RoomDTO(){

    }

    public RoomDTO(int roomClassificationId) {
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
