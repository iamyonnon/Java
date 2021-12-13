package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Booking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5791696496233072452L;

	@ManyToOne
	@JoinColumn(name="roomId")
	private Room room;
	
	private Date arrivalDate;
	private Date departureDate;
	private String status;
	private double customizedPrice;
	
	
	public Booking() {
	}


	public Booking(Room room, Date arrivalDate, Date departureDate, String status, double customizedPrice) {
		super();
		this.room = room;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.status = status;
		this.customizedPrice = customizedPrice;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	public Date getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public Date getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public double getCustomizedPrice() {
		return customizedPrice;
	}


	public void setCustomizedPrice(double customizedPrice) {
		this.customizedPrice = customizedPrice;
	}


	@Override
	public String toString() {
		return "Booking [room=" + room + ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate
				+ ", status=" + status + ", customizedPrice=" + customizedPrice + "]";
	}
	
	
	
}
