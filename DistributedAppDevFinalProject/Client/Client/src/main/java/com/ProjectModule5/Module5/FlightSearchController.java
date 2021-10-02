package com.ProjectModule5.Module5;


import java.util.Collections;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class FlightSearchController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/search")
	public String search() {
		return "flightsearch";
	}
	
	@PostMapping("/search")
	public String search(
		@RequestParam(name="cityFrom") String from, 
		@RequestParam(name="cityTo") String to,
		@RequestParam(name="adults") String Adults,
		@RequestParam(name="kids") String Kids,
		@RequestParam(name="departDate") String travelDate,
		@RequestParam(name="returnDate") String returnDate,
		Model model) {
		
		System.out.println(from);
		System.out.println(to);
		System.out.println(DateConverter.getFormattedDate(travelDate, "yyyy-MM-dd", "dd/MM/yyyy"));
		String apiURL;
		apiURL = ("https://tequila-api.kiwi.com/v2/search?flight_type=round&fly_from=" + from + "&fly_to=" + to + "&date_from=" + DateConverter.getFormattedDate(travelDate, "yyyy-MM-dd", "dd/MM/yyyy") + "&date_to=" + DateConverter.getFormattedDate(travelDate, "yyyy-MM-dd", "dd/MM/yyyy") + "&return_from=" + DateConverter.getFormattedDate(returnDate, "yyyy-MM-dd", "dd/MM/yyyy") + "&return_to=" + DateConverter.getFormattedDate(returnDate, "yyyy-MM-dd", "dd/MM/yyyy") + "&Adults=" + Adults + "&children=" + Kids);		System.out.println(apiURL);

		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// create headers
		HttpHeaders headers = new HttpHeaders();

		// set `Content-Type` and `Accept` headers
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		// apikey header
		headers.set("apikey", "LtPNFzPYwDypzoQazE71yH87nrFVFDVB");

		// build the request
		HttpEntity request = new HttpEntity(headers);

		// make an HTTP GET request with headers
		ResponseEntity<String> response = restTemplate.exchange(
				apiURL,
				HttpMethod.GET,
				request,
				String.class,
				1
		);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Request Successful.");
			
			JSONObject respond = new JSONObject(response);
			JSONObject jBody = new JSONObject(respond.getString("body"));
			JSONArray jData = jBody.getJSONArray("data"); 
			System.out.println(respond);
			model.addAttribute("flightSearchResult", jData);
			
		} else {
			System.out.println("Request Failed");
			System.out.println(response);
		}

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		
		
		return "results";
	}
}

