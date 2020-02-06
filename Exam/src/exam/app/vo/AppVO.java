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
	private int Kor;
	private int Math;
	private int Eng;
	
	
	public AppVO() {
		super();
	}


	public AppVO(String name, int kor, int math, int eng) {
		super();
		this.name = name;
		this.Kor = kor;
		this.Math = math;
		this.Eng = eng;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return Kor;
	}


	public void setKor(int kor) {
		Kor = kor;
	}


	public int getMath() {
		return Math;
	}


	public void setMath(int math) {
		Math = math;
	}


	public int getEng() {
		return Eng;
	}


	public void setEng(int eng) {
		Eng = eng;
	}
	
	
	
	
}
