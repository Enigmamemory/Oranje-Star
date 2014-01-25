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

    //keeps track of defeat
    private static boolean redlose;
    private static boolean bluelose;

    public GameDriver(){
	turn = 1;
	gameOver = false;
	isr = new InputStreamReader(System.in);
	in = new BufferedReader(isr);
	side = "Red";
	redmoney = 1000;
	bluemoney = 1000;
	newGame();
    }

    //-----------Methods--------------

    public static void newGame(){

	int start = 0;
	String intro = "Welcome to Summoner's Rif - I mean, the glorious battlefield of Advance Wars!\n\n";
	intro += "We're still experiencing technical difficulties,\n";
	intro += "so the only option we can change to your needs is the starting monies \n";
	intro += "between the two sides. Enter your desired starting value here:";
	System.out.println(intro);
	try{
	    start = Integer.parseInt(in.readLine());
	}
	catch(IOException e){};
	if (start >= 0){
	    System.out.println("Alright, let's get this game started.");
	    redmoney = start;
	    bluemoney = start;
	}
	else {
	    System.out.println("Eh? What's this? No matter, we already have default start for you.");
	}
    }
	    

    public static void playTurn(Grid Field) {

	int xgiven=0;
	int ygiven=0;
	String endturn = "";
	String current = side;

	//state what # turn it is and which side is in control.
	System.out.println("It is turn " + turn + ". " + current + "'s turn.");

	//Each turn, the side gets money equal to 1000 x the number of buildings they control.
        if (side.equals("Red"))
	    redmoney += Field.turngain("Red");
	else
	    bluemoney += Field.turngain("Blue");

	//begin actions one can take:
	while (current.equals(side)){
	    System.out.println("Pass turn? Type yes or no");
	    try {
		endturn = in.readLine();
	    }
	    catch(IOException e){}
	    //Only way to exit loop: This changes the side, rendering the while useless.
	    //This also makes it the prime site to declare victory conditions.
	    if (endturn.equals("yes")) {
		System.out.println(current + " passes turn");
		if (current.equals("blue")){
		    turn += 1;
		}
		pass();
		if (!Field.hasHQ(current)){
		    if (current.equals("Red"))
			redlose = true;
		    if (current.equals("Blue"))
			bluelose = true;
		    gameOver = true;
		}
		if (Field.hasnounits(current) && turn >= 5){
		    if (current.equals("Red"))
			redlose = true;
		    if (current.equals("Blue"))
			bluelose = true;
		    gameOver = true;
		}
	    }
	    else {
		if (endturn.equals("no")){
		    System.out.println(Field);
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
			    if (Field.Board[ygiven][xgiven].Fodder != null) {
				Unit selected = Field.Board[ygiven][xgiven].Fodder;
				int choice = 0;
				System.out.println("Move unit, attack with unit, or capture with unit? Type 1 to move, 2 to attack, 3 to capture.");
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
						    if (Field.Board[yattack][xattack].Fodder != null && Field.Board[yattack][xattack].Fodder.side != selected.side){
							Unit target = Field.Board[yattack][xattack].Fodder;
							System.out.println(selected.getUnit() + " attacks " + target.getUnit());
							Field.attack(selected,target);
							if (Field.Board[yattack][xattack].Fodder != null){
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
					if (choice == 3){
					    if (Field.Board[ygiven][xgiven].Floor.cancapture == true){
						if (!Field.Board[ygiven][xgiven].Floor.side.equals(current)){
						    Field.capture(Field.Board[ygiven][xgiven].Fodder);
						}
						else
						    System.out.println("You already control this building.");
					    }
					    else {
						System.out.println("There is no building to capture here.");
					    }
					}
					else{
					    System.out.println("Cannot register command. Returning to beginning.");
					}
				    }
				}
			    }
			    else {
				if (Field.Board[ygiven][xgiven].Floor.candeploy == true && Field.Board[ygiven][xgiven].Floor.side.equals(current)){
				    String deployment = "";
				    System.out.println("Deploy unit? Type yes to deploy");
				    try {
					deployment = in.readLine();
				    }
				    catch( IOException e) {}
				    if (deployment.equals("yes")){
					int choose = 0;
					String buy = "Type the number corresponding to the unit to deploy it.\n";
					if (Field.Board[ygiven][xgiven].Floor.getname().equals("Fctory")){
					    buy += "1. Infantry - 1500\n";
					    buy += "2. Mech - 2500\n";
					    buy += "3. Bike - 2500\n";
					    buy += "4. Recon - 4000\n";
					    buy += "5. Anti-Air - 7000\n";
					    buy += "6. Light Tank - 7000\n";
					    buy += "7. Medium Tank - 12000\n";
					    buy += "8. War Tank - 16000\n";
					    buy += "9. Artillery - 6000\n";
					    buy += "10. Anti-Tank - 11000\n";
					    buy += "11. Rockets - 15000\n";
					    buy += "12. Missile - 12000";
					    System.out.println(buy);
					    try {
						choose = Integer.parseInt(in.readLine());
					    }
					    catch(IOException e){}
					    if (current.equals("Red"))
						Field.spawnfact(redmoney, ygiven, xgiven, choose);
					    if (current.equals("Blue"))
						Field.spawnfact(bluemoney, ygiven, xgiven, choose);
					}
					if (Field.Board[ygiven][xgiven].Floor.getname().equals("AirPrt")){
					    buy += "1. Fighter - 20000\n";
					    buy += "2. Bomber - 20000\n";
					    buy += "3. Duster - 13000\n";
					    buy += "4. Battlecopter - 9000\n";
					    System.out.println(buy);
					    try {
						choose = Integer.parseInt(in.readLine());
					    }
					    catch(IOException e){}
					    if (current.equals("Red"))
						Field.spawnair(redmoney, xgiven, ygiven, choose);
					    if (current.equals("Blue"))
						Field.spawnair(bluemoney, xgiven, ygiven, choose);
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
	
	Grid Field = new Grid("blargh");

	while (gameOver != true){
	    Field.setDefaultMove();	
	    playTurn(Field);
	}

	if (redlose == true && bluelose == true)
	    System.out.println("Oh, dear...you must've tried to make this a draw.");
	else{
	    if (redlose == true)
		System.out.println("Blue wins!");
	    if (bluelose == true)
		System.out.println("Red wins!");
	}

	System.out.println("Everything seems to be working");

    }

}
