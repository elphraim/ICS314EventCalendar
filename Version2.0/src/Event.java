import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

/**
 * Represents a event object
 * 
 * @author Dan Paguirigan
 * @author Eri Ane
 * @author Spencer Luther
 */
public class Event {
  public String address; /* address of the event */
  public String classification; /* type of event: public, private */
  public String comment; /* comment field for event */
  public String currentDate; /* date stamp for event */
  public String currentTime; /* time stamp for event */
  public String description; /* description of the event */
  public String endDate; /* end date of the event */
  public String endTime; /* end time of the event */
  public boolean isLat; /* if coordinates added */
  public float latitude; /* latitude of the event */
  public float longitude; /* longitude of the event */
  public String location; /* location of the event */
  public String name; /* name of the event */
  public String startDate; /* start date of the event */
  public String startTime; /* start time of the event */
  public String UID; /* unique ID of the event */


  public Event() {
    // Unique random UID number for each event
    UID = UUID.randomUUID().toString().toUpperCase();
    TimeZone tz = TimeZone.getTimeZone("UTC");
    Calendar cal = Calendar.getInstance(tz);

    /* get time stamp */
    int hour = cal.get(Calendar.HOUR);
    int minute = cal.get(Calendar.MINUTE);
    int second = cal.get(Calendar.SECOND);

    /* check current time */
    currentTime = "";
    if (hour < 10) {
      currentTime += "0" + hour;
    }
    else {
      currentTime += "" + hour;
    }
    if (minute < 10) {
      currentTime += "0" + minute;
    }
    else {
      currentTime += "" + minute;
    }
    if (second < 10) {
      currentTime += "0" + second;
    }
    else {
      currentTime += "" + second;
    }

    /* get date stamp */
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DAY_OF_MONTH);

    /* check date */
    currentDate = "";
    if (year < 10) {
      currentDate += "0" + year;
    }
    else {
      currentDate += "" + year;
    }

    if (month < 10) {
      currentDate += "0" + month;
    }
    else {
      currentDate += "" + month;
    }
    if (day < 10) {
      currentDate += "0" + day;
    }
    else {
      currentDate += "" + day;
    }
  }

/**
 * Builds event file information
 * @return string
 */
  private String createContent() {
    String content =
        "BEGIN:VCALENDAR\nVERSION:2.0"
            + "PRODID://TeamVinte/luther/eane/danp/ICS314//"
            + "\nBEGIN:VTIMEZONE\nTZID:Pacific/Honolulu\n"
            + "BEGIN:DAYLIGHT" 
            + "\nTZOFFSETFROM:-1030\nDTSTART:19430430T020000\nTZNAME:HDT\nTZOFFSETTO:-0930\nRDATE:19430430T020000\n"
            + "RDATE:19220209T020000\nEND:DAYLIGHT" 
            + "\nBEGIN:STANDARD" 
            + "\nTZNAME:HST\nTZOFFSETFROM:-1030\nDTSTART:19550607T020000\n"
            + "TZOFFSETTO:-1000\nRDATE:19550607T020000\nEND:STANDARD\nEND:VTIMEZONE" 
            + "\nBEGIN:VEVENT"
            + "\nCLASS:" + classification
            + "\nSUMMARY:" + name
            + "\nCREATED:" + currentDate + "T" + currentTime + "Z\nUID:" + UID
            + "\nDTSTART;TZID=Pacific/Honolulu:" + startDate + "T" + startTime
            + "\nDTEND;TZID=Pacific/Honolulu:" + endDate + "T" + endTime
            + "\nDTSTAMP:" + startDate + "T" + startTime + "Z" + "\nLOCATION:" + address
            + "\nGEO:" + latitude + ";" + longitude
            + "\nDESCRIPTION:" + description
            + "\nCOMMENT:" + comment
            + "\nEND:VEVENT\nEND:VCALENDAR";
    return content;
  }

/**
 * Creates .ICS file in a
 * directory on the Desktop
 * @return true if file was created
 */
  public boolean createFile() {
    String filename = name + ".ics";
    String directory = "Calendar-Files";
    String userHome = System.getProperty("user.home") + "/Desktop/";
    System.out.println("Generating Event File...");
    
    try {
      File folder = new File(userHome, directory);

      // if no folder exists, create it
      if (!folder.exists()) {
        folder.mkdir();
      }

      // change file location
      File file = new File(userHome + "/" + directory, filename);

      // if no file exists, create it
      if (!file.exists()) {
        file.createNewFile();
      }

      // write the content string to the event file
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

/*returns classification of event */
  public String getClassification() {
    return classification;
  }

/* sets classification of event */
  public void setClassification(String classification) {
    this.classification = classification;
  }


  /* returns current date */
  public String getCurrentDate() {
    return currentDate;
  }


  /* sets current date */
  public void setCurrentDate(String currentDate) {
    this.currentDate = currentDate;
  }


  /* returns current time */
  public String getCurrentTime() {
    return currentTime;
  }


  /* sets current time of event */
  public void setCurrentTime(String currentTime) {
    this.currentTime = currentTime;
  }


  /* returns name of the event */
  public String getName() {
    return name;
  }


  /* sets the name of the event */
  public void setName(String name) {
    this.name = name;
  }


  /* returns the location of the event */
  public String getLocation() {
    return location;
  }


  /* sets the location of the event */
  public void setLocation(String location) {
    this.location = location;
  }


  /* returns the address of the event */
  public String getAddress() {
    return address;
  }


  /* sets the address of the event */
  public void setAddress(String address) {
    this.address = address;
  }


  /* returns the latitude of the event */
  public float getLatitude() {
    return latitude;
  }


  /* sets the latitude of the event */
  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }
  
  /* returns true if lat/lon have been set*/
  public boolean getIsLat() {
	  return isLat;
  }
  
  /* sets whether lat/lon coordinates have been given */
  public void setIsLat(Boolean boo) {
	  this.isLat = boo;
  }


  /* returns the longitude of the event */
  public float getLongitude() {
    return longitude;
  }


  /* sets the longitude of the event */
  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }


  /* returns the description of the event */
  public String getDescription() {
    return description;
  }


  /* sets the description of the event */
  public void setDescription(String description) {
    this.description = description;
  }
  
  /* returns the comment of the event */
  public String getComment() {
    return description;
  }


  /* sets the description of the event */
  public void setComment(String comment) {
    this.comment = comment;
  }


  /* returns the start date of the event */
  public String getStartDate() {
    return startDate;
  }


  /* sets the start date of the event */
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }


  /* returns the end date of the event */
  public String getEndDate() {
    return endDate;
  }


  /* sets the end date of the event */
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }


  /* returns the start time of the event */
  public String getStartTime() {
    return startTime;
  }


  /* sets the start time of the event */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }


  /* returns the end time of the event */
  public String getEndTime() {
    return endTime;
  }


  /* sets the end time of the event */
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }


  /* returns the UID of the event */
  public String getUID() {
    return UID;
  }


  /* sets the UID of the event */
  public void setUID(String UID) {
    this.UID = UID;
  }
}
