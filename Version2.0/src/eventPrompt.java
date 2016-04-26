import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Input/Output User Interface
 * 
 * @author Dan Paguirigan
 * @author Eri Ane
 * @author Spencer Luther
 */
public class eventPrompt {
  Scanner sc; // String Inputs
  Scanner sc1; // Float Inputs
  Scanner sc2; // Yes or no


  public eventPrompt() {
    sc = new Scanner(System.in);
    sc1 = new Scanner(System.in);
  }


  /**
   * PromptUser
   * 
   * creates a new event and assigns inputed information
   * 
   * @param newEvent
   */
  public void PromptUser(Event newEvent) {
    //boolean that will check if user inputted lat/long info
	  boolean checkLatLong = true;
    // gets user input for a name
    System.out.println("Please enter an event name: ");
    newEvent.setName(sc.nextLine());

    // gets user input for classification
    System.out.println("What is the classification of the event? (private/public)");
    newEvent.setClassification(sc.nextLine().toUpperCase());

    // gets user input for a name of location
    System.out.println("Please enter a location name: ");
    newEvent.setLocation(sc.nextLine());

    // gets user input for the address of the location
    System.out.println("Please enter the address of the location: ");
    newEvent.setAddress(sc.nextLine());

    System.out.println("Do you have the latitude and longitude of the location? (yes/no)");
    String input = sc.nextLine();
    if (input.equalsIgnoreCase("yes")) {
      // gets user input for the latitude of the location
      System.out.println("Please enter the latitude of the location: ");
      newEvent.setLatitude(sc1.nextFloat());

      // gets user input for the longitude of the location
      System.out.println("Please enter the longitude of the location: ");
      newEvent.setLongitude(sc1.nextFloat());

      // Set marker saying lat/lon have been set
      newEvent.setIsLat(true);
    }
    else {
      // Set marker saying lat/lon have not been set
      newEvent.setIsLat(false);
        checkLatLong = false;
    }

    // Get user input for a start date
    System.out.println("Please enter a start date in the following format yyyymmdd: ");
    String dateStart = sc.nextLine();
    newEvent.setStartDate(dateStart);
    while (!checkDate(dateStart)) {
      System.out.println("Invalid date! Please use date format yyyymmdd: ");
      dateStart = sc.nextLine();
    }

    // Get user input for an end date
    System.out.println("Please enter an end date in the following format yyyymmdd: ");
    String dateEnd = sc.nextLine();
    newEvent.setEndDate(dateEnd);
    while (!checkDate(dateStart)) {
      System.out.println("Invalid date! Please use date format yyyymmdd: ");
      dateStart = sc.nextLine();
    }

    // Get user input for a start time
    System.out.println("Please enter a start time in 24 hour time in the following format hhmmss: ");
    String startTime = sc.nextLine();
    newEvent.setStartTime(startTime);
    while (!checkTime(startTime)) {
      System.out.println("Invalid time! Please use time format hhmmss: ");
      startTime = sc.nextLine();
    }

    // Get user input for an end time
    System.out.println("Please enter an end time in 24 hour time in the following format hhmmss: ");
    String endTime = sc.nextLine();
    newEvent.setEndTime(endTime);
    while (!checkTime(endTime)) {
      System.out.println("Invalid time! Please use time format hhmmss: ");
      endTime = sc.nextLine();
    }

    // input the great circle distance(computed in Driver.java) into comment field
     
    if(Driver.calDistance()== true)
    {
    	newEvent.setComment(Driver.distance());
    	if(checkLatLong == false)
    	{
    		newEvent.setComment("Missing Latitude/Longitude info to calculate GCD");
    	}
    }
       else
       {
        newEvent.setComment("You have no other events today");
       }
  }
  


  /**
   * Error checking for time
   * 
   * @param input time
   * @return true if string matches format
   */
  public static boolean checkTime(String time) {
    SimpleDateFormat formatTime = new SimpleDateFormat("HHmmss");
    formatTime.setLenient(false);
    try {
      formatTime.parse(time.trim());
    }
    catch (ParseException e) {
      return false;
    }
    return true;
  }


  /**
   * Error checking for date
   * 
   * @param input date
   * @return true if string matches format
   */
  public static boolean checkDate(String date) {
    SimpleDateFormat formatTime = new SimpleDateFormat("yyyyMMdd");
    formatTime.setLenient(false);
    try {
      formatTime.parse(date.trim());
    }
    catch (ParseException e) {
      return false;
    }
    return true;
  }
}
