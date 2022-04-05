package finalGame;
import java.util.ArrayList;

public class GameBoard {
	ArrayList<Category> categories = new ArrayList<Category>();
	ArrayList<Player> players = new ArrayList<Player>();
	
	public GameBoard() {
		//cat 1
		Category cat1 = new Category("Science");
		categories.add(cat1);
			cat1.addQuestion("Which of the following is used in pencils? ", 100);
				cat1.getQuestion(0).addAnswer("Silicon", false);
				cat1.getQuestion(0).addAnswer("Graphite", true);
				cat1.getQuestion(0).addAnswer("Charcoal", false);
				cat1.getQuestion(0).addAnswer("Phosphorous", false);
			cat1.addQuestion("The chemical formula for water is: ", 200);
				cat1.getQuestion(1).addAnswer("CO2", false);
				cat1.getQuestion(1).addAnswer("H2O2", false);
				cat1.getQuestion(1).addAnswer("H20", true);
				cat1.getQuestion(1).addAnswer("NaCl", false);
			cat1.addQuestion("The gas usually filled in an electric bulb is: ", 300);
				cat1.getQuestion(2).addAnswer("Nitrogen", true);
				cat1.getQuestion(2).addAnswer("Hydrogen", false);
				cat1.getQuestion(2).addAnswer("Carbon Dioxide", false);
				cat1.getQuestion(2).addAnswer("Oxygen", false);
			cat1.addQuestion("Brass gets discolored in air because of the presence of which of the "
					+ "following gasses? ", 400);
				cat1.getQuestion(3).addAnswer("Oxygen", false);
				cat1.getQuestion(3).addAnswer("Hydrogen sulphide", true);
				cat1.getQuestion(3).addAnswer("Nitrogen", false);
				cat1.getQuestion(3).addAnswer("Carbon Dioxide", false);
			cat1.addQuestion("Quartz crystals normally used in quartz clocks etc. is chemically... ", 500);
				cat1.getQuestion(4).addAnswer("Sodium silicate", false);
				cat1.getQuestion(4).addAnswer("Silicon dioxide", true);
				cat1.getQuestion(4).addAnswer("Sodium chloride", false);
				cat1.getQuestion(4).addAnswer("Germanium oxide", false);
		//cat 2
		Category cat2 = new Category("Literature");
		categories.add(cat2);
			cat2.addQuestion("What is a comparison of two things while using 'like' or 'as'? ", 100);
				cat2.getQuestion(0).addAnswer("Analogy", false);
				cat2.getQuestion(0).addAnswer("Smile", false);
				cat2.getQuestion(0).addAnswer("Metaphore", false);
				cat2.getQuestion(0).addAnswer("Simile", true);
			cat2.addQuestion("The contrast is between the literal meaning of what is said and what is "
					+ "meant is called... ", 200);
				cat2.getQuestion(1).addAnswer("Verbal irony", true);
				cat2.getQuestion(1).addAnswer("Analogy", false);
				cat2.getQuestion(1).addAnswer("Paradox", false);
				cat2.getQuestion(1).addAnswer("Juxtaposition", false);
			cat2.addQuestion("A device in literature where an object represents an idea is... ", 300);
				cat2.getQuestion(2).addAnswer("Narrator", false);
				cat2.getQuestion(2).addAnswer("Parody", false);
				cat2.getQuestion(2).addAnswer("Symbolism", true);
				cat2.getQuestion(2).addAnswer("Theme", false);
				
		Category cat3 = new Category("Guessing Game");
		categories.add(cat3);
			cat3.addQuestion("Feeling lucky? Choose the right one", 100);
				cat3.getQuestion(0).addAnswer("Good Luck", true);
				cat3.getQuestion(0).addAnswer("Good Luck", true);
				cat3.getQuestion(0).addAnswer("Good Luck", false);
				cat3.getQuestion(0).addAnswer("Good Luck", false);
				cat3.getQuestion(0).addAnswer("Good Luck", true);
				cat3.getQuestion(0).addAnswer("Good Luck", true);
				cat3.getQuestion(0).addAnswer("Good Luck", false);
				cat3.getQuestion(0).addAnswer("Good Luck", true);
			cat3.addQuestion("Feeling lucky? Choose the right one", 200);
				cat3.getQuestion(1).addAnswer("Good Luck", false);
				cat3.getQuestion(1).addAnswer("Good Luck", true);
				cat3.getQuestion(1).addAnswer("Good Luck", false);
				cat3.getQuestion(1).addAnswer("Good Luck", true);
				cat3.getQuestion(1).addAnswer("Good Luck", false);
				cat3.getQuestion(1).addAnswer("Good Luck", true);
				cat3.getQuestion(1).addAnswer("Good Luck", true);
				cat3.getQuestion(1).addAnswer("Good Luck", false);
			cat3.addQuestion("Feeling lucky? Choose the right one", 300);
				cat3.getQuestion(2).addAnswer("Good Luck", true);
				cat3.getQuestion(2).addAnswer("Good Luck", false);
				cat3.getQuestion(2).addAnswer("Good Luck", false);
				cat3.getQuestion(2).addAnswer("Good Luck", true);
				cat3.getQuestion(2).addAnswer("Good Luck", false);
				cat3.getQuestion(2).addAnswer("Good Luck", true);
				cat3.getQuestion(2).addAnswer("Good Luck", false);
				cat3.getQuestion(2).addAnswer("Good Luck", false);
			cat3.addQuestion("Feeling lucky? Choose the right one", 400);
				cat3.getQuestion(3).addAnswer("Good Luck", false);
				cat3.getQuestion(3).addAnswer("Good Luck", true);
				cat3.getQuestion(3).addAnswer("Good Luck", false);
				cat3.getQuestion(3).addAnswer("Good Luck", true);
				cat3.getQuestion(3).addAnswer("Good Luck", false);
				cat3.getQuestion(3).addAnswer("Good Luck", false);
				cat3.getQuestion(3).addAnswer("Good Luck", false);
				cat3.getQuestion(3).addAnswer("Good Luck", false);
			cat3.addQuestion("Feeling lucky? Choose the right one", 500);
				cat3.getQuestion(4).addAnswer("Good Luck", false);
				cat3.getQuestion(4).addAnswer("Good Luck", false);
				cat3.getQuestion(4).addAnswer("Good Luck", false);
				cat3.getQuestion(4).addAnswer("Good Luck", false);
				cat3.getQuestion(4).addAnswer("Good Luck", false);
				cat3.getQuestion(4).addAnswer("Good Luck", true);
				cat3.getQuestion(4).addAnswer("Good Luck", false);
				cat3.getQuestion(4).addAnswer("Good Luck", false);
		
		
			
	}
	//this is me brute forcing the making of the board
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	//adds players to the players list
	
