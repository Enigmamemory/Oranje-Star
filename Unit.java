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
    protected String name;
    
    Unit(){
	movespace = 1;attack = 1; HP = 10; defense = 1; minrange = 1; maxrange = 1;
	name = "Rookie";
    }
    Unit(int ms,int att, int H, int def,int min,int max,int x, int y, String N){
	movespace = ms; attack = att; HP = H;
	defense = def; minrange = min; maxrange = max;
	xcoord = x; ycoord = y;
	name = N;
    }
    public int [] move(){
	int [] coordinate = new int [2];
	coordinate[0] = xcoord; coordinate[1] = ycoord;
	return coordinate; 
    }
    public String getUnit(){
	return name;
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
