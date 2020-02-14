package kr.or.ddit.watson.tts;

import java.io.*;
import java.util.*;

import com.ibm.watson.developer_cloud.service.security.*;
import com.ibm.watson.developer_cloud.text_to_speech.v1.*;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.*;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.*;

/**
 * IBM Text to Speech 서비스는 IBM의 음성합성기능을 사용하여
 * 다양한 언어, 방언 및 음성으로 텍스트를 자연스러운 발음으로
 * 합성하는 API를 제공한다.
 * 이 서비스는 각 언어에 대해 남성 또는 여성, 때로는 둘다를 
 * 지원한다.
 * @author HelloJava
 *
 */
public class TestTextToSpeech {
	
	private static final String API_KEY = "JcXKmwQn98Kv7QZu1--8FZbo91vaPz9XltyqZrJtUyQ2";
	private static final String URL = "https://api.us-south.text-to-speech.watson.cloud.ibm.com/instances/dff17491-492d-4b07-9656-c41633012886";

	private TextToSpeech  service; // TextToSpeech 서비스
	
	/**
	 * 서비스 설정
	 */
	private void setService() {
		
		IamOptions options = new IamOptions.Builder()
			    .apiKey(API_KEY)
			    .build();

		service = new TextToSpeech(options);

		service.setEndPoint(URL);

	}
	
	
	/**
	 * 서비스 헤더 설정
	 * - watson은 기본적으로 서비스 사용에 대한 로그를 남겨
	 *   서비스를 개선하는데 사용하고 있다.
	 *   만약 watson에서 서비스의 내용을 바꾸길 원하지 않는다면
	 *   헤더에 내용을 명시해 주어야 한다.
	 */
	private void setHeader() {
		Map<String, String> headers = new HashMap<String, String>();
		// true는 허용, false는 불허
		headers.put("X-Watson-Learning-Opt-Out", "false");
		service.setDefaultHeaders(headers);
		
	}

	/**
	 * 음성 타입 검색
	 */
	private void getVoice() {
		
		Voices voices = service.listVoices().execute();
		
		System.out.println(voices);
	}
	
	
	/**
	 * 서비스 실행
	 */
	private void executeService() {
		String text = "Welcom to Java world! My name is Simpson. Nice to meet you. Have a nice day.";
		
		SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
		  .text(text)
		  .accept(SynthesizeOptions.Accept.AUDIO_WAV)
		  .build();
		
		InputStream stream = 
				service.synthesize(synthesizeOptions).execute();
		
		// 음성데이터를 재생
		try {

			InputStream in = WaveUtils.reWriteWaveHeader(stream);
			// File file = new File(URLDecoder.decode(getClass().getResource("").getPath())+"/hello_world.wav");
			File file = new File("E:/hello_world.wav");
			OutputStream os = new FileOutputStream(file);
			byte[] tmp = new byte[1024];
			int length;
			while ((length = in.read(tmp)) != -1) {
				os.write(tmp, 0, length);
			}
			os.close();
			in.close();
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestTextToSpeech textToSpeech = new TestTextToSpeech();
		textToSpeech.setService();
		textToSpeech.setHeader();
		//textToSpeech.getVoice();
		textToSpeech.executeService();
	}
}
