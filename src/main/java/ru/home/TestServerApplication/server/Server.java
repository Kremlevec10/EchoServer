package ru.home.TestServerApplication.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public Server() {
		startServer();
	}

	private void startServer() {
		try(ServerSocket serverSocket = new ServerSocket(8080)){
			System.out.println("Wait conection");
			Socket socket = serverSocket.accept();
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			while (true) {
				String messeg = inputStream.readUTF();
				outputStream.writeUTF(messeg);
				if ("/end".equals(messeg)) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
