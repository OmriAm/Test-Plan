package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

import listner.MainSystemEventListener;



public class Main_system {
		
		private ArrayList<Question> questions = new ArrayList<>();
		private ArrayList<Test> tests = new ArrayList<>();
		private ArrayList<MainSystemEventListener> AllQuestionsListeners = new ArrayList<>();
	    private int index;
	    

	   
	    public void registerListener(MainSystemEventListener listener) {
	    	AllQuestionsListeners.add(listener);
		}
	    
	    public int getNumOfQuestions() {
			return questions.size();
		}
	    
	    public Main_system() {
	    	
	        this.index = 0;
	    }
	    public void display_tests(int id) {
	    	this.tests.get(id-1).print_test_Questions_And_Answers();
	    	this.tests.get(id-1).save_To_arr_test_Questions_And_Answers();

//			tests.get(id-1).print_test_Questions();
//			Test thisTest = (Test)tests.get(id-1);
//			for (int i = 0; i < thisTest.Ques; i++) {
//				
//			}
//			String allString = 
			//JOptionPane.showInputDialog("write Q number");
			
		}
//	    public void display_tests() {
//			for (int i = 0; i < tests.size(); i++) {
//				System.out.println( i + "---");
//				tests.get(i).print_test_Questions();
//			}
//		}
	    public void cloneTest(Integer numOfTest) throws CloneNotSupportedException {
	    	Test test = tests.get(numOfTest-1).clone();
	    	tests.add(test);
	    	AddTestToEventListener(tests.size());
			
		}
//	    public ArrayList<Question> createManualyTest(int [] arr) {
//	    	ArrayList<Question> pickList = new ArrayList<Question>();
//			for (int i=0; i<arr.length; i++) {
//				//pickList.add(main_system.getQuestion(Integer.parseInt(s.nextLine().strip())));
//				pickList.add(this.getQuestion(arr[i]));
//			}
//			return pickList;
//		}
	    public void sortByAnswers() {
	    	this.tests.get(tests.size()-1).sortTest(new CompareQuestionsByAnswerLength());
		}
	    
	 //   public void read_Binary_File() throws IOException,FileNotFoundException, ClassNotFoundException {
	   // 	  ObjectInputStream infile = new ObjectInputStream(new FileInputStream("C:\\Users\\tomer\\eclipse-workspace\\Stam2\\questions.txt"));
	     // 	ArrayList<Question> questions = (ArrayList<Question>)infile.readObject();
	      	
	      	
//	      	for (int i = 0; i < questions.size(); i++) {
//	      		if(questions.get(i) instanceof RegularQuestion)
//	      			this.questions.AddQ_R(questions.get(i).text, String A)
//				this.questions.add(questions.get(i));
//			}
//	      	System.out.println("Read questions: " + questions.size());
	      	//Question question = (Question)infile.readObject();
	      	
