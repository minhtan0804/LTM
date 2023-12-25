package TCP917_Object;

import java.io.Serializable;

public class Product implements Serializable {
  private static final long serialVersionUID = 917;

  private int id;
  private String code;
  private String name;
  private int quantity;

  public Product(int id, String code, String name, int quantity) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.quantity = quantity;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + "]";
  }

}
