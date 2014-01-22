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
    }
    public void moveup (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	x.setycoord(ycoor + 1);
	Board[xcoor][ycoor + 1].setUnit(x);
	Board[xcoor][ycoor] = null;
    }
    public void moveleft (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	x.setxcoord(xcoor - 1);
	Board[xcoor - 1][ycoor].setUnit(x);
	Board[xcoor][ycoor] = null;
    }

    public void moveright (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	x.setxcoord(xcoor + 1);
	Board[xcoor + 1][ycoor].setUnit(x);
	Board[xcoor][ycoor] = null;
    }

    public void movedown (Unit x){
	int xcoor = x.getxcoord();
	int ycoor = x.getycoord();
	x.setycoord(ycoor - 1);
	Board[xcoor][ycoor + 1].setUnit(x);
	Board[xcoor][ycoor] = null;
    }
    public void attack (Unit x, Unit y){
	int xdiff = Math.abs((x.getxcoord() - y.getxcoord()));
	int ydiff = Math.abs((x.getycoord() - y.getycoord()));
	int diff = xdiff + ydiff;
	if (diff <= x.getmaxrange() && diff >= x.getminrange()){
	    int dmg = x.getAttack();
	    y.setHP(y.getHP() - dmg);
	}
	else {
	    System.out.println("Unit not in Range");
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
		    all += "      ";
	    }
	    all = all.substring(0,all.length()-1);
	    all += "\n";
	}
	return all;
    }
}
