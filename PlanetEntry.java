package com.csc280.FantasyWorldLab2;

public class PlanetEntry {
	
	public Planets GetEntry(String id) {
		Planets entry = new Planets();
		
		entry.setID((id));
		//entry.setName(name);
		
		return entry;
		
	}
}
