package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorInf extends Remote {
  public int add(int a, int b) throws RemoteException;
}
