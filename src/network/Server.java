package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import msgManagement.Msg;
import usersManagement.User;

public class Server {
	private ServerSocket serverSocket;
	
	public Server(ServerSocket serverSocket ){
		this.serverSocket = serverSocket;
	}
	
	public void StartServer() {
		try {
			System.out.println("SERVER : server is started!");
			while(!serverSocket.isClosed()) {
				Socket socket = this.serverSocket.accept();
				System.out.println("A New User has Connected!");
				ClientHandler client = new ClientHandler(socket);
				Thread thread = new Thread(client);
				thread.start();
			}
		}catch(IOException e ) {
			System.out.println(e.getMessage());
		}
	}
	
	public void CloseServerSocket() {
		try {
			if(serverSocket != null) {
				serverSocket.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(1234);
		Server server = new Server(serverSocket);
		server.StartServer();
	}
}
