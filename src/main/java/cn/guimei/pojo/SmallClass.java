package cn.guimei.pojo;


import java.io.Serializable;

public class SmallClass implements Serializable {

  private long id;
  private String smallName;
  private long smallBigId;
  private String smallText;


  public SmallClass(long id, String smallName, long smallBigId, String smallText) {
    this.id = id;
    this.smallName = smallName;
    this.smallBigId = smallBigId;
    this.smallText = smallText;
  }

  public SmallClass() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSmallName() {
    return smallName;
  }

  public void setSmallName(String smallName) {
    this.smallName = smallName;
  }

  public long getSmallBigId() {
    return smallBigId;
  }

  public void setSmallBigId(long smallBigId) {
    this.smallBigId = smallBigId;
  }

  public String getSmallText() {
    return smallText;
  }

  public void setSmallText(String smallText) {
    this.smallText = smallText;
  }
}
