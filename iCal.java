import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class iCal {

  static final String NL = "\r\n";
  private String version = "VERSION:1.0" + NL;
  private String prodid = "PRODID://TeamVinte/danp/luther/eane/ICS314//" + NL;
  private String calBegin = "BEGIN:VCALENDAR" + NL;
  private String calEnd = "END:VCALENDAR" + NL;
  private String eventBegin = "BEGIN:VEVENT" + NL;
  private String eventEnd = "END:VEVENT" + NL;
  // private String name = "EventName" + NL;
  // private String summary = "summary" + NL;

  private String UID = "UID:Uujpb6nrvgcqf9a1ae6fh2ptepc@google.com" + NL;
  private String title;
  private String summary;
  private String DTSTART;
  private String DTEND;
  private String title2;
  private String place;
  // Declare GEO and its associates
  private String GEO;
  private float LAT;
  private float LON;
  // Declare Classification
  private String CLASS;
  // Declare Great Circle Distance
  private float GCDist;


  public iCal(String eventTitle, String date, String startTime, String endTime, String location, String sum,
      float geo1, float geo2, String classChoice) {
    title = "SUMMARY:" + eventTitle + NL;
    summary = "DESCRIPTION:" + sum + NL;
    place = "LOCATION:" + location + NL;
    DTSTART = "DTSTART:" + date + "T" + startTime + "Z" + NL;
    DTEND = "DTEND:" + date + "T" + endTime + "Z" + NL;
    // initialize GEO
    GEO = latLong(geo1, geo2);
    LAT = geo1;
    LON = geo2;
    // initialize CLASSIFICATION
    CLASS = Classification(classChoice);
    title2 = eventTitle;
    //Check to see if there was an event before this one
    if(isPrevious()) {
      //If there was a previous event, get the LAT and LON of previous event
      //and compute the great circle distance
      
      //INCOMPLETE: gets the LAT and LON of previous event; to do this, event awareness must be implemented
      float lat0 = __________.getLAT();
      float lon0 = __________.getLON();
      GCDist = gcdist(lat0, lon0, LAT, LON);
    } else {
      GCDist = 0;
    }
  }
  
  //This function will check if there is a previous event on the same day
  //Returns true if there was
  public boolean isPrevious() {
    //stub
  }

  // Format GEO
  public String latLong(float lat, float lon) {
    String ret = "GEO:";
    float temp;
    if (lat > 90.0) {
      temp = (lat % 90);
      lat = temp;
      ret = ret + lat + ":";
    }
    if (lon > 180) {
      temp = (lon % 180);
      lon = temp;
      ret = ret + lon + NL;
    }
    if (lat < -90.0) {
      temp = ((-1 * lat) % 90);
      lat = -1 * temp;
      ret = ret + lat + ":";
    }
    if (lon < -180) {
      temp = ((-1 * lon) % 180);
      lon = -1 * temp;
      ret = ret + lon + NL;
    }
    return ret;
  }

  public String Classification(String cLASS) {
    if (cLASS.equalsIgnoreCase("Public")) {
      CLASS = "CLASS:PUBLIC";
    }
    else if (cLASS.equalsIgnoreCase("Confidential")) {
      CLASS = "CLASS:CONFIDENTIAL";
    }
    else if (cLASS.equalsIgnoreCase("DEFAULT")) {
      CLASS = "CLASS:PUBLIC";
    }
     else if (cLASS.equalsIgnoreCase("PRIVATE")) 
    {
        CLASS = "CLASS:PRIVATE";
    }
    else if 
    {
    	System.out.println(cLASS + " Error! Invalid entry. Thus will be classified as Public(default)");
      CLASS = "CLASS:PUBLIC";
    }
    else {
      CLASS = "CLASS:PRIVATE";
    }
    return (CLASS + NL);
  }
  
  //Function: computes the great circle distance between two events
  //THIS IS SET TO KILOMETERS
  public float GCDist(float lat1, float lon1, float lat2, float lon2) {
    float ret = 0;
    float abs = lon2 - lon1;
    ret = 6371 * (Math.acos((Math.sin(lat1) * Math.sin(lat2))
      + (Math.cos(lat1) * Math.cos(lat2) * Math.cos(Math.abs(abs)))));
    return ret;
  }

  public void write() {

    StringBuilder builder = new StringBuilder();
    builder.append(title2);
    builder.append(".ics");

    try {

      File file = new File(builder.toString());

      // if file doesnt exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }

      FileWriter fw = new FileWriter(file.getAbsoluteFile());
      BufferedWriter bw = new BufferedWriter(fw);
      bw.write(calBegin);
      bw.write(version);
      bw.write(prodid);
      bw.write(eventBegin);
      bw.write(UID);
      bw.write(GEO);
      bw.write(LAT);
      bw.write(LON);
      bw.write(DTSTART);
      bw.write(DTEND);
      bw.write(title);
      bw.write(summary);
      bw.write(place);
      bw.write(CLASS);
      bw.write(eventEnd);
      bw.write(calEnd);

      bw.close();

      System.out.println("Done");

    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }


  public String getVersion() {
    return version;
  }


  public String getProdid() {
    return prodid;
  }


  public String getCalBegin() {
    return calBegin;
  }


  public String getCalEnd() {
    return calEnd;
  }


  public String getEventBegin() {
    return eventBegin;
  }


  public String getEventEnd() {
    return eventEnd;
  }


  public String getUID() {
    return UID;
  }


  public String getTitle() {
    return title;
  }


  public String getSummary() {
    return summary;
  }


  public String getDTSTART() {
    return DTSTART;
  }


  public String getDTEND() {
    return DTEND;
  }


  public String getTitle2() {
    return title2;
  }


  public String getPlace() {
    return place;
  }


  public String getGEO() {
    return GEO;
  }
  
  public float getLAT() {
    return LAT;
  }

  public float getLON() {
    return LON;
  }

  public String getCLASS() {
    return CLASS;
  }
}
