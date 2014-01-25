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
					if (choice == 3){
					    if (Field.Board[xgiven][ygiven].Floor.candeploy == true){
						if (!Field.Board[xgiven][ygiven].Floor.side.equals(current)){
						    Field.capture(Field.Board[xgiven][ygiven].Fodder);
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
				if (Field.Board[xgiven][ygiven].Floor.candeploy == true && Field.Board[xgiven][ygiven].Floor.side.equals(current)){
				    String deployment = "";
				    System.out.println("Deploy unit? Type yes to deploy");
				    try {
					deployment = in.readLine();
				    }
				    catch( IOException e) {}
				    if (deployment.equals("yes")){
					int choose = 0;
					String buy = "Type the number corresponding to the unit to deploy it.\n";
					if (Field.Board[xgiven][ygiven].Floor.getname().equals("Fctory")){
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
						Field.spawnfact(redmoney, xgiven, ygiven, choose);
					    if (current.equals("Blue"))
						Field.spawnfact(bluemoney, xgiven, ygiven, choose);
					}
					if (Field.Board[xgiven][ygiven].Floor.getname().equals("AirPrt")){
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
	
	Grid Field = new Grid(10,10);

	while (gameOver != true){
	    playTurn(Field);
	    if (side.equals("Red"))
		gameOver = true;
	}

	System.out.println("Everything seems to be working");

    }

}
