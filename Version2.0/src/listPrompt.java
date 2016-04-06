import java.io.File;

public class listPrompt {
  String userHome;
  String foldername;
  File folder;
  File[] calFiles;
  int noFiles;
  String[] eventFiles;
  int noEvents;


  public listPrompt() {
    userHome = System.getProperty("user.home") + "/Desktop/";
    foldername = "Calendar-Files";
    folder = new File(userHome, foldername);
    calFiles = folder.listFiles();
    noFiles = calFiles.length;
  }


  public boolean promptUser() {
    /* if the folder does not exist then there are no events, hence the user is free. */
    if (!folder.exists()) {
      System.out.println("Directory is empty.");
      return true;
    }

    /* if the folder is empty, there are no events, hence the user is free */
    if (noFiles == 0) {
      System.out.println("Directory is empty.");
      return true;
    }

    if (noFiles > 0) {
      return true;
    }

    return false;
  }
}
