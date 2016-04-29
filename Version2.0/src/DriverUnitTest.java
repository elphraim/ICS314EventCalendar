import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Team Vinte
 *
 */
public class DriverUnitTest {
  @Before
  public void setUp() {
  }


  @After
  public void tearDown() {
  }


  @Test
  public void testCanCreateEvent() {
    // Populate data for event
    Event event = new Event();
    event.setName("TestEvent");
    event.setClassification("PRIVATE");
    event.setLocation("US");
    event.setAddress("Test Address");
    event.setLatitude(100);
    event.setLongitude(200);
    event.setIsLat(true);
    event.setStartDate("20160110");
    event.setEndDate("20160111");
    event.setStartTime("070500");
    event.setEndTime("073001");

    assertNotNull(event);
    assertEquals(event.getName(), "TestEvent");
    assertEquals(event.getClassification(), "PRIVATE");
    assertEquals(event.getLocation(), "US");
    assertEquals(event.getAddress(), "Test Address");
    assertEquals(event.getLatitude(), 100, 0.01);
    assertEquals(event.getLongitude(), 200, 0.01);
    assertTrue(event.getIsLat());
    assertEquals(event.getStartDate(), "20160110");
    assertEquals(event.getEndDate(), "20160111");
    assertEquals(event.getStartTime(), "070500");
    assertEquals(event.getEndTime(), "073001");
    assertNull(event.getComment());
  }


  @Test
  public void testCanCreateCalendarICSFile() {
    // Populate data for event
    Event event = new Event();
    event.setName("TestEvent");
    event.setClassification("PRIVATE");
    event.setLocation("US");
    event.setAddress("Test Address");
    event.setLatitude(100);
    event.setLongitude(200);
    event.setIsLat(true);
    event.setStartDate("20160110");
    event.setEndDate("20160111");
    event.setStartTime("070500");
    event.setEndTime("073001");

    assertNotNull(event);
    assertEquals(event.getName(), "TestEvent");
    assertEquals(event.getClassification(), "PRIVATE");
    assertEquals(event.getLocation(), "US");
    assertEquals(event.getAddress(), "Test Address");
    assertEquals(event.getLatitude(), 100, 0.01);
    assertEquals(event.getLongitude(), 200, 0.01);
    assertTrue(event.getIsLat());
    assertEquals(event.getStartDate(), "20160110");
    assertEquals(event.getEndDate(), "20160111");
    assertEquals(event.getStartTime(), "070500");
    assertEquals(event.getEndTime(), "073001");
    assertNull(event.getComment());

    boolean created = event.createFile();
    assertTrue(created);

    String directory = "Calendar-Files";
    String userHome = System.getProperty("user.home") + "/Desktop/";
    String filename = event.getName() + ".ics";

    File file = new File(userHome + "/" + directory, filename);
    assertTrue(file.exists());
  }


  @Test
  public void testCalculateGreatCircleDistance() {
    // Populate data for event
    Event event = new Event();
    event.setName("TestEvent");
    event.setClassification("PRIVATE");
    event.setLocation("US");
    event.setAddress("Test Address");
    event.setLatitude(18.123f);
    event.setLongitude(18.123f);
    event.setIsLat(true);
    event.setStartDate("20160110");
    event.setEndDate("20160111");
    event.setStartTime("070500");
    event.setEndTime("073001");

    assertNotNull(event);
    assertEquals(event.getName(), "TestEvent");
    assertEquals(event.getClassification(), "PRIVATE");
    assertEquals(event.getLocation(), "US");
    assertEquals(event.getAddress(), "Test Address");
    assertEquals(event.getLatitude(), 18.123, 0.01);
    assertEquals(event.getLongitude(), 18.123, 0.01);
    assertTrue(event.getIsLat());
    assertEquals(event.getStartDate(), "20160110");
    assertEquals(event.getEndDate(), "20160111");
    assertEquals(event.getStartTime(), "070500");
    assertEquals(event.getEndTime(), "073001");
    assertNull(event.getComment());

    // 2nd event to calculate great circle distance
    Event event2 = new Event();
    event2.setName("TestEvent2");
    event2.setClassification("PRIVATE");
    event2.setLocation("US");
    event2.setAddress("Test Address");
    event2.setLatitude(20.123f);
    event2.setLongitude(20.123f);
    event2.setIsLat(true);
    event2.setStartDate("20160110");
    event2.setEndDate("20160111");
    event2.setStartTime("080500");
    event2.setEndTime("083001");

    Driver.icsCalendar314 = new ArrayList<Event>(999);
    Driver.icsCalendar314.add(event);
    Driver.icsCalendar314.add(event2);
    Driver.icsCalendar314.sort(new EventComp());

    System.out.println(Driver.distance());
    assertNotNull(Driver.distance());
  }

}
