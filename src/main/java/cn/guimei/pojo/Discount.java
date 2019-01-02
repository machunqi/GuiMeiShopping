package cn.guimei.pojo;


import java.io.Serializable;

public class Discount implements Serializable {

  private long id;
  private double discRate;


  public Discount(long id, double discRate) {
    this.id = id;
    this.discRate = discRate;
  }

  public Discount() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public double getDiscRate() {
    return discRate;
  }

  public void setDiscRate(double discRate) {
    this.discRate = discRate;
  }
}
