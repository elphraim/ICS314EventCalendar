import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

public class Event {
  public String currentDate;
  public String currentTime;
  public String classification; /* type of event: public, private */
  public String name; /* name of the event */
  public String location; /* location of the event */
  public String address; /* address of the event */
  public float latitude; /* latitude of the event */
  public float longitude; /* longitude of the event */
  public String description; /* description of the event */
  public String comment; // idk
  public String startDate; /* start date of the event */
  public String endDate; /* end date of the event */
  public String startTime; /* start time of the event */
  public String endTime; /* end time of the event */
  public String UID; /* unique ID of the event */


  /* creates an event */
  public Event() {
    UID = UUID.randomUUID().toString().toUpperCase();
    TimeZone tmz = TimeZone.getTimeZone("UTC");
    Calendar cal = Calendar.getInstance(tmz);

    /* get time */
    int hour = cal.get(Calendar.HOUR);
    int minute = cal.get(Calendar.MINUTE);
    int second = cal.get(Calendar.SECOND);

    /* check time */
    currentTime = "";
    if (hour < 10)
      currentTime += "0" + hour;
    else
      currentTime += "" + hour;

    if (minute < 10)
      currentTime += "0" + minute;
    else
      currentTime += "" + minute;

    if (second < 10)
      currentTime += "0" + second;
    else
      currentTime += "" + second;

    /* get date */
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DAY_OF_MONTH);

    /* check date */
    currentDate = "";
    if (year < 10)
      currentDate += "0" + year;
    else
      currentDate += "" + year;

    if (month < 10)
      currentDate += "0" + month;
    else
      currentDate += "" + month;

    if (day < 10)
      currentDate += "0" + day;
    else
      currentDate += "" + day;
  }


  private String createContent() {
    String content =
        "BEGIN:VCALENDAR\nVERSION:2.0"
            + "PRODID://TeamVinte/luther/eane/danp/ICS314//"
            + "\nBEGIN:VTIMEZONE\nTZID:Pacific/Honolulu\n"
            + "BEGIN:DAYLIGHT\nTZOFFSETFROM:-1030\nDTSTART:19330430T020000\nTZNAME:HDT\nTZOFFSETTO:-0930\nRDATE:19330430T020000\n"
            + "RDATE:19420209T020000\nEND:DAYLIGHT\nBEGIN:STANDARD\nTZOFFSETFROM:-1030\nDTSTART:19470608T020000\nTZNAME:HST\n"
            + "TZOFFSETTO:-1000\nRDATE:19470608T020000\nEND:STANDARD\nEND:VTIMEZONE" + "\nBEGIN:VEVENT" + "\nCLASS:"
            + classification
            + "\nSUMMARY"
            + name
            + "\nCREATED:"
            + currentDate
            + "T"
            + currentTime
            + "Z\nUID:"
            + UID
            + "\nDTEND;TZID=Pacific/Honolulu:"
            + endDate
            + "T"
            + endTime
            + "\nDTSTART;TZID=Pacific/Honolulu:"
            + startDate
            + "T"
            + startTime
            + "\nDTSTAMP:"
            + startDate
            + "T"
            + startTime
            + "Z"
            + "\nLOCATION:"
            + address
            + "\nGEO:"
            + latitude
            + ";"
            + longitude
            + "\nDESCRIPTION:"
            + description
            + "\nCOMMENT:"
            + "\nEND:VEVENT\nEND:VCALENDAR";
    return content;
  }


  public boolean createFile() {
    System.out.println("Generating Event File...");
    String foldername = "Calendar-Files";
    String userHome = System.getProperty("user.home") + "/Desktop/";
    String filename = name + ".ics";

    try {
      File folder = new File(userHome, foldername);

      // if the folder does not exist, create it
      if (!folder.exists()) {
        folder.mkdir();
      }

      // change file location based on local system
      File file = new File(userHome + "/" + foldername, filename);

      // if file doesn't exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }

      // write the content string to the file
      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(createContent());
      bw.close();
    }
    catch (IOException e) {
      return false;
    }
    return true;
  }


  public String getClassification() {
    return classification;
  }


  public void setClassification(String classification) {
    this.classification = classification;
  }


  /* returns current date of event */
  public String getCurrentDate() {
    return currentDate;
  }


  /* reassigns current date of event */
  public void setCurrentDate(String currentDate) {
    this.currentDate = currentDate;
  }


  /* returns current time of event */
  public String getCurrentTime() {
    return currentTime;
  }


  /* reassigns current time of event */
  public void setCurrentTime(String currentTime) {
    this.currentTime = currentTime;
  }


  /* returns name of the event */
  public String getName() {
    return name;
  }


  /* reassigns the name of the event */
  public void setName(String name) {
    this.name = name;
  }


  /* returns the location of the event */
  public String getLocation() {
    return location;
  }


  /* reassigns the location of the event */
  public void setLocation(String location) {
    this.location = location;
  }


  /* returns the address of the event */
  public String getAddress() {
    return address;
  }


  /* reassigns the address of the event */
  public void setAddress(String address) {
    this.address = address;
  }


  /* returns the latitude of the event */
  public float getLatitude() {
    return latitude;
  }


  /* reassigns the latitude of the event */
  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }


  /* returns the longitude of the event */
  public float getLongitude() {
    return longitude;
  }


  /* reassigns the longitude of the event */
  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }


  /* returns the description of the event */
  public String getDescription() {
    return description;
  }


  /* reassigns the description of the event */
  public void setDescription(String description) {
    this.description = description;
  }


  /* returns the comment of the event */
  public String getComment() {
    return description;
  }


  /* reassigns the description of the event */
  public void setComment(String comment) {
    this.comment = comment;
  }


  /* returns the start date of the event */
  public String getStartDate() {
    return startDate;
  }


  /* reassigns the start date of the event */
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }


  /* returns the end date of the event */
  public String getEndDate() {
    return endDate;
  }


  /* reassigns the end date of the event */
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }


  /* returns the start time of the event */
  public String getStartTime() {
    return startTime;
  }


  /* reassigns the start time of the event */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }


  /* returns the end time of the event */
  public String getEndTime() {
    return endTime;
  }


  /* reassigns the end time of the event */
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }


  /* returns the UID of the event */
  public String getUID() {
    return UID;
  }


  /* reassigns the UID of the event */
  public void setUID(String UID) {
    this.UID = UID;
  }
}
