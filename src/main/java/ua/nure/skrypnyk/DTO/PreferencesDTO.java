package ua.nure.skrypnyk.DTO;

import ua.nure.skrypnyk.model.Entity;

public class PreferencesDTO extends Entity<Integer> {
    private String name;

    public PreferencesDTO(){

    }

    public PreferencesDTO(String name) {
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
        return "Preferences{" +
                "name='" + name + '\'' +
                '}';
    }
}
