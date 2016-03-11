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
  private String GEO;
  // Declare Classification
  private String CLASS;


  public iCal(String eventTitle, String date, String startTime, String endTime, String location, String sum,
      float geo1, float geo2, String classChoice) {
    title = "SUMMARY:" + eventTitle + NL;
    summary = "DESCRIPTION:" + sum + NL;
    place = "LOCATION:" + location + NL;
    DTSTART = "DTSTART:" + date + "T" + startTime + "Z" + NL;
    DTEND = "DTEND:" + date + "T" + endTime + "Z" + NL;
    // initialize GEO
    // GEO = latLong(geo1, geo2);
    GEO = "GEO:" + geo1 + ";" + geo2 + NL;

    // initialize CLASSIFICATION
    CLASS = Classification(classChoice);
    title2 = eventTitle;
  }


  // Format GEO
  public String latLong(float lat, float lon) {
    String ret = "GEO:";
    float temp;
    if (lat > 90.0) {
      temp = (lat % 90);
      lat = temp;
      ret = ret + "+" + lat + ":";
    }
    if (lon > 180) {
      temp = (lon % 180);
      lon = temp;
      ret = ret + "+" + lon;
    }
    if (lat < -90.0) {
      temp = ((-1 * lat) % 90);
      lat = -1 * temp;
      ret = ret + lat + ":";
    }
    if (lon < -180) {
      temp = ((-1 * lon) % 180);
      lon = -1 * temp;
      ret = ret + lon;
    }
    return null;

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


  public String getCLASS() {
    return CLASS;
  }
}
