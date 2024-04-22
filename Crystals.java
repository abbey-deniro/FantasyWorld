package com.csc280.FantasyWorldLab2;

import java.util.ArrayList;

public class Crystals {
	public String id;
	public String name;
	public String color;
	public int rarity;
	public String specialPower;
	public String originPlanet;
	
	Crystals() {}
	
	Crystals(String id, String name, String color, int rarity, String specialPower, String originPlanet) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.rarity = rarity;
		this.specialPower = specialPower;
		this.originPlanet = originPlanet;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public String getSpecialPower() {
		return specialPower;
	}

	public void setSpecialPower(String specialPower) {
		this.specialPower = specialPower;
	}

	public String getOriginPlanet() {
		return originPlanet;
	}

	public void setOriginPlanet(String originPlanet) {
		this.originPlanet = originPlanet;
	}

	@Override
	public String toString() {
		return "Crystals [id=" + id + ", name=" + name + ", color=" + color + ", rarity=" + rarity + ", specialPower="
				+ specialPower + ", originPlanet=" + originPlanet + "]";
	}
	
	static ArrayList<Crystals> crystalArray = new ArrayList<Crystals>();
}
