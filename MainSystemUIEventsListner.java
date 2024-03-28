package listner;

public interface MainSystemUIEventsListner {
	
	public void AddQ_R_FromUI(String Q, String A);
	public void AddQ_M_FromUI(String Q, String A, String IsCorrect);
	public void Add_Answer_FromUI(int QID, String answer, String IsCorrect);
	public void Remove_Regular_Question_FromUI(int i) ;
	public void Remove_Multiple_Question_FromUI(int id);
	public void Edit_RQuestion_FromUI(String question,int id);
	public void Edit_MAnswer_FromUI(String answer,int id);
	public void Edit_RAnswer_FromUI(String answer,int id);
	public void Create_Random_Test_From_Ui_ByNumber(String id); 
	public void Create_Manual_Test_From_Ui_ByNumber(int []arr); 
	public void Show_Test_FromUI(int id);
	public void Copy_Test_FromUI(int id);
	public void Read_FromBinary();
}
