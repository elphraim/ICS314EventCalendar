import java.util.Scanner;

public class Driver {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.print("  Title  :  ");
    String eventTitle = scan.nextLine();

    System.out.print(" Event Date  :  ");
    String date = scan.nextLine();

    System.out.print(" Starting Time  :  ");
    String startTime = scan.nextLine();

    System.out.print(" Ending Time  :  ");
    String endTime = scan.nextLine();

    System.out.print(" Summary  :  ");
    String sum = scan.nextLine();
    
    System.out.print(" Location : ");
    String location = scan.nextLine();
    
    scan.close();

    iCal calendar = new iCal(eventTitle, date, startTime, endTime, location, sum);
    calendar.write();
  }

}
