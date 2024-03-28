package controller;

import java.util.ArrayList;

import listner.MainSystemEventListener;
import listner.MainSystemUIEventsListner;
import model.Main_system;
import model.MultiQuestion;
import model.Question;
import model.RegularQuestion;
import view.AbstractMainSystemView;


public class MainSystemController implements MainSystemEventListener, MainSystemUIEventsListner {
	private Main_system main_system_model;
	private AbstractMainSystemView main_system_view;
	//private AbstractShowMainSystem showStageV
	
	public MainSystemController(Main_system model, AbstractMainSystemView view) {
		main_system_model = model;
		main_system_view = view;
		
		main_system_model.registerListener(this);
		main_system_view.registerListener(this);
	} 
	

//	public AbstractMainSystemView copyAbstractMainSystemView() {
//		return this.main_system_view;
//	}
//
	@Override
	public void Read_FromBinary() {
		try { 
			main_system_model.read_Binary_File();
		      } catch (Exception exception ) {
		    	  System.out.println("Failed to read binary file. " + exception.getMessage());
		      }
	}
	@Override
	public void Copy_Test_FromUI(int id) {
		try {
			main_system_model.cloneTest(id);
		} catch (CloneNotSupportedException e) {
			System.out.println("Failed clone test ");
			e.printStackTrace();
		}
		
	}
	@Override
	public void Show_Test_FromUI(int id) {
		main_system_model.display_tests(id);
	}
	@Override
	public void Create_Random_Test_From_Ui_ByNumber(String id) {
		int count = Integer.parseInt(id);
		main_system_model.addTestRandom(count);	
	}
	@Override
	public void Create_Manual_Test_From_Ui_ByNumber(int[] arr) {
		main_system_model.addTestManually(arr);
	}
	@Override
	public void AddQ_R_FromUI(String Q, String A) {
		main_system_model.AddQ_R(Q, A);
	}
	
	@Override
	public void AddQ_M_FromUI(String Q, String A, String IsCorrect) {
		String t = "true", f = "false";
			if ((IsCorrect.equals(t)) || (IsCorrect.equals(f))) {
				main_system_model.AddQ_M(Q, A,IsCorrect);
			}
			else {
				main_system_view.WrongIndicationMessage("Spelling mistake");
			}
			
		
	}
	@Override
	public void Add_Answer_FromUI(int QID, String answer, String is_correct) {
		String t = "true", f = "false";
		if ((is_correct.equals(t)) || (is_correct.equals(f))) {
			main_system_model.AddAnswer(QID, answer, is_correct);
		}
		else {
			main_system_view.WrongIndicationMessage("Spelling mistake");
		} 
	}
	@Override
	public void Remove_Regular_Question_FromUI(int i) {
		main_system_model.removeQuestion(i);
    }
	@Override
	public void Remove_Multiple_Question_FromUI(int id) {
		main_system_model.removeQuestion(id);
		
	}
	@Override
	public void Edit_RQuestion_FromUI(String question, int id) {
		main_system_model.editRQuestion(question, id);
	}
	@Override
	public void Edit_MAnswer_FromUI(String answer,int id){
		main_system_model.editMAnswer(answer, id);
	}

	@Override
	public void Edit_RAnswer_FromUI(String answer, int id) {
		main_system_model.editRAnswer(answer, id);
	}

	
	
	
	@Override
	public void Add_Test_ToControllerFromModelEvent(int id) {
		main_system_view.addTestToUI(id);
		
	}
	@Override
    public void AddQ_R_ToControllerFromModelEvent(String Q, String A, int id) {
    	main_system_view.addRegularQuestionToUI(Q,A,id);
    }
	@Override
    public void AddQ_M_ToControllerFromModelEvent(String Q, String A,int id,String isCorrectString) {
    	main_system_view.addMultipleQuestionToUI(Q,A,id,isCorrectString);
    }
	
	@Override
    public void AddM_Answer_ToControllerFromModelEvent( String answer,int QID,int AID, String is_correct) {
    	main_system_view.addAnswerToUI(QID,AID,answer,is_correct);
    }
	@Override
    public void Remove_Question_FromModelEvent(int id) {
    	main_system_view.removeQuestionFromUI(id);
    }

	@Override
	public void Edit_RQuestion_FromModelEvent(String question, int i) {
		main_system_view.editRegularQuestionToUI(question, i);
		
	}
	@Override
	public void Edit_RAnswer_FromModelEvent(String answer, int i) {
		main_system_view.editRegularAnswerToUI(answer, i);
		
	}


	


	


	


	


	



	

	
	


	


	
	
	
	





}
