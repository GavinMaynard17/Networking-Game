package finalClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class GameClient {
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
		
		int numOfRounds = in.read();
		//boolean answerer = false;?
		
		while (numOfRounds > 0){
			//in.readLine(); //command that tells specific client if it is answerer?
			//maybe need to have a variable or boolean thing that server tells the client if it is the answerer
			
			System.out.println(in.readLine()); //this will either show "___ is selecting the question" or "Enter the category # and then the point value you wish to attempt."
			System.out.println(in.readLine()); //who is answering quesiton
			System.out.println(in.readLine()); //this will display the board
		
			System.out.println(in.readLine()); //this will display the current points
		
			//if(answerer){
				out.println(keyboard.read());//catNum
				out.println(keyboard.read());//pValue
			//}
		
			System.out.println(in.readLine()); //this will display the question and answer
		
			//this is the points i need to figure out the ringing system
			//maybe like while(!server.receive)?
				//sendto server (input which is the ringer)
				//theoretically once someone rings i can have the server send a packet which will break the loop?
			//server.receive()? //sets answerer again
			System.out.println(in.readLine());//enter answer				need to isolate these two lines for when i get more people
			System.out.println(in.readLine());//who is answering			top line to answerer, bottom to others
			//if(answerer){
				out.println(keyboard.read());//cAns
			//} else {
				//server.receive() //"____ is answering"
			//}
		
			System.out.println(in.readLine());//either "___ got it right!", "___ got it wrong!", "you got it right!", or "you got it wrong!"
			
			numOfRounds--;	
		}
		
		System.out.println(in.readLine());//game over
		System.out.println(in.readLine());//leaderboard
		
		socket.close();
	}
	
	
	
}
