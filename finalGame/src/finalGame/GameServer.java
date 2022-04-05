package finalGame;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.*;


public class GameServer {
	private static final int PORT = 4040;

	public static void main(String [] args) throws IOException {
		GameBoard board = new GameBoard();
		int numOfRounds = board.numQuestions();
		int roundNum = 1;
		//create board, calculate rounds
		
		
		
		System.out.println(board.toString());
		System.out.println("There are " + numOfRounds + " rounds." + "\n");
		//display board to server so I can make sure 
		//the board looks good before game starts
		
		//int tCatNum = 2;
		//int tValue = 200;
		//int tAns = 3;
		//System.out.println(board.printQ(tCatNum, tValue));//test print question with answers
		//System.out.println(board.testAns(tCatNum, tValue, tAns) + "\n");//test print determining correctness of answer
		//board.removeQuestion(tCatNum, tValue);//test for removing a question
		
		ServerSocket listener = new ServerSocket(PORT);
		System.out.println("Waiting for clients to connect...");
		Socket client = listener.accept();
		System.out.println("Client connected!");
		
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);//output to client
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));//clients' input
        
        Player player = new Player(in.readLine());//first line the client will send will be the name
        //Player player = new Player(ip or port or something idk)
        
		board.addPlayer(player);
		
		Player selector = player;//this is for later
		selector.setAnswerer(true);
		
		// let people connect
		//MAKING PROGRAM ONLY ALLOW 1 PERSON, WILL ADJUST TO 3 PLAYERS LATER
			//need 3 people to connect before stop accepting
			//keep track of 3 people by when they joined
			//want them to be able to set their name
		
		out.println(numOfRounds);//so that client knows number of rounds
		
		while(numOfRounds > 0) {
			
			out.println("Enter the category # and then the point value you wish to attempt. \n");//should only do this for the person answering, maybe set a variable for the players name?
			out.println(player.getName() + " is selecting the question \n"); //goes to everyone else
			out.println(board.toString());
			out.println(board.currentPoints());//current point standings
		
				
				//when i move to multiple players, the input lines only go to selector
			int catNum = Integer.parseInt(in.readLine()); //category the client chooses
			Category roundCat = board.getCategory(catNum); //gets the category the client choses
			int pValue = Integer.parseInt(in.readLine()); //point value the client chooses
			
			out.println(roundCat.getName() + " for " + pValue + "\n");//tells category and point value
			out.println(board.printQ(catNum, pValue)); //prints the question and answers
			
					//when i move to multiple players, i need to find our how to do a "ring in" function
					//client.println("Enter 'R' to ring in to attempt to answer");
					//start a timer, need to figure this out
					//Player ringer = *whoever ringed*
					
			out.println("Please enter the number corresponding to your answer. \n");//when i move to multiple players, only to ringer
			out.println(player.getName() + " is attempting to answer \n");//to everyone else
			//if time runs out
				//out.println("You ran out of time!");
				//player.clearPoints;
				
			//else { 
				int cAns = Integer.parseInt(in.readLine()); //the number for the client's answer
				if(board.testAns(catNum, pValue, cAns)){
					out.println("You got the answer right! \n \n \n");
					player.addPoints(pValue);
				} else {
					out.println("You got the answer wrong! \n \n \n");
					player.clearPoints();
				}
		
			board.removeQuestion(catNum, pValue);//removes question
			
			if(roundCat.getNum() == 0) {
				board.removeCategory(roundCat);
			}//if a category has no quesitons, remove it
			
			numOfRounds--;
			System.out.println("round " + roundNum + " has completed");
		}
		
		
		
		
		out.println("Game Over!" + "\n" + "Thank you for playing!!");
		out.println(board.leaderboard());
		
		client.close();
		listener.close();
		//close server
	}
}