	public int numQuestions() {
		int num=0;
		for(int i=0; i<categories.size(); i++) {
			num+=categories.get(i).getNum();
		}
		return num;
	}
	//gets the number of total questions which tells how many rounds there are
	
	public int numCat() {
		return categories.size();
	}
	
	public Category getCategory(int index) {
		return categories.get(index-1);
	}
	
	public Question getQuestion(int index, int value) {
		return categories.get(index-1).fromValue(value);
	}
	//gets question
	
	public String printQ(int index, int value) {
		return categories.get(index-1).fromValue(value).toString();
	}
	
	public boolean testAns(int index, int value, int ans) {
		return categories.get(index-1).fromValue(value).getAns(ans).isCorrect();
	}
	
	public void removeQuestion(int index, int value) {
		categories.get(index-1).remove(categories.get(index-1).fromValue(value));
	}
	
	public void removeCategory(Category c) {
		categories.remove(c);
	}
	
	public String toString() {
		String printBoard = "";
		int num = 1;
		for (int i=0; i<categories.size(); i++) {
			printBoard+= num + ": " + categories.get(i).getName()
					+ ": " + categories.get(i).getQuestions() + "\n";
			num++;
		}
		return printBoard;
	}
	//prints a list of all categories and quesitons for each respective category
	
	public String leaderboard() {
		String leader = "Leaderboard:" + "\n";
		//sortPlayers();//this will adjust the original players list
		int num=1;
		for(int i=0; i<players.size(); i++) {
			leader+=String.valueOf(num)+": ";//displays position
			leader+=players.get(i).getName()+": ";//displays name
			leader+=String.valueOf(players.get(i).getPoints()) + " points" + "\n";//displays points
			num++;
		}
		return leader;
		
	}
	
	//public void sortPlayers() {
		//ArrayList<Player> newList = new ArrayList<>();
		
		
		//players = newList;
	//}
	
	public String currentPoints() {
		String points = "Current Points" + "\n";
		
		for(int i=0; i<players.size(); i++) {
			points += players.get(i).getName() + ": " + players.get(i).printPoints() + "\n";
		}
		
		return points;
	}
	//will be used to show current points after each round, will not be sorted
}
