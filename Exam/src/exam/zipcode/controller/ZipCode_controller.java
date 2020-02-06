package exam.zipcode.controller;

import java.net.*;
import java.util.*;

import exam.zipcode.service.*;
import exam.zipcode.vo.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;

public class ZipCode_controller implements Initializable {

    @FXML
    private TableColumn<ZipCodeVO, String> zipcode;

    @FXML
    private TableColumn<ZipCodeVO, String> gugun;

    @FXML
    private TableColumn<ZipCodeVO, String> bunji;

    @FXML
    private TableColumn<ZipCodeVO, String> sido;

    @FXML
    private ComboBox<String> cbox;

    @FXML
    private TextField ddong;

    @FXML
    private TableView<ZipCodeVO> tableView;

    @FXML
    private TableColumn<ZipCodeVO, String> dong;

    @FXML
    private Button btn;
    
    private ObservableList<ZipCodeVO> data;
	
	ZipCodeService service = ZipCodeServiceImpl.getInstance();

    @FXML
    void search(ActionEvent event) {
    	if(cbox.getValue().equals("동이름")) {
			data = FXCollections.observableArrayList(service.getSearchZip(cbox.getValue(), ddong.getText()));
			tableView.setItems(data);
		}else {
			data = FXCollections.observableArrayList(service.getSearchZip(cbox.getValue(), ddong.getText()));
			tableView.setItems(data);
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
			zipcode.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
			sido.setCellValueFactory(new PropertyValueFactory<>("sido"));
			gugun.setCellValueFactory(new PropertyValueFactory<>("gugun"));
			dong.setCellValueFactory(new PropertyValueFactory<>("dong"));
			bunji.setCellValueFactory(new PropertyValueFactory<>("bunji"));
			
			cbox.getItems().addAll("동이름", "우편번호");
			cbox.setValue("동이름");
		}
}
