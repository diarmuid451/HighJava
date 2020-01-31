package kr.or.ddit.basic;

import javafx.application.*;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.util.*;

public class T13_ListViewTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		ListView<String> list = new ListView<>();
		
		Label label = new Label();
		label.setFont(new Font(20));
		
		//ListView에 들어갈 데이터 구성하기
		ObservableList<String> data = FXCollections.observableArrayList(
			"green", "gold", "red","blue","black", "brown","blueviolet",
			"pink","yellow","chocolate","silver","magenta","slateblue"
		);
		list.setItems(data);
		
		//ListView에서 값이 선택 되었을때 처리
//		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
//
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				label.setText(newValue);
//				label.setTextFill(Color.web(newValue)); 	//글자색 변경	
//			}
//		});
		
		list.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> {
					label.setText(newValue);
					label.setTextFill(Color.web(newValue));
				});
				
		//ListViewe의 내용은 변경하지 않고 화면에 보이는 부분만 변경하는 방법
		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

			@Override
			public ListCell<String> call(ListView<String> param) {
				
				return new ListCell<String>() {
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						
						//변경되는 데이터가 문자열이면 setText()를 사용 
						//setText(item);
						
						Rectangle rect = new Rectangle(50, 20);
						if(item != null) {  //또는 !empty
							rect.setFill(Color.web(item));  //색칠하기
							//setGraphic(rect); // 값 변경하기
							
							Label lbTxt = new Label(item);
							lbTxt.setTextFill(Color.web(item));
							
							HBox hb2 = new HBox(10);
							
							hb2.getChildren().addAll(rect, lbTxt);
							
							setGraphic(hb2);
						}
					}
				};
			}
			
		});
		
		VBox vbox = new VBox(10);
		
		vbox.getChildren().addAll(list, label);
		
		Scene scene = new Scene(vbox);
		
		primaryStage.setTitle("ListView 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
