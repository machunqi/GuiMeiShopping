package cn.guimei.pojo;


import java.io.Serializable;

public class BigClass implements Serializable {

  private long id;
  private String bigName;
  private String bigText;


  public BigClass(long id, String bigName, String bigText) {
    this.id = id;
    this.bigName = bigName;
    this.bigText = bigText;
  }

  public BigClass() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBigName() {
    return bigName;
  }

  public void setBigName(String bigName) {
    this.bigName = bigName;
  }

  public String getBigText() {
    return bigText;
  }

  public void setBigText(String bigText) {
    this.bigText = bigText;
  }
}
