import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class iCalTest
{
    @Test
    public void verifyCanCreateICalObject() throws Exception
    {
        iCal iCal = new iCal("title", "20161109", "00:01:00", "11:20:30", "New York", "summary", 21.30081f, -157.8162f, "Public");

        assertNotNull(iCal);

        assertEquals(iCal.getTitle(), "SUMMARY:title\r\n");
        assertEquals(iCal.getSummary(), "DESCRIPTION:summary\r\n");
        assertEquals(iCal.getDTSTART(), "DTSTART:20161109T00:01:00Z\r\n");
        assertEquals(iCal.getDTEND(), "DTEND:20161109T11:20:30Z\r\n");
        assertEquals(iCal.getPlace(), "LOCATION:New York\r\n");
        assertEquals(iCal.getGEO(), "GEO:21.30081;-157.8162\r\n");
        assertEquals(iCal.getCLASS(), "CLASS:PUBLIC\r\n");
    }

    @Test
    public void verifyCanCreateTheFile() throws Exception
    {
        iCal iCal = new iCal("title", "20161109", "00:01:00", "11:20:30", "New York", "summary", 21.30081f, -157.8162f, "Public");
        iCal.write();

        File file = new File("title.ics");
        assertTrue(file.exists());

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String calBegin = bufferedReader.readLine();
        String version = bufferedReader.readLine();
        String prodid = bufferedReader.readLine();
        String eventBegin = bufferedReader.readLine();
        String uid = bufferedReader.readLine();
        String geo = bufferedReader.readLine();
        String dtstart = bufferedReader.readLine();
        String dtend = bufferedReader.readLine();
        String title = bufferedReader.readLine();
        String summary = bufferedReader.readLine();
        String location = bufferedReader.readLine();
        String classify = bufferedReader.readLine();
        String eventEnd = bufferedReader.readLine();
        String calEnd = bufferedReader.readLine();

        assertEquals(calBegin, "BEGIN:VCALENDAR");
        assertEquals(version, "VERSION:1.0");
        assertEquals(prodid, "PRODID://TeamVinte/danp/luther/eane/ICS314//");
        assertEquals(eventBegin, "BEGIN:VEVENT");
        assertEquals(uid, "UID:Uujpb6nrvgcqf9a1ae6fh2ptepc@google.com");
        assertEquals(geo, "GEO:21.30081;-157.8162");
        assertEquals(dtstart, "DTSTART:20161109T00:01:00Z");
        assertEquals(dtend, "DTEND:20161109T11:20:30Z");
        assertEquals(title, "SUMMARY:title");
        assertEquals(summary, "DESCRIPTION:summary");
        assertEquals(location, "LOCATION:New York");
        assertEquals(classify, "CLASS:PUBLIC");
        assertEquals(eventEnd, "END:VEVENT");
        assertEquals(calEnd, "END:VCALENDAR");

    }
}
