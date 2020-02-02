package exam.prodInfo.vo;

/**
 * @author PC-01
 * DB 테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스
 * <p>
 * 	DB테이블의 컬럼이 이 클래스의 멤버 변수가 된다.<br>
 *  DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다. <br>
 * </p> 
 */
public class ProdVO {
	private String mem_id; //아이디
	private String mem_name; //이름
	private String mem_tel; //전화번호
	private String mem_addr; //주소
	
	
	
	public ProdVO() {
		super();
		
	}



	public ProdVO(String mem_id, String mem_name, String mem_tel, String mem_addr) {
		super();
		this.mem_id = mem_id;
		this.mem_name = mem_name;
		this.mem_tel = mem_tel;
		this.mem_addr = mem_addr;
	}

	
	
	public String getMem_id() {
		return mem_id;
	}



	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}



	public String getMem_name() {
		return mem_name;
	}



	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}



	public String getMem_tel() {
		return mem_tel;
	}



	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}



	public String getMem_addr() {
		return mem_addr;
	}



	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}



	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_name=" + mem_name + ", mem_tel=" + mem_tel + ", mem_addr="
				+ mem_addr + "]";
	}
		
	
}
