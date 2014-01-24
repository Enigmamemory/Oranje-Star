public class Unit{
    protected boolean moved;
    protected int movespace;
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
    	movespace = 3;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 1500;tiretype = "Foot";
    	name = "Inftry"; protected String goodagainst;
    }
    public void changeMech(){
    	movespace = 2;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 2500;tiretype = "Foot";
    	name = "Mech  "; protected String goodagainst;
    }
    public void changeBike(){
    	movespace = 5;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 2500;tiretype = "Foot";
    	name = "Bike  "; protected String goodagainst;
    }
    public void changeRecon(){
    	movespace = 8;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 4000;tiretype = "Foot";
    	name = "Recon "; protected String goodagainst;
    }
    public void changeFlare(){
    	movespace = 5;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 5000;tiretype = "Foot";
    	name = "Flare "; protected String goodagainst;
    }
    public void changeAntiAirTank(){
    	movespace = 6;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 7000;tiretype = "Foot";
    	name = "AtArTk"; protected String goodagainst;
    }
    public void changeLightTank(){
    	movespace = 6;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 7000;tiretype = "Foot";
    	name = "LghtTk"; protected String goodagainst;
    }
    public void changeMediumTank(){
    	movespace = 5;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 12000;tiretype = "Foot";
    	name = "MedTnk"; protected String goodagainst;
    } 
    public void changeWarTank(){
    	movespace = 4;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 16000;tiretype = "Foot";
    	name = "WarTnk"; protected String goodagainst;
    }
    public void changeArtillery(){
    	movespace = 5;attack = 1;HP = 10;defense = 1;minrange = 2;maxrange = 3;cost = 6000;tiretype = "Foot";
    	name = "Artlry"; protected String goodagainst;
    }    
    public void changeAntiTank(){
    	movespace = 4;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 3;cost = 11000;tiretype = "Foot";
    	name = "AntiTk"; protected String goodagainst;
    }
    public void changeRocketLauncher(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 3;maxrange = 5;cost = 15000;tiretype = "Foot";
    	name = "RktLch"; protected String goodagainst;
    }
    public void AntiAirMissileLauncher(){
    	movespace = 5;attack = 1;HP = 10;defense = 1;minrange = 3;maxrange = 6;cost = 12000;tiretype = "Foot";
    	name = "ArArML"; protected String goodagainst;
    }
    public void changeFighter(){
    	movespace = 9;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 20000;tiretype = "Foot";
    	name = "Fighter"; protected String goodagainst;
    }
    public void changeBomber(){
    	movespace = 7;attack = 1;HP = 10;defense = 1;minrange = 0;maxrange = 1;cost = 20000;tiretype = "Foot";
    	name = "Bomber"; protected String goodagainst;
    }
    public void changeDuster(){
    	movespace = 8;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;cost = 1;tiretype = "Foot";
    	name = "Duster"; protected String goodagainst;
    }
    public void changeBattleHelicopter(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;cost = 1;tiretype = "Foot";
    	name = "BtlHcp"; protected String goodagainst;
    }
    public void changeSeaplane(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;cost = 1;tiretype = "Foot";
    	name = "Seapln"; protected String goodagainst;
    }
    public void changeTransportHelicopter(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;cost = 1;tiretype = "Foot";
    	name = "TrnHcp"; protected String goodagainst;
    }    
    public String getUnit(){
	return name;
    }
    public String getInfo(){
    	String all = "" + name;
    	all += movespace + "\n";all += attack + "\n";all += HP + "\n";all += defense + "\n";
    	all += minrange + "\n";all += maxrange + "\n"; all += side;
    	return all;
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
    public int getmaxrange(){
	return maxrange;
    }
    public int getminrange(){
	return minrange;
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
