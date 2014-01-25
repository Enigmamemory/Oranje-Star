public class Terrain {
    protected boolean candeploy;
    protected int capturerate;	
    protected int defenseinc;
    protected String name;
    protected String side;
    protected int movetakefoot;
    protected int movetaketank;
    protected int movetakeair;
    protected int movetaketire;
    protected int money;
    protected boolean cancapture = false;
    
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
    public void changePlain(){
    	name = "Plain "; candeploy = false;defenseinc = 1;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1;movetaketire = 2;money = 0;
    }
    public void changeAirport(String x){
    	name = "AirPrt"; candeploy = true; side = x;defenseinc = 3;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1;movetaketire = 1; money = 1000;
    	cancapture = true;
    }
    public void changeBridge(){
    	name = "Bridge"; candeploy = false;defenseinc = 0;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1;movetaketire = 1; money = 0;
    }
    public void changeCity(String x){
    	name = "City  "; candeploy = false; side = x;defenseinc = 2;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1;movetaketire = 1; money = 1000;
    	cancapture = true;
    }
    public void changeCommTower(String x){
    	name = "ComTwr"; candeploy = false; side = x;defenseinc = 3;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1;movetaketire = 1; money = 1000;
    	cancapture = true;
    }
    public void changeFactory(String x){
    	name = "Fctory"; candeploy = true; side = x;defenseinc = 3;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1;movetaketire = 1; money = 1000;
    	cancapture = true;
    }
    public void changeHeadquarter(String x){
    	name = "HQ    "; candeploy = false; side = x;defenseinc = 4;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1;movetaketire = 1; money = 1000;
    	cancapture = true;
    }    
    public void changeMissileSilo(String x){
    	name = "MislSl"; candeploy = false; side = x;defenseinc = 2;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1;movetaketire = 1; money = 1000;
    	cancapture = true;
    }
    public void changeMountain(){
    	name = "Mntain"; candeploy = false; defenseinc = 4;
    	movetakefoot = 2;movetaketank = 99;movetakeair = 1;movetaketire = 99; money = 0;
    }
    public void changeRoad(){
    	name = "Road  "; candeploy = false; defenseinc = 0;
    	movetakefoot = 1;movetaketank = 1;movetakeair = 1;movetaketire = 1; money = 0;
    }    
    public void changeWasteland(){
    	name = "WstLnd"; candeploy = false; defenseinc = 2;
    	movetakefoot = 1;movetaketank = 2;movetakeair = 1;movetaketire = 3; money = 0;
    }
    public void changeWood(){
    	name = "Wood  "; candeploy = false; defenseinc = 3;
    	movetakefoot = 1;movetaketank = 2;movetakeair = 1;movetaketire = 3; money = 0;
    }    
    public String getname(){
	return name;
    }
    public int getmovetake(Unit x){
    	String type = x.gettiretype();
    	if (type.equals("Foot")){
    		return movetakefoot;
    	}
    	else if (type.equals("Tire")){
    		return movetaketire;
    	}
    	else if (type.equals("Tank")){
    		return movetaketank;
    	}
    	else {
    		return movetakeair;
    	}
    }
    public void setname(String x){
	name = x;
    }
    public boolean getdeploy(){
	return candeploy;
    }
    public int getdefenseinc(){
    	return defenseinc;
    }
    public void setdeploy(boolean x){
	candeploy = x;
    }
    public String toString(){
    	String all = "";
    	all += name;
	return all;
    }
    public String getinfo(){
	String all = "";
    	all += "Terrain: " + name + "\n";all += "Player: " + side + "  ";all += "Capture: " + capturerate + "\n";
    	all += "DefenseIncrease: " + defenseinc + "\n";
	return all;
    }
    public int getcapturerate(){
    	return capturerate;
    }
    public int getmoney(){
    	return money;
    }
    public String getside(){
    	return side;
    }
    public void setside(String x){
    	side = x;
    }
    public void setcapturerate(int x){
    	capturerate = x;
    }
    
}
