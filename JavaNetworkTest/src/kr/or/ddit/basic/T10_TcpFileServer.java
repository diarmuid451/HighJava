package kr.or.ddit.basic;

import java.io.*;
import java.net.*;

public class T10_TcpFileServer {
	// 서버는 클라이언트가 접속하면 서버 컴퓨터는 E드라이브의 D_Other폴더에 있는 Tulips.jpg파일을 클라이언트로 전송한다.
	private ServerSocket server;
	private Socket socket;
	private OutputStream out;
	private FileInputStream fis;
	
	public void serverStart() {
		File file = new File("E:/D_Other/Tulips.jpg");
		try {
			server = new ServerSocket(7777);
			System.out.println("Server Ready");
			
			socket = server.accept();
			
			System.out.println("File Uploading...");
			
			fis = new FileInputStream(file);
			out = socket.getOutputStream();
			
			// 한꺼번에 읽어와 전송할 데이터 저장변수 선언
			byte[] temp = new byte[1024];
			int length = 0;
			while ((length = fis.read(temp)) != -1 ) {
				out.write(temp, 0, length);
			}
			
			out.flush();
			System.out.println("Uploading Complete");
			
		} catch (IOException e) {
			
		} finally {
			if(fis != null) {
				try { fis.close();} catch (IOException e) {}
			}
			if(out != null) {
				try { out.close();} catch (IOException e) {}
			}
			if(socket != null) {
				try { socket.close();} catch (IOException e) {}
			}
			if(server != null) {
				try { server.close();} catch (IOException e) {}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		new T10_TcpFileServer().serverStart();
	}

}
