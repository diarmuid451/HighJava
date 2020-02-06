package exam.prodInfo.controller;

import java.net.*;
import java.util.*;

import exam.prodInfo.service.*;
import exam.prodInfo.vo.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.util.*;


public class ProdInfo_controller implements Initializable {
	
	    @FXML
	    private TableColumn<ProdVO, String> PROD_DETAIL;

	    @FXML
	    private TableColumn<ProdVO, String> PROD_BUYER;

	    @FXML
	    private TableColumn<ProdVO, String> PROD_LGU;

	    @FXML
	    private TableColumn<ProdVO, Integer> PROD_COST;

	    @FXML
	    private TableView<ProdVO> tableView;

	    @FXML
	    private TableColumn<ProdVO, Integer> PROD_PROPERSTOCK;

	    @FXML
	    private TableColumn<ProdVO, Date> PROD_INSDATE;

	    @FXML
	    private TableColumn<ProdVO, String> PROD_NAME;

	    @FXML
	    private TableColumn<ProdVO, Integer> PROD_TOTALSTOCK;

	    @FXML
	    private TableColumn<ProdVO, Integer> PROD_PRICE;

	    @FXML
	    private TableColumn<ProdVO, String> PROD_IMG;

	    @FXML
	    private ComboBox<lProdVO> clprod_gu;

	    @FXML
	    private TableColumn<ProdVO, String> PROD_COLOR;

	    @FXML
	    private TableColumn<ProdVO, Integer> PROD_MILEAGE;

	    @FXML
	    private TableColumn<ProdVO, Integer> PROD_QTYIN;

	    @FXML
	    private TableColumn<ProdVO, String> PROD_DELIVERY;

	    @FXML
	    private TableColumn<ProdVO, String> PROD_SIZE;

	    @FXML
	    private ComboBox<ProdVO> cprod_name;

	    @FXML
	    private TableColumn<ProdVO, Integer> PROD_SALE;

	    @FXML
	    private TableColumn<ProdVO, String> PROD_UNIT;

	    @FXML
	    private TableColumn<ProdVO, String> PROD_ID;

	    @FXML
	    private TableColumn<ProdVO, String> PROD_OUTLINE;

	    @FXML
	    private TableColumn<ProdVO, Integer> PROD_QTYSALE;

	    ProdService  service = ProdServiceImpl.getInstance();
	    ObservableList<lProdVO> lpList;
	    ObservableList<ProdVO> prodList;
	    ObservableList<ProdVO> view;
	    
	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	    	
	    	List<lProdVO> compd1 = service.combo1List();
			lpList = FXCollections.observableArrayList(compd1);
			prodList=FXCollections.observableArrayList();
			clprod_gu.setItems(lpList);
		
			ListView<lProdVO> list = new ListView<lProdVO>();
			
			clprod_gu.setCellFactory(new Callback<ListView<lProdVO>, ListCell<lProdVO>>() {
				
				@Override
				public ListCell<lProdVO> call(ListView<lProdVO> param) {

					return new ListCell<lProdVO>() {
						@Override
						protected void updateItem(lProdVO item, boolean empty) {
							super.updateItem(item, empty);
							if(!empty) {
								setText(item.getLprod_nm());
							}
						};
					};
				}
			});
			clprod_gu.setButtonCell(new ListCell<lProdVO>() {
				@Override
				protected void updateItem(lProdVO item, boolean empty) {
					super.updateItem(item, empty);
					if(!empty) {
						setText(item.getLprod_nm());
					}
				}
			});
	    }
	    
	    
	    
	    @FXML
	    public void selectedbox1(ActionEvent event) {
	    	lProdVO mv = clprod_gu.getValue();
			List<ProdVO> compd2 = service.combo2List(mv.getLprod_gu());
			prodList = FXCollections.observableArrayList(compd2);
			cprod_name.setItems(prodList);
			
			cprod_name.setCellFactory(new Callback<ListView<ProdVO>, ListCell<ProdVO>>() {
				
				@Override
				public ListCell<ProdVO> call(ListView<ProdVO> param) {
					
					return new ListCell<ProdVO>() {
						@Override
						protected void updateItem(ProdVO item, boolean empty) {
							super.updateItem(item, empty);
							if(!empty) {
								setText(item.getProd_name());
							}
						};
					};
				}
			});
			cprod_name.setButtonCell(new ListCell<ProdVO>() {
				@Override
				protected void updateItem(ProdVO item, boolean empty) {
					super.updateItem(item, empty);
					if(!empty) {
						setText(item.getProd_name());
					}
				}
			});	
	    }

	    @FXML
	    public void selectedbox2(ActionEvent event) {
	    	ProdVO info =cprod_name.getValue();
			view = FXCollections.observableArrayList(info);
			tableView.setItems(view);
			PROD_ID.setCellValueFactory(new PropertyValueFactory<>("prod_id"));
			PROD_NAME.setCellValueFactory(new PropertyValueFactory<>("prod_name"));
			PROD_LGU.setCellValueFactory(new PropertyValueFactory<>("prod_lgu"));
			PROD_BUYER.setCellValueFactory(new PropertyValueFactory<>("prod_buyer"));
			PROD_COST.setCellValueFactory(new PropertyValueFactory<>("prod_cost"));
			PROD_PRICE.setCellValueFactory(new PropertyValueFactory<>("prod_price"));
			PROD_SALE.setCellValueFactory(new PropertyValueFactory<>("prod_sale"));
			PROD_OUTLINE.setCellValueFactory(new PropertyValueFactory<>("prod_outLine"));
			PROD_DETAIL.setCellValueFactory(new PropertyValueFactory<>("prod_detail"));
			PROD_IMG.setCellValueFactory(new PropertyValueFactory<>("prod_img"));
			PROD_TOTALSTOCK.setCellValueFactory(new PropertyValueFactory<>("prod_totoalstock"));
			PROD_INSDATE.setCellValueFactory(new PropertyValueFactory<>("prod_insdate"));
			PROD_PROPERSTOCK.setCellValueFactory(new PropertyValueFactory<>("prod_properstock"));
			PROD_SIZE.setCellValueFactory(new PropertyValueFactory<>("prod_size"));
			PROD_COLOR.setCellValueFactory(new PropertyValueFactory<>("prod_color"));
			PROD_DELIVERY.setCellValueFactory(new PropertyValueFactory<>("prod_delivery"));
			PROD_UNIT.setCellValueFactory(new PropertyValueFactory<>("prod_unit"));
			PROD_QTYIN.setCellValueFactory(new PropertyValueFactory<>("prod_qtyin"));
			PROD_QTYSALE.setCellValueFactory(new PropertyValueFactory<>("prod_qtysale"));
			PROD_MILEAGE.setCellValueFactory(new PropertyValueFactory<>("prod_mileage"));
			
		}
	    	
	    	
	    	
	    



	
	

	
	
}