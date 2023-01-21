package ru.home.TestServerApplication.server;

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
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
