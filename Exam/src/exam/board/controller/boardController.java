package exam.board.controller;

import java.net.*;
import java.util.*;

import exam.board.VO.*;
import exam.board.service.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;

public class boardController implements Initializable {

	@FXML
    private TableColumn<boardVO, String> board_title;

    @FXML
    private TableColumn<boardVO, Date> board_date;

    @FXML
    private TableColumn<boardVO, Integer> board_no;

    @FXML
    private TableColumn<boardVO, String> board_writer;

    @FXML
    private TableColumn<boardVO, String> board_content;
    
    @FXML
    private TableView<boardVO> table;

    @FXML
    public void add(ActionEvent event) {

    }

    @FXML
    public void update(ActionEvent event) {

    }

    @FXML
    public void delete(ActionEvent event) {

    }
	
    ObservableList<boardVO> data;
    
    private boardService service;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		board_no.setCellValueFactory(new PropertyValueFactory<>("board_no"));
		board_title.setCellValueFactory(new PropertyValueFactory<>("board_title"));
		board_writer.setCellValueFactory(new PropertyValueFactory<>("board_writer"));
		board_date.setCellValueFactory(new PropertyValueFactory<>("board_date"));
		board_content.setCellValueFactory(new PropertyValueFactory<>("board_content"));
		
		service = boardServiceImpl.getInstance();
		
		data = FXCollections.observableArrayList(service.getAllBoard());
		
		table.setItems(data);
	}

}
