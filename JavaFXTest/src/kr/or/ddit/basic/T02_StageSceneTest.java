package kr.or.ddit.basic;



import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class T02_StageSceneTest extends Application {

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();		//컨트롤들을 세로로 배치해주는 컨테이너
		root.setPrefWidth(650);		//VBox의 너비
		root.setPrefHeight(150); 	//VBox의 높이
		root.setAlignment(Pos.CENTER);		//컨트롤들을 가운데 정렬
		root.setSpacing(20); 	//컨트롤과 컨트롤 사이의 간격
		
		Label label = new Label();	//Label객체 생성
		label.setText("안녕하세요. JavaFX 입니다.");
		label.setFont(new Font(50));	//Font객체를 이용하여 글자크기 설정
		
		Button btn = new Button();
		btn.setText("확 인");
//		btn.setOnAction(new EventHandler<ActionEvent>() {
//		
//	
//			@Override
//			public void handle(ActionEvent event) {
//				Platform.exit();	//프로그램 종료
//			}
//		});
		
		btn.setOnAction(e -> Platform.exit());
		
		//VBox에 컨트롤들 추가하기
		root.getChildren().add(label);
		root.getChildren().add(btn);
		
		//VBox를 루트컨테이너로 하는 Scene객체 생성
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Stage와 Scene 연습"); 	//창 제목
		primaryStage.setScene(scene); 	//Stage에 Scene설정
		
		primaryStage.show();
		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);

	}


}