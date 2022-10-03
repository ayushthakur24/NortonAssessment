package com.nortonassessment.questions;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.nortonassessment.helper.helper;


//class to find the planet orbitting the hottest star
public class FindPlanetOrbittingHottestStar {

	public String planetOrbittingHottesStar(JSONArray jsonArray) {
		JSONObject planet = null;
		long maxLongTemperature = 0;
		double maxDoubleTemperature = 0.0;
		long largestValue = 0;
		HashMap<Long,String> map = new HashMap<>();
		helper objectHelper = new helper();
		for(int i=0;i<jsonArray.size();i++) {
			 planet = (JSONObject) jsonArray.get(i);
			 
			 
			 if(planet.get("HostStarTempK")!= null && planet.get("HostStarTempK")!= "") {
				 long currentLongTemp = objectHelper.longValue(planet.get("HostStarTempK"));
				 double currentDoubleTemp = objectHelper.doubleValue(planet.get("HostStarTempK"));
				 
				 if(currentLongTemp!=-1 && currentDoubleTemp==-1) {
					 if(currentLongTemp > maxLongTemperature) {
						 maxLongTemperature = Math.max(maxLongTemperature, currentLongTemp);
						 Long value = (Long)maxLongTemperature;
						 map.put(value, (String) planet.get("PlanetIdentifier"));
					 }
					 
				 }
				 else {
					 if(currentDoubleTemp > maxDoubleTemperature) {
					 maxDoubleTemperature = Math.max(maxDoubleTemperature, currentDoubleTemp);
					 Long ans = Math.round(maxDoubleTemperature);
					 map.put(ans, (String) planet.get("PlanetIdentifier"));
					 }
				 }
			 }
		}
		
		for (Entry<Long, String> mapElement : map.entrySet()) {
            Long key = mapElement.getKey();
            largestValue = Math.max(key, largestValue);
           
	 		}
		
		return map.get(largestValue);
	}
}
