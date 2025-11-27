package com.ripon.spring.boot.web.mondb;

import org.springframework.data.annotation.Id;

public class Team {
	
	@Id
	private int teamId;
	private String teamName;
	private String teamCity;
	private int teamFounded;
	private String coachName;
	
	//Empty constructor
	
	public Team() {
		super();	
	}
	
	//Constructor with parameters
	public Team(int teamId, String teamName, String teamCity, int teamFounded, String coachName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamCity = teamCity;
		this.teamFounded = teamFounded;
		this.coachName = coachName;
	}
	
	//Getter and setter methods
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamCity() {
		return teamCity;
	}
	public void setTeamCity(String teamCity) {
		this.teamCity = teamCity;
	}
	
	
	public int getTeamFounded() {
		return teamFounded;
	}
	public void setTeamFounded(int teamFounded) {
		this.teamFounded = teamFounded;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	
	

}

