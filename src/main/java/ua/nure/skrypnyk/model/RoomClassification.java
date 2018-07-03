package ua.nure.skrypnyk.model;

import java.sql.Blob;

public class RoomClassification extends Entity<Integer>{
    private String classification;
    private int capacity;
    private String additionalInformation;
    private Blob pictures;
    private double dailyPrice;

    public RoomClassification(){

    }

    public RoomClassification(String classification, int capacity, String additionalInformation, Blob pictures, double dailyPrice) {
        this.classification = classification;
        this.capacity = capacity;
        this.additionalInformation = additionalInformation;
        this.pictures = pictures;
        this.dailyPrice = dailyPrice;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Blob getPictures() {
        return pictures;
    }

    public void setPictures(Blob pictures) {
        this.pictures = pictures;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    @Override
    public String toString() {
        return "RoomClassification{" +
                "classification='" + classification + '\'' +
                ", capacity=" + capacity +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", pictures=" + pictures +
                ", dailyPrice=" + dailyPrice +
                '}';
    }
}
