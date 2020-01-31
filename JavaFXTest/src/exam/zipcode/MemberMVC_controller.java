package exam.zipcode;

import java.net.*;
import java.util.*;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.control.cell.*;
import kr.or.ddit.member.service.*;
import kr.or.ddit.member.vo.*;

public class MemberMVC_controller implements Initializable {
	
	@FXML TextField id;
	@FXML TextField name;
	@FXML TextField tel;
	@FXML TextField addr;
	@FXML
	Button btnAdd;
	@FXML
	 Button btnUpd;
	@FXML
	 Button btnDel;
	@FXML
	 Button btnConf;
	@FXML
	 Button btnCan;
	@FXML TableColumn<MemberVO, String> mem_id;
	@FXML TableColumn<MemberVO,String> mem_name;
	@FXML TableColumn<MemberVO, String> mem_tel;
	@FXML TableColumn<MemberVO, String> mem_addr;
	@FXML TableView<MemberVO> table;
	
	private int check;
	ObservableList<MemberVO> data;
	
	private IMemberService memberService;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mem_id.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		mem_name.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
		mem_tel.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
		mem_addr.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));

		memberService = MemberServiceImpl.getInstance();
	
		//data.add(new MemberVO("1", "홍길동","1111-2222","대전"));
		data =FXCollections.observableArrayList(memberService.getAllMemberList());
		
		table.setItems(data);
		
		//테이블의 값 선택시 텍스트 필드에 값이 나타나게 하는 메소드
		table.setOnMouseClicked(e->{
			if(table.getSelectionModel().isEmpty()) {
				return;
			}
			//tabelView에서 선택한 줄의 데이터를 가져온다
			MemberVO mem = table.getSelectionModel().getSelectedItem();
			
			id.setText(mem.getMem_id());
			name.setText(mem.getMem_name());
			tel.setText(mem.getMem_tel());
			addr.setText(mem.getMem_addr());
		});
	}

	//추가
	@FXML public void btnAddClick(ActionEvent event) {
		
		
		//버튼 세개 비활성화
		btnAdd.setDisable(true);
		btnDel.setDisable(true);
		btnUpd.setDisable(true);
		
		//버튼 두개 활성화
		btnConf.setDisable(false);
		btnCan.setDisable(false);
		
		//텍스트필드 모두 비활성화
		id.setEditable(false);
		name.setEditable(false);
		tel.setEditable(false);
		addr.setEditable(false);
		
		//전역변수 값을 1로 바꾼다
		check = 1;
	}

	//수정
	@FXML public void btnUpdClick(ActionEvent event) {
		//버튼 세개 비활성화
		btnAdd.setDisable(true);
		btnDel.setDisable(true);
		btnUpd.setDisable(true);
		
		//버튼 두개 활성화
		btnConf.setDisable(false);
		btnCan.setDisable(false);
		
		//텍스트필드 모두 비활성화
		id.setEditable(false);
		name.setEditable(false);
		tel.setEditable(false);
		addr.setEditable(false);
		
		//전역변수 값을 2로 바꾼다
		check = 2;
	}

	//삭제
	@FXML public void btnDelClick(ActionEvent event) {
		//버튼 세개 비활성화
		btnAdd.setDisable(true);
		btnDel.setDisable(true);
		btnUpd.setDisable(true);
		
		//버튼 두개 활성화
		btnConf.setDisable(false);
		btnCan.setDisable(false);
		
		
		//텍스트필드 모두 비활성화
		id.setEditable(false);
		name.setEditable(false);
		tel.setEditable(false);
		addr.setEditable(false);
		
		//전역변수 값을 3으로 바꾼다
		check = 3;
	}

	//확인
	@FXML public void btnConfClick(ActionEvent event) {
		//전역변수가 1일때, 텍스트 필드에 있는 값 테이블에 추가
		if(check == 1) {
			
			if(id.getText().isEmpty() || name.getText().isEmpty() || tel.getText().isEmpty() || addr.getText().isEmpty()) {
				
				errMsg("작업오류", "빈 항목이 있습니다");
				return;
			}
			
			//data.add(new MemberVO(id.getText(), name.getText(), tel.getText(), addr.getText()));
			memberService.insertMember(new MemberVO(id.getText(), name.getText(), tel.getText(), addr.getText()));
			
			data =FXCollections.observableArrayList(memberService.getAllMemberList());
			
			table.setItems(data);
			
			infoMsg("작업 결과", "정보 추가가 완료되었습니다");
			//텍스트 필드에 값이 있을 때 자동으로 삭제
			id.clear();
			name.clear();
			tel.clear();
			addr.clear();
			
		}
		
		//전역변수가 2일때, 텍스트 필드에 있는 값의 인덱스 찾아서 데이터 수정
		if(check == 2) {
			
			if(id.getText().isEmpty() || name.getText().isEmpty() || tel.getText().isEmpty() || addr.getText().isEmpty()) {
				
				errMsg("작업오류", "빈 항목이 있습니다");
				return;
			}
			
			memberService.updateMember(new MemberVO(id.getText(), name.getText(), tel.getText(), addr.getText()));
			
			data =FXCollections.observableArrayList(memberService.getAllMemberList());
			
			table.setItems(data);
			
			infoMsg("작업 결과", "정보 수정이 완료되었습니다");
			id.clear();
			name.clear();
			tel.clear();
			addr.clear();
		}
		
		//전역변수가 3일때, 텍스트 필드에 있는 값의 인덱스 찾아서 데이터 삭제
		if(check == 3) {
			
			if(table.getSelectionModel().isEmpty()){
				errMsg("작업오류","삭제할 자료를 선택한 후 삭제하세요");
				return;
			}
			memberService.deleteMember(id.getText());
			
			data =FXCollections.observableArrayList(memberService.getAllMemberList());
			
			table.setItems(data);
		
			infoMsg("작업 결과", name.getText()+"님 정보가 삭제되었습니다");
			id.clear();
			name.clear();
			tel.clear();
			addr.clear();
		}
		
		//텍스트필드 비활성화 및 기타 버튼 설정
		btnConf.setDisable(true);
		btnCan.setDisable(true);
		btnAdd.setDisable(false);
		btnDel.setDisable(false);
		btnUpd.setDisable(false);
		
		id.setEditable(true);
		name.setEditable(true);
		tel.setEditable(true);
		addr.setEditable(true);
				
		//마지막으로 전역변수 초기화
		check = 0;
	}

	//취소
	@FXML public void btnCanClick(ActionEvent event) {
		
		//텍스트 필드에 있는 값 모두 삭제
		id.clear();
		name.clear();
		tel.clear();
		addr.clear();
		
		//버튼 세개 활성화
		btnAdd.setDisable(false);
		btnDel.setDisable(false);
		btnUpd.setDisable(false);
		
		//버튼 두개 비활성화
		btnConf.setDisable(true);
		btnCan.setDisable(true);
		
		//텍스트 필드 비활성화
		id.setEditable(true);
		name.setEditable(true);
		tel.setEditable(true);
		addr.setEditable(true);
		
		//전역변수 초기화
		check = 0;
	}
	
	//오류 알림 메소드
	public void errMsg(String headerText, String msg) {
		Alert errAlert = new Alert(AlertType.ERROR);
		errAlert.setTitle("오류");
		errAlert.setHeaderText(headerText);
		errAlert.setContentText(msg);
		errAlert.showAndWait();
	}
	
	//정보 알림 메소드
	public void infoMsg(String headerText, String msg) {
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("알림");
		infoAlert.setHeaderText(headerText);
		infoAlert.setContentText(msg);
		infoAlert.showAndWait();
	}

}
