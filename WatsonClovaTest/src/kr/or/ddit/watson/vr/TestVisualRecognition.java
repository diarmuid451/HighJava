package kr.or.ddit.watson.vr;

import java.io.*;

import com.ibm.watson.developer_cloud.service.security.*;
import com.ibm.watson.developer_cloud.visual_recognition.v3.*;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.*;

public class TestVisualRecognition {
	
	public void test(){
		
	   IamOptions options = new IamOptions.Builder().apiKey("J_hd-fTMEYPButS7QyMj9KWgA9ky_CehoBoWTmWQ2MLE").build();
	   
	   VisualRecognition service = new VisualRecognition("2018-03-19", options);
	   
	   InputStream imagesStream;
	   
	   try {
		   
		   //imagesStream = new FileInputStream("src/basic/watson/actrees.jpg");
		   //imagesStream = new FileInputStream("src/kr/or/ddit/watson/visualRecognition/test.jpg");
		   imagesStream = new FileInputStream(new File(getClass().getResource("IfYYwHpn97VH-IaJUKASX8iVLqM8.png").getPath()));
		   
		   ClassifyOptions classifyOptions
		   	= new ClassifyOptions
		   	.Builder()
		   	.imagesFile(imagesStream)
		   	.imagesFilename("IfYYwHpn97VH-IaJUKASX8iVLqM8.png")
		   	.build();
		   
		   ClassifiedImages result = service.classify(classifyOptions).execute();
		   System.out.println(result);
		   
	   }catch(FileNotFoundException e) {
		   e.printStackTrace();
	   }
	   
	}
	
	public static void main(String[] args) {
		TestVisualRecognition obj = new TestVisualRecognition();
		obj.test();
	}
}
