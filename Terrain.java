public class Terrain {
    private int capturerate;	
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
    public int getcapturerate(){
    	return capturerate;
    }
}
