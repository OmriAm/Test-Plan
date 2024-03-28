package view;

import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import listner.MainSystemUIEventsListner;


public class TheMainSystemStageJavaFX implements AbstractMainSystemView {
	
	private Vector<MainSystemUIEventsListner> allListeners = new Vector<MainSystemUIEventsListner>();
	private ComboBox<String> cmbAllQuestions = new ComboBox<String>();
	private ComboBox<String> cmbAllAnswers = new ComboBox<String>();
	private ComboBox<String> cmbAllTests = new ComboBox<String>();
	
	public TheMainSystemStageJavaFX(Stage theStage) {
		theStage.setTitle("Welcome To Main System");
		
		GridPane gpRoot = new GridPane();
		gpRoot.setPadding(new Insets(10));
		gpRoot.setHgap(10);
		gpRoot.setVgap(10);
		
		Label QuestionLable = new Label("Enter Regular Question : ");
		TextField tfQuestion = new TextField();
		
		Label AnswerLable = new Label("Enter Answer : ");
		TextField tfAnswer = new TextField();
		
		Button btnAddRegularQuestion = new Button("Add Regular Question and Answer");
		
		btnAddRegularQuestion.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent action) {
				for (MainSystemUIEventsListner l : allListeners)
					l.AddQ_R_FromUI(tfQuestion.getText(), tfAnswer.getText());
				
				tfQuestion.setText("");
				tfAnswer.setText("");
			}
		});
		
		Label lblAllRQuestions = new Label("All Questions:");
		Button btnRemoveRQuestion = new Button("Remove Question");
		Label lblAllREMoveQuestion = new Label("To remove question mark from all questions then press buttun:");
		btnRemoveRQuestion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
//				for (int i = 0; i < cmbAllQuestions.getItems().size(); i++)
//					allListeners.get(i).Remove_Question_FromUI(i);
				for (MainSystemUIEventsListner l : allListeners)
					l.Remove_Regular_Question_FromUI(getIdFromQuestionString(cmbAllQuestions.getValue()));;
				
			}
		});
		

		Button btnEditRQuestion = new Button("Edite Question");
		Label lblAllRAnswers = new Label("All Answers : ");
		
		Label SetQuestionText = new Label("Write Question then mark question to edit: ");
		Label SetQuestionText2 = new Label("Mark from all Questions");
		TextField tfSetQuestion = new TextField();
		
		btnEditRQuestion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
//				for (int i = 0; i < cmbAllQuestions.getItems().size(); i++)
//					allListeners.get(i).Remove_Question_FromUI(i);
				for (MainSystemUIEventsListner l : allListeners)
					l.Edit_RQuestion_FromUI(tfSetQuestion.getText(),getIdFromQuestionString(cmbAllQuestions.getValue()));
				tfSetQuestion.setText("");
			}
		});
		
		Button btnEditRAnswer = new Button("Edite Answer");
		Label SetAnswerText = new Label("Write Answer then mark Answer to edit:  ");
		Label SetAnswerText2 = new Label("Mark from all answers");
		TextField tfSetAnswer = new TextField();
		
		btnEditRAnswer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
