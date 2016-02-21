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

  private String UID = "UID:uid1@example.com" + NL;
  private String organizer = "ORGANIZER;CN=Name Lastname:MAILTO:sample@example.com" + NL;
  private String title;
  private String summary;
  private String DTSTART;
  private String DTEND;
  private String DTSTAMP;
  private String title2;
  private String place;


  public iCal(String eventTitle, String date, String startTime, String endTime, String location, String sum) {
    title = "SUMMARY:" + eventTitle + NL;
    summary = "DESCRIPTION:" + sum + NL;
    place = "LOCATION:" + location + NL;
    DTSTART = "DTSTART:" + startTime + NL;
    DTEND = "DTEND:" + endTime + NL;
    DTSTAMP = "DTSTAMP:" + date + NL;
    title2 = eventTitle;
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
      bw.write(DTSTAMP);
      bw.write(organizer);
      bw.write(DTSTART);
      bw.write(DTEND);
      bw.write(title);
      bw.write(summary);
      bw.write(place);
      bw.write(eventEnd);
      bw.write(calEnd);

      bw.close();

      System.out.println("Done");

    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}