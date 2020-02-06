package kr.or.ddit.basic;

import java.io.*;

public class T11_BufferedIOTest {

	public static void main(String[] args) {
		//입출력의 성능 향상을 위해서 버퍼를 이용하는 보조 스트림
		FileOutputStream fout = null;
		BufferedOutputStream bout = null;
		
		try {
			fout = new FileOutputStream("E:/D_Other/bufferTest.txt");
			
			//버퍼의 크기를 지정하지 않으면 기본적으로 버퍼의 크기가 8kb(8192byte)로 설정된다.
			
			//버퍼의 크기가 5인 스트림 생성
			bout = new BufferedOutputStream(fout, 5);
			for (int i = '1'; i <= '9'; i++) {  //숫자자체를 문자로 저장함
				bout.write(i);
			}
			
			bout.flush(); 	//작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력시킨다.(close호출 시 자동으로 호출)
			
			bout.close();
			System.out.println("임무 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
