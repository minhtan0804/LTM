package RMI;

import java.rmi.Naming;

public class Client {
  public static void main(String[] args) throws Exception {
    CalculatorInf calculatorInf = (CalculatorInf) Naming.lookup("rmi://localhost:666/cal");

    System.out.println("sum: " + calculatorInf.add(100, 200));
  }
}
