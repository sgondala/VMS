package beans;

public class Route {
	private String routeId;
	private String routeName;
	private String source;
	private String destination;
	private int distance;
	private int fare;
	public String getRouteId() {
		return routeId;
	}
	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	
	public Route(){}
	
	public Route(String routeId, String routeName, String source, String destination, int distance, int fare) {
		super();
		this.routeId = routeId;
		this.routeName = routeName;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.fare = fare;
	}
	
	
}
