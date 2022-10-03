package com.nortonassessment.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.nortonassessment.helper.helper;



public class FindTimeLineOfPlanets {

	public List<String> FindTimeLineOfPlanets(JSONArray jsonArray) {
		helper objectHelper = new helper();
		List<String> resultSet = new ArrayList<>();
		ArrayList<Long> yearsList = new ArrayList<>();
		HashMap<Long,List<Double>> map = new HashMap<>();
		HashMap<Long,Integer> smallPlanets = new HashMap<>();
		HashMap<Long,Integer> mediumPlanets = new HashMap<>();
		HashMap<Long,Integer> largePlanets = new HashMap<>();
		
		JSONObject planet = null;
		
		
		for(int i=0;i<jsonArray.size();i++) {
			 planet = (JSONObject) jsonArray.get(i);
			 
			 if(planet.get("DiscoveryYear")!=""){
				 Long currentYear = (Long)planet.get("DiscoveryYear");
				 
				 if(!yearsList.contains(currentYear))
					 yearsList.add(currentYear);
				 else
					 continue;
			 }
		}
		
		//sorting based on years - 1781,1846,1930....
		Collections.sort(yearsList);
		
		
		//adding all radiuses according to the years
		for(int i=0;i<jsonArray.size();i++) {
			 planet = (JSONObject) jsonArray.get(i);
			 
			 if(planet.get("RadiusJpt")!="") {
				 if(planet.get("DiscoveryYear")!="") {
					 Long DiscoveryYear = (Long) planet.get("DiscoveryYear");
					 double currentDoubleRadius = objectHelper.doubleValue(planet.get("RadiusJpt"));
					 
					 if(!map.containsKey(DiscoveryYear)) {
						 map.put(DiscoveryYear, new ArrayList<Double>());
						 List<Double> radiuses = map.get(DiscoveryYear);
						 radiuses.add(currentDoubleRadius);
						 map.put(DiscoveryYear, radiuses);
					 }
					 else {
						 List<Double> radiuses = map.get(DiscoveryYear);
						 radiuses.add(currentDoubleRadius);
						 map.put(DiscoveryYear, radiuses);
					 }
				 }
			 }
		}
		
		
		for (Entry<Long, List<Double>> radiusElement : map.entrySet()) {
			Long currentYear = radiusElement.getKey();
			List<Double> radiuses = radiusElement.getValue();
			Integer smallCount = 0, mediumCount=0, largeCount = 0;
			
			for(int i=0;i<radiuses.size();i++) {
				Double jupiterRadius = radiuses.get(i);
				
				if(jupiterRadius <= 0.9) {
					smallCount++;
					
				}
				else if(jupiterRadius >= 1.0 && jupiterRadius <= 1.9) {
					mediumCount++;
					
				}
				else {
					largeCount++;
					
				}
			}
			
			smallPlanets.put(currentYear, smallCount);
			mediumPlanets.put(currentYear, mediumCount);
			largePlanets.put(currentYear, largeCount);
		}
		
		for(Long year : yearsList) {
		if((smallPlanets.get(year) == null) || (mediumPlanets.get(year) == null) || (largePlanets.get(year) == null))
			continue;
		else	
			resultSet.add("In year " + year + " we discovered " + smallPlanets.get(year) + " small planets," + 
				mediumPlanets.get(year) + " medium planets, and " + largePlanets.get(year) + " large planets");
	}
		
		return resultSet;
	}

}
