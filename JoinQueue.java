class JoinQueue extends Event {
  private Customer customer;
  private Bank bank;

  public JoinQueue(double time, Customer customer, Bank bank) {
    super(time);
    this.customer = customer;
    this.bank = bank;
  }

  @Override
  public String toString() {
    String message = ": " + this.customer.toString() +
            " joined bank queue " + this.bank.getQueue().toString();
    return super.toString() + message;
  }

  @Override
  public Event[] simulate() {
    this.bank.getQueue().enq(this.customer);
    return new Event[] {};
  }
}
