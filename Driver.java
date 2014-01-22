public class Driver{
  public static void main(String [] Args){
    Grid Field = new Grid();
    System.out.println(Field);
    Unit Testing = new Unit();
    Field.Place(Testing, 0, 1);
    Field.moveup(Testing);
    System.out.println(Field);
  }
}  
