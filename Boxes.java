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
    public String toString (){
	String rtnstn = Floor.getName();
	if (isUnitThere()
    }
    /*ublic void changeUnit(){*/
	
    public static void main (String[] args) {
	Boxes Test = new Boxes();
	System.out.println(Test);
    }
}
