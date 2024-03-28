package model;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class RegularQuestion extends Question implements Serializable{
    
	private String Answer;
	
	public RegularQuestion(String text) {
		super(text);
	}
	public RegularQuestion(String text, String answer) {
		super(text);
		this.setAnswer(answer);
		
	}
	
	public String getAnswer() {
		return Answer;
	}
	
	public void setAnswer(String answer) {
		Answer = answer;
	}
	
	
	@Override
	public int answerLen() {
		return this.Answer.length();
	}
	
	
	public String toString() {
		return String.format("Question: %s - Answer: %s",
				this.getText(), this.getAnswer());
	}
	@Override
	public void display() {
		System.out.println(toString());
	}
	
	public String displayRe() {
		return toString();
	}
	public void display_question() {
		System.out.println(String.format("Question: %s", this.getText()));
    }
	
	
	public void save_R_Q_with_answers(String Question,PrintWriter printWriter, int i) {
		printWriter.print(i);
		printWriter.print(")");
		printWriter.println(Question);
		printWriter.println(Answer);
	}
	public void save_R_Q(String Question,PrintWriter printWriter, int i) {
		printWriter.print(i);
		printWriter.print(")");
		printWriter.println(Question);
	}
			
//	public void sort() {
//	Collections.sort(MyQs);
//}
//

//public void pickQuestion(int index) {
//	for (Integer i = 0; i < MyQs.size(); i++) {
//		if ((i + 1) == index) 
//			System.out.println(Integer.toString(i) + "Question: " + MyQs.get(i).getQuestion() + " Answer: " + MyQs.get(i).getAnswer());
//	}
//}  		
//    
//    public boolean equals(String q, RegularQObj question) {
//        if (q == question.getQuestion()){
//            return true;
//        }
//        return false;
//    }
//
//   



}
