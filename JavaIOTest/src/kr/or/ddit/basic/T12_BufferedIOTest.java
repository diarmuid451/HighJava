package kr.or.ddit.basic;

import java.io.*;

/**
 * 문자기반 Buffered스트림 예제
 *
 */
public class T12_BufferedIOTest {

	public static void main(String[] args) {
		// 문자기반 Buffered스트림 사용 예제
		try {
			//이클립스에서 만든 자바프로그램이 실행되는 기본 위치는 해당 프로젝트 폴더이다.
			FileReader fr = new FileReader("./src/kr/or/ddit/basic/T11_BufferIOTest.java");
			
			int c;
			while ((c= fr.read()) != -1) {
				System.out.print((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
