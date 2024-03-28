package listner;

public interface MainSystemEventListener {
		public void AddQ_R_ToControllerFromModelEvent( String Q, String A,int id);
	    public void AddQ_M_ToControllerFromModelEvent(String Q, String A,int id, String isCorrectString);
	    public void AddM_Answer_ToControllerFromModelEvent(String answer,int QID,int AID, String is_correct) ;
	    public void Remove_Question_FromModelEvent(int i);
	    public void Edit_RQuestion_FromModelEvent(String question,int i);
	    public void Edit_RAnswer_FromModelEvent(String answer,int i);
	    public void Add_Test_ToControllerFromModelEvent(int id);
	    
}
