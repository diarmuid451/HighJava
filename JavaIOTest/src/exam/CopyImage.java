package exam;

import java.io.*;

public class CopyImage {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		fis = new FileInputStream("E:/D_Other/Tulips.jpg");
		fos = new FileOutputStream("E:/D_Other/복사본_Tulips.jpg");
		
		int c;
		
		while ((c = fis.read()) != -1) {
			fos.write(c);
		}
		
		fis.close();
		fos.close();

	}
}
