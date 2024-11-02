import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Run {
  public static void main(String[] args) {

    // Create a scanner to read from input files.
    Scanner sc = null;
    try {
      sc = new Scanner(new File("inputs/Test1.in"));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    // Create a simulation.  The BankSimulation
    // constructor will read the simulation parameters 
    // and initial events using the scanner.
    Simulation simulation = new BankSimulation(sc);

    // Create a new simulator and run the simulation
    new Simulator(simulation).run();

    // Clean up the scanner.
    sc.close();
  }
}
