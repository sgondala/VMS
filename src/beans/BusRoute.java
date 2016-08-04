package beans;

import java.sql.Time;
import java.util.Date;

public class BusRoute {
	private String brId;
	private String busNumber;
	private String routeId;
	private Date journeyDate;
	private Time timeStamp;
	
	public String getBrId() {
		return brId;
	}
	public void setBrId(String brId) {
		this.brId = brId;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public Time getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Time timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public BusRoute(){};
	
	public BusRoute(String brId, String busNumber, String routeId, Date journeyDate, Time timeStamp) {
		super();
		this.brId = brId;
		this.busNumber = busNumber;
		this.routeId = routeId;
		this.journeyDate = journeyDate;
		this.timeStamp = timeStamp;
	}
	
	
}
