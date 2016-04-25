import java.io.File;

/**
 * Display list of events
 * 
 * @author Dan Paguirigan
 * @author Eri Ane
 * @author Spencer Luther
 */
public class listPrompt {
  String userHome;
  String foldername;
  File folder;
  File[] calFiles;
  String[] eventFiles;
  int noEvents;

  /**
   * Sets directory for .ICS files
   */
  public listPrompt() {
    userHome = System.getProperty("user.home") + "/Desktop/";
    foldername = "Calendar-Files";
    folder = new File(userHome, foldername);
    calFiles = folder.listFiles();
    noEvents = calFiles.length;
  }

/**
 * Checks if directory exists and has events
 * @return false if folder exists
 */
  public boolean promptUser() {
    /* if the folder does not exist then there are no events, hence the user is free. */
    if (!folder.exists()) {
      System.out.println("Directory is empty.");
      return true;
    }

    /* if the folder is empty, there are no events, hence the user is free */
    if (noEvents == 0) {
      System.out.println("Directory is empty.");
      return true;
    }

    if (noEvents > 0) {
      return true;
    }

    return false;
  }
}
