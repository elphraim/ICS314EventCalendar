import java.util.Comparator;

//Sort Calendar events
public class EventComp implements Comparator<Event> {
  public int compare(Event e1, Event e2) {
    int xeventdate = Integer.parseInt(e1.startDate.trim());
    int xeventtime = Integer.parseInt(e1.startTime.trim());
    int yeventdate = Integer.parseInt(e2.startDate.trim());
    int yeventtime = Integer.parseInt(e2.startTime.trim());

    if (xeventdate < yeventdate) {
      return -1;
    }
    else if (xeventdate > yeventdate) {
      return 1;
    }
    else {
      if (xeventtime < yeventtime) {
        return -1;
      }
      else if (xeventtime > yeventtime) {
        return 1;
      }
      else {
        return 0;
      }
    }
  }
}
