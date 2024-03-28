package model;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class MultiQuestion extends Question implements Serializable{
	
	private Set<MultiQAnswer> answers = new Set<>();
	
	public MultiQuestion(String text) {
		super(text);
	}
	
	public int answersLength() {
		return this.answers.size();
	}
	public int answerLen() {
		int len = 0;
		for (MultiQAnswer answer : answers.items()) {
			len += answer.length();
		}
		return len;
	}
	public void add_answer(String Text, boolean isCorret) { 
		this.answers.add(new MultiQAnswer(Text, isCorret));
	}
	public void del_answer(int i) {
		this.answers.remove(i);
	}
	public void edit_answer(int i, String new_text) {
		this.answers.get(i).setAnswer(new_text);
	}
	
	public String toString() {
		String res=String.format("Question: %s\n", this.getText());
		for (int i = 0; i < this.answers.size(); i++) {
			MultiQAnswer ans = answers.get(i);
			res += String.format("%d\t%s\n", 
					i, ans.toString());
		}
		return res;
	}
	public void save_M_Q_with_answers(String Question,PrintWriter printWriter, int i) {
		printWriter.print(i);
		printWriter.print(")");
		printWriter.println(Question);
		for (int j = 0; j < answers.size(); j++) {
		answers.get(i).save_M_Q_A_With_IsCorrecr(printWriter, i);
		}
	}
	public void save_M_Q_only_questions(String Question,PrintWriter printWriter, int i) {
		printWriter.print(i);
		printWriter.print(")");
		printWriter.println(Question);
		for (int j = 0; j < answers.size(); j++) {
		answers.get(i).save_M_Q_A_no_IsCorrecr(printWriter, i);
		}
	}
	public void display_question() {
		System.out.println(String.format("Question: %s", this.getText()));
		for(int i = 0; i < this.answers.size();i++) {
			answers.get(i).diaplay_without_indication();
	}
		System.out.println("Answer: none of the above");
		System.out.println("Answer: more than one correct answer");
    }
	
	@Override
	public void display() {
		System.out.println(this.toString());
	}
	

//	@Override
//	public int compareTo(MultiQObj o) {
//    	if (return_Length_All_Answers() < o.return_Length_All_Answers()) {
//			return -1;
//		}
//		if (return_Length_All_Answers() > o.return_Length_All_Answers()) {
//			return 1;
//		}
//		else {
//			return 0;
//		}
//	}
//    
//    private int return_Length_All_Answers() {
//    	int sum = 0;
//		for (int i = 0; i < MQA.size(); i++) {
//			sum += MQA.get(i).getAnswer().length();
//		}
//		return sum;
//	}
//    public void save_M_Q (PrintWriter printWriter, int i) {
//		printWriter.print(i);
//		printWriter.print(")");
//		printWriter.println(Question);
//		save_M_Q_A(printWriter);
//	}
//    public void save_M_Q_A(PrintWriter printWriter) {
//        for (int i = 0; i < MQA.size();i++) 
//        	if (MQA.get(i) != null)
//        		MQA.get(i).save_M_Q_A_Without_IsCorrecr(printWriter,i);
//    }
//    

//    public void save_M_Q_A_With_A(PrintWriter printWriter) {
//        for (int i = 0; i < MQA.size();i++) 
//        	if (MQA.get(i) != null)
//        		MQA.get(i).save_M_Q_A_With_IsCorrecr(printWriter,i);
//    }
//    
//   
//    
//    
//    public MultiQObj(){
//
//    }
//    
//    public MultiQObj(String Q, int index){
//        this.Question = Q;
//        this.MQA = new ArrayList<MultiQAnswer>();
//        this.index = index;
//    }
//    
//    public void setQuestion(String question) {
//        Question = question;
//    }
//    
//    public void pickQuestion(int index) {
//    	for (Integer i = 0; i < MQA.size(); i++) {
//    		if ((i + 1) == index) 
//    			System.out.println(i.toString() +":  "+ ":Answer " + this.MQA.get(i).getAnswer() );
//    	}
//    }
//    
//    
//
//    public String getQuestion() {
//        return this.Question;
//    }
//
//    public MultiQAnswer get_answer(int index){
//        return this.MQA.get(index);
//    }
//
//    public int getAnswers_size() {
//        return this.MQA.size();
//    }
//    public void getAnswers() {
//        Integer idx = 0;
//        for (int i = 0; i < MQA.size();i++) {
//            System.out.println("\t"+idx.toString() + ": " + "Answer: " + MQA.get(i).getAnswer() + " Is correct: " + MQA.get(i).getCorrect());
//            idx++;
//        }
//    }
//    
//    public void getAnswers_Without_Indication() {
//        Integer idx = 0;
//        for (int i = 0; i < MQA.size();i++) {
//            System.out.println("\t"+idx.toString() + ": " + "Answer: " + MQA.get(i).getAnswer());
//            idx++;
//        }
//    }
//   
//    public void setMQA(String answer, Boolean is_correct) {
//        this.MQA.add(new MultiQAnswer(answer,is_correct));
//    }
//
//    public boolean UpdateA(String Answer,String new_ANswer){
//    	 for (int i = 0; i < this.MQA.size(); i++) {
//    		 if(Answer == this.MQA.get(i).getAnswer()){
//    			 this.MQA.get(i).setAnswer(new_ANswer);
//    			 return true;
//    		 }
//    	 }
//    	 return false;
//    }
//    
//    
//    public void DeleteA(Integer Aindex, String new_ANswer){
//        this.MQA.get(Aindex).setAnswer(new_ANswer);
//    }
//
//	public int getIndex() {
//		return index;
//	}
	
}
