class ServiceEnd extends Event {
  private Customer customer;
  private Counter counter;
  private Bank bank;
  private boolean success;

  public ServiceEnd(double time, Customer customer,
                    Counter counter, Bank bank, boolean success) {
    super(time);
    this.customer = customer;
    this.counter = counter;
    this.bank = bank;
    this.success = success;
  }

  @Override
  public String toString() {
    String message = ": " + customer.toString() + " " +
            customer.getTask() + " done (by ";
    if (!success) {
      return super.toString() + message + counter.toString() + " fail";
    }
    return super.toString() + message + counter.toString() + " success";
  }

  @Override
  public Event[] simulate() {
    this.counter.free();
    if (!counter.getQueue().isEmpty()) {
      Customer first = (Customer) counter.getQueue().deq();
      if (bank.getQueue().isEmpty()) {
        return new Event[] { new Departure(this.getTime(), customer),
                new ServiceBegin(this.getTime(), first, counter, bank) };
      } else {
        Customer bankQFirst = (Customer) bank.getQueue().deq();
        return new Event[] { new Departure(this.getTime(), customer),
                new ServiceBegin(this.getTime(), first, counter, bank),
                new JoinCounterQueue(this.getTime() + 0.01, bankQFirst, counter) };
      }
    }
    if (bank.getQueue().isEmpty()) {
      return new Event[] { new Departure(this.getTime(), customer) };
    } else if (counter.getQueue().isEmpty()) {
      Customer first = (Customer) bank.getQueue().deq();
      return new Event[] { new Departure(this.getTime(), customer),
              new ServiceBegin(this.getTime(), first, counter, bank) };
    }
    return new Event[] {};
  }

}