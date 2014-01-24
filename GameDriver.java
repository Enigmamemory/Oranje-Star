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
    private static int redmoney;
    private static int bluemoney;

    public GameDriver(){
	turn = 1;
	gameOver = false;
	isr = new InputStreamReader(System.in);
	in = new BufferedReader(isr);
	side = "Red";
	redmoney = 1000;
	bluemoney = 1000;
    }

    //-----------Methods--------------

    public static void playTurn(Grid Field) {

	int xgiven=0;
	int ygiven=0;
	String endturn = "";
	String current = side;

	//state what # turn it is and which side is in control.
	System.out.println("It is turn " + turn + ". " + current + "'s turn.");

        if (side.equals("Red"))
	    redmoney += Field.turngain("Red");
	else
	    bluemoney += Field.turngain("Blue");

	//begin actions one can take:
	while (current.equals(side)){
	    System.out.println(Field);
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
			    System.out.println(Field);
			    System.out.println(Field.Status(xgiven,ygiven));
			    if (Field.Board[xgiven][ygiven].Fodder != null) {
				Unit selected = Field.Board[xgiven][ygiven].Fodder;
				int choice = 0;
				System.out.println("Move unit or attack with unit? Type 1 to move, 2 to attack.");
				try {
				    choice = Integer.parseInt(in.readLine());
				}
				catch(IOException e){}
				if (choice == 1){
				    int move = 0;
				    if (selected.movespace <= 0)
					System.out.println("This unit cannot move any more spaces.");
				    else {
					System.out.println("Type 1 to move up, 2 to move left, 3 to move down, and 4 to move right.");
					try {
					    move = Integer.parseInt(in.readLine());
					}
					catch(IOException e){}					
					if (move == 1)
					    Field.moveup(selected);
					else{
					    if (move == 2)
						Field.moveleft(selected);
					    else {
						if (move == 3)
						    Field.movedown(selected);
						else{
						    if (move == 4)
							Field.moveright(selected);
						    else
							System.out.println("Cannot register command. Returning to beginning.");
						}
					    }
					}
				    }
				}
				else {				    
				    if (choice == 2){
					int xattack = 0;
					int yattack = 0;
					if (selected.moved == true)
					    System.out.println("This unit attacked already");
					else {
					    System.out.println(Field);
					    System.out.println("Choose x coordinate:");
					    try {
						xattack = Integer.parseInt(in.readLine());
					    }
					    catch( IOException e) {}
					    if (xattack >= Field.Board[0].length){
						System.out.println("xcor given does not fit in the map.");
					    }
					    else {
						System.out.println("Choose y coordinate:");
						try {
						    yattack = Integer.parseInt(in.readLine());
						}
						catch(IOException e){}
						if (yattack >= Field.Board.length){
						    System.out.println("ycor given does not fit in the map.");
						}
						else{
						    if (Field.Board[xattack][yattack].Fodder != null && Field.Board[xattack][yattack].Fodder.side != selected.side){
							Unit target = Field.Board[xattack][yattack].Fodder;
							System.out.println(selected.getUnit() + " attacks " + target.getUnit());
							Field.attack(selected,target);
							if (Field.Board[xattack][yattack].Fodder != null){
							    System.out.println(target.getUnit() + " attacks " + selected.getUnit());  
							    Field.attack(target,selected);
							}
						    }
						    else {
							System.out.println("There is no enemy unit to attack there.");
						    }
						}
					    }
					}
				    }
				    else {
					System.out.println("Cannot register command. Returning to beginning.");
				    }
				}
			    }
			    else {
				if (Field.Board[xgiven][ygiven].Floor.candeploy == true && Field.Board[xgiven][ygiven].Floor.side.equals(current)){
				    String deployment = ""
				    System.out.println("Deploy unit? Type yes to deploy");
				    try {
					deployment = in.readLine();
				    }
				    catch( IOException e) {}
				    if (deployment = "yes"){
					String buy = "Type the number corresponding to the unit to deploy it.";
					if (Field.Board[xgiven][ygiven].Floor.getTerrain().equals("Fctory")){
					}
				    }   
				}
			    }
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
