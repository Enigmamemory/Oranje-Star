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
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "Inftry";
    }
    public void changeMech(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "Mech  ";
    }
    public void changeBike(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "Bike  ";
    }
    public void changeRecon(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "Recon ";
    }
    public void changeFlare(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "Flare ";
    }
    public void changeAntiAirTank(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "AtArTk";
    }
    public void changeLightTank(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "LghtTk";
    }
    public void changeMediumTank(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "MedTnk";
    }
    public void changeWarTank(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "WarTnk";
    }
    public void changeArtillery(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "Artlry";
    }    
    public void changeAntiTank(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "AntiTk";
    }
    public void changeRocketLauncher(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "RktLch";
    }
    public void AntiAirMissileLauncher(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "ArArML";
    }
    public void changeRig(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "Rig   ";
    }
    public void changeFighter(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "Fighter";
    }
    public void changeBomber(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "Bomber";
    }
    public void changeDuster(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "Duster";
    }
    public void changeBattleHelicopter(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "BtlHcp";
    }
    public void changeSeaplane(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "Seapln";
    }
    public void changeTransportHelicopter(){
    	movespace = 1;attack = 1;HP = 10;defense = 1;minrange = 1;maxrange = 1;
    	name = "TrnHcp";
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
