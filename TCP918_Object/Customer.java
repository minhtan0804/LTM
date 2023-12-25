package TCP918_Object;

import java.io.Serializable;

public class Customer implements Serializable {
  private static final long serialVersionUID = 918;

  private int id;
  private String code;
  private String name;
  private String dayOfBirth;
  private String username;

  public Customer(int id, String code, String name, String dayOfBirth, String username) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.dayOfBirth = dayOfBirth;
    this.username = username;
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

  public String getDayOfBirth() {
    return dayOfBirth;
  }

  public void setDayOfBirth(String dayOfBirth) {
    this.dayOfBirth = dayOfBirth;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "Customer [id=" + id + ", code=" + code + ", name=" + name + ", dayOfBirth=" + dayOfBirth + ", username="
        + username + "]";
  }

}
