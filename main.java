package mvcMainSystem;

  
import java.io.IOException; 
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import controller.MainSystemController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Main_system;
import view.*;



public class main extends Application{

		@Override
		public void start(Stage primaryStage) throws Exception {
			
			//AbstractMainSystemView theView1 = new MainSystemJavaFx(primaryStage);
			
			Main_system main_system = new Main_system(); 
			
			
//			try { 
//		       main_system.read_Binary_File();
//		      } catch (Exception exception ) {
//		    	  System.out.println("Failed to read binary file. " + exception.getMessage());
//		      }

			
			AbstractMainSystemView theView1 = new TheMainSystemStageJavaFX(new Stage());
			MainSystemController controller1 = new MainSystemController(main_system, theView1);
	
			
//			try { 
//			       main_system.read_Binary_File();
//			      } catch (Exception exception ) {
//			    	  System.out.println("Failed to read binary file. " + exception.getMessage());
//			      }
		     

		}	


	public static void main(String[] args) throws IOException ,ClassNotFoundException,NotSerializableException,FileNotFoundException {
		


		 launch(args);

//    	int choise;
//    	
//    	
//    	do {
//        	int numOfQuestions ,counter = 0;
//        	 Scanner s = new Scanner(System.in);
//    		
//    		System.out.println("Enter your choise:\n1 - show all system questions and answers\n2 - add question and answer \n3 - Edit question \n4 - Edit answer \n5 - delete question \n6 - create manually test \n7 - create automatically test \n8 - copy test exist \n9 - exit\n");
//    		
//    		choise = s.nextInt();
//    	
//    		s.nextLine();
//    		switch (choise) {
//    		
//    		
//    		
//    		case 1: 
//    			
//    			main_system.display();
//    			
//    			break;
//    		
//    		case 2: 
//    			
//    			System.out.println("Enter question and press enter");
//    			
//				
//				String newQuestion2 = s.nextLine().strip();
//				
//    		
//			
//				System.out.println("Enter answer and press enter");
//				
//				String newAnswer2 =  s.nextLine().strip();
//    			System.out.println("If you want to add regular question press 1 and to multuple question press 2");
//    			int type2 = Integer.parseInt(s.nextLine().strip());
//    			
//    			if(type2 == 1) {
//    				main_system.AddQ_R(newQuestion2, newAnswer2);
//    				
//    			}
//    			if(type2 == 2) {
//    				System.out.println("Enter indication true or false");
//    				
//    				boolean IsCor2 = Boolean.parseBoolean(s.nextLine().strip());
//    				int ansIdx = main_system.AddQ_M(newQuestion2, newAnswer2 , IsCor2);
//    				
//    				System.out.println("How many answers do you want to add?(1-9)");
//    				int numOfAnswers2 = Integer.parseInt(s.nextLine().strip());
//    				
//    				for (int i = 0; i < numOfAnswers2; i++) {
//    					System.out.println("Enter answer and press enter");
//    					newAnswer2 =  s.nextLine();
//    					System.out.println("Enter indication true or false");
//    					IsCor2 = Boolean.parseBoolean(s.nextLine().strip());
//    					main_system.getMultiQuestion(ansIdx).add_answer(newAnswer2, IsCor2);
//					}
//    				
//    			}
//    
//    			break;
//    			
//    		case 3: 
//    			
//    			System.out.println("Enter the question you want to edit");
//    			int updateQuestion3 = Integer.parseInt(s.nextLine().strip());
//    			Question q = main_system.getQuestion(updateQuestion3);
//    			System.out.println("Enter the new question:");
//    			q.setText(s.nextLine());
//    			break;
//    			
//    		case 4: 
//    			System.out.println("Enter the question you want to edit");
//    			int updateQuestion4 = Integer.parseInt(s.nextLine().strip());
//    			Question q4 = main_system.getQuestion(updateQuestion4);
//    			if (q4 instanceof MultiQuestion) {
//					MultiQuestion mq4 = (MultiQuestion) q4;
//					System.out.println("Which answer you want to edit?");
//					int ansIdx = Integer.parseInt(s.nextLine().strip());
//					System.out.println("What is the new answer?");
//
//					mq4.edit_answer(ansIdx, s.nextLine().strip());
//				}
//    			if (q4 instanceof RegularQuestion) {
//    				RegularQuestion rq4 = (RegularQuestion) q4;
//					System.out.println("What is the new answer?");
//    				rq4.setAnswer(s.nextLine().strip());
//    			}
//
//    			break;
//    			
//    			
//    		case 5: 
//    			
//    			System.out.println("Enter the question you want to delete it answer");
//    			int q5idx = Integer.parseInt(s.nextLine().strip());
//    			main_system.removeQuestion(q5idx);
//    			break;
//    			
//    		case 6: 
//    		
//    			System.out.println("How much questions do you want?");
//    			numOfQuestions = Integer.parseInt(s.nextLine().strip());
//    			ArrayList<Question> pickList = new ArrayList<Question>();
//    			for (int i=0; i<numOfQuestions; i++) {
//    				System.out.println("Which question?");
//    				pickList.add(main_system.getQuestion(Integer.parseInt(s.nextLine().strip())));
//    			}
//    			main_system.addTest(new Test(pickList));
//    			main_system.display_test_with_answers();
//    			System.out.println("--only_questions--");
//    			main_system.display_test_only_questions();
//    			System.out.println("--after sort--");
//    			main_system.sortByAnswers();
//    			main_system.save_Text_File();
//    			main_system.display_test_with_answers();
//    			break;
//    			
//    		case 7: 
//    			System.out.println("How many questions do you want?");
//    			main_system.addTestRandom(Integer.parseInt(s.nextLine().strip()));
//    			main_system.display_test_with_answers();
//    			System.out.println("--only_questions--");
//    			main_system.display_test_only_questions();
//    			System.out.println("--after sort--");
//    			main_system.sortByAnswers();
//    			main_system.save_Text_File();
//    			main_system.display_test_with_answers();
//    			break;
//    			
//    		 			
//    		case 8: 
//    			
//    			main_system.display_tests();
//    			System.out.println("Enter the test number you want to copy");
//    			int TestId = Integer.parseInt(s.nextLine().strip());
//    			try {
//    			main_system.cloneTest(TestId);
//    			main_system.display_test_with_answers();
//    			} catch (Exception exception) {
//    			   System.out.println("Exception in test clone" + exception.getMessage());	
//    			}
//    			break;	
//    			
//    		case 9: 
//    			
//    			
//    			main_system.save_Binary_File();
//    			
//    			System.out.println("Exit\n");
//    			
//    			break;
//    		}
//    		
//    	} while (choise != 9);
    	
	}
	
}
