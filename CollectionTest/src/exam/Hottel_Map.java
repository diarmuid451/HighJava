package exam;

import java.util.*;

public class Hottel_Map {

/*
문제)

호텔 운영을 관리하는 프로그램 작성.(Map이용)
 - 키값은 방번호 
 
실행 예시)

**************************
호텔 문을 열었습니다.
**************************

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 101 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 홍길동 <-- 입력
체크인 되었습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 102 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 성춘향 <-- 입력
체크인 되었습니다

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 3 <-- 입력

방번호 : 102, 투숙객 : 성춘향
방번호 : 101, 투숙객 : 홍길동

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 2 <-- 입력

어느방을 체크아웃 하시겠습니까?
방번호 입력 => 101 <-- 입력
체크아웃 되었습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 1 <-- 입력

어느방에 체크인 하시겠습니까?
방번호 입력 => 102 <-- 입력

누구를 체크인 하시겠습니까?
이름 입력 => 허준 <-- 입력
102방에는 이미 사람이 있습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 2 <-- 입력

어느방을 체크아웃 하시겠습니까?
방번호 입력 => 101 <-- 입력
101방에는 체크인한 사람이 없습니다.

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 3 <-- 입력

방번호 : 102, 투숙객 : 성춘향

*******************************************
어떤 업무를 하시겠습니까?
1.체크인  2.체크아웃 3.객실상태 4.업무종료
*******************************************
메뉴선택 => 4 <-- 입력

**************************
호텔 문을 닫았습니다.
**************************

*/
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Map<String, Hotel> map = new HashMap<>(); //호텔 객실 예약 정보 수집용
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************");
		
		int input = 0;
		while(true) { //업무 수행
			System.out.println("\r\n*******************************************");
			System.out.println("어떤 업무를 하시겠습니까? \r\n"
					+ "1.체크인  2.체크아웃  3.객실상태  4.업무종료");
			System.out.println("*******************************************");
			System.out.print("메뉴입력 => ");
			input = Integer.parseInt(scan.nextLine());
			switch (input) {
			case 1:
				System.out.println();
				add(map);
				break;
			case 2:
				System.out.println();
				del(map);
				break;
			case 3:
				System.out.println();
				list(map);
				break;
			case 4:
				System.out.println();
				System.out.println("**************************\r\n" +  
						"호텔 문을 닫았습니다.\r\n" + 
						"**************************");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}
	private static void list(Map<String, Hotel> map) { //예약 확인 메서드
		if (map.size() == 0) {
			System.out.println("현재 투숙객이 존재하지 않습니다.\r\n");
			return;
		}
		for (String s : map.keySet()) {
			System.out.println("방번호 : "+ s + ", 투숙객 : "+ map.get(s).getName());
		}
	}
	private static void del(Map<String, Hotel> map) { //체크아웃을 수행하는 메서드
		
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String room = scan.nextLine();
		if (map.get(room) == null) {
			System.out.println(room + "방에는 체크인한 사람이 없습니다.\r\n");
			return;
		}
		map.remove(room);
		System.out.println("체크아웃 되었습니다.");
	}
	private static void add(Map<String, Hotel> map) { //체크인을 수행하는 메서드
		String room;
		String name;
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		room = scan.nextLine();

		System.out.println();
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		name = scan.nextLine();
		
		if (map.get(room) != null) {
			System.out.println(room + "방에는 이미 사람이 있습니다.");
			return;
		}
		System.out.println("체크인 되었습니다.");		
		Hotel hotel = new Hotel(room, name);
		map.put(room, hotel);
	}
}


class Hotel{
	private String room; // 방번호
	private String name; // 이름
	
	public Hotel(String room, String name) {
		super();
		this.room = room;
		this.name = name;
	}
	
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

