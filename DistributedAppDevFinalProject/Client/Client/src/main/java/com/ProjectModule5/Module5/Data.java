package com.ProjectModule5.Module5;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Data {

	private String id;
	private Duration duration;
	private String distance;
	private List<String> airlines;
	private String price;
	private Availability availability;
	private List<Route> route;
	private String flyDuration;
	
	public Data() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public List<String> getAirlines() {
		return airlines;
	}
	public void setAirlines(List<String> airlines) {
		this.airlines = airlines;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Availability getAvailability() {
		return availability;
	}
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}
	public List<Route> getRoute() {
		return route;
	}
	public void setRoute(List<Route> route) {
		this.route = route;
	}
	
	public String getFlyDuration() {
		return flyDuration;
	}

	public void setFlyDuration(String flyDuration) {
		this.flyDuration = flyDuration;
	}
}
