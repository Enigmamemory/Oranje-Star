public class Grid {
    int Length;
    int Width;
    Boxes [][] Board;
    
    Grid(){
        Length = 1; Width = 1;
        Board = new Boxes [Length][Width]; 
    }
    Grid(int x, int y){
        Length = x; Width = y;
        Board = new Boxes [Length][Width];
    }
    public String toString() {
        String all = "";
        for (int x = 0; x < Board.length ; x++){
	    for (int y = 0 ; y < Board[x].length ; y++){
		all += Board[x][y];
	    }
	}
	return all;
    }
}
