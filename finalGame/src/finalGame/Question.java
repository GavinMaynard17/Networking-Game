package finalGame;
import java.util.ArrayList;

public class Question {
	ArrayList<Answer> answers = new ArrayList<Answer>();
	int points;
	String question;
	
	public Question(String question, int value) {
		this.question = question;
		this.points = value;
	}
	
	public void addAnswer(String answer, boolean correct) {
		Answer selection = new Answer(answer, correct);
		answers.add(selection);
	}
	
	public Answer getAns(int i) {
		return answers.get(i-1);
	}
	//returns the answer being tested, usually for correctness
	
	public int getValue() {
		return points;
	}
	//gets the value of specific question
	
	public String strPoints() {
		return String.valueOf(points);
	}
	//returns the points in a string to display the board
	
	public String toString() {
		String q = question + "\n";
		
		int num = 1;
		for(int i=0; i<answers.size(); i++) {
			q+= String.valueOf(num) + ": " + answers.get(i).toString() + "\n";
			num++;
		}
		
		return q;
	}
	//This will display the question along with the answers
	
	
}
