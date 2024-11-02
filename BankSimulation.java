import java.util.Scanner;

class BankSimulation extends Simulation {

  /**
   * The list of customer arrival events to populate
   * the simulation with.
   */
  public Event[] initEvents;

  /**
   * Constructor for a bank simulation.
   *
   *           The first integer scanned is the number of customers; followed
   *           by the number of service counters.  Next is a
   *           sequence of (arrival time, service time) pair, each
   *           pair represents a customer.
   */
  public BankSimulation(Scanner sc) {
    initEvents = new Event[sc.nextInt()];
    int numOfCounters = sc.nextInt();
    int counterQSize = sc.nextInt();
    int entranceQSize = sc.nextInt();
    Bank bank = new Bank(numOfCounters, new Queue<>(entranceQSize), counterQSize);

    int id = 0;
    while (sc.hasNextDouble()) {
      double arrivalTime = sc.nextDouble();
      double serviceTime = sc.nextDouble();
      Customer customer = new Customer(id, new Task(sc.nextInt(), sc.nextInt()), serviceTime);
      initEvents[id] = new Arrival(arrivalTime, customer, bank, counterQSize);
      id = id + 1;
    }
  }

  /**
   * Retrieve an array of events to populate the
   * simulator with.
   */
  //@Override
  public Event[] getInitialEvents() {
    return initEvents;
  }

}
