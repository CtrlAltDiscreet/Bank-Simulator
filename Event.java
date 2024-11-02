
abstract class Event implements Comparable<Event> {
  /** The time this event occurs in the simulation. */
  private final double time;

  /**
   * Creates an event that occurs at the given time
   */
  public Event(double time) {
    this.time = time;
  }

  public double getTime() {
    return this.time;
  }

  /**
   * Compare this event with a given event e.
   *
   * The other event to compare to.
   * returns 1 if this event occurs later than e;
   *         0 if they occur the same time; 
   *         -1 if this event occurs earlier.
   */
  @Override
  public int compareTo(Event e) {
    if (this.time > e.time) {
      return 1;
    } else if (this.time == e.time) {
      return 0;
    } else {
      return -1;
    }
  }

  @Override
  public String toString() {
    return String.format("%.3f", this.time);
  }

  public abstract Event[] simulate();
}
