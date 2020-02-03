package exam.app.controller;

import java.io.*;
import java.net.*;
import java.util.*;

import exam.app.service.*;
import exam.app.vo.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;

public class AppMain_controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button barChart;

    @FXML
    private Button btnAdd;

    @FXML
    private TableColumn<AppVO, String> name;

    @FXML
    private TableView<AppVO> tableView;

    @FXML
    private TableColumn<AppVO, Integer> Math;

    @FXML
    private TableColumn<AppVO, Integer> Kor;

    @FXML
    private TableColumn<AppVO, Integer> Eng;

    
    ObservableList<AppVO> data;
    
    private AppService appService;
    
    
    @FXML
    void callAddOn(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("exam.AddOn.fxml"));
			Parent parent = loader.load();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void callBarChart(ActionEvent event) {
    		
    }

    @FXML
    void initialize() {
        assert barChart != null : "fx:id=\"barChart\" was not injected: check your FXML file 'AppMain.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'AppMain.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'AppMain.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'AppMain.fxml'.";
        assert Math != null : "fx:id=\"Math\" was not injected: check your FXML file 'AppMain.fxml'.";
        assert Kor != null : "fx:id=\"Kor\" was not injected: check your FXML file 'AppMain.fxml'.";
        assert Eng != null : "fx:id=\"Eng\" was not injected: check your FXML file 'AppMain.fxml'.";

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		appService = AppServiceImpl.getInstance();
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		Kor.setCellValueFactory(new PropertyValueFactory<>("Kor"));
		Math.setCellValueFactory(new PropertyValueFactory<>("Math"));
		Eng.setCellValueFactory(new PropertyValueFactory<>("Eng"));
		
		//테이블의 값 선택시 파이그래프가 나오도록 하는 메서드
		tableView.setOnMouseClicked(e -> {
			if(tableView.getSelectionModel().isEmpty()) {
			return;
		}
		AppVO appVO = tableView.getSelectionModel().getSelectedItem();
		
		piechart(appVO);
	});
		
	}

	private void piechart(AppVO appVO) {
		PieChart pieChart = new PieChart();
		
		ObservableList<PieChart, Data> pieChartData = FXCollections.observableArrayList();
		
		pieChart.setTitle("파이 그래프");
		pieChart.setLegendSide(Side.BOTTOM);
		pieChart.setData(pieChartData);
		
		
		
	}

}
