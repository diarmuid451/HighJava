package exam.zipcode;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class ZipCodeMain extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("searchZipCode.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("MemberMVCMain.fxml");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
