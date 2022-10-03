package com.nortonassessment.questions;

import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FindNumberOfOrphanPlanets {

	public int numberOfOrphanPlanets(JSONArray jsonArray) {
		Set<String> orphanPlanets = new HashSet<>();
		JSONObject planet = null;
		
		
		for(int i=0;i<jsonArray.size();i++) {
			 planet = (JSONObject) jsonArray.get(i);
			 String PlanetIdentifier = (String) planet.get("PlanetIdentifier");
			 Long TypeFlag = (Long) planet.get("TypeFlag");
			 
			 if(TypeFlag == 3 && !orphanPlanets.contains(PlanetIdentifier)) {
				 orphanPlanets.add(PlanetIdentifier);
			}
		}
		return orphanPlanets.size();
	}

	
}
