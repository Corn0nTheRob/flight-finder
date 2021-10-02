package com.ProjectModule5.Module5;

public class Duration {
	
	private String departure;
    private String total;
    
	public Duration() {
		
	}
	
	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
	    return departure;
	}

}
