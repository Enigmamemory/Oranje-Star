public class Terrain {
    protected boolean candeploy;
    protected int capturerate;	
    protected String name;
    protected String side;
    protected int movetakefoot;
    protected int movetaketank;
    protected int movetakeair;
    protected int money;
    
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
    public void changePlain(String x){
    	name = "Plain "; candeploy = false; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
    }
    public void changeAirport(String x){
    	name = "AirPrt"; candeploy = true; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
    }
    public void changeBridge(String x){
    	name = "Bridge"; candeploy = false; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
    }
    public void changeCity(String x){
    	name = "City  "; candeploy = false; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
    }
    public void changeCommTower(String x){
    	name = "ComTwr"; candeploy = false; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
    }
    public void changeFactory(String x){
    	name = "Fctory"; candeploy = true; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
    }
    public void changeHeadquarter(String x){
    	name = "HQ    "; candeploy = false; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
    }    
    public void changeMissileSilo(String x){
    	name = "MislSl"; candeploy = false; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
    }
    public void changeMountain(String x){
    	name = "Mntain"; candeploy = false; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
    }
    public void changeRoad(String x){
    	name = "Road  "; candeploy = false; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
    }    
    public void changeWasteland(String x){
    	name = "WstLnd"; candeploy = false; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
    }
    public void changeWood(String x){
    	name = "Wood  "; candeploy = false; side = x;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1; money = 1;
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
