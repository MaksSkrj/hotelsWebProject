package ua.nure.skrypnyk.DTO;

import ua.nure.skrypnyk.model.Entity;

public class PositionDTO extends Entity<Integer> {
    private String name;

    public PositionDTO(){

    }

    public PositionDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                '}';
    }
}
