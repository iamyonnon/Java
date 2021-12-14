package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import entity.Room;

public class RoomManagerGUI extends JFrame {
	
	private JTextArea ta;
	private JTextField tfRoomType;
	private JButton btnSearch;
	private DataOutputStream out;
	private ObjectInputStream in;

	public RoomManagerGUI() {
		setExtendedState(MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Room Manager");

		Container cp = getContentPane();
		
		Box b;
		cp.add(b = Box.createHorizontalBox(), BorderLayout.NORTH);
		b.add(new JLabel("Search room by room type : "));
		b.add(tfRoomType = new JTextField("Deluxe"));
		b.add(btnSearch = new JButton("Search..."));
		cp.add(new JScrollPane(ta = new JTextArea()));
	
		new Thread(() -> {
			try {
				Socket socket = new Socket("192.168.1.73", 9090);
				out = new DataOutputStream(socket.getOutputStream());
				in = new ObjectInputStream(socket.getInputStream());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
		
		btnSearch.addActionListener((e) -> {
		
			try {
				String roomType = tfRoomType.getText();
				//Gửi lên server
				out.writeUTF(roomType);
				//Nhận từ server
				List<Room> rooms = (List<Room>) in.readObject();
				//Hiển thị kết quả
				for(Room r : rooms) {
					SwingUtilities.invokeLater(() -> {
						ta.append("\n" + r.toString());
					});
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new RoomManagerGUI().setVisible(true);
		});
	}
}
