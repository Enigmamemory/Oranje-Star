public class Driver{
  public static void main(String [] Args){
    Grid Field = new Grid();
    System.out.println(Field);
    /*
    Unit Testing = new Unit();
    Unit noob = new Unit();
    Field.Place(Testing, 0, 0);
    Field.Place(noob,0,1);
    System.out.println(Field);
    System.out.println(Field.Status(0,0));
    System.out.println(Field.Status(0,1));
    Field.attack(Testing,noob);
    System.out.println(Field.Status(0,1));
    System.out.println(Field);
    */
    Unit backup = new Unit();
    Field.deploy(backup,0,0);
    System.out.println(Field);
    
  }
}  
