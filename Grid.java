public class Grid {
    protected int Length;
    protected int Width;
    Boxes [][] Board;
    
    Grid(){
        Length = 2; Width = 2;
        Board = new Boxes [Length][Width]; 
	for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
		Board[x][y] = new Boxes();
	    }
	}
    }
    Grid(int a, int b){
        Length = a; Width = b;
        Board = new Boxes [Length][Width];
	for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
		Board[x][y] = new Boxes();
	    }
	}
    }
    public void Place(Unit a, int x, int y) {
	Board[x][y].Fodder = a;
	a.setxcoord(x);a.setycoord(y);
    }
    public String Status(int x, int y){
    	String all = "";
    	all += "Terrain: ";
    	all += Board[x][y].Floor.getname();
	if (Board[x][y].Fodder != null)
	    all += Board[x][y].Fodder.getInfo();
	else
	    all += "\n";
    	return all;
    }
    public void setDefaultMove(){
	for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
	    	if (Board[x][y].Fodder != null){
	    		Board[x][y].Fodder.setmovespace(Fodder.defaultmove());
	    	}
	    }
	}
    }
    public void moveup (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	int movetake = Board[xcoor][ycoor - 1].getTerrain.getmovetake(x);
	if (x.getmoved()){
		System.out.println("This unit has attacked already");
	}
	else if (x.getmovespace() - movetake <= 0){
		System.out.println("This unit does not have enough move");
	}
	else if (Board[xcoor][ycoor - 1].getUnit() == null){
		System.out.println("There is already a unit there");
	}
	else{
		x.setycoord(ycoor - 1);
		x.setmovespace(x.getmovespace - movetake);
		Board[xcoor][ycoor - 1].setUnit(x);
		Board[xcoor][ycoor].setUnit(null); 
	}
    }
    public void moveleft (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	int movetake = Board[xcoor - 1][ycoor.getTerrain.getmovetake(x);
	if (x.getmoved()){
		System.out.println("This unit has attacked already");
	}
	else if (x.getmovespace() - movetake <= 0){
		System.out.println("This unit does not have enough move");
	}
	if (Board[xcoor - 1][ycoor].getUnit() == null){
		System.out.println("There is already a unit there");
	}
	else{
		x.setxcoord(xcoor - 1);
		x.setmovespace(x.getmovespace - movetake);
		Board[xcoor - 1][ycoor].setUnit(x);
		Board[xcoor][ycoor].setUnit(null);
	}
    }

    public void moveright (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	int movetake = Board[xcoor + 1][ycoor.getTerrain.getmovetake(x);
	if (x.getmoved()){
		System.out.println("This unit has attacked already");
	}
	else if (x.getmovespace() - movetake <= 0){
		System.out.println("This unit does not have enough move");
	}
	if (Board[xcoor + 1][ycoor].getUnit() == null){
		System.out.println("There is already a unit there");
	}
	else{
		x.setxcoord(xcoor + 1);
		x.setmovespace(x.getmovespace - movetake);
		Board[xcoor + 1][ycoor].setUnit(x);
		Board[xcoor][ycoor].setUnit(null);
	}
    }

    public void movedown (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	int movetake = Board[xcoor][ycoor + 1].getTerrain.getmovetake(x);
	if (x.getmoved()){
		System.out.println("This unit has attacked already");
	}
	else if (x.getmovespace() - movetake <= 0){
		System.out.println("This unit does not have enough move");
	}
	if (Board[xcoor][ycoor + 1].getUnit() == null){
		System.out.println("There is already a unit there");
	}
	else{
		x.setycoord(ycoor + 1);
		x.setmovespace(x.getmovespace - movetake);
		Board[xcoor][ycoor + 1].setUnit(x);
		Board[xcoor][ycoor].setUnit(null);
	}
    }
    /*
    public Unit[] cantarget (Unit x){

	int xdiff = Math.abs((x.getxcoord() - y.getxcoord()));
	int ydiff = Math.abs((x.getycoord() - y.getycoord()));
	int diff = xdiff + ydiff;
	

    }
    */
    public void attack (Unit x, Unit y){
	int xdiff = Math.abs((x.getxcoord() - y.getxcoord()));
	int ydiff = Math.abs((x.getycoord() - y.getycoord()));
	int diff = xdiff + ydiff;
	if (diff <= x.getmaxrange() && diff >= x.getminrange()){
	    String type1 = x.getgoodagainst(); String type2 = y.gettiretype();
	    int troops = x.getHP();int dmg = x.getAttack();
	    int block = y.getDefense() + Board[y.getxcoord()][y.getycoord()].getTerrain.getdefenseinc();
	    if (type1.equals(type2)){
	    	if (type1.equals("Foot")){
	    		dmg += 1;
	    	}
	    	if (type1.equals("Tank")){
	    		dmg *= 2;
	    	}
	    	if (type1.equals("Air")){
	    		dmg += 4;
	    	}
	    }
	    dmg -= 10 - troops;
	    int dmgdealt = dmg - block;
	    if (dmgdealt > 0){
	    	y.setHP(y.getHP() - dmg);
	    }
	    x.setmoved(true);
	}
	else {
	    System.out.println("Unit not in Range");
	}
    }
    public void capture (Unit x){
    	int xcoor = x.getxcoord();
    	int ycoor = x.getycoord();
    	Board[xcoor][ycoor].getTerrain().setcapturerate(Board[xcoor][ycoor].getTerrain().getcapturerate() - 1);
    }	

    public void deploy (Unit guy, int x, int y){
	if (Board[x][y].Floor.candeploy == true){
	    if (Board[x][y].Fodder == null){
		Place(guy,x,y);
	    }
	    else
		System.out.println("Unit occupying terrain, cannot deploy");
	}
	else
	    System.out.println("Terrain cannot deploy units");
    }

    public String toString() {
        String all = "";
        for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
		all += Board[y][x].Floor + " ";
	    }
	    all = all.substring(0,all.length()-1);
	    all += "\n";
	    for (int z = 0 ; z < Board[x].length ; z++){
		if (Board[z][x].Fodder != null)
		    all += Board[z][x].Fodder + " ";
		else
		    all += "      ";
	    }
	    all = all.substring(0,all.length()-1);
	    all += "\n";
	}
	return all;
    }
}
