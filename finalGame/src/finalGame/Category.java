package finalGame;
import java.util.ArrayList;

public class Category {
	ArrayList<Question> questions = new ArrayList<Question>();
	String name;
	
	public Category(String name) {
		this.name = name;
	}
	
	public void addQuestion(String question, int value) {
		Question q = new Question(question, value);
		questions.add(q);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNum() {
		return questions.size();
	}
	
	public Question getQuestion(int i) {
		return questions.get(i);
	}
	//the server uses the index to get a specific question that it needs, only used in GameBoard.java
	
	public Question fromValue(int value) {
		for(int i=0; i<questions.size(); i++) {
			if(questions.get(i).getValue() == value)
				return questions.get(i);
		}
		
		return null;
	}
	//gets a question based on the player's points value they wish to attempt
	
	public void remove(Question q) {
		for(int i=0; i<questions.size(); i++) {
			if(questions.get(i) == q) {
				questions.remove(i);
			}
		}
	}
	//removes question from the category
	
	public String getQuestions() {
		String qList = "";
		for(int i=0; i<questions.size(); i++) {
			qList += questions.get(i).strPoints() + " ";
		}
		return qList;
	}
	//prints the point value of each available questions
	
	
	
}
