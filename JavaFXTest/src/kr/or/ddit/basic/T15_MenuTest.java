package kr.or.ddit.basic;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class T15_MenuTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		
		root.setTop(menuBar);
		
		//File menu 만들어 보기 >> new, save, exit
		Menu fileMenu = new Menu("File"); 	//주 메뉴
		
		MenuItem newMenuItem = new MenuItem("New"); 	//부메뉴
		MenuItem saveMenuItem = new MenuItem("Save"); 	//부메뉴
		MenuItem exitMenuItem = new MenuItem("Exit"); 	//부메뉴
		
		//메뉴에 이벤트 설정
		exitMenuItem.setOnAction(e -> {
			//해당메뉼했을때 처리할 내용 기술
			Platform.exit();
		});
		
		//주메뉴에 부메뉴들 추가
		fileMenu.getItems().addAll(newMenuItem, saveMenuItem, exitMenuItem);
		
		//------------------------------------------------------------------------
		Menu webMenu = new Menu("web");
		
		CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
		htmlMenuItem.setSelected(false);
		
		CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
		cssMenuItem.setSelected(true);
		
		webMenu.getItems().addAll(htmlMenuItem, cssMenuItem);
		
		//-----------------------------------------------------------------------------------
		Menu sqlMenu = new Menu("SQL");
		ToggleGroup tGroup = new ToggleGroup();
		
		RadioMenuItem mysqlIItem = new RadioMenuItem("MySQL");
		mysqlIItem.setToggleGroup(tGroup);
		mysqlIItem.setSelected(true);
		
		RadioMenuItem oraclelItem = new RadioMenuItem("Oracle");
		oraclelItem.setToggleGroup(tGroup);
		
		RadioMenuItem mssqlItem = new RadioMenuItem("MS-SQL");
		mssqlItem.setToggleGroup(tGroup);
		
		sqlMenu.getItems().addAll(mysqlIItem, oraclelItem, mssqlItem);
		
		//부메뉴의 부메뉴 구성하기
		
		Menu tutorialMenu = new Menu("Tutorial");
		tutorialMenu.getItems().addAll(
				new CheckMenuItem("Java"), new CheckMenuItem("JavaFX"),new CheckMenuItem("Java Swing"));
		
		sqlMenu.getItems().addAll(new SeparatorMenuItem(), tutorialMenu);
		
		//주메뉴들을 MenuBar에 추가
		menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu);
		
		Scene scene = new Scene(root, 300, 250);
		
		primaryStage.setTitle("메뉴 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
		
	}
}
