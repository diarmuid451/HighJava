package kr.or.ddit.basic;

import javax.swing.*;

/*
 *  컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 *  
 *  컴퓨터의 가위 바위 보는 난수를 이용하여 구하고
 *  사용자의 가위 바위 보는 showInputDialog()메서드를 이용하여 입력받는다.
 *  
 *  입력시간은 5초로 제한하고 카운트다운을 진행한다.
 *  5초동안 입력이 없으면 진 것으로 처리한다.
 *  
 *  5초 안에 입력이 완료되면 승패를 출력한다.
 *  
 *  예시)
 *  	== 결과 ==
 *  	컴퓨터 : 가위
 *  	당  신 : 바위
 *  	결  과 : 당신이 이겼습니다.
 *  
 */
public class T07_ThreadGame {
public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		Thread th1 = new gameDataInput();
		Thread th2 = new gameCountDown();
		
		th1.start();
		th2.start();
	}
}
/**
 * 데이터 입력을 위한 메서드
 */
class gameDataInput extends Thread {
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("당신의 선택은?");
		
		//입력이 완료되면 inputCheck변수를 true로 변경한다.
		T07_ThreadGame.inputCheck = true;
		
		int user = 0;
		switch (str) {
		case "가위":
			user = 1;
			break;
		case "바위":
			user = 2;
			break;
		case "보":
			user = 3;
			break;

		}
		int num = (int)(Math.random()*3 +1);
		String com = null;
		switch (num) {
			case 1:
				com = "가위";
			break;
			case 2:
				com = "바위";
				break;
			case 3:
				com = "보";
				break;
		}
		System.out.println("== 결과 ==");
		System.out.println("컴퓨터 : "+ com);
		System.out.println("당  신 : "+ str);
		if((user - num) == 1 || (user - num) == -2) {
			System.out.println("당신이 이겼습니다.");
		} else if ((user - num) == -1 || (user - num) == 2) {
			System.out.println("당신이 졌습니다.");
		} else {
			System.out.println("비겼습니다.");
		}
		
		
	}
}

class gameCountDown extends Thread {
	
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			//입력이 완료되었는지 여부를 검사하고 입력이 완료되면 run()메서드를 종료시킨다. 즉 현재 쓰레드를 종료시킨다.
			if(T07_ThreadGame.inputCheck) {
				return;
			}
				
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//10초가 경과되었는데도 입력이 없으면 프로그램을 종료한다.
		System.out.println("5초가 지났습니다.\r\n당신의 패배입니다.");
		System.exit(0);
	}

	
	
	
}
