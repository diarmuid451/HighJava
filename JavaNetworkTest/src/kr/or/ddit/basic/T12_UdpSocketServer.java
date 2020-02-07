package kr.or.ddit.basic;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class T12_UdpSocketServer {
	
	private DatagramSocket socket;
	
	public void start() throws IOException{
		// 포트번호 8888번을 사용하는 소켓 생성
		socket = new DatagramSocket(8888);
		DatagramPacket inPacket, outPacket;		// 패킷송수신을 위한 객체변수
		
		byte[] inMsg = new byte[1];		// 패킷수신을 위한 바이트 배열 선언
		byte[] outMsg;					// 패킷송신을 위한 바이트 배열 선언
		
		while (true) {
			// 데이터를 수신하기 위한 패킷을 생성
			inPacket = new DatagramPacket(inMsg, inMsg.length);
			
			System.out.println("inPacket is ready.");
			
			// 패킷을 통해 데이터를 수신한다.
			socket.receive(inPacket);
			
			System.out.println("inPacket receive complete.");
			
			// 수신한 패킷으로부터 client의 IP주소와 Port를 얻는다.
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			
			// 서버의 현재 시간을 시분초 형태 ([hh:mm:ss])로 반환한다.
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());	// 서버의 현재시간
			outMsg = time.getBytes(); 	// 시간문자열을 byte배열로 변환
			
			// 패킷을 생성해서 client에게 전송한다.
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			socket.send(outPacket);
		}
	}
	
	
	public static void main(String[] args) {
		try {
			new T12_UdpSocketServer().start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
