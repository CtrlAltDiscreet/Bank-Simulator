class Departure extends Event {
  private Customer customer;

  public Departure(double time, Customer customer) {
    super(time);
    this.customer = customer;
  }

  @Override
  public String toString() {
    String message = ": " + customer.toString() + " departed";
    return super.toString() + message;
  }

  @Override
  public Event[] simulate() {
    return new Event[] {};
  }
}
