package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import msgManagement.IMsgImp;
import msgManagement.Msg;


public class ClientHandler implements Runnable{
public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
private Socket socket;
private ObjectOutputStream write ;
private ObjectInputStream read;
private String username;

	public ClientHandler(Socket socket) {
		try {
			this.socket = socket;
			this.write = new ObjectOutputStream(socket.getOutputStream());
			this.read = new ObjectInputStream(socket.getInputStream());
			
			Msg msg1 =(Msg) read.readObject();
			this.username = msg1.getSender();
			clientHandlers.add(this);
			Msg msg = new Msg(1,"("+username+") has entered chat!",1,"SERVER");
			Broadcast(msg);
		} catch (IOException e) {
			closeAll( socket, read, write);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		 Msg msg;
		 
		while(socket.isConnected()) {
			try {
				msg =(Msg) read.readObject();
				IMsgImp ob = new IMsgImp();
				ob.addMsg(msg);
				Broadcast(msg);
			}catch(Exception e) {
				closeAll(socket,read,write);
				break;
			}
		}
	}
	
	public void Broadcast(Msg msg) {
		for(ClientHandler clientHandler : clientHandlers) {
			try {
				clientHandler.write.writeObject(msg);
				clientHandler.write.flush();
			} catch (IOException e) {
				closeAll(socket,read,write);
			}
		}
	}
	
	
	public void removeClient() {
		clientHandlers.remove(this);
		//int msgId, String contentMsg, int userId, String sender
		String contentMsg =  "("+username+") has leave chat!";
		Msg msg = new Msg(1,contentMsg,1,"SERVER");
		Broadcast(msg);
	}
	
	public void closeAll(Socket socket,ObjectInputStream read,ObjectOutputStream write) {
		removeClient();
		try {
			if(read != null) {
				read.close();
			}
			if(write != null) {
				write.close();
			}
			if(socket != null) {
				socket.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
