package owmapi;

import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.core.OWM.Unit;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import java.util.Scanner;

public class OwmAPICase {

	public static void main(String[] args) {
        
        // Declare OWM object and set metric as unit
        OWM owmObj = new OWM("3d3adbb44ef4da409b94a18948ed122b");
        owmObj.setUnit(Unit.METRIC);
        
        String city = getCityName();
        
        // Try/catch For APIException
        try {
			getCurrentWeather(owmObj, city);
		} 
        catch (APIException e) {
			if (e.getCode() == 404) {
				System.out.println("Error: 404 City not found.");
			}
			else {
				System.out.println("Something went wrong."); // Something else went wrong
				e.printStackTrace();
			}
		}
    }
	
	// Input city name with scanner
	public static String getCityName() {
		// Initiate Scanner, get next line and then close scanner
		Scanner scnr = new Scanner(System.in);
        System.out.println("Enter city of choice:");
        String cityName = scnr.nextLine();
        scnr.close();
        
        return cityName;
	}
	
	// Get and print current weather for given city
	public static void getCurrentWeather(OWM owm, String city) throws APIException {
		// Get current weather
		CurrentWeather currWeather = owm.currentWeatherByCityName(city);
		
		// If currWeather has a response code and the code is 200, everything is OK.
		if (currWeather.hasRespCode() && currWeather.getRespCode() == 200) {
			// Print city name and country code
			System.out.println("City: " + currWeather.getCityName() + ", " + currWeather.getSystemData().getCountryCode());
			// Print temperature and a description of the weather
			System.out.println("Temperature: " + currWeather.getMainData().getTemp() + "°C \n" +
							   "Description: " + currWeather.getWeatherList().get(0).getMainInfo() + ", " + currWeather.getWeatherList().get(0).getDescription());
		}
	}
}









