package TCP917_Object;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception {
    int port = 1109;
    ServerSocket server = new ServerSocket(port);

    while (true) {
      Socket socket = server.accept();

      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

      String receiveMessage = (String) ois.readObject();
      System.out.println("Receive message: " + receiveMessage);

      Product product = new Product(1, "P001", "M1 MacBook Laptop", 256);

      oos.writeObject(product);

      product.setName("Laptop MacBook M1");
      product.setQuantity(652);

      Product receiveProduct = (Product) ois.readObject();

      System.out.println("True Product : " + product);
      System.out.println("Nhận được Product: " + receiveProduct);

      if (product.toString().equals(receiveProduct.toString())) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
      ois.close();
      oos.close();
      socket.close();

    }
  }
}
