//package view;
//
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.Stack;
//
//import javax.swing.JOptionPane;
//
//import controller.MainSystemController;
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import listner.MainSystemUIEventsListner;
//import model.Main_system;
//
//
//public class MainSystemJavaFx  implements AbstractMainSystemView{
//	
//	
//	public MainSystemJavaFx(Stage stage) throws Exception {
//		
//		Main_system main_system = new Main_system();
//		
//		stage.setTitle("Welcome to main system");
//		StackPane pane = new StackPane();
//		//pane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
//		stage.setScene(new Scene(pane,300,500));
//		Label buttonTitle=new Label();
//		buttonTitle.setText("Choose option and clic button");
//		buttonTitle.setAlignment(Pos.CENTER);
//		Button option1 =new Button("Show all system questions and answers");
//		Button option2 =new Button("Add question and answer");
//		Button option3 =new Button("Edit question");
//		Button option4 =new Button("Edit answer");
//		Button option5 =new Button("Delete question");
//		Button option6 =new Button("Create manually test");
//		Button option7 =new Button("Create automatically test");
//		Button option8 =new Button("Copy test exist");
//		Button option9 =new Button("Exit");
//		
//		option1.setPrefSize(300, 20);
//		option2.setPrefSize(300, 20);
//		option3.setPrefSize(300, 20);
//		option4.setPrefSize(300, 20);
//		option5.setPrefSize(300, 20);
//		option6.setPrefSize(300, 20);
//		option7.setPrefSize(300, 20);
//		option8.setPrefSize(300, 20);
//		option9.setPrefSize(300, 20);
//		
//		option1.setOnAction(new EventHandler<ActionEvent>() {
//		
//			@Override
//			public void handle(ActionEvent event) {
//				Stage showStage = new Stage();
//				AbstractMainSystemView showView = new ShowJavaFx(showStage);
//				MainSystemController showController = new MainSystemController(main_system, showView);
//				
//				
//				main_system.AddQ_R("ofir", "shimi");
//			}
//		});
//		option2.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				Stage newStage = new Stage();
//				AbstractMainSystemView theView1 = new TheMainSystemStageJavaFX(newStage);
//				MainSystemController controller1 = new MainSystemController(main_system, theView1);
//		
//				
//			}
//		});
//		option3.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				
//			}
//		});
//		option9.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event)  {
//				
//    			System.out.println("Exit\n");
//    			
//    			Platform.exit();
//			}
//		});
//		
//		
//		VBox vbox = new VBox();
//		vbox.getChildren().addAll(buttonTitle,option1,option2,option3,option4,option5,option6,option7,option8,option9);
//		vbox.setSpacing(10); 
//		
//		stage.setScene(new Scene(vbox,500,500));
//		
//		stage.show();
//		
//		
//	}	
//	
////	@Override
////	public void showAllQiestionsAndAnswersFromUI(Stage stage) {
////		stage.setTitle("All questions and answers");
////		StackPane pane = new StackPane();
////		stage.setScene(new Scene(pane,300,500));
////		
////		for (int i = 0; i < getNumOfQuestions(); i++) {
////			
////		}
////		
////	}
//	
//	public void failedReadBinaryMessage(String msg) {
//		JOptionPane.showMessageDialog(null, msg);
//		
//	}
//
//	@Override
//	public void registerListener(MainSystemUIEventsListner listener) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void addRegularQuestionToUI(String Q, String A, int id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void addMultipleQuestionToUI(String Q, String A, boolean IsCorrect) {
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
//	@Override
//	public void removeQuestionFromUI(int id) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	
////
////	@Override
////	public void addQuestionAndAnswerFromUI() {
////		// TODO Auto-generated method stub
////		
////	}
////
////	@Override
////	public void editAnswerFromUI() {
////		// TODO Auto-generated method stub
////		
////	}
////
////	@Override
////	public void deleteQuestionFromUI() {
////		// TODO Auto-generated method stub
////		
////	}
////
////	@Override
////	public void createManuallyTestFromUI() {
////		// TODO Auto-generated method stub
////		
////	}
////
////	@Override
////	public void createAutomaticallyTestFromUI() {
////		// TODO Auto-generated method stub
////		
////	}
////
////	@Override
////	public void copyTestFromUI() {
////		// TODO Auto-generated method stub
////		
////	}
////
////	@Override
////	public void exit() {
////		// TODO Auto-generated method stub
////		
////	}
////
////	@Override
////	public void registerListener(MainSystemController mainSystemController) {
////		// TODO Auto-generated method stub
////		
////	}
//
//	
//
//	
//
//	
//
//}
