package kr.or.ddit.basic;

import java.io.*;
import java.net.*;

public class T11_TcpFileClient {
	
	// 클라이언트는 서버에 접속하여 서버가 보내주는 파일을 E드라이브의 C_Lib 폴더에 저장한다.
	private Socket socket;
	private InputStream is;
	private FileOutputStream fos;
	
	public void clientStart() {
		File file = new File("E:/C_Lib/Tulips빵빵.jpg");
		
		try {
			socket = new Socket("localhost", 7777);
			System.out.println("File downloading...");
			
			fos = new FileOutputStream(file);
			is = socket.getInputStream();
			
			byte[] temp = new byte[1024];
			int length = 0;
			while ((length = is.read(temp)) != -1) {
				fos.write(temp, 0, length);
			}
			fos.flush();
			System.out.println("download Complete");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is != null) {
				try {is.close();} catch (IOException e2) {}
			}
			if(fos != null) {
				try {fos.close();} catch (IOException e2) {}
			}
			if(socket != null) {
				try {socket.close();} catch (IOException e2) {}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new T11_TcpFileClient().clientStart();
	}

}
