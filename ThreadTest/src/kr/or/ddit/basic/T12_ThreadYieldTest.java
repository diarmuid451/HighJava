package kr.or.ddit.basic;

public class T12_ThreadYieldTest {
	public static void main(String[] args) {
		ThreadYield th1 = new ThreadYield("1번쓰레드");
		ThreadYield th2 = new ThreadYield("2번쓰레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		
		th1.work = false; //양보 시작
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		th1.work = true; //양보 끝
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//반복문 멈춤
		th1.stop = true;
		th2.stop = true;
	}

}

/**
 * yield()메서드 연습용 쓰레드
 * @author PC-01
 *
 */
class ThreadYield extends Thread {
	public boolean stop = false;
	public boolean work = true;
	
	public ThreadYield(String name) {
		//쓰르드에는 기본적으로 name속성이 있고, Threrad생성자 중에서는 
		//name값을 매개변수로 받아서 설정하는 생성자가 있다.
		super(name); //쓰레드의 이름 설정
	}
	
	@Override
	public void run() {
		while(!stop) { // stop변수값이 true이면 반복을 멈춘다.
			if(work) {
				//작업하는 영역
				//getName() >> 현재쓰레드의 name값 변환
				System.out.println(getName()+ "작업 중");
			} else {
				System.out.println(getName()+ "작업 양보");
				Thread.yield();
			}
		}
		System.out.println(getName() + "작업 끝");
	}
}