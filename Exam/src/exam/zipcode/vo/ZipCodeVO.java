package exam.zipcode.vo;

/**
 * @author PC-01
 * DB 테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스
 * <p>
 * 	DB테이블의 컬럼이 이 클래스의 멤버 변수가 된다.<br>
 *  DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다. <br>
 * </p> 
 */
public class ZipCodeVO {
	private String zipcode;
	private String sido;
	private String gugun;
	private String dong;
	private String ri;
	private String bldg;
	private String bunji;
	private int seq;
	
	
	public ZipCodeVO() {
		super();
	}


	public ZipCodeVO(String zipcode, String sido, String gugun, String dong, String ri, String bldg, String bunji,
			int seq) {
		super();
		this.zipcode = zipcode;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.ri = ri;
		this.bldg = bldg;
		this.bunji = bunji;
		this.seq = seq;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getSido() {
		return sido;
	}


	public void setSido(String sido) {
		this.sido = sido;
	}


	public String getGugun() {
		return gugun;
	}


	public void setGugun(String gugun) {
		this.gugun = gugun;
	}


	public String getDong() {
		return dong;
	}


	public void setDong(String dong) {
		this.dong = dong;
	}


	public String getRi() {
		return ri;
	}


	public void setRi(String ri) {
		this.ri = ri;
	}


	public String getBldg() {
		return bldg;
	}


	public void setBldg(String bldg) {
		this.bldg = bldg;
	}


	public String getBunji() {
		return bunji;
	}


	public void setBunji(String bunji) {
		this.bunji = bunji;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	
	
}
