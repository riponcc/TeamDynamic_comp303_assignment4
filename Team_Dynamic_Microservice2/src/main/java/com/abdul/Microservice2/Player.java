package com.abdul.Microservice2;

public class Player {
    private int playerId;
    private String firstName;
    private String lastName;
    private String position;
    private int jerseyNumber;
    private int age;
    private int teamId;

    // empty Constructor
    public Player() {
        super();
		// TODO Auto-generated constructor stub
    }

    // Constructor with all fields
    public Player(int playerId, String firstName, String lastName, String position, int jerseyNumber, int age, int teamId) {
        super();
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
        this.age = age;
        this.teamId = teamId;
    }

    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}