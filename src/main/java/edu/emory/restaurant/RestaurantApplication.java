package edu.emory.restaurant;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.emory.restaurant.domain.Restaurant;
import edu.emory.restaurant.service.CompanyService;
import edu.emory.restaurant.service.JsonService;
import edu.emory.restaurant.vo.Company;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
