package com.csc280.FantasyWorldLab2;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class Controller {
	
	
	
	
	
	//@RequestMapping("/admin")
	@PutMapping(path="/admin/planets/update/{id}")
	@ResponseBody
	public String updatePlanet(@RequestBody Planets newPlanet, @PathVariable String id) throws IOException {
		System.out.println("ID: " + newPlanet.getId());
		System.out.println("Name: " + newPlanet.getName());
		System.out.println("Climate: " + newPlanet.getClimate());
		System.out.println("Rotation Period: " + newPlanet.getRotation_period());
		System.out.println("Orbital Period: " + newPlanet.getOrbital_period());
		
		Planets planetObject = new Planets(newPlanet.getId(), newPlanet.getName(), newPlanet.getClimate(), newPlanet.getRotation_period(), newPlanet.getOrbital_period());
		System.out.println("planetlist" + planetObject);
		
		for(int i = 0; i <Planets.planetArray.size(); i++) {
			if(Planets.planetArray.get(i).id.contains(id)) {
				Planets.planetArray.set(i, planetObject);
				return "Planet Updated";
			}
		}
		return "Planet not found.";		
	}
	
	

//tester
	@RequestMapping(path = "/speak", method = RequestMethod.GET)
	public String speak() {
		return "test";
	}

	// PLANETS
	
//	@PutMapping(path="/planets/update/{id}")
//	@ResponseBody
//	public String updatePlanet(@RequestBody Planets newPlanet, @PathVariable String id) throws IOException {
//		System.out.println("ID: " + newPlanet.getId());
//		System.out.println("Name: " + newPlanet.getName());
//		System.out.println("Climate: " + newPlanet.getClimate());
//		System.out.println("Rotation Period: " + newPlanet.getRotation_period());
//		System.out.println("Orbital Period: " + newPlanet.getOrbital_period());
//		
//		Planets planetObject = new Planets(newPlanet.getId(), newPlanet.getName(), newPlanet.getClimate(), newPlanet.getRotation_period(), newPlanet.getOrbital_period());
//		System.out.println("planetlist" + planetObject);
//		
//		for(int i = 0; i <Planets.planetArray.size(); i++) {
//			if(Planets.planetArray.get(i).id.contains(id)) {
//				Planets.planetArray.set(i, planetObject);
//				return "Planet Updated";
//			}
//		}
//		return "Planet not found.";		
//	}
//	
	@DeleteMapping(path ="/admin/planets/delete/{id}")
    @ResponseBody
    public String DeletePlanetEntry(@PathVariable String id) {
		
         System.out.println("Id: " + id);
         String p = id;
         for(int i = 0; i<Planets.planetArray.size();i++) {
         if(Planets.planetArray.get(i).id.contains(p)) {
        	 Planets.planetArray.remove(Planets.planetArray.get(i));
        	 System.out.println("1planetlist" + Planets.planetArray);
            return "Deleted";
         }
         }

        return "Planet Not Found";
    }

	// adding planet
	@PostMapping(path = "/user/addPlanet")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String CreatePlanetEntry(@RequestBody Planets newPlanet) throws IOException {

		// Test/Validate values
		System.out.println("ID: " + newPlanet.getId());
		System.out.println("Name: " + newPlanet.getName());
		System.out.println("Climate: " + newPlanet.getClimate());
		System.out.println("Rotation Period: " + newPlanet.getRotation_period());
		System.out.println("Orbital Period: " + newPlanet.getOrbital_period());
		
		Planets planetObject = new Planets(newPlanet.getId(), newPlanet.getName(), newPlanet.getClimate(), newPlanet.getRotation_period(), newPlanet.getOrbital_period());		// Add values to your list

		Planets.planetArray.add(planetObject);
		System.out.println("planetlist" + Planets.planetArray);
		return "new planet added";
	}
	
	@GetMapping(path="/user/planets/get/{id}")
	//@ResponseBody
	public Planets getPlanet(@PathVariable String id) throws IOException {
		
		String planetID = id;
		
		Planets planetObject = new Planets();
		
		
		for(int i = 0; i <Planets.planetArray.size(); i++) {
			if(Planets.planetArray.get(i).id.contains(planetID)) {
				//Planets.planetArray.set(i, planetObject);
				//System.out.println("planetlist" + planetObject);
				System.out.println(Planets.planetArray.get(i));
				return Planets.planetArray.get(i);
			}
			//System.out.println(planetObject);
		}
		
		//System.out.println("planetlist" + planetObject);
		return planetObject;
		
	}

	@GetMapping(path = "/user/planets/getAllEntries")
	public ArrayList<Planets> printAllPlanetslist() throws IOException {
		return Planets.planetArray;
		
		
	}

	// STAR
	

	@PutMapping(path="/admin/stars/update/{id}")
	@ResponseBody
	public String updateStar(@RequestBody Stars newStar, @PathVariable String id) throws IOException {
		
		Stars starObject = new Stars(newStar.getId(), newStar.getName(), newStar.getBrightness(), newStar.getColor(), newStar.getMass());
		System.out.println("Starlist" + starObject);
		
		for(int i = 0; i <Stars.starArray.size(); i++) {
			if(Stars.starArray.get(i).id.contains(id)) {
				Stars.starArray.set(i, starObject);
				System.out.println("starlist" + starObject);
				return "Star Updated";
			}
			//System.out.println(planetObject);
		}
		
		System.out.println("starlist" + starObject);
		return "Planet not found.";
		
	}
	
	@DeleteMapping(path ="/admin/stars/delete/{id}")
    @ResponseBody
    public String DeleteEntry(@PathVariable String id) {
		
         System.out.println("Id: " + id);
         String p = id;
         for(int i = 0; i<Stars.starArray.size();i++) {
         if(Stars.starArray.get(i).id.contains(p)) {
        	 Stars.starArray.remove(Stars.starArray.get(i));
            return "Deleted";
         }
         }

        return "Star Not Found";
    }

	// adding star
	@PostMapping(path = "/user/addStar")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String CreateStarEntry(@RequestBody Stars newStar) throws IOException {

		Stars starObject = new Stars(newStar.getId(), newStar.getName(), newStar.getBrightness(), newStar.getColor(), newStar.getMass());
		//System.out.println("Starlist" + starObject);

		Stars.starArray.add(starObject);
		System.out.println("starlist" + Stars.starArray);
		return "new star added";
	}
	
	@GetMapping(path="/user/stars/get/{id}")
	@ResponseBody
	public Stars getStar(@PathVariable String id) throws IOException {

		
		Stars starObject = new Stars();
		//System.out.println("Starlist" + starObject);
		
		for(int i = 0; i <Stars.starArray.size(); i++) {
			if(Stars.starArray.get(i).id.contains(id)) {
				//Planets.planetObject.set(i, planetObject);
				//System.out.println("planetlist" + planetObject);
				return Stars.starArray.get(i);
			}
			//System.out.println(planetObject);
		}
		
		System.out.println("starlist" + starObject);
		return starObject;
		
	}

	@RequestMapping(path = "/user/stars/getAllEntries", method = RequestMethod.GET)
	public ArrayList<Stars> printAllStarslist() throws IOException {
		return Stars.starArray;
		
	}
	
	// CRYSTAL
	
	
	@PutMapping(path="/admin/crystals/update/{id}")
	@ResponseBody
	public String updateCrystal(@RequestBody Crystals newCrystal, @PathVariable String id) throws IOException {
		
		Crystals crystalObject = new Crystals(newCrystal.getId(), newCrystal.getName(), newCrystal.getColor(), newCrystal.getRarity(), newCrystal.getSpecialPower(), newCrystal.getOriginPlanet());
		
		for(int i = 0; i <Crystals.crystalArray.size(); i++) {
			if(Crystals.crystalArray.get(i).id.contains(id)) {
				Crystals.crystalArray.set(i, crystalObject);
				System.out.println("starlist" + crystalObject);
				return "Crystal Updated";
			//System.out.println(planetObject);
		}
		}
		
		//System.out.println("starlist" + starObject);
		return "Crystal not found.";
		
		
	}

	
	
	@DeleteMapping(path ="/admin/crystals/delete/{id}")
    @ResponseBody
    public String DeleteCEntry(@PathVariable String id) {
		
         System.out.println("Id: " + id);
         String p = id;
         for(int i = 0; i<Crystals.crystalArray.size();i++) {
         if(Crystals.crystalArray.get(i).id.contains(p)) {
        	 Crystals.crystalArray.remove(Crystals.crystalArray.get(i));
        	 System.out.println("CrystalList" + Crystals.crystalArray);
            return "Deleted";
         }
         }
		return "Crystal not found";
	}
	
//	@DeleteMapping(path ="/crystals/delete/{id}")
//    @ResponseBody
//    public String DeleteCrystalEntry(@PathVariable String id) {
//		
//         System.out.println("Id: " + id);
//         String p = id;
//         for(int i = 0; i<Crystals.crystalArray.size();i++) {
//         if(Crystals.crystalArray.get(i).id.contains(p)) {
//        	 Crystals.crystalArray.remove(Crystals.crystalArray.get(i));
//        	 System.out.println("crystalList" + Crystals.crystalArray);
//            return "Deleted";
//         }
//         }
//
//        return "Crystal Not Found";
//    }

	// adding Crystal
	@PostMapping(path = "/user/addCrystal")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String CreateStarEntry(@RequestBody Crystals newCrystal) throws IOException {

		Crystals crystalObject = new Crystals(newCrystal.getId(), newCrystal.getName(), newCrystal.getColor(), newCrystal.getRarity(), newCrystal.getSpecialPower(), newCrystal.getOriginPlanet());
		
		Crystals.crystalArray.add(crystalObject);
		System.out.println("crystalList" + Crystals.crystalArray);
		return "new crystal added";
	}
	
	@GetMapping(path="/user/crystals/get/{id}")
	@ResponseBody
	public Crystals getCrystal(@PathVariable String id) throws IOException {

		
		Crystals crystalObject = new Crystals();
		
		
		for(int i = 0; i <Crystals.crystalArray.size(); i++) {
			if(Crystals.crystalArray.get(i).id.contains(id)) {
				//Planets.planetObject.set(i, planetObject);
				//System.out.println("planetlist" + planetObject);
				return Crystals.crystalArray.get(i);
			}
			//System.out.println(planetObject);
		}
		
		System.out.println("crystallist" + crystalObject);
		return crystalObject;
		
	}

	@RequestMapping(path = "/user/crystals/getAllEntries", method = RequestMethod.GET)
	public ArrayList<Crystals> printAllCrystallist() throws IOException {
		return Crystals.crystalArray;
		
	}

	// MATERIAL
	
	@PutMapping(path="/admin/materials/update/{id}")
	@ResponseBody
	public String updateMaterial(@RequestBody Materials newMaterial, @PathVariable String id) throws IOException {
		
		Materials materialObject = new Materials(newMaterial.getId(), newMaterial.getName(), newMaterial.getOriginPlanet(), newMaterial.getRarity());
		
		for(int i = 0; i <Materials.materialArray.size(); i++) {
			if(Materials.materialArray.get(i).id.contains(id)) {
				Materials.materialArray.set(i, materialObject);
				System.out.println("materiallist" + materialObject);
				return "Material Updated";
			}
			//System.out.println(planetObject);
		}
		
		System.out.println("materiallist" + materialObject);
		return "Material not found.";
		
	}
	
	@DeleteMapping(path ="/admin/materials/delete/{id}")
    @ResponseBody
    public String DeleteEntry4(@PathVariable String id) {
		
         System.out.println("Id: " + id);
         String p = id;
         for(int i = 0; i<Materials.materialArray.size();i++) {
         if(Materials.materialArray.get(i).id.contains(p)) {
        	 Materials.materialArray.remove(Materials.materialArray.get(i));
        	 System.out.println("11materialList" + Materials.materialArray);
            return "Deleted";
            
         }
         System.out.println("22materialList" + Materials.materialArray);
         }

         System.out.println("33materialList" + Materials.materialArray);
        return "Material Not Found";
    }

	// adding planet
	@PostMapping(path = "/user/addMaterial")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String CreateMaterialEntry(@RequestBody Materials newMaterial) throws IOException {

		Materials materialObject = new Materials(newMaterial.getId(), newMaterial.getName(), newMaterial.getOriginPlanet(), newMaterial.getRarity());
		

		Materials.materialArray.add(materialObject);
		System.out.println("materialList" + Materials.materialArray);
		return "new material added";
	}
	
	@GetMapping(path="/user/materials/get/{id}")
	@ResponseBody
	public Materials getMaterial(@PathVariable String id) throws IOException {

		
		Materials materialObject = new Materials();
		
		
		for(int i = 0; i <Materials.materialArray.size(); i++) {
			if(Materials.materialArray.get(i).id.contains(id)) {
				//Planets.planetObject.set(i, planetObject);
				//System.out.println("planetlist" + planetObject);
				return Materials.materialArray.get(i);
			}
			//System.out.println(planetObject);
		}
		
		System.out.println("materialList" + materialObject);
		return materialObject;
		
	}

	@RequestMapping(path = "/user/materials/getAllEntries", method = RequestMethod.GET)
	public ArrayList<Materials> printAllMaterialslist() throws IOException {
		return Materials.materialArray;
		
	}

}


