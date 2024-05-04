package in.ashokit._JSON_JACKSON_App.util;

import java.io.File;



//import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import in.ashokit._JSON_JACKSON_App.binding.Address;
import in.ashokit._JSON_JACKSON_App.binding.Passenger;

public class JavaToJSON {
	public static void main(String[] args) throws Exception {
		Passenger passenger = new Passenger();
		
		Address addr = new Address();
		addr.setCity("Mumbai");
		addr.setState("Maharashtra");
		addr.setCountry("India");
		
		passenger.setName("Raju");
		passenger.setFrom("Mumbai");
		passenger.setTo("Delhi");
		passenger.setGender("Male");
		passenger.setAddress(addr);
		
		/*
		 * ObjectMapper mapper = new ObjectMapper(); 
		 * mapper.writeValue(new File("passenger.json"),passenger);
		 * 
		 * 
		 */
//--------------------- GSON API Example -----------------------------------------
		Gson gson = new Gson();
		String json = gson.toJson(passenger);
		System.out.println(json);
		
		System.out.println("Done...........");
	}

}
