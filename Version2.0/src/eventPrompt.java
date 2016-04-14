import java.util.Scanner;

public class eventPrompt {
  Scanner sc; // String Inputs
  Scanner sc1; // Float Inputs
  Scanner sc2; // Yes or no


  public eventPrompt() {
    sc = new Scanner(System.in);
    sc1 = new Scanner(System.in);
  }


  /* creates a new event and assigns it user input */
  public void PromptUser(Event newEvent) {
    // gets user input for a name
    System.out.println("Please enter an event name(only letters): ");
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
      
      //Set marker saying lat/lon have been set
      newEvent.setIsLat(true);
    } else {
    	//Set marker saying lat/lon have not been set
    	newEvent.setIsLat(false);
    }

    // Get user input for a start date
    System.out.println("Please enter a start date in the following format yyyymmdd: ");
    newEvent.setStartDate(sc.nextLine());

    // Get user input for an end date
    System.out.println("Please enter an end date in the following format yyyymmdd: ");
    newEvent.setEndDate(sc.nextLine());

    // Get user input for a start time
    System.out.println("Please enter a start time in 24 hour time in the following format hhmmss: ");
    newEvent.setStartTime(sc.nextLine());

    // Get user input for an end time
    System.out.println("Please enter an end time in 24 hour time in the following format hhmmss: ");
    newEvent.setEndTime(sc.nextLine());
    
    //input the great circle distance(computed in Driver.java) into comment field
		newEvent.setComment(Driver.distance());
  }
}
