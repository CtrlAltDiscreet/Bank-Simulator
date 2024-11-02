public class JoinCounterQueue extends Event {
  private Customer customer;
  private Counter counter;

  public JoinCounterQueue(double time, Customer customer, Counter counter) {
    super(time);
    this.customer = customer;
    this.counter = counter;
  }

  @Override
  public String toString() {
    String message = "";
    message = ": " + customer.toString() + " joined counter queue (at " + counter.toString();
    return super.toString() + message;
  }

  @Override
  public Event[] simulate() {
    counter.getQueue().enq(customer);
    return new Event[] {};
  }
}