package kr.or.ddit.basic;

import java.io.*;
import java.net.*;

public class Receiver extends Thread{
	Socket socket;
	DataInputStream dis;
	public Receiver(Socket socket) {
		
		this.socket = socket;
		
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (dis != null) {
			try {
				System.out.println(dis.readUTF());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
}
