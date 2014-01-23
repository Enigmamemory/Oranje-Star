public class Boxes {
    Terrain Floor;
    Unit Fodder;

    public Boxes(){
	Floor = new Terrain();
	Fodder = null;
    }

    public boolean isUnitThere (){
	return (Fodder.equals(null));
    } 
    public Terrain getTerrain(){
    	return Floor;
    }
    public Unit getUnit (){
    	return Fodder;
    }
    public void setUnit (Unit x){
	Fodder = x;
    }
    public String toString (){
	String rtnstn = Floor.getname();
	return rtnstn;
    }
    /*public void changeUnit(){*/
	
    public static void main (String[] args) {
	Boxes Test = new Boxes();
	System.out.println(Test);
    }
}
