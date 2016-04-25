import java.util.Comparator;

/**
 * Compare events
 * 
 * @author Dan Paguirigan
 * @author Eri Ane
 * @author Spencer Luther
 */
public class EventComp implements Comparator<Event> {
  /**
   * @return positive integer if first arg is less than, equal to, or greater than the second
   */
  public int compare(Event e1, Event e2) {
    // instantiate event date and time
    int eventdate1 = Integer.parseInt(e1.startDate.trim());
    int eventtime1 = Integer.parseInt(e1.startTime.trim());
    int eventdate2 = Integer.parseInt(e2.startDate.trim());
    int eventtime2 = Integer.parseInt(e2.startTime.trim());
    
    if (eventdate1 < eventdate2) {
      return -1;
    }
    else if (eventdate1 > eventdate2) {
      return 1;
    }
    else {
      if (eventtime1 < eventtime2) {
        return -1;
      }
      else if (eventtime1 > eventtime2) {
        return 1;
      }
      else {
        return 0;
      }
    }
  }
}
