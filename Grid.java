public class Grid {
    int Length;
    int Width;
    Boxes [][] Board;
    
    Grid(){
        Length = 1; Width = 1;
        Board = Boxes [Length][Width]; 
    }
    Grid(int x, int y){
        Length = x; Width = y;
        Board = Boxes [Length][Width]
    }
  }
