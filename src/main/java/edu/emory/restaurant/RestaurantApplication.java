package edu.emory.restaurant;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.emory.restaurant.service.JsonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RestaurantApplication.class, args);
		parseJsonRestaurants();
	}

	private static void parseJsonRestaurants() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonService jsonService = new JsonService();
		String resJsonStr = jsonService.getRestaurants();
		int i = 0;
		while(resJsonStr.charAt(i) != '[') {
			i++;
		}
		resJsonStr = resJsonStr.substring(i);
		System.out.println(resJsonStr);
	}
}
