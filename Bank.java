
public class Bank {
  private Seq<Counter> counters;
  private Queue<Customer> bankQueue;
  private int bankQSize;

  public Bank(int bankQSize, Queue<Customer> bankQueue, int counterQSize) {
    this.counters = new Seq<Counter>(bankQSize);
    this.bankQueue = bankQueue;
    this.bankQSize = bankQSize;

    for (int i = 0; i < bankQSize; i++) {
      counters.set(i,
              new Counter(i, true, new Queue<Customer>(counterQSize), counterQSize));
    }
  }

  public int getSize() {
    return bankQSize;
  }

  public Counter getCounter(int i) {
    return counters.get(i);
  }

  public Queue<Customer> getQueue() {
    return bankQueue;
  }

  public Counter getMin() {
    return counters.min();
  }
}
