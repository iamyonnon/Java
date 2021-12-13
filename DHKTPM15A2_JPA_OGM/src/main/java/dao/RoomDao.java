package dao;

import java.util.List;

import entity.Room;

public interface RoomDao {
	
	public List<Room> getRoomByType(String roomType);
	
}
