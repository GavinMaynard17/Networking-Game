package finalGame;

public class Answer {
	boolean correct;
	String answer;
	
	public Answer(String answer, boolean correct) {
		this.answer = answer;
		this.correct = correct;
	}
	
	public boolean isCorrect() {
		return correct;
	}
	
	public String toString() {
		return answer;
	}
}
