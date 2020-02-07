package kr.or.ddit.basic;

import java.io.*;
import java.net.*;

public class T13_UdpSocketClient {

	private void start() throws IOException {
		// 소켓객체 생성
		DatagramSocket socket = new DatagramSocket();
		InetAddress serverAddr = InetAddress.getByName("localhost");
		
		// 데이터가 저장될 공간으로 byte배열을 생성한다.(패킷 수신용)
		byte[] msg = new byte[100];
		
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddr, 8888);
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
		
		socket.send(outPacket);	 	// DatagramPacket을 송신한다.
		socket.receive(inPacket); 	// DatagramPacket을 수신한다.
		
		System.out.println("현재 서버 시간 : "+ new String(inPacket.getData()));
		
		socket.close(); //소켓 종료
	}
	
	
	
	public static void main(String[] args) throws IOException  {
		new T13_UdpSocketClient().start();
	}

}
