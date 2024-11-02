class ServiceBegin extends Event {
  private Customer customer;
  private Counter counter;
  private Bank bank;
  private boolean success = false;

  public ServiceBegin(double time, Customer customer, Counter counter, Bank bank) {
    super(time);
    this.customer = customer;
    this.counter = counter;
    this.bank = bank;
  }


  @Override
  public String toString() {
    String message = ": " +  customer.toString() + " " +
            customer.getTask() + " begin (by " + counter.toString();
    return super.toString() + message;
  }

  @Override
  public Event[] simulate() {
    if (counter.getValue() + customer.getValue() >= 0) {
      counter.updateValue(customer.getValue());
      this.success = true;
    }
    this.counter.busy();
    double end = this.getTime() + customer.getServiceTime();
    return new Event[] { new ServiceEnd(end, customer, counter, bank, this.success) };
  }

}
