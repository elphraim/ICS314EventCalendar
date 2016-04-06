import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
  static ArrayList<Event> icsCalendar314;


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean cont = true;
    icsCalendar314 = new ArrayList<Event>(999);

    System.out.println("***Welcome to your Calendar Event Maker!***");
    while (cont == true) {
      System.out.println("***Menu:");
      System.out.println("\t0: Add an Event");
      System.out.println("\t1: Show sorted Calendar List");
      System.out.print("\t2: Quit\n:");
      int menu = scan.nextInt();

      if (menu < 0 || menu > 2) {
        System.out.println("Invalid menu choice.");
        break;
      }

      switch (menu) {
      case 0:
        Event calen = new Event();
        eventPrompt calprompt = new eventPrompt();

        calprompt.PromptUser(calen);

        if (calen.createFile() != true) {
          System.out.println("Incomplete, ics file could not be created");
        }
        else {
          System.out.println("Complete, ics file created");
          icsCalendar314.add(calen);
          icsCalendar314.sort(new EventComp());
        }
        break;
      case 1:
        listPrompt trprompt = new listPrompt();
        if (trprompt.promptUser() == false) {
          System.out.println("Error");
        }
        // calDistance();
        printList();
        break;
      case 2:
        System.out.println("Goodbye!");
        cont = false;
        break;
      }
    }
    scan.close();
  }


  private static void printList() {
    for (int i = 0; i < icsCalendar314.size(); i++) {
      System.out.println(icsCalendar314.get(i).name + "\t" + icsCalendar314.get(i).startDate + "\t"
          + icsCalendar314.get(i).startTime + "\t||"/* Maybe comment section shows calendar distance thing here */);
    }
  }

  /*
   * private static boolean calDistance() { for(int i = 1; i < icsCalendar314.size() ; i++) { System.out.println(i +
   * "\t" + icsCalendar314.size()); int date1 = Integer.parseInt(icsCalendar314.get(i-1).startDate.trim()); int date2 =
   * Integer.parseInt(icsCalendar314.get(i).startDate.trim());
   * 
   * if(date1 == date2) { System.out.println(icsCalendar314.get(i-1).startDate + " and " +
   * icsCalendar314.get(i).startDate + " have matching start dates");
   * 
   * //Call calCirDist here }
   */

  /*
   * private static double calCirDist(float latitude1, float longitude1, float latitude2, float longitude2) {
   * //Calculate stuff
   */
}