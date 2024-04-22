package com.csc280.FantasyWorldLab2;

import java.util.ArrayList;

public class Planets {
	public String id;
	public String name;
	public String climate;
	public int rotation_period;
	public int orbital_period;
	
	Planets() {}
	
	
	
	Planets(String id, String name, String climate, int rotation_period, int orbital_period) {
		this.id = id;
		this.name = name;
		this.climate = climate;
		this.rotation_period = rotation_period;
		this.orbital_period = orbital_period;
	}
	
	public Planets GetEntry(String id) {
		Planets planets = new Planets();
		
		planets.setID(id);
			
		return planets;
			
	}
	
	public String getId() { return id;}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public int getRotation_period() {
		return rotation_period;
	}

	public void setRotation_period(int rotation_period) {
		this.rotation_period = rotation_period;
	}

	public int getOrbital_period() {
		return orbital_period;
	}

	public void setOrbital_period(int orbital_period) {
		this.orbital_period = orbital_period;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + ", climate=" + climate + ", rotation_period=" + rotation_period
				+ ", orbital_period=" + orbital_period + "]";
	}
	
	static ArrayList<Planets> planetArray = new ArrayList<Planets>();

	
}
