import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
  static ArrayList<Event> icsCalendar314;


  /**
   * Event Calendar Main
   * 
   * @author Dan Paguirigan
   * @author Eri Ane
   * @author Spencer Luther
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean run = true;
    icsCalendar314 = new ArrayList<Event>(999);

    System.out.println("\t-------------------------------------");
    System.out.println("\tWelcome to your Calendar Event Maker!");
    System.out.println("\t-------------------------------------");

    while (run == true) {
      System.out.println("\t| Menu:");
      System.out.println("\t| 0: Add an Event");
      System.out.println("\t| 1: Show sorted Calendar List");
      System.out.print("\t| 2: Quit\n:");
      int choice = scan.nextInt();

      if (choice < 0 || choice > 2) {
        System.out.println("Invalid menu choice.");
        break;
      }

      switch (choice) {
      case 0:
        Event calen = new Event();
        eventPrompt calprompt = new eventPrompt();

        calprompt.PromptUser(calen);

        if (calen.createFile() != true) {
          System.out.println("Can't generate file.");
        }
        else {
          System.out.println("Sucessful, file created!");
          icsCalendar314.add(calen);
          icsCalendar314.sort(new EventComp());
        }
        break;
      case 1:
        try {
          listPrompt trprompt = new listPrompt();
          if (trprompt.promptUser() == false) {
            System.out.println("Error");
          }
        }
        catch (NullPointerException e) {
          System.out.println("Empty List.. Add an event");
        }
        System.out.println("Event" + "\tDate" + "\t\tTime");
        System.out.println("------------------------------");
        printList();
        calDistance();
        break;
      case 2:
        System.out.println("Goodbye!");
        run = false;
        break;
      }
    }
    scan.close();
  }


  /**
   * printList
   * 
   * Prints sorted events
   */
  private static void printList() {
    // Loops through array and prints sorted list
    for (int i = 0; i < icsCalendar314.size(); i++) {
      System.out.println(icsCalendar314.get(i).name + "\t" + icsCalendar314.get(i).startDate + "\t"
          + icsCalendar314.get(i).startTime + "\t");
    }
  }


  /**
   * calDistance
   * 
   * Calculates and prints distance between events
   * 
   * @return true
   */
  public static boolean calDistance() {
    for (int i = 1; i < icsCalendar314.size(); i++) {
      System.out.println(i + "\t" + icsCalendar314.size());
      int date1 = Integer.parseInt(icsCalendar314.get(i - 1).startDate.trim());
      int date2 = Integer.parseInt(icsCalendar314.get(i).startDate.trim());

      if (date1 == date2 && icsCalendar314.get(i - 1).getIsLat() && icsCalendar314.get(i).getIsLat()) {

        // Call calCirDist here
        float GCD =
            GCDist(icsCalendar314.get(i - 1).latitude, icsCalendar314.get(i - 1).longitude,
                icsCalendar314.get(i).latitude, icsCalendar314.get(i).longitude);
        double GCDmiles = GCD / 1.609344;
        System.out.println("\tGreat Circle Distance (from " + icsCalendar314.get(i - 1).name + " to "
            + icsCalendar314.get(i).name + "): " + GCD + " Kilometers" + "/ " + GCDmiles + " Miles");
      }
    }
    return true;

  }


  /**
   * GCDist
   * 
   * computes the great circle distance between two events THIS IS SET TO KILOMETERS
   */
  public static float GCDist(float lat1, float lon1, float lat2, float lon2) {
    float ret = 0;
    float difLon = (float) Math.abs(Math.toRadians(lon1) - Math.toRadians(lon2));
    ret =
        (float) (6371 * (Math.acos((Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)))
            + (Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.abs(difLon))))));
    return ret;
  }


  /**
   * distance
   * 
   * computes the great circle between two events and saves results into a String (to add to comment field)
   * 
   * @return string
   */
  public static String distance() {
    String CompDist = "";
    for (int i = 1; i < icsCalendar314.size(); i++) {

      int date1 = Integer.parseInt(icsCalendar314.get(i - 1).startDate.trim());
      int date2 = Integer.parseInt(icsCalendar314.get(i).startDate.trim());

      if (date1 == date2 && icsCalendar314.get(i - 1).getIsLat() && icsCalendar314.get(i).getIsLat()) {

        // Call calCirDist here
        float GCD =
            GCDist(icsCalendar314.get(i - 1).latitude, icsCalendar314.get(i - 1).longitude,
                icsCalendar314.get(i).latitude, icsCalendar314.get(i).longitude);
        double GCDmiles = GCD / 1.609344;

        CompDist =
            ("\tGreat Circle Distance (from " + icsCalendar314.get(i - 1).name + " to " + icsCalendar314.get(i).name
                + "): " + GCD + " Kilometers" + "/ " + GCDmiles + " Miles");

        icsCalendar314.get(i - 1).comment = CompDist;
        icsCalendar314.get(i - 1).createFile();
      }
      else {
        CompDist = "";
      }
    }

    return (CompDist);
  }

}
