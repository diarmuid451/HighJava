package kr.or.ddit.basic;

import java.net.*;
import java.util.*;

import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.util.*;

public class PagingController implements Initializable{

	@FXML TableView<MemberVO> tableView;
	@FXML TableColumn<MemberVO, String> id;
	@FXML TableColumn<MemberVO, String> name;
	@FXML TableColumn<MemberVO, String> addr;
	@FXML Pagination pagi;

	
	private int from, to, itemForPage;
	
	private ObservableList<MemberVO> allTableData, currentPageData;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		addr.setCellValueFactory(new PropertyValueFactory<>("addr"));
		
		//전체 테이블 데이터 설정
		allTableData = FXCollections.observableArrayList();
		
		allTableData.add(new MemberVO("1", "홍길동1", "대전시 중구 대흥동 대덕인재개발원"));
		allTableData.add(new MemberVO("2", "홍길동2", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("3", "홍길동3", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("4", "홍길동4", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("5", "홍길동5", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("6", "홍길동6", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("7", "홍길동7", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("8", "홍길동8", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("9", "홍길동9", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("10", "홍길동10", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("11", "홍길동11", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("12", "홍길동12", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("13", "홍길동13", "대전시 중구 대흥동 대적인재개발원"));
		allTableData.add(new MemberVO("14", "홍길동14", "대전시 중구 대흥동 대적인재개발원"));
		
		itemForPage = 7; 	//한페이지에 보여줄 항목 수 설정
		int totPageCount = allTableData.size()%itemForPage == 0 ? allTableData.size()/itemForPage : allTableData.size()/itemForPage + 1;
		
		pagi.setPageCount(totPageCount); 	//전체 페이지 수 설정
		
		pagi.setPageFactory(new Callback<Integer, Node>() {

			@Override
			public Node call(Integer param) {
				from = param* itemForPage;
				to = from + itemForPage -1;
				tableView.setItems(getTableView(from, to));
				
				return tableView;
			}

		});
	}
	protected ObservableList<MemberVO> getTableView(int from, int to) {
		// 현제 페이지의 데이터 초기화
		currentPageData = FXCollections.observableArrayList();
		
		int totSize = allTableData.size();
		
		for (int i = from; i <= to && i < totSize; i++) {
			currentPageData.add(allTableData.get(i));
		}
		
		return currentPageData;
	}
	
}