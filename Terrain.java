public class Terrain {
    private int capturerate;	
    private String name;
    
    Terrain(){
    	name = "Plain ";
    }

    public String getname(){
	return name;
    }

    public String toString(){
	return getname();
    }
    public int getcapturerate(){
    	return capturerate;
    }
    public void setcapturerate(int x){
    	capturerate = x;
    }
}
