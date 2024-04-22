package com.csc280.FantasyWorldLab2;

import java.util.ArrayList;

public class Stars {
	public String id;
	public String name;
	public int brightness;
	public String color;
	public String mass;
	
	Stars() {}
	
	Stars(String id, String name, int brightness, String color, String mass) {
		this.id = id;
		this.name = name;
		this.brightness = brightness;
		this.color = color;
		this.mass = mass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBrightness() {
		return brightness;
	}

	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	@Override
	public String toString() {
		return "Stars [id=" + id + ", name=" + name + ", brightness=" + brightness + ", color=" + color + ", mass="
				+ mass + "]";
	}
	
	public Stars updateWith(Stars stars) {
		return new Stars(this.id, stars.name,stars.brightness,stars.color,stars.mass);
	}
	
	static ArrayList<Stars> starArray = new ArrayList<Stars>();
}
