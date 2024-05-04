package in.ashokit._JSON_JACKSON_App.util;

import java.io.File;
import java.io.FileReader;

import com.google.gson.Gson;

//import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit._JSON_JACKSON_App.binding.Passenger;

public class JsonToJava {
	public static void main(String[] args) throws Exception{
		
		/*
		 * ObjectMapper mapper = new ObjectMapper();
		 * 
		 * Passenger passenger= mapper.readValue(new
		 * File("passenger.json"),Passenger.class); System.out.println(passenger);
		 */
		
// ----------------------------GSON API Example--------------------------------------
		Gson gson = new Gson();
		Passenger p =  gson.fromJson(new FileReader("passenger.json"),Passenger.class);
		System.out.println(p);
		
	}

}
