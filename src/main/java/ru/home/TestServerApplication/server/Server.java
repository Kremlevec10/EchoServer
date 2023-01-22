package ru.home.TestServerApplication.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	public Server() {
		startServer();
	}

	private void startServer() {
		try(ServerSocket serverSocket = new ServerSocket(50800)){
			System.out.println("Wait conection");
			Socket socket = serverSocket.accept();
			System.out.println("Client conection");
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			while (true) {
				System.out.println("Wait messege from Client");
				String messeg = inputStream.readUTF();
				if ("/end".equals(messeg)) {
					break;
				}
				System.out.println("Send messege Client");
				outputStream.writeUTF(getMessege());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private String getMessege() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your server messege");
		String messege = scanner.nextLine();
		return messege;
	}

}
