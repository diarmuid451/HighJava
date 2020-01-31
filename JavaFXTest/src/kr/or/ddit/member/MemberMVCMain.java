package kr.or.ddit.member;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class MemberMVCMain extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("MemberMVCMain.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("MemberMVCMain.fxml");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
