package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements CalculatorInf {

  Calculator() throws RemoteException {
    super();
  }

  @Override
  public int add(int a, int b) throws RemoteException {
    System.out.println("Client request .....");
    return a + b;
  }

}