	      //	this.questions.addAll(questions);
	      //	infile.close();
	    //}
	    public void read_Binary_File() throws IOException,FileNotFoundException, ClassNotFoundException {
	    ObjectInputStream infile = new ObjectInputStream(new FileInputStream("C:\\Users\\tomer\\eclipse-workspace\\2022B\\questions.txt"));
	    ArrayList<Question> questions = (ArrayList<Question>)infile.readObject();
	    this.questions.addAll(questions);
	    infile.close();
	    }
	    public void save_Binary_File()throws IOException,FileNotFoundException, ClassNotFoundException {
	    	ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("C:\\Project TMA\\TMA\\questions.txt"));
	    	//outfile.writeObject(this.questions);
	    	outfile.writeObject(this.questions);
	    	outfile.close();
	    }
	    
	    public void display_test_with_answers(){
	    	this.tests.get(this.tests.size()-1).print_test_Questions_And_Answers();
	    }
	    public void display_test_only_questions(){
	    	this.tests.get(this.tests.size()-1).print_test_Questions();
	    }
	    
	    public void save_main_with_answers_toFile(File f) throws IOException,FileNotFoundException {
	    	this.tests.get(this.tests.size()-1).save_test_with_answers_to_text_file(f);
	    }
	    
	    public void save_main_only_questions(File f) throws IOException,FileNotFoundException{
	    	this.tests.get(this.tests.size()-1).save_test_only_questions_to_test_file(f);
	    }
	    
		public void display(){
			for (int i = 0; i < questions.size(); i++) {
				System.out.println(String.format("%d) %s", 
						i, questions.get(i).toString()));
			}
	    }
		public void addTestManually(int [] arr) {
			ArrayList<Question> pickList = new ArrayList<Question>();
			for (int i=0; i<arr.length; i++) {
				pickList.add(this.getQuestion(arr[i]));
			}
			addTest(new Test(pickList));
			AddTestToEventListener(tests.size());
		} 
		public void addTestRandom(int pick) {
		    tests.add(Test.pick(this.questions, pick));
		   // AddTestToEventListener(tests.get(this.tests.size()));
		    AddTestToEventListener(tests.size());
		} 
		public void AddTestToEventListener(int id) {
			for (MainSystemEventListener l : AllQuestionsListeners) {
				l.Add_Test_ToControllerFromModelEvent(id);
			}
		}
	    public int AddQ_R(String Q, String A) {
	    	this.questions.add(new RegularQuestion(Q, A));
	    	
	    	AddRegularQuestionToEventListener(Q,A,this.questions.size()-1);
	    	
	    	return this.questions.size();
	    }
	    
	    private void AddRegularQuestionToEventListener(String Q, String A,int id) {
			for (MainSystemEventListener l : AllQuestionsListeners) {
				l.AddQ_R_ToControllerFromModelEvent(Q,A,id);
			}
		}
	    
	    public int AddQ_M(String Q, String A,String isCorrectString) {
	    	String t = "true";
			boolean IsTrue = true;
			
	    	MultiQuestion q = new MultiQuestion(Q);
	    	if ((isCorrectString.equals(t))){
	    		q.add_answer(A, IsTrue);
	    	}
	    	else {
	    		q.add_answer(A, !IsTrue);	
			}
	    	this.questions.add(q);
	    	AddMultipleQuestionToEventListener(Q,A,questions.size()-1, isCorrectString);
	    	return this.questions.size();
	    }
	    public void AddMultipleQuestionToEventListener(String Q, String A,int id,String isCorrectString) {
	    	for (MainSystemEventListener l : AllQuestionsListeners) 
				l.AddQ_M_ToControllerFromModelEvent(Q,A,id,isCorrectString);
	    }
	    
	    public boolean AddAnswer(int QID, String answer, String is_correct){
	    	String t = "true";
			boolean IsTrue = true;
	    	MultiQuestion q = (MultiQuestion)questions.get(QID);
	    	
	    	if ((is_correct.equals(t))){
	    		q.add_answer(answer, IsTrue);
	    	}
	    	else {
	    		q.add_answer(answer, !IsTrue);	
			}
	 
	    	FireAddAnswerToEvent(answer,QID,q.answersLength()-1,is_correct); 
	        return true;
	    }
	    
	    public void FireAddAnswerToEvent(String answer, int QID,int AID, String is_correct) {
			for(MainSystemEventListener l : AllQuestionsListeners)
	    		l.AddM_Answer_ToControllerFromModelEvent(answer,QID,AID,is_correct);
		}
	    
	    public void removeQuestion(int i){
			Question QuestionToRemove = getQuestion(i);
			this.questions.remove(QuestionToRemove);
			fireRemoveQuestionEvent(QuestionToRemove, i);
		}

	    public Question getQuestion(int i) {
	    	return questions.get(i);
	    }
	    private void fireRemoveQuestionEvent(Question Q, int i) {
	    	for(MainSystemEventListener l : AllQuestionsListeners)
	    		l.Remove_Question_FromModelEvent(i);
		}
	    public MultiQuestion getMultiQuestion(int i) {
	    	return (MultiQuestion) questions.get(i);
	    }
	    public RegularQuestion getRegularQuestion(int i) {
	    	return (RegularQuestion) questions.get(i);
	    }
	   
	    
	    
	   
	    public void addTest(Test t) {
	    	tests.add(t);
	    }
	   

		
		 
		public void save_Text_File ()throws IOException ,ClassNotFoundException,NotSerializableException {
			DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("uuuu/MM/dd");
			LocalDate localDate = LocalDate.now();
			String date = currentDate.format(localDate);  
			String newDate = date.replace("/", "_");
			String ktobet1E = "/Users/omriamsalem/exam_";
			String ktobet1S = "/Users/omriamsalem/solution_";
			String ktobet2 = ".txt";
			String ktobetStringS = ktobet1E + newDate + ktobet2;
			String ktobetStringE = ktobet1S + newDate + ktobet2;
				
			File fE = new File(ktobetStringE);
			fE.createNewFile();
			save_main_with_answers_toFile(fE);
			File fS = new File(ktobetStringS);
			fS.createNewFile();
			save_main_only_questions(fS);
		 }
		public void editRQuestion(String question, int id) {
	    	Question q = getQuestion(id);
			q.setText(question);
			FireEditRegularQuestionToEvent(question,id);
	    }
		public void FireEditRegularQuestionToEvent(String question, int id) {
			for(MainSystemEventListener l : AllQuestionsListeners)
	    		l.Edit_RQuestion_FromModelEvent(question,id);
		}
		public void editMAnswer(String answer, int id){
			Question q = getQuestion(id);
			RegularQuestion rq = (RegularQuestion) q;
			rq.setAnswer(answer);
			FireEditRegularAnswerToEvent(answer,id);
	    }
		
		public void editRAnswer(String answer, int id) {
			Question q = getQuestion(id);
			RegularQuestion rq = (RegularQuestion) q;
			rq.setAnswer(answer);
			FireEditRegularAnswerToEvent(answer,id);
	    }
		public void FireEditRegularAnswerToEvent(String answer, int id) {
			for(MainSystemEventListener l : AllQuestionsListeners)
	    		l.Edit_RAnswer_FromModelEvent(answer,id);
		}
		
		

		public Question removeQuestionFromUI(int i) {
			//Remove_Question_ToUI(i);
			
			Question QuestionToRemove = getQuestion(i);
	    	questions.remove(i);
	    	//fireRemoveQuestionEvent(QuestionToRemove);
	    	return QuestionToRemove;
	    }

	  
//		public Question getQuestionById(int id) {
//		for (Question q : questions) {
//			if (q.getId() == id)
//				return p;
//		}
//		return null;
//	} 
}
