import java.util.Scanner;

public class Driver {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.print("  Title  :  ");
    String eventTitle = scan.nextLine();

    System.out.print(" Event Date (YYYYMMDD) :  ");
    String date = scan.nextLine();

    System.out.print(" Starting Time (24HR 00:00:00) :  ");
    String startTime = scan.nextLine();

    System.out.print(" Ending Time (24HR 00:00:00)  :  ");
    String endTime = scan.nextLine();

    System.out.print(" Summary  :  ");
    String sum = scan.nextLine();
    
    System.out.print(" Location : ");
    String location = scan.nextLine();
    
    System.out.print(" Class : ");
    String classChoice = scan.nextLine();
    
    System.out.print(" Latitude : ");
    float geo1 = scan.nextFloat();
    
    System.out.print(" Longitude : ");
    float geo2 = scan.nextFloat();
    
    
    scan.close();

    iCal calendar = new iCal(eventTitle, date, startTime, endTime, location, sum, geo1, geo2, classChoice);
    calendar.write();
  }

}