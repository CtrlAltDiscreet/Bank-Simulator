class Arrival extends Event {
  private Counter counter;
  private Customer customer;
  private Bank bank;
  private int counterQSize;


  public Arrival(double time, Customer customer, Bank bank, int counterQSize) {
    super(time);
    this.customer = customer;
    this.bank = bank;
    this.counterQSize = counterQSize;
  }

  @Override
  public String toString() {
    String message = ": " + customer.toString() + " arrived " + bank.getQueue().toString();
    return super.toString() + message;
  }

  @Override
  public Event[] simulate() {
    for (int i = 0; i < bank.getSize(); i++) {
      if (bank.getCounter(i).status()) {
        counter = bank.getCounter(i);
        if (bank.getQueue().isEmpty()) {
          return new Event[] {
                  new ServiceBegin(this.getTime(), customer, counter, bank) };
        }
      }
    }
    if (bank.getMin().queueSize() >= this.counterQSize) {
      if (!bank.getQueue().isFull()) {
        return new Event[] { new JoinQueue(this.getTime(), customer, bank) };
      }
    } else {
      return new Event[] { new JoinCounterQueue(this.getTime(), customer, bank.getMin()) };
    }
    return new Event[] { new Departure(this.getTime(), customer) };
  }

}