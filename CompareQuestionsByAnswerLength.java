package model;

import java.util.Comparator;

public class CompareQuestionsByAnswerLength implements Comparator<Question>{

	@Override
	public int compare(Question question1, Question question2) {
		
		if (question1.answerLen() < question2.answerLen()) {
			return -1;
		}
		if (question1.answerLen() > question2.answerLen()) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
