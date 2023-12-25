package TCP918_Object;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception {
    int port = 1107;
    ServerSocket server = new ServerSocket(port);
    while (true) {
      Socket socket = server.accept();

      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
      String receiveMessage = (String) ois.readObject();
      System.out.println("Receive message: " + receiveMessage);

      Customer customer = new Customer(1, "C100", "Tran Minh Tan", "09-29-2002", "minhtan");
      System.out.println("Send: " + customer.toString());
      oos.writeObject(customer);

      Customer receiveCustomer = (Customer) ois.readObject();
      System.out.println("Receive customer: " + receiveCustomer);
    }

  }
}
