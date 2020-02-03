package kr.or.ddit.basic.timeclock;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Root.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Platform.runLater() 예제");
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);;
	}

}
