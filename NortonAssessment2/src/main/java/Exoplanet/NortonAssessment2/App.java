package Exoplanet.NortonAssessment2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.nortonassessment.helper.RemoteDownloadFile;
import com.nortonassessment.questions.FindNumberOfOrphanPlanets;
import com.nortonassessment.questions.FindPlanetOrbittingHottestStar;
import com.nortonassessment.questions.FindTimeLineOfPlanets;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException, ParseException{
    	RemoteDownloadFile object1 = new RemoteDownloadFile();
		
		//Code to setup connection with the JSON URL and then download it locally
		try {
			URL url = new URL("https://gist.githubusercontent.com/joelbirchler/66cf8045fcbb6515557347c05d789b4a/raw/9a196385b44d4288431eef74896c0512bad3defe/exoplanets");
			HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
			if(connection.getResponseCode() == 200) {
				object1.remoteDownloadFile(connection);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		

		FindNumberOfOrphanPlanets object2 = new FindNumberOfOrphanPlanets();
		FindPlanetOrbittingHottestStar object3 = new FindPlanetOrbittingHottestStar();
		FindTimeLineOfPlanets object4 = new FindTimeLineOfPlanets();
		
		
		
		
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = (JSONArray)jsonParser.parse(new FileReader("C:\\Users\\at382\\eclipse-workspace\\NortonAssessment2\\ExoplanetList.json"));
	
		
		
		
		System.out.println("Q1. The number of Orphan planets = " + object2.numberOfOrphanPlanets(jsonArray));
		System.out.println("Q2. The planet orbitting the hottest star is : " + object3.planetOrbittingHottesStar(jsonArray));
		List<String> timeLineofPlanets = object4.FindTimeLineOfPlanets(jsonArray);
		
			for(String list : timeLineofPlanets) {
				
				System.out.println(list);
			}
		
    }
}
