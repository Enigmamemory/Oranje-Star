public class Terrain {

    private String name;
    
    Terrain(){
    	name = "Plain ";
    }

    public String getTerrain(){
	return name;
    }

    public String toString(){
	return getTerrain();
    }

}
