package beans;

import java.util.Date;

public class Booking {
	private String bookingId;
	private String brId;
	private Date bookingDate;
	private String userId;
	private String status;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getBrId() {
		return brId;
	}
	public void setBrId(String brId) {
		this.brId = brId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Booking(){};
	
	public Booking(String bookingId, String brId, Date bookingDate, String userId, String status) {
		super();
		this.bookingId = bookingId;
		this.brId = brId;
		this.bookingDate = bookingDate;
		this.userId = userId;
		this.status = status;
	}
	
	
}
