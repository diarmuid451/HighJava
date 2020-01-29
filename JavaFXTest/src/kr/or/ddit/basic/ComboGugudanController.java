package kr.or.ddit.basic;

import java.net.*;
import java.util.*;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class ComboGugudanController implements Initializable{

	@FXML
	private ComboBox<Integer> cmbDan;
	
	@FXML
	private Button btnDan;
	
	@FXML
	private TextArea txtResult;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Integer> list = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9);
		cmbDan.setItems(list);
		
//		btnDan.setOnAction(e -> {
//			int dan = cmbDan.getSelectionModel().getSelectedItem();
//			
//			txtResult.setText(dan + "단\n\n");
//			for (int i = 1; i <= 9; i++) {
//				int r = dan * i;
//				txtResult.appendText(dan+" * "+i+" = " + r + "\n");
//			}
//		});
	}

	@FXML
	public void btnDanClicked(ActionEvent event) {
		int dan = cmbDan.getSelectionModel().getSelectedItem();
		
		txtResult.setText(dan + "단\n\n");
		for (int i = 1; i <= 9; i++) {
			int r = dan * i;
			txtResult.appendText(dan+" * "+i+" = " + r + "\n");
		}
	}
	
}
