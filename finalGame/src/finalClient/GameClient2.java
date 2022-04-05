package finalClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class GameClient2 {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 4040;

	public static void main(String [] args) throws IOException {
		Socket socket = new Socket(SERVER_IP, SERVER_PORT);
		//set up connection details
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//server input
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));//keyboard input
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);//output to server
		
		
		System.out.println("What is your name? ");
		
		out.println(keyboard.readLine());//should send the name
		
		//enter round 1
		
		int numOfRounds = Integer.parseInt(in.readLine());
		int roundNum = 1;
		//boolean answerer = false;?
		
		while (numOfRounds > 0){
			System.out.println("Round " + roundNum + ":");
			
			while(in.ready()) {
				System.out.println(in.readLine());
			}//should print initial details of a round, the selector, the board, and the current points
			
			out.println(keyboard.readLine());//catNum
			
			out.println(keyboard.readLine());//pValue
				
			while(in.ready()) {
				System.out.println(in.readLine());
			}
			//this will display the question and answer (WHY NO WORK!!!!!)
		
			out.println(keyboard.readLine());//cAns
		
			while(in.ready()) {
				System.out.println(in.readLine());
			}//either "___ got it right!", "___ got it wrong!", "you got it right!", or "you got it wrong!"
			
			numOfRounds--;	
			roundNum++;
		}//game over
		
		while(in.ready()) {
			System.out.println(in.readLine());
		}//leaderboard
		
		socket.close();
	}
}
