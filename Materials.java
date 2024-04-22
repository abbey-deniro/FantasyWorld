package com.csc280.FantasyWorldLab2;

import java.util.ArrayList;

public class Materials {
	public String id;
	public String name;
	public String originPlanet;
	public String rarity;
	
	
	Materials() {}
	
	Materials(String id, String name, String originPlanet, String rarity){
		this.id = id;
		this.name = name;
		this.originPlanet = originPlanet;
		this.rarity = rarity;
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

	public String getOriginPlanet() {
		return originPlanet;
	}

	public void setOriginPlanet(String originPlanet) {
		this.originPlanet = originPlanet;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	
	
@Override
	public String toString() {
		return "Materials [id=" + id + ", name=" + name + ", originPlanet=" + originPlanet + ", rarity=" + rarity + "]";
	}



	//	public Materials updateWith(Materials material) {
//		return new Materials(material.id, material.name, material.originPlanet, material.rarity);
//	}
//	
	static ArrayList<Materials> materialArray = new ArrayList<Materials>();
	
	
}
