package exam.app.vo;

/**
 * @author PC-01
 * DB 테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스
 * <p>
 * 	DB테이블의 컬럼이 이 클래스의 멤버 변수가 된다.<br>
 *  DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다. <br>
 * </p> 
 */
public class AppVO {
	private String name;
	private int Korean;
	private int Math;
	private int English;
	
	
	public AppVO() {
		super();
	}


	public AppVO(String name, int korean, int math, int english) {
		super();
		this.name = name;
		Korean = korean;
		Math = math;
		English = english;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKorean() {
		return Korean;
	}


	public void setKorean(int korean) {
		Korean = korean;
	}


	public int getMath() {
		return Math;
	}


	public void setMath(int math) {
		Math = math;
	}


	public int getEnglish() {
		return English;
	}


	public void setEnglish(int english) {
		English = english;
	}
	
	
}
