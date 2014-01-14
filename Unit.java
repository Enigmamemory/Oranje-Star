public abstract class Unit{
    boolean moved;
    int movespace;
    int attack;
    int HP;
    int def;
    int mimrange;
    int maxrange;
    int xcoord;
    int ycoord;
    String name;
    
    Unit(){
      movespace = 1;attack = 1; HP = 10; def = 1; minrange = 1; maxrange = 1;
      name = "Rookie";
    }
    public int [] move(){
      int [] coordinate = new int [2];
      coordinate[0] = xcoord; coordinate[1] = ycoord;
      ;
      return 
    }
    
