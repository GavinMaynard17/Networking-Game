package finalGame;

public class Player {
	int points;
	//String ip or port or name or whatever i can use
	boolean answerer;
	String name;
	
	public Player(String name) {
		points = 0;
		answerer = false;
		this.name = name;
	}
	
	public void addPoints(int value) {
		points  +=value;
	}
	//if a player gets a question right, give them points
	
	public void clearPoints() {
		points = 0;
	}
	//if a player gets it wrong, clear the points
	
	public int getPoints() {
		return points;
	}
	
	public String getName() {
		return name;//will be changed later to implement a name
	}
	
	public String printPoints() {
		return String.valueOf(points);
	}
	
	public void setAnswerer(boolean res) {
		this.answerer = res;
	}
	
	public boolean isAnswerer() {
		return answerer;
	}
}
