package TCP917_Object;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws Exception {
    String host = "127.0.0.1";
    int port = 1109;

    Socket socket = new Socket(host, port);

    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

    System.out.println("Sending...");
    String codeSend = "B20DCCN757;917";
    oos.writeObject(codeSend);
    System.out.println("Send code success...");

    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
    Product product = (Product) ois.readObject();

    String[] itemNames = product.getName().split(" ");

    if (itemNames != null && itemNames.length > 1) {
      String temp = itemNames[0];
      itemNames[0] = itemNames[itemNames.length - 1];
      itemNames[itemNames.length - 1] = temp;
    }

    product.setName(String.join(" ", itemNames));

    StringBuilder quantity = new StringBuilder(Integer.toString(product.getQuantity()));

    product.setQuantity(Integer.valueOf(quantity.reverse().toString()));

    oos.writeObject(product);
  }
}
