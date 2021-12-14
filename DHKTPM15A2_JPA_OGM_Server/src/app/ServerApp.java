/*
 *  (C) Copyright 2020 IUH. All rights reserved.
 * 
 *  @author: VinhHien
 *  @date: Nov 16, 2020
 *  @version: 1.0
 */

package app;

import java.awt.Container;
import java.awt.Dimension;
import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import dao.impl.RoomImpl;
import entity.Room;

public class ServerApp extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8129095323655532452L;
	private JTextArea ta;
	private RoomImpl roomDao;

	public ServerApp() {
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Room Reservation Server");

		Container cp = getContentPane();
		cp.add(new JScrollPane(ta = new JTextArea()));

		roomDao = new RoomImpl();

		new Thread(() -> {

			try {
				ServerSocket serverSocket = new ServerSocket(9090);

				SwingUtilities.invokeLater(() -> {
					ta.append("Server is started at : " + LocalDateTime.now());
					ta.append("\nServer is ready...");

				});

				while(true) {
					Socket socket = serverSocket.accept();

					SwingUtilities.invokeLater(() -> {
						ta.append("\nClient's IP Address: " + socket.getInetAddress().getHostAddress());
						ta.append("\nClient's Host name: " + socket.getInetAddress().getHostName());
					});
					RoomHandler handler = new RoomHandler(socket);
					Thread thread = new Thread(handler);
					thread.start();
				}

			}catch (Exception e) {
				e.printStackTrace();
			}

		}).start();

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ServerApp mygui = new ServerApp();
			mygui.setVisible(true);
		});

	}

	class RoomHandler implements Runnable{

		private Socket socket;
		private DataInputStream in;
		private List<Room> rooms;
		private ObjectOutputStream out;

		public RoomHandler(Socket socket) {
			super();
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new ObjectOutputStream(socket.getOutputStream());
				while(true) {
					//Nhận từ client
					String roomType = in.readUTF();

					SwingUtilities.invokeLater(() -> {
						ta.append("\nReceive from " + socket.getInetAddress().getHostName());
						ta.append("\n\tRoom type: " + roomType);
					});

					//Xử lý
					rooms = roomDao.getRoomByType(roomType);
					//Gửi kết quả ngược về client
					out.writeObject(rooms);				
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
