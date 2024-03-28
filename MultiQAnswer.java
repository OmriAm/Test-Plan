package model;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

public class MultiQAnswer implements Serializable, Cloneable{
	 	
		private String Answer;
	    private Boolean IsCorrect;
	    
	    @Override
	    protected MultiQAnswer clone() throws CloneNotSupportedException {
	    // TODO Auto-generated method stub
	    return (MultiQAnswer) super.clone();
	    }
	  
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MultiQAnswer other = (MultiQAnswer) obj;
			if (Answer == null) {
				if (other.Answer != null)
					return false;
			} else if (!Answer.equals(other.Answer))
				return false;
			if (IsCorrect == null) {
				if (other.IsCorrect != null)
					return false;
			} else if (!IsCorrect.equals(other.IsCorrect))
				return false;
			return true;
		}
		
		public void diaplay_without_indication() {
	    	System.out.println(String.format("Answer: %s",this.Answer));
	    }
	    public String toString() {
	    	return String.format("Answer: %s - IsCorrect: %s", 
	    			this.Answer, this.IsCorrect.toString());
	    }
	    public void save_M_Q_A_no_IsCorrecr(PrintWriter printWriter, int i) {
			printWriter.print(i);
			printWriter.print(")");
			printWriter.println(Answer);
		}
	    public void save_M_Q_A_With_IsCorrecr(PrintWriter printWriter, int i) {
			printWriter.print(i);
			printWriter.print(")");
			printWriter.println(Answer);
			printWriter.println(IsCorrect);
		}
	    public MultiQAnswer(){

	    }

	    public MultiQAnswer(String Answer, Boolean IsCorrect){
	        this.Answer = Answer;
	        this.IsCorrect = IsCorrect;
	    }

	    public String getAnswer() {
	        return Answer;
	    }
	    public void setAnswer(String new_Answer) {
	        this.Answer = new_Answer;
	    }

	    public Boolean getCorrect() {
	        return IsCorrect;
	    }

		public int length() {
			return this.Answer.length();
		}
	    
}
