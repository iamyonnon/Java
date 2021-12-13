package app;

import dao.CustomerDao;
import dao.RoomDao;
import dao.impl.CustomerImpl;
import dao.impl.RoomImpl;

public class App {
	public static void main(String[] args) {
		RoomDao roomDao = new RoomImpl();
		CustomerDao customerDao = new CustomerImpl();
		customerDao.updatePhoneNumbers("BRVA12553", "0914 555 666");
		
		
//		roomDao.getRoomByType("Deluxe")
//		.forEach(r -> System.out.println(r));
	}
}
