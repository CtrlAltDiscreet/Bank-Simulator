class Customer {

  private int customer;
  private Task task;
  private double serviceTime;

  public Customer(int customer, Task task, double serviceTime) {
    this.customer = customer;
    this.task = task;
    this.serviceTime = serviceTime;
  }

  @Override
  public String toString() {
    return "C" + customer;
  }

  public String getTask() {
    return task.toString();
  }

  public int getValue() {
    return task.getValue();
  }

  public double getServiceTime() {
    return serviceTime;
  }

}

