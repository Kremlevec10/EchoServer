package gui.backend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		new Client();
	}
	
	public Client() {
		conectionServer();
	}

	private static void conectionServer() {
		try (Socket socket = new Socket("localhost", 50800)) {
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			while (true) {
				outputStream.writeUTF(getMessegInConsole());
				String outMessege = inputStream.readUTF();
				if (outMessege.equals("/end")) {
					break;
				}
				System.out.println(outMessege);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getMessegInConsole() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your massege");
		String messeg = scanner.nextLine();
		return messeg;
	}

}
