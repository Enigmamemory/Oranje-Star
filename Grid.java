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
        Board = new Boxes [Width][Length];
	for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
		Board[x][y] = new Boxes();
	    }
	}
    }
    Grid(int c){
    	Length = 20; Width = 20;
        Board = new Boxes [Length][Width];
	for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
		Board[x][y] = new Boxes();
	    }
	}
    }
    Grid(String fill){
	Length = 11; Width = 25;
	Board = new Boxes[Width][Length];
	for (int x = 0; x < Board.length ; x++){
	    for (int y = 0; y < Board[x].length; y++){
		Board[x][y] = new Boxes();
		Board[x][y].Floor.changePlain();
	    }
	}
	Board[0][4].Floor.changeCity("Blue");
	Board[0][6].Floor.changeCity("Blue");
	Board[24][4].Floor.changeCity("Red");
	Board[24][6].Floor.changeCity("Red");
	Board[3][2].Floor.changeCity("Neutral");
	Board[3][8].Floor.changeCity("Neutral");
	Board[21][2].Floor.changeCity("Neutral");
	Board[21][8].Floor.changeCity("Neutral");
	Board[7][10].Floor.changeCity("Neutral");
	Board[11][0].Floor.changeCity("Neutral");
	Board[11][4].Floor.changeCity("Neutral");
	Board[13][4].Floor.changeCity("Neutral");
	Board[11][6].Floor.changeCity("Neutral");
	Board[13][4].Floor.changeCity("Neutral");
	Board[1][3].Floor.changeFactory("Blue");
	Board[1][7].Floor.changeFactory("Blue");
	Board[23][3].Floor.changeFactory("Red");
	Board[23][7].Floor.changeFactory("Red");
	Board[8][5].Floor.changeFactory("Neutral");
	Board[16][5].Floor.changeFactory("Neutral");
	Board[13][5].Floor.changeAirport("Neutral");
	Board[0][5].Floor.changeHeadquarter("Blue");
	Board[24][5].Floor.changeHeadquarter("Red");
    }	
    public boolean hasHQ(String side){
	for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
	    	Terrain a = Board[x][y].Floor; 
		if (a.getname().equals("HQ    ") && a.getside().equals(side)){
			return true;
		} 
	    }
	}
	return false;	
    }
    public boolean hasnounits(String side){
	for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
		if (Board[x][y].getUnit() != null){
		    if (Board[x][y].Fodder.side.equals(side))
			return false;
		}
	    }
	}
	return true;
    }   
    	
    public void Place(Unit a, int x, int y) {
	Board[x][y].Fodder = a;
	a.setxcoord(x);a.setycoord(y);
    }
    public int turngain(String side){
    	int total = 0;
	for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
		if (Board[x][y].getTerrain().getside().equals(side)){
		    total += Board[x][y].getTerrain().getmoney();
		}
	    }    
	}
	return total;
    }
    public String Status(int x, int y){
    	String all = "";
    	all += "Terrain: ";
    	all += Board[y][x].Floor.getname();
	if (Board[y][x].Fodder != null)
	    all += Board[y][x].Fodder.getInfo();
	else
	    all += "\n";
    	return all;
    }
    public void setDefaultMove(){
	for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
	    	if (Board[x][y].Fodder != null){
	    		Board[x][y].Fodder.setmovespace(Board[x][y].Fodder.defaultmove);
	    	}
	    }
	}
    }
    public void moveup (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	int movetake = Board[xcoor - 1][ycoor].getTerrain().getmovetake(x);
	if (x.moved()){
		System.out.println("This unit has attacked already");
	}
	else if (x.getmovespace() - movetake < 0){
		System.out.println("This unit does not have enough move");
	}
	else if (Board[xcoor - 1][ycoor].getUnit() != null){
		System.out.println("There is already a unit there");
	}
	else{
		x.setxcoord(xcoor - 1);
		x.setmovespace(x.getmovespace() - movetake);
		Board[xcoor - 1][ycoor].setUnit(x);
		Board[xcoor][ycoor].setUnit(null); 
	}
    }
    public void moveleft (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	int movetake = Board[xcoor][ycoor - 1].getTerrain().getmovetake(x);
	if (x.moved()){
		System.out.println("This unit has attacked already");
	}
	else if (x.getmovespace() - movetake < 0){
		System.out.println("This unit does not have enough move");
	}
	if (Board[xcoor][ycoor - 1].getUnit() != null){
		System.out.println("There is already a unit there");
	}
	else{
		x.setycoord(ycoor - 1);
		x.setmovespace(x.getmovespace() - movetake);
		Board[xcoor][ycoor - 1].setUnit(x);
		Board[xcoor][ycoor].setUnit(null);
	}
    }

    public void moveright (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	int movetake = Board[xcoor][ycoor + 1].getTerrain().getmovetake(x);
	if (x.moved()){
		System.out.println("This unit has attacked already");
	}
	else if (x.getmovespace() - movetake < 0){
		System.out.println("This unit does not have enough move");
	}
	if (Board[xcoor][ycoor + 1].getUnit() != null){
		System.out.println("There is already a unit there");
	}
	else{
		x.setycoord(ycoor + 1);
		x.setmovespace(x.getmovespace() - movetake);
		Board[xcoor][ycoor + 1].setUnit(x);
		Board[xcoor][ycoor].setUnit(null);
	}
    }

    public void movedown (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	int movetake = Board[xcoor + 1][ycoor].getTerrain().getmovetake(x);
	if (x.moved()){
		System.out.println("This unit has attacked already");
	}
	else if (x.getmovespace() - movetake < 0){
		System.out.println("This unit does not have enough move");
	}
	if (Board[xcoor + 1][ycoor].getUnit() != null){
		System.out.println("There is already a unit there");
	}
	else{
		x.setxcoord(xcoor + 1);
		x.setmovespace(x.getmovespace() - movetake);
		Board[xcoor + 1][ycoor].setUnit(x);
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
	    int block = y.getDefense() + Board[y.getxcoord()][y.getycoord()].getTerrain().getdefenseinc();
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
    	if (x.gettiretype().equals("Foot") || x.name.equals("Bike  ")){
	    int xcoor = x.getxcoord();
	    int ycoor = x.getycoord();
	    if (Board[xcoor][ycoor].getTerrain().cancapture == true && Board[xcoor][ycoor].getTerrain().side != (x.side)){
    		Board[xcoor][ycoor].getTerrain().setcapturerate(Board[xcoor][ycoor].getTerrain().getcapturerate() - 1);
	    }
	    else
		System.out.println("This terrain cannot be captured");
    	}
    	else {
    		System.out.println("Only Footmen can capture stuff");
    	}
    }	

    public void deploy (int money, Unit guy, int x, int y){
	if (Board[x][y].Floor.candeploy == true){
	    if (Board[x][y].Fodder == null){
		if (guy.cost < money)
		    Place(guy,x,y);
		else
		    System.out.println("Don't have enough money to deploy this unit");
	    }
	    else
		System.out.println("Unit occupying terrain, cannot deploy");
	}
	else
	    System.out.println("Terrain cannot deploy units");
    }
    public void spawnfact(int money, int x, int y, int z){
	if (Board[x][y].getTerrain().getname().equals("Fctory")){
	    if (z < 1 || z > 12){
		System.out.println("Enter a number that represents a unit.");
	    }
	    if (z == 1){
		Unit a = new Unit();
		a.changeInfantry();
		deploy(money, a, x, y);
	    }
	    if (z == 2){
		Unit a = new Unit();
		a.changeMech();
		deploy(money, a, x, y);
	    }
	    if (z == 3){
		Unit a = new Unit();
		a.changeBike();
		deploy(money, a, x, y);
	    }
	    if (z == 4){
		Unit a = new Unit();
		a.changeRecon();
		deploy(money, a, x, y);
	    }
	    if (z == 5){
		Unit a = new Unit();
		a.changeAntiAirTank();
		deploy(money, a, x, y);
	    } 
	    if (z == 6){
		Unit a = new Unit();
		a.changeLightTank();
		deploy(money, a, x, y);
	    }
	    if (z == 7){
		Unit a = new Unit();
		a.changeMediumTank();
		deploy(money, a, x, y);
	    }
	    if (z == 8){
		Unit a = new Unit();
		a.changeWarTank();
		deploy(money, a, x, y);
	    }
	    if (z == 9){
		Unit a = new Unit();
		a.changeArtillery();
		deploy(money, a, x, y);
	    }
	    if (z == 10){
		Unit a = new Unit();
		a.changeAntiTank();
		deploy(money, a, x, y);
	    }
	    if (z == 11){
		Unit a = new Unit();
		a.changeRocketLauncher();
		deploy(money, a, x, y);
	    }
	    if (z == 12){
		Unit a = new Unit();
		a.AntiAirMissileLauncher();
		deploy(money, a, x, y);
	    }
	}
    }
    public void spawnair(int money, int x, int y, int z){
	if (Board[x][y].getTerrain().getname().equals("AirPrt")){
	    if (z < 1 || z > 4){
		System.out.println("Enter a number that represents a unit.");
	    }
	    if (z == 1){
		Unit a = new Unit();
		a.changeFighter();
		deploy(money, a, x, y);
	    }
	    if (z == 2){
		Unit a = new Unit();
		a.changeBomber();
		deploy(money, a, x, y);
	    }
	    if (z == 3){
		Unit a = new Unit();
		a.changeDuster();
		deploy(money, a, x, y);
	    }
	    if (z == 4){
		Unit a = new Unit();
		a.changeBattleHelicopter();
		deploy(money, a, x, y);
	    }
	}
    }
    
    public String toString() {
        String all = "";
        for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
		all += Board[x][y].Floor + " ";
	    }
	    all = all.substring(0,all.length()-1);
	    all += "\n";
	    for (int z = 0 ; z < Board[x].length ; z++){
		if (Board[x][z].Fodder != null)
		    all += Board[x][z].Fodder + " ";
		else
		    all += "       ";
	    }
	    all = all.substring(0,all.length()-1);
	    all += "\n";
	}
	return all;
    }
}
