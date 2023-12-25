package RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
  public static void main(String[] args) throws Exception {
    int port = 666;
    LocateRegistry.createRegistry(port);
    Calculator calculator = new Calculator();
    Naming.rebind("rmi://localhost:666/cal", calculator);

    System.out.println("Success !!!!");
  }
}
