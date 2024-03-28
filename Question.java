package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Question implements Serializable, Cloneable, Comparable<Question> {
	String text;
	private static int idGenerator = 0;
	private int id;
	
	public Question(String text) {
		this.text = text;
		this.id = idGenerator++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public abstract void display();
	public abstract int answerLen();

	
	@Override 
	public Question clone() throws CloneNotSupportedException {
		Question cloned = (Question) super.clone(); 
		return cloned;
	}
	
	@Override
	public int compareTo(Question o) {
		return this.answerLen() - o.answerLen();
	}
	
}
