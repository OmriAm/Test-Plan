package view;

import controller.MainSystemController;
import javafx.stage.Stage;
import listner.MainSystemUIEventsListner;

public interface AbstractMainSystemView {
	
	void registerListener(MainSystemUIEventsListner listener);
	
	public void addRegularQuestionToUI(String Q, String A,int id ) ;
	public void addMultipleQuestionToUI(String Q, String A, int id,String isCorrectString);
	public void addAnswerToUI(int QID,int AID, String answer, String is_correct); 
	public void removeQuestionFromUI(int id);
	public void editRegularQuestionToUI(String question,int id);
	public void editRegularAnswerToUI(String answer,int id);
	public void WrongIndicationMessage(String msg);
	public void addTestToUI(int id);
	
	
	//AbstractMainSystemView BringQuestions();
	
//	void showAllQiestionsAndAnswersFromUI(Stage stsge);
//	void addRegularQuestionToUI(String question, String answer);
//	void addMultipleQuestionToUI(String Q, String A, boolean IsCorrect);
//	
//	void editAnswerFromUI();
//	void deleteQuestionFromUI();
//	void createManuallyTestFromUI();
//	void createAutomaticallyTestFromUI();
//	void copyTestFromUI();
//	void exit();
//	void registerListener(MainSystemController mainSystemController);
	
}
