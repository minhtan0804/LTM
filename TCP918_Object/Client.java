package TCP918_Object;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Client {
  public static void main(String[] args) throws Exception {
    String host = "localhost";
    int port = 1107;
    Socket client = new Socket(host, port);

    ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
    String sendMessage = "B20DCCN757;918";
    System.out.println("Send message: " + sendMessage);
    oos.writeObject(sendMessage);

    ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
    Customer customer = (Customer) ois.readObject();
    System.out.println("Receive: " + customer.toString());

    String[] itemNames = customer.getName().trim().split(" ");
    sendMessage = itemNames[itemNames.length - 1].toUpperCase() + ",";

    for (String item : Arrays.copyOfRange(itemNames, 0, itemNames.length - 1)) {
      String itemFormat = item.substring(0, 1).toUpperCase() + item.substring(1);
      sendMessage += " " + itemFormat;
    }
    customer.setName(sendMessage);
    System.out.println("Name: " + customer.getName());

    SimpleDateFormat format = new SimpleDateFormat("mm-dd-yyyy");
    Date date = format.parse(customer.getDayOfBirth());
    System.out.println(date.toString());
    format = new SimpleDateFormat("dd/mm/yyyy");
    String dateFormat = format.format(date);
    customer.setDayOfBirth(dateFormat);
    System.out.println("Date: " + dateFormat);

    oos.writeObject(customer);

  }
}
