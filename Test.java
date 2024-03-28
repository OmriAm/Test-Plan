package model;

import java.awt.desktop.QuitStrategy;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import javax.swing.JOptionPane;

public class Test implements Cloneable {
	
	private ArrayList<Question> questions = new ArrayList<>();
	
	public Test(List<Question> q) {
		this.questions.addAll(q);
	}
	
	public Test(int num) {
//	    this.num_of_Q = num;
	    	
	}
	
    public static Test pick(ArrayList<Question> q, int pick) {
    	ArrayList<Question> qnew  = (ArrayList<Question>) q.clone();
    	Collections.shuffle(qnew);
    	return new Test(q.subList(0, pick));
//    	return Test(new ArrayList<Question>());
    }
    public void fileBinary()  throws IOException, NotSerializableException, ClassNotFoundException{
    	ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("/Users/omriamsalem/binary.txt"));
    	outFile.writeObject(questions);
		outFile.close();
	}
    @Override
	public Test clone() throws CloneNotSupportedException {
		return (Test) super.clone();
//		ArrayList<Question> tempArrayList = new ArrayList<Question>();
//		tempArrayList = (ArrayList<Question>)questions.clone();
//    	return (Test) super.clone();
	}
    
//    public void sortTest() {
//		Collections.sort(questions);
//	}
    
    public void sortTest(Comparator c) {
		for (int i = questions.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (c.compare(questions.get(j), questions.get(j+1))> 0) {
					Question tmp = questions.get(j);
					questions.set(j,questions.get(j+1));
					questions.set(j+1, tmp);
				}
			}
		}
	}
    public void save_To_arr_test_Questions_And_Answers(){
    	String [] arr = new String[this.questions.size()];
        for (int i = 0; i < this.questions.size(); i++) {
            if (this.questions.get(i) instanceof RegularQuestion)
            	arr[i] =  questions.get(i).toString();
            if (this.questions.get(i) instanceof MultiQuestion)
            	arr[i] = questions.get(i).toString();
        }
       // JOptionPane.showInputDialog(null, arr);
        JOptionPane.showInputDialog(null, "all test questions and answers", "Test", 0, null, arr, arr);
    }
    public void print_test_Questions_And_Answers(){
        for (int i = 0; i < this.questions.size(); i++) {
            if (this.questions.get(i) instanceof RegularQuestion)
            ((RegularQuestion)questions.get(i)).display();
            if (this.questions.get(i) instanceof MultiQuestion)
                ((MultiQuestion)questions.get(i)).display();
        }
    }
    
    public void print_test_Questions(){
    	for (int i = 0; i < this.questions.size(); i++) {
            if (this.questions.get(i) instanceof RegularQuestion)
            ((RegularQuestion)questions.get(i)).display_question();
            if (this.questions.get(i) instanceof MultiQuestion)
                ((MultiQuestion)questions.get(i)).display_question();
        }
    }
    public void save_test_with_answers_to_text_file(File f) throws FileNotFoundException{
		
		PrintWriter pWriter = new PrintWriter(f);
		
		for (int i = 0; i < this.questions.size(); i++) {
            if (this.questions.get(i) instanceof RegularQuestion)
            ((RegularQuestion)questions.get(i)).save_R_Q_with_answers(this.questions.get(i).text, pWriter, i);
            if (this.questions.get(i) instanceof MultiQuestion)
                ((MultiQuestion)questions.get(i)).save_M_Q_with_answers(this.questions.get(i).text,pWriter,i);
        }
		pWriter.close();
	}
	public void save_test_only_questions_to_test_file(File f) throws FileNotFoundException{
			
			PrintWriter pWriter = new PrintWriter(f);
			for (int i = 0; i < this.questions.size(); i++) {
	            if (this.questions.get(i) instanceof RegularQuestion)
	            ((RegularQuestion)questions.get(i)).save_R_Q(this.questions.get(i).text, pWriter, i);
	            if (this.questions.get(i) instanceof MultiQuestion)
	                ((MultiQuestion)questions.get(i)).save_M_Q_only_questions(this.questions.get(i).text,pWriter,i);
	        }
			pWriter.close();
		}
}

