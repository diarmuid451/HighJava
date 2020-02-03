package exam.prodInfo.vo;

import java.util.*;

/**
 * @author PC-01
 * DB 테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스
 * <p>
 * 	DB테이블의 컬럼이 이 클래스의 멤버 변수가 된다.<br>
 *  DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다. <br>
 * </p> 
 */
public class ProdVO {
	private String prod_id;
	private String prod_name;
	private String prod_lgu;
	private String prod_buyer;
	private int prod_cost;
	private int prod_price;
	private int prod_sale;
	private String prod_outline;
	private String prod_detail;
	private String prod_img;
	private int prod_totoalstock;
	private Date prod_insdate; 
	private int prod_properstock;
	private String prod_size;
	private String prod_color;
	private String prod_delivery;
	private String prod_unit;
	private int prod_qtyin;
	private int prod_qtysale;
	private int prod_mileage;

	
	
	public ProdVO() {
		super();
	
	}



	public ProdVO(String prod_id, String prod_name, String prod_lgu, String prod_buyer, int prod_cost, int prod_price,
			int prod_sale, String prod_outline, String prod_detail, String prod_img, int prod_totoalstock,
			Date prod_insdate, int prod_properstock, String prod_size, String prod_color, String prod_delivery,
			String prod_unit, int prod_qtyin, int prod_qtysale, int prod_mileage) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_lgu = prod_lgu;
		this.prod_buyer = prod_buyer;
		this.prod_cost = prod_cost;
		this.prod_price = prod_price;
		this.prod_sale = prod_sale;
		this.prod_outline = prod_outline;
		this.prod_detail = prod_detail;
		this.prod_img = prod_img;
		this.prod_totoalstock = prod_totoalstock;
		this.prod_insdate = prod_insdate;
		this.prod_properstock = prod_properstock;
		this.prod_size = prod_size;
		this.prod_color = prod_color;
		this.prod_delivery = prod_delivery;
		this.prod_unit = prod_unit;
		this.prod_qtyin = prod_qtyin;
		this.prod_qtysale = prod_qtysale;
		this.prod_mileage = prod_mileage;
	}



	public String getProd_id() {
		return prod_id;
	}



	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}



	public String getProd_name() {
		return prod_name;
	}



	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}



	public String getProd_lgu() {
		return prod_lgu;
	}



	public void setProd_lgu(String prod_lgu) {
		this.prod_lgu = prod_lgu;
	}



	public String getProd_buyer() {
		return prod_buyer;
	}



	public void setProd_buyer(String prod_buyer) {
		this.prod_buyer = prod_buyer;
	}



	public int getProd_cost() {
		return prod_cost;
	}



	public void setProd_cost(int prod_cost) {
		this.prod_cost = prod_cost;
	}



	public int getProd_price() {
		return prod_price;
	}



	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}



	public int getProd_sale() {
		return prod_sale;
	}



	public void setProd_sale(int prod_sale) {
		this.prod_sale = prod_sale;
	}



	public String getProd_outline() {
		return prod_outline;
	}



	public void setProd_outline(String prod_outline) {
		this.prod_outline = prod_outline;
	}



	public String getProd_detail() {
		return prod_detail;
	}



	public void setProd_detail(String prod_detail) {
		this.prod_detail = prod_detail;
	}



	public String getProd_img() {
		return prod_img;
	}



	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}



	public int getProd_totoalstock() {
		return prod_totoalstock;
	}



	public void setProd_totoalstock(int prod_totoalstock) {
		this.prod_totoalstock = prod_totoalstock;
	}



	public Date getProd_insdate() {
		return prod_insdate;
	}



	public void setProd_insdate(Date prod_insdate) {
		this.prod_insdate = prod_insdate;
	}



	public int getProd_properstock() {
		return prod_properstock;
	}



	public void setProd_properstock(int prod_properstock) {
		this.prod_properstock = prod_properstock;
	}



	public String getProd_size() {
		return prod_size;
	}



	public void setProd_size(String prod_size) {
		this.prod_size = prod_size;
	}



	public String getProd_color() {
		return prod_color;
	}



	public void setProd_color(String prod_color) {
		this.prod_color = prod_color;
	}



	public String getProd_delivery() {
		return prod_delivery;
	}



	public void setProd_delivery(String prod_delivery) {
		this.prod_delivery = prod_delivery;
	}



	public String getProd_unit() {
		return prod_unit;
	}



	public void setProd_unit(String prod_unit) {
		this.prod_unit = prod_unit;
	}



	public int getProd_qtyin() {
		return prod_qtyin;
	}



	public void setProd_qtyin(int prod_qtyin) {
		this.prod_qtyin = prod_qtyin;
	}



	public int getProd_qtysale() {
		return prod_qtysale;
	}



	public void setProd_qtysale(int prod_qtysale) {
		this.prod_qtysale = prod_qtysale;
	}



	public int getProd_mileage() {
		return prod_mileage;
	}



	public void setProd_mileage(int prod_mileage) {
		this.prod_mileage = prod_mileage;
	}
	
	
	
}