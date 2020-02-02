package com.telran.trello.model;

public class TeamData {
    private String name;
    private String description;
    String team;


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public TeamData setName(String name) {
        this.name = name;
        return this;
    }

    public TeamData setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "TeamData{" +
                "name='" + name + '\'' +
                '}' +  "TeamData{" +
                "description='" + description + '\'' +
                '}';
    }

}
