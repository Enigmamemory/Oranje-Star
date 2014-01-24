public class Unit{
    protected boolean moved;
    protected int movespace;
    protected int defaultmove;
    protected int attack;
    protected int HP;
    protected int defense;
    protected int minrange;
    protected int maxrange;
    protected int xcoord;
    protected int ycoord;
    protected int cost;
    protected String goodagainst;
    protected String tiretype;
    protected String side;
    protected String name;
    
    Unit(){
	movespace = 1;attack = 1; HP = 10; defense = 1; minrange = 1; maxrange = 1;
	name = "Rookie"; side = "neutral";
    }
    Unit(int ms,int att, int H, int def,int min,int max,int x, int y, String N, String color){
	movespace = ms; attack = att; HP = H;
	defense = def; minrange = min; maxrange = max;
	xcoord = x; ycoord = y;
	name = N; side = color;
    }
    public int [] move(){
	int [] coordinate = new int [2];
	coordinate[0] = xcoord; coordinate[1] = ycoord;
	return coordinate; 
    }
    public void changeInfantry(){
    	defaultmove = 3;attack = 2;HP = 10;defense = 0;minrange = 0;maxrange = 1;cost = 1500;tiretype = "Foot";
    	name = "Inftry"; protected String goodagainst = "Foot";
    }
    public void changeMech(){
    	defaultmove = 2;attack = 3;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 2500;tiretype = "Foot";
    	name = "Mech  "; protected String goodagainst = "Foot";
    }
    public void changeBike(){
    	defaultmove = 5;attack = 2;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 2500;tiretype = "Tire";
    	name = "Bike  "; protected String goodagainst = "Foot";
    }
    public void changeRecon(){
    	defaultmove = 8;attack = 2;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 4000;tiretype = "Tire";
    	name = "Recon "; protected String goodagainst = "None";
    }
    public void changeAntiAirTank(){
    	defaultmove = 6;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 7000;tiretype = "Tank";
    	name = "AtArTk"; protected String goodagainst = "Air";
    }
    public void changeLightTank(){
    	defaultmove = 6;attack = 4;HP = 10;defense = 3;minrange = 0;maxrange = 1;cost = 7000;tiretype = "Tank";
    	name = "LghtTk"; protected String goodagainst = "Foot";
    }
    public void changeMediumTank(){
    	defaultmove = 5;attack = 5;HP = 10;defense = 4;minrange = 0;maxrange = 1;cost = 12000;tiretype = "Tank";
    	name = "MedTnk"; protected String goodagainst = "Foot";
    } 
    public void changeWarTank(){
    	defaultmove = 4;attack = 6;HP = 10;defense = 5;minrange = 0;maxrange = 1;cost = 16000;tiretype = "Tank";
    	name = "WarTnk"; protected String goodagainst = "Foot";
    }
    public void changeArtillery(){
    	defaultmove = 5;attack = 5;HP = 10;defense = 2;minrange = 2;maxrange = 3;cost = 6000;tiretype = "Tank";
    	name = "Artlry"; protected String goodagainst = "Foot";
    }    
    public void changeAntiTank(){
    	defaultmove = 4;attack = 5;HP = 10;defense = 2;minrange = 1;maxrange = 3;cost = 11000;tiretype = "Tank";
    	name = "AntiTk"; protected String goodagainst = "Tank";
    }
    public void changeRocketLauncher(){
    	defaultmove = 5;attack = 4;HP = 10;defense = 1;minrange = 3;maxrange = 5;cost = 15000;tiretype = "Tank";
    	name = "RktLch"; protected String goodagainst = "Foot";
    }
    public void AntiAirMissileLauncher(){
    	defaultmove = 5;attack = 1;HP = 10;defense = 2;minrange = 3;maxrange = 6;cost = 12000;tiretype = "Tank";
    	name = "ArArML"; protected String goodagainst = "Air";
    }
    public void changeFighter(){
    	defaultmove = 9;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 20000;tiretype = "Air";
    	name = "Fighter"; protected String goodagainst = "Air";
    }
    public void changeBomber(){
    	defaultmove = 7;attack = 4;HP = 10;defense = 3;minrange = 0;maxrange = 1;cost = 20000;tiretype = "Air";
    	name = "Bomber"; protected String goodagainst = "Tank";
    }
    public void changeDuster(){
    	defaultmove = 8;attack = 6;HP = 10;defense = 2;minrange = 0;maxrange = 1;cost = 13000;tiretype = "Air";
    	name = "Duster"; protected String goodagainst = "Foot";
    }
    public void changeBattleHelicopter(){
    	defaultmove = 6;attack = 2;HP = 10;defense = 2;minrange = 0;maxrange = 1;cost = 9000;tiretype = "Air";
    	name = "BtlHcp"; protected String goodagainst = "Air";
    }
    public String getUnit(){
	return name;
    }
    public String getInfo(){
    	String all = "Name: " + name + "\n";
    	all += "Movespace: " + movespace + "\n";all += "Attack: " + attack + "\n";all += "HP: " + HP + "\n";
    	all += "Defense: " + defense + "\n";all += "Range: " + minrange + " - " + maxrange + "\n";
    	all += "Team: " + side + "\n";all += "MoveType: " + tiretype + "\n";all += "Strength: " + goodagainst + "\n";
    	return all;
    }
    public boolean moved(){
    	return moved;
    }
    public void setmoved(boolean x){
    	moved = x;
    }
    public int getmovespace(){
    	return movespace;
    }
    public void setmovespace(int x){
    	movespace = x;
    }
    public int getxcoord(){
	return xcoord; 
    }
    public int getycoord(){
	return ycoord;
    }
    public int getAttack(){
	return attack;
    }
    public int getDefense(){
    	return defense;
    }
    public int getmaxrange(){
	return maxrange;
    }
    public int getminrange(){
	return minrange;
    }
    public String gettiretype(){
    	return tiretype;
    }
    public String getgoodagainst(){
    	return goodagainst();
    }
    public int setxcoord(int x){
	int xcoor = xcoord;
	xcoord = x;
	return xcoor;
    }
    public int setycoord(int y){
	int ycoor = ycoord;
	ycoord = y;
	return ycoor;
    }
    public int getHP(){
	return HP;
    }
    public void setHP(int x){
	HP = x;
    }

    public String toString(){
	return getUnit();
    }
    
}