//				for (int i = 0; i < cmbAllQuestions.getItems().size(); i++)
//					allListeners.get(i).Remove_Question_FromUI(i);
				for (MainSystemUIEventsListner l : allListeners)
					l.Edit_RAnswer_FromUI(tfSetAnswer.getText(),getIdFromQuestionString(cmbAllAnswers.getValue()));;
				tfSetAnswer.setText("");
			}
		});
		
		Button btnEditMAnswer = new Button("Edite Multiple Answer");
		
		btnEditMAnswer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				for (MainSystemUIEventsListner l : allListeners)
					l.Edit_MAnswer_FromUI(tfSetAnswer.getText(),getIdFromQuestionString(cmbAllQuestions.getValue()));
				tfSetAnswer.setText("");
			}
		});
	
		
		Label MultipleQuestionLable = new Label("Enter Multiple Question : ");
		TextField tfMultipleQuestion = new TextField();
		
		Label MultipleAnswerLable = new Label("Enter First Multiple Answer : ");
		TextField tfMultipleAnswer = new TextField();
		Label MultipleIndicationLable = new Label("Enter Indication 'true' or 'false' only low case: ");
		TextField tfMultipleIndication = new TextField();
		
		Button btnAddMultipleQuestionAndAnswer = new Button("Add Multiple Question And Answer");
		
		btnAddMultipleQuestionAndAnswer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				for (MainSystemUIEventsListner l : allListeners)
					l.AddQ_M_FromUI(tfMultipleQuestion.getText(),tfMultipleAnswer.getText(),tfMultipleIndication.getText());;
				tfMultipleQuestion.setText("");
				tfMultipleAnswer.setText("");
				tfMultipleIndication.setText("");
			}
		});
		
		//Label lblAllRQuestions = new Label("All Regular Questions:");
		Button btnRemoveMultipleQuestion = new Button("Remove Multiple Question");
		btnRemoveMultipleQuestion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				for (MainSystemUIEventsListner l : allListeners)
					l.Remove_Multiple_Question_FromUI(getIdFromQuestionString(cmbAllQuestions.getValue()));;
				
			}
		});
		
		TextField tfMultipleAddIndication = new TextField();
		TextField tfMultipleAddAnswer = new TextField();
		Label lblAddMAnswerAndIndication = new Label("To Add Multiple answer mark the question from all questions, write new answer then indication and press button");
		Label lblAddMAnswerAndIndication2 = new Label("write indication-->");
		Label lblAddMAnswerAndIndication1 = new Label("write new answer-->");
		Button btnAddMultipleAnswer = new Button("Add Multiple answer");
		btnAddMultipleAnswer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				for (MainSystemUIEventsListner l : allListeners)
					l.Add_Answer_FromUI(getIdFromQuestionString(cmbAllQuestions.getValue()),tfMultipleAddAnswer.getText(),tfMultipleAddIndication.getText());;
				tfMultipleAddAnswer.setText("");
				tfMultipleAddIndication.setText("");
			}
		});
		
		
		Button btnCreateRandomTest = new Button("Create random test");
		TextField tfNumOfQuestions = new TextField();
		Label lblCreateRandomTest = new Label("write num of questions");
		btnCreateRandomTest.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				for (MainSystemUIEventsListner l : allListeners)
					l.Create_Random_Test_From_Ui_ByNumber(tfNumOfQuestions.getText());;
				
				tfNumOfQuestions.setText("");
			}
		});
		Button btnCreateTestByUser = new Button("Create by user");
		btnCreateTestByUser.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String n = tfNumOfQuestions.getText();
				int m = Integer.parseInt(n);
				tfNumOfQuestions.setText("");
				int arr[] = new int[m];
				
				for (int i = 0; i < m; i++) {
					arr[i] = Integer.parseInt(JOptionPane.showInputDialog("write Q number"));
				}
				for (MainSystemUIEventsListner l : allListeners)
					l.Create_Manual_Test_From_Ui_ByNumber(arr);;
			}
		});
		Button btnShowQuestionTest = new Button("Show Test");
		btnShowQuestionTest.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				for (MainSystemUIEventsListner l : allListeners)
					l.Show_Test_FromUI(getIdFromQuestionString(cmbAllTests.getValue()));;
			}
		});
		
		Button btnCloneTest = new Button("Copy Test");
		Label lblAllTests = new Label("All tests:");
		btnCloneTest.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				for (MainSystemUIEventsListner l : allListeners)
					l.Copy_Test_FromUI(getIdFromQuestionString(cmbAllTests.getValue()));;
			}
		});
		Button btnReadFromBinary = new Button("Read From Binary");
		Label lblBinarys = new Label("All tests:");
		btnReadFromBinary.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				for (MainSystemUIEventsListner l : allListeners)
					l.Read_FromBinary();;
			}
		});
		gpRoot.add(QuestionLable, 0, 0);
		gpRoot.add(tfQuestion, 1, 0);
		gpRoot.add(AnswerLable, 0, 1);
		gpRoot.add(tfAnswer, 1, 1);
		gpRoot.add(btnAddRegularQuestion, 2, 1);
		gpRoot.add(MultipleQuestionLable, 0, 2);
		gpRoot.add(tfMultipleQuestion, 1, 2);
		gpRoot.add(MultipleAnswerLable, 0, 3);
		gpRoot.add(tfMultipleAnswer, 1, 3);
		gpRoot.add(MultipleIndicationLable, 0, 4);
		gpRoot.add(tfMultipleIndication, 1, 4);
		gpRoot.add(btnAddMultipleQuestionAndAnswer, 2, 4);
		gpRoot.add(lblAllRQuestions, 0, 5);
		gpRoot.add(cmbAllQuestions, 1, 5);
		gpRoot.add(lblAllRAnswers, 2, 5);
		gpRoot.add(cmbAllAnswers, 3, 5);
		gpRoot.add(SetQuestionText, 0, 6);
		gpRoot.add(tfSetQuestion, 1, 6);
		gpRoot.add(SetQuestionText2, 2, 6);
		gpRoot.add(btnEditRQuestion, 3, 6);
		gpRoot.add(SetAnswerText, 0, 7);
		gpRoot.add(tfSetAnswer, 1, 7);
		gpRoot.add(SetAnswerText2, 2, 7);
		gpRoot.add(btnEditRAnswer, 3, 7);
		gpRoot.add(lblAddMAnswerAndIndication, 0, 8, 3, 1);
		gpRoot.add(lblAddMAnswerAndIndication1, 0, 9);
		gpRoot.add(tfMultipleAddAnswer, 1, 9);
		gpRoot.add(lblAddMAnswerAndIndication2, 2, 9);
		gpRoot.add(tfMultipleAddIndication, 3, 9);
		gpRoot.add(btnAddMultipleAnswer, 3, 8);
		gpRoot.add(lblAllREMoveQuestion, 0, 10, 2, 1);
		gpRoot.add(btnRemoveRQuestion, 3, 10);
		gpRoot.add(lblCreateRandomTest, 0, 11);
		gpRoot.add(tfNumOfQuestions, 1, 11);
		gpRoot.add(btnCreateRandomTest, 2, 11);
		gpRoot.add(cmbAllTests, 1, 12);
		gpRoot.add(btnCreateTestByUser, 3, 11);
		gpRoot.add(btnShowQuestionTest, 2, 12);
		gpRoot.add(btnCloneTest, 3, 12);
		gpRoot.add(lblAllTests, 0, 12);
		//gpRoot.add(btnReadFromBinary, 0, 13);
		
		theStage.setScene(new Scene(gpRoot, 800, 500));
		theStage.show();
	}
	
	
	
	@Override
	public void registerListener(MainSystemUIEventsListner listener) {
		allListeners.add(listener);
		
	}
	@Override
	public void addTestToUI(int id) {
		cmbAllTests.getItems().add("Test number ("+ id + ")");
		
	}
	@Override
	public void addRegularQuestionToUI(String Q, String A, int id) {
		cmbAllQuestions.getItems().add( Q + "(" + id +")" + " Regular");
		cmbAllAnswers.getItems().add( A +"(" + id +") ");
	}

	@Override
	public void addMultipleQuestionToUI(String Q, String A, int id, String isCorrectString) {
		cmbAllQuestions.getItems().add(Q + "(" + id +")" + " Multuple");
		cmbAllAnswers.getItems().add(A + " (" + id + ") " + " - "  + id+"." + 0 + " " +isCorrectString);
		
	}

	@Override
	public void addAnswerToUI(int QID,int AID, String answer, String is_correct) {
		cmbAllAnswers.getItems().add(answer +  "(" + QID  +") - " +  QID+"." + AID+" " + is_correct);
	}
	public void removeQuestionFromUI(int id) {
		ObservableList<String> allcmbAllQuestions = cmbAllQuestions.getItems();
		for (int i = 0 ; i < allcmbAllQuestions.size() ; i++) {
			int lineId = getIdFromQuestionString(allcmbAllQuestions.get(i));
			if (lineId == id) {
				cmbAllQuestions.getItems().remove(i);
			}
		}
		ObservableList<String> allcmbAllAnswers = cmbAllAnswers.getItems();
		for (int k = 0 ; k < allcmbAllAnswers.size() ; k++) {
			int lineId = getIdFromQuestionString(allcmbAllAnswers.get(k));
			if(lineId == id) {
				cmbAllAnswers.getItems().remove(k);
			}
		}
	}

	private int getIdFromMultipleAnswerString(String str) {
		System.out.println(str);
		String[] arr = str.split("-");
		return Integer.parseInt(arr[0]);
	}
	
	private int getIdFromQuestionString(String str) {
		//System.out.println(str);
		String[] arr = str.split("[()]");
		//System.out.println(arr);
		return Integer.parseInt(arr[1]);
	}
	@Override
	public void editRegularQuestionToUI(String question, int id) {
		String qType = question + " (" + id + ")";
		for (int i = 0 ; i < cmbAllQuestions.getItems().size() ; i++) {
			if (i == id) {
				cmbAllQuestions.getItems().set(i, qType);
			}
		}
		
	}

	


	@Override
	public void WrongIndicationMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	
	@Override
	public void editRegularAnswerToUI(String answer, int id) {
		String aType = answer + " (" + id + ")";
		for (int i = 0 ; i < cmbAllAnswers.getItems().size() ; i++) {
			if (i == id) {
				cmbAllAnswers.getItems().set(i, aType);
			}
		}
		
	}



	

}
