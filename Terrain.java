public class Terrain {
    protected boolean candeploy;
    protected int capturerate;	
    protected String name;
    protected String side;
    
    Terrain(){
    	name = "Plain ";
	capturerate = 20;
	candeploy = true;
	side = "Neutral";
    }
    Terrain(String color){
    	this();
    	side = color;
    }
    public String getname(){
	return name;
    }
    public void setname(String x){
	name = x;
    }
    public boolean getdeploy(){
	return candeploy;
    }
    public void setdeploy(boolean x){
	candeploy = x;
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
