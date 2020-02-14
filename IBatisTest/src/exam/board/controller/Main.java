package exam.board.controller;


import java.util.*;

import exam.board.VO.*;
import exam.board.service.*;


public class Main {
	private boardService boardS;
	
	public Main() {
		boardS = boardServiceImpl.getInstance();
	}
	
	private Scanner scan = new Scanner(System.in);
	
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 검색 자료 출력");
		System.out.println("  5. 전체 자료 출력");
		System.out.println("  6. 작업 끝.");
		System.out.println("------------------------------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 * 
	 */
	public void start() {
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 자료 입력
					insertBoard();
					break;
				case 2 :  // 자료 삭제
					deleteBoard();
					break;
				case 3 :  // 자료 수정
					updateBoard();
					break;
				case 4 :  // 검색 자료 출력
					searchBoard();
					break;
				case 5 :  // 전체 자료 출력
					getAllBoard();
					break;
				case 6 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					System.exit(0);
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=6);
	}
	
	
	
	
	private void getAllBoard() {
		System.out.println("\r\n------------------------------------------");
		System.out.println("번호\t제목\t작성자\t작성날짜\t\t\t\t"+"내용");
		
		List<boardVO> bList = boardS.getAllBoard();
		
		if(bList.size() == 0) {
			System.out.println("출력할 게시글이 없습니다.");
		}else {
			for(boardVO bvo : bList) {
				
				System.out.println(bvo.getBoard_no()+"\t"
						+ bvo.getBoard_title() +"\t"
						+ bvo.getBoard_writer() +"\t"
						+ bvo.getBoard_date() +"\t"
						+ bvo.getBoard_content());
			}
		}
		System.out.println("------------------------------------------\r\n");
		
		
	}

	private void searchBoard() {
		scan.nextLine();
		System.out.println();
		System.out.println("검색할 게시글 내용을 입력하세요.");
		System.out.print("게시글 제목 >> ");
		String board_title = scan.nextLine().trim();
		
		System.out.print("게시글 작성자 >> ");
		String board_writer = scan.nextLine().trim();
		
		System.out.print("게시글 내용 >> ");
		String board_content = scan.nextLine().trim();
		
		boardVO bvo = new boardVO();
		bvo.setBoard_title(board_title);
		bvo.setBoard_writer(board_writer);
		bvo.setBoard_content(board_content);
		
		System.out.println("\r\n------------------------------------------");
		System.out.println("번호\t제목\t작성자\t작성날짜\t"+"\t내용");
		
		List<boardVO> bList = boardS.searchBoard(bvo);
		if(bList.size() == 0) {
			System.out.println("게시글이 없습니다.");
		} else {
			for (boardVO boardVO : bList) {
				
				System.out.println(boardVO.getBoard_no() +"\t" + boardVO.getBoard_title() + "\t"+ 
							boardVO.getBoard_writer()  + "\t"+ boardVO.getBoard_date()  + "\t"+ 
							boardVO.getBoard_content());
				
			}
		}
		System.out.println("------------------------------------------\r\n");
		
	}

	private void updateBoard() {
		System.out.println();
		int no = 0;
		boolean chk = true;
		
		do {
			System.out.print("수정할 게시글 번호를 입력하세요 >>");
			no = scan.nextInt();
			
			chk = getNo(no);
			
			if(chk == false) {
				System.out.println(no + "번 게시글은 없는 게시글입니다.");
				System.out.println("다시 입력하세요.");
			}
			
			
		}while(chk == false);
		
		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 제목 >> ");
		String title = scan.next();
		
		System.out.print("새로운 작성자 >> ");
		String writer = scan.next();
		
		scan.nextLine(); // 버퍼 비우기
		System.out.print("새로운 내용 >> ");
		String content = scan.nextLine();
		
		boardVO bvo = new boardVO();
		bvo.setBoard_no(no);
		bvo.setBoard_title(title);
		bvo.setBoard_writer(writer);
		bvo.setBoard_content(content);
		
		int cnt = boardS.updateBoard(bvo);
		
		if(cnt > 0) {
			System.out.println(no + "번 게시글 수정 완료...");
		}else {
			System.out.println(no + "번 게시글 수정 실패!!!");
		}
	}

	private void deleteBoard() {
		System.out.println("\r\n삭제할 게시글 번호를 입력하세요. >> ");
		int no = scan.nextInt();
		
		int cnt = boardS.deleteBoard(no);
		
		if(cnt > 0) {
			System.out.println(no + "번 게시글 삭제성공");
		} else {
			System.out.println(no + "번 게시글 삭제실패");
		}
		
	}

	private void insertBoard() {
		System.out.print("게시글 제목 >> ");
		String title = scan.next();
		
		System.out.println("작성자 >> ");
		String writer = scan.next();
		
		scan.nextLine(); //버퍼 비우기
		System.out.print("내용 >> ");
		String content = scan.nextLine();
		
		boardVO bvo = new boardVO();
		bvo.setBoard_title(title);
		bvo.setBoard_writer(writer);
		bvo.setBoard_content(content);
		
		int cnt = boardS.insertBoard(bvo);
		
		if(cnt > 0) {
			System.out.println("게시글 등록 완료");
		} else {
			System.out.println("게시글 등록 실패");
		}
		
	}
	
private boolean getNo(int boardNo) {
		
		boolean chk = false;
		
		chk = boardS.getBoardNo(boardNo);
		
		return chk;
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
}






