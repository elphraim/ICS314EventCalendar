import java.io.File;

/**
 * Display list of events
 * 
 * @author Dan Paguirigan
 * @author Eri Ane
 * @author Spencer Luther
 */
public class listPrompt {
  File[] calFiles;
  File folder;
  String foldername;
  String userHome;
  int noEvents;


  /**
   * Sets directory for .ICS files
   */
  public listPrompt() {
    /* Location for folder */
    userHome = System.getProperty("user.home") + "/Desktop/";
    foldername = "Calendar-Files";
    folder = new File(userHome, foldername);
    calFiles = folder.listFiles();
    noEvents = calFiles.length;
  }


  /**
   * Checks if directory exists and has events
   * 
   * @return false if folder exists
   */
  public boolean promptUser() {
    /* checks if no folder exists */
    if (!folder.exists()) {
      System.out.println("Directory is empty.");
      return true;
    }

    /* checks if there are no events */
    if (noEvents == 0) {
      System.out.println("Directory is empty.");
      return true;
    }
    /* events exist */
    if (noEvents > 0) {
      return true;
    }

    return false;
  }
}
