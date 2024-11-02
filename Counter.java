class Counter implements Comparable<Counter> {
  private int counter;
  private boolean available;
  private Queue<Customer> queue;
  private int counterQSize;
  private int value = 100;

  public Counter(int counter, boolean available, Queue<Customer> queue, int counterQSize) {
    Queue<Customer> temp = queue;
    this.counter = counter;
    this.available = available;
    this.queue = temp;
    this.counterQSize = counterQSize;
  }

  public void busy() {
    available = false;
  }

  public void free() {
    available = true;
  }

  public boolean status() {
    return this.available;
  }

  public int updateValue(int change) {
    this.value = value + change;
    return value;
  }

  public int getValue() {
    return value;
  }

  public int queueSize() {
    return queue.length();
  }

  public Queue getQueue() {
    return queue;
  }

  @Override
  public String toString() {
    return "S" + this.counter + " $" +
            this.value + " " + queue.toString() + ")";
  }

  @Override
  public int compareTo(Counter counter) {
    if (this.queue.length() < counter.queue.length()) {
      return -1;
    } else if (this.queue.length() > counter.queue.length()) {
      return 1;
    } else {
      return 0;
    }
  }

}