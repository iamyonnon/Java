package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Room implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6547296007488436379L;
	@Id
	private int id;
	private String roomType;
	private String description;
	private boolean smoke;
	private int capacity;
	
	public Room() {
	}

	public Room(int id, String roomType, String description, boolean smoke, int capacity) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.description = description;
		this.smoke = smoke;
		this.capacity = capacity;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isSmoke() {
		return smoke;
	}

	public void setSmoke(boolean smoke) {
		this.smoke = smoke;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomType=" + roomType + ", description=" + description + ", smoke=" + smoke
				+ ", capacity=" + capacity + "]";
	}
	
	
}
