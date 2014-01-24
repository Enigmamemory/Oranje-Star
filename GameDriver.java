import java.io.*;
import java.util.*;

public class GameDriver{
    
    //Well, it's best if I comment so I don't get lost. This represent how many turns past. One turn constitutes both red and blue team passing.
    public static int turn;

    //Game Over boolean
    private static boolean gameOver;

    //This was in YoRPG, I don't dare not include these, even though I'm not sure what they are.
    private static InputStreamReader isr;
    private static BufferedReader in;

    //keeps track whose turn it is
    private static String side;

    public GameDriver(){
	turn = 1;
	gameOver = false;
	isr = new InputStreamReader(System.in);
	in = new BufferedReader(isr);
	side = "Red";
    }

    //-----------Methods--------------

    public static void playTurn(Grid Field) {

	int xgiven=0;
	int ygiven=0;
	String endturn = "";
	String current = side;

	//state what # turn it is and which side is in control.
	System.out.println("It is turn " + turn + ". " + current + "'s turn.");

	//check turn side, add money here

	//begin actions one can take:
	while (current.equals(side)){
	    System.out.println("Pass turn? Type yes or no");
	    try {
		endturn = in.readLine();
	    }
	    catch(IOException e){}
	    if (endturn.equals("yes")) {
		System.out.println(current + " passes turn");
		if (current.equals("blue")){
		    turn += 1;
		}
		pass();
	    }
	    else {
		if (endturn.equals("no")){
		    System.out.println("Choose x coordinate:");
		    try {
			xgiven = Integer.parseInt(in.readLine());
		    }
		    catch( IOException e) {}
		    if (xgiven >= Field.Board[0].length){
		    System.out.println("xcor given does not fit in the map.");
		    }
		    else {
			System.out.println("Choose y coordinate:");
			try {
			    ygiven = Integer.parseInt(in.readLine());
		    }
			catch(IOException e){}
			if (ygiven >= Field.Board.length){
			    System.out.println("ycor given does not fit in the map.");
			}
			else {
			    System.out.println(Field.Status(xgiven,ygiven));
			}
		    }
		}
		else {
		    System.out.println("Cannot register command. Returning to beginning.");
		}
	    }
	}

    }
   

    //switches orientation of turn
    public static void pass() {
	if (side.equals("Red")){
	    side = "Blue";
	}
	else
	    side = "Red";
    }

    public static void main (String[] args) {

	GameDriver game = new GameDriver();
	
	Grid Field = new Grid(10,10);

	while (gameOver != true){
	    playTurn(Field);
	    if (side.equals("Red"))
		gameOver = true;
	}

	System.out.println("Everything seems to be working");

    }

}
