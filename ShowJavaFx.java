//package view;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import listner.MainSystemUIEventsListner;
//import model.Main_system;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Vector;
//
//import controller.*;
//
//public class ShowJavaFx implements AbstractMainSystemView{
//	private Vector<MainSystemUIEventsListner> allListeners = new Vector<MainSystemUIEventsListner>();
//	private ListView<String> Questionlist = new ListView<String>();
//	private ListView<String> AnswerList = new ListView<String>();
//	private Vector<Integer> IndexList = new Vector<Integer>();
//	private ListView<String> Index = new ListView<String>();
//	
//	private FlowPane flPnlAllPassenger = new FlowPane();
//	
//	public ShowJavaFx(Stage showStage) {
//		
////		showStage.setTitle("All questions and Answers");
////		VBox box = new VBox();
////		Scene scene = new Scene(box, 500, 500);
////		showStage.setScene(scene);
//		
//		showStage.setTitle("All questions and Answers");
//		VBox vBox1 = new VBox();
////	     for (int i = 0; i < 3; i++) {
////	          vBox1.getChildren().add( new Text("9" + i));
//	          //vBox1.getChildren().add(Questionlist);
////      }
//		GridPane gpRoot = new GridPane();
//		gpRoot.setPadding(new Insets(10));
//		gpRoot.setHgap(10);
//		gpRoot.setVgap(10);
//		gpRoot.add(Questionlist,0,0);
//		vBox1.getChildren().add(Questionlist);
//		vBox1.getChildren().addAll(AnswerList);
////		for (int i = 0; i < Questionlist.getItems().size(); i++) {
////			vBox1.getChildren().add(i, Questionlist);
////		}
//		
//		showStage.setScene(new Scene(gpRoot, 700, 400));
//	    // Scene scene = new Scene(vBox1, 500, 500);
//	   //  showStage.setScene(scene);
//
////        VBox vBox2 = new VBox();
////        for( int i=0; i < 10; i++) {
////            vBox2.getChildren().add( 0, new Text( "Item " + i)); // add on top
////        }
////
////        HBox hBox = new HBox();
////        hBox.setSpacing(20);
////        hBox.getChildren().addAll(vBox1, vBox2);
////        
//        
//	//	box.getChildren().addAll( Questionlist);
//	//	box.getChildren().addAll(AnswerList);
//		showStage.show();
//		
//		
//		
////		GridPane qGridPane = new GridPane();
////		GridPane aGridPane = new GridPane();
////		qGridPane.add(Questionlist,0,0);
////		aGridPane.add(AnswerList,300,300);
////		showStage.setScene(new Scene(qGridPane,100,500));
//		
//	}
//
//
//	@Override
//	public void removeQuestionFromUI(int id) {
//		for (int i = 0; i < Questionlist.getItems().size(); i++) {
//			if (id == i) {
//				Questionlist.getItems().remove(i);
//				AnswerList.getItems().remove(i);
//				IndexList.remove(i);
//				Index.getItems().remove(i);
//			}
//		}
//	}
//	
//	@Override
//	public void addRegularQuestionToUI(String question, String answer, int id) {
//		String index = ""+ id;
//		this.Questionlist.getItems().add(question);
//		this.AnswerList.getItems().add(answer);
//		this.Index.getItems().add(index);
//		Integer ID = id;
//		this.IndexList.add(ID);
//		//AddQuestionToShowStage(id,question);
//		//AddAnswerToShowStage(id, answer);
//	}
//	
//	public void AddQuestionToShowStage(int id, String question) {
//		this.Questionlist.getItems().add(id, question);
//	}
//	public void AddAnswerToShowStage(int id, String answer) {
//		AnswerList.getItems().add(id, answer);
//	}
//	public void RempveQuestionFromShowStage(int id, String question) {
//		Questionlist.getItems().remove(id);
//	}
//
//	@Override
//	public void registerListener(MainSystemUIEventsListner listener) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public void addMultipleQuestionToUI(String Q, String A,int id,String isCorrectString) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void addAnswerToUI(int i, String answer, boolean is_correct) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public void editRegularQuestionToUI(String question, int id) {
//		for (int i = 0; i < Questionlist.getItems().size(); i++) {
//			if (id == i) {
//				Questionlist.getItems().set(id, question);
//			}
//		}	
//	}
//
//
//	@Override
//	public void editRegularAnswerToUI(String answer, int id) {
//		for (int i = 0; i < AnswerList.getItems().size(); i++) {
//			if (id == i) {
//				AnswerList.getItems().set(id, answer);
//			}
//		}
//	}
//
//
//
//	@Override
//	public void WrongIndicationMessage(String msg) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	
//}
