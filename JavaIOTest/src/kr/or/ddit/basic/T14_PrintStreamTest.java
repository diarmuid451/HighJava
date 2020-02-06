package kr.or.ddit.basic;

import java.io.*;

public class T14_PrintStreamTest {

	public static void main(String[] args) throws IOException {
		FileOutputStream fout = new FileOutputStream("E:/D_Other/print.txt");
		FileOutputStream fout2 = new FileOutputStream("E:/D_Other/print_1.txt");
		
		PrintStream out = new PrintStream(fout);
		out.print("안녕하세요. PrintStream 입니다.\n");
		out.println("안녕하세요. PrintStream 입니다.2");
		out.println("안녕하세요. PrintStream 입니다.3");
		
		out.close();
		
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(fout2, "UTF-8"));
		writer.print("안녕하세요. Printwriter 입니다. \r\n");
		writer.println("안녕하세요. Printwriter 입니다. 2");
		writer.println("안녕하세요. Printwriter 입니다. 3");
		
		writer.close();
	}

}
