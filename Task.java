public class Task {
  private int action;
  private int money;
  
  public Task(int action, int money) {
    this.action = action;
    this.money = money;
  }

  @Override
  public String toString() {
    if (action == 0) {
      return "deposit $" + this.money;
    } else {
      return "withdrawal $" + this.money;
    }
  }

  public int getValue() {
    if (action == 0) {
      return money;
    } else {
      return (-1 * money);
    }
  }
}
