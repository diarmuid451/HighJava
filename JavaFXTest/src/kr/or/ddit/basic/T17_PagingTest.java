package kr.or.ddit.basic;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class T17_PagingTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PagingTest.fxml"));
		
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Paging Test");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
