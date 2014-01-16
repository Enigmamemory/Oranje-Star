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
        return Floor.getName();
    }
    public static void main (String[] args) {
	Boxes Test = new Boxes();
	System.out.println(Test);
    }
}
