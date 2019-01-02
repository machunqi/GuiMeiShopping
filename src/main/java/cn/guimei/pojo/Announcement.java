package cn.guimei.pojo;


import java.io.Serializable;
import java.sql.Date;

public class Announcement implements Serializable {

  private long id;
  private String aTitle;
  private String aText;
  private Date aDate;


  public Announcement(long id, String aTitle, String aText, Date aDate) {
    this.id = id;
    this.aTitle = aTitle;
    this.aText = aText;
    this.aDate = aDate;
  }

  public Announcement() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getaTitle() {
    return aTitle;
  }

  public void setaTitle(String aTitle) {
    this.aTitle = aTitle;
  }

  public String getaText() {
    return aText;
  }

  public void setaText(String aText) {
    this.aText = aText;
  }

  public Date getaDate() {
    return aDate;
  }

  public void setaDate(Date aDate) {
    this.aDate = aDate;
  }
}
