package kr.or.ddit.basic;

public class T02_LambdaTest {
	public static void main(String[] args) {
	/*	//람다식을 사용하지 않을 경우
		LambdaTestInterface1 lam1 = new LambdaTestInterface1() {
			
			@Override
			public void test() {
				System.out.println("안녕하세요");
				System.out.println("익명 구현 객체 방식입니다.");
			}
		}; */
		
		LambdaTestInterface1 lam2 = () -> {
			System.out.println("반가워요\r\n람다식으로 처리하는 방식입니다.");
		};
		lam2.test();	//메서드 호출
		
		//=====================================
	
/*
 * 		람다식의 작성 방법
 * 
 *	기본 형식) (자료형이름 매개변수명, ...) -> {실행문들;...}
 * 
 *	1) 매개변수의 자료형이름은 생략할 수 있다.
 *	예) (int a) -> {System.out.println(a);}
 *	= (a) -> {System.out.println(a);}
 * 		
 * 	2) 매개변수가 1개일 경우에는 괄호()를 생략할 수 있다. 단, 자료형이름을 지정할 경우에는 괄호 생략 불가
 * 	예) a -> {System.out.println(a);}
 * 
 * 	3) 실행문이 1개일 경우에는 중괄호{} 생략할 수 있다. 이때 문장의 끝을 나타내는 세미콜론;도 생략한다.
 * 	예) a -> System.out.println(a)
 * 
 * 	4) 매개변수가 하나도 없으면 괄호() 생략 불가
 * 	예) () -> System.out.println("안녕")
 * 
 * 	5) 변환값이 있을 경우에는 return 명령을 사용한다.
 * 	예) (a, b) -> {return a+b;}
 * 
 * 	6) 실행문에 return문만 있을 경우 return명령과 {}를 생략할 수 있다.
 *	예) (a, b) -> a+b
 */
	
		LambdaTestInterface2 lam3 = 
		(int z) -> {
			int result = z+ 100;
			System.out.println("result = "+ result);
		};
		lam3.test(30);
		
		LambdaTestInterface2 lam4 = 
		
		z -> {
			int result = z + 300;
			System.out.println("result = "+ result);
		};
		
		lam4.test(60);
		
		LambdaTestInterface2 lam5 =
		
		z -> System.out.println("result = "+ (z+500));
		lam5.test(50);
		
	}
}
