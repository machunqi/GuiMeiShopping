package cn.guimei.pojo;


import java.io.Serializable;

public class Shoppingcar implements Serializable {

  private long id;
  private long scCusId;
  private long scGoodsId;
  private long scNumber;


  public Shoppingcar(long id, long scCusId, long scGoodsId, long scNumber) {
    this.id = id;
    this.scCusId = scCusId;
    this.scGoodsId = scGoodsId;
    this.scNumber = scNumber;
  }

  public Shoppingcar() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getScCusId() {
    return scCusId;
  }

  public void setScCusId(long scCusId) {
    this.scCusId = scCusId;
  }

  public long getScGoodsId() {
    return scGoodsId;
  }

  public void setScGoodsId(long scGoodsId) {
    this.scGoodsId = scGoodsId;
  }

  public long getScNumber() {
    return scNumber;
  }

  public void setScNumber(long scNumber) {
    this.scNumber = scNumber;
  }
}
