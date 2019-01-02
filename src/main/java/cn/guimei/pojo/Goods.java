package cn.guimei.pojo;


import java.io.Serializable;

/**
 * @Program: GuiMeiShopping
 * @ClassName: Goods
 * @Auther: machunqi
 * @Date: 2018-12-29 13:38
 * @Description: 商品
 * @Version 1.0
 */

public class Goods implements Serializable {

  private long id;
  private String goodsName;
  private long goodsSmallId;
  private double goodsMoney;
  private long goodsNumber;
  private String goodsImage;
  private double goodsCarriage;
  private long goodsType;
  private long goodsSellerId;
  private long goodsDiscId;

  public Goods(long id, String goodsName, long goodsSmallId, double goodsMoney, long goodsNumber, String goodsImage, double goodsCarriage, long goodsType, long goodsSellerId, long goodsDiscId) {
    this.id = id;
    this.goodsName = goodsName;
    this.goodsSmallId = goodsSmallId;
    this.goodsMoney = goodsMoney;
    this.goodsNumber = goodsNumber;
    this.goodsImage = goodsImage;
    this.goodsCarriage = goodsCarriage;
    this.goodsType = goodsType;
    this.goodsSellerId = goodsSellerId;
    this.goodsDiscId = goodsDiscId;
  }

  public Goods() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public long getGoodsSmallId() {
    return goodsSmallId;
  }

  public void setGoodsSmallId(long goodsSmallId) {
    this.goodsSmallId = goodsSmallId;
  }

  public double getGoodsMoney() {
    return goodsMoney;
  }

  public void setGoodsMoney(double goodsMoney) {
    this.goodsMoney = goodsMoney;
  }

  public long getGoodsNumber() {
    return goodsNumber;
  }

  public void setGoodsNumber(long goodsNumber) {
    this.goodsNumber = goodsNumber;
  }

  public String getGoodsImage() {
    return goodsImage;
  }

  public void setGoodsImage(String goodsImage) {
    this.goodsImage = goodsImage;
  }

  public double getGoodsCarriage() {
    return goodsCarriage;
  }

  public void setGoodsCarriage(double goodsCarriage) {
    this.goodsCarriage = goodsCarriage;
  }

  public long getGoodsType() {
    return goodsType;
  }

  public void setGoodsType(long goodsType) {
    this.goodsType = goodsType;
  }

  public long getGoodsSellerId() {
    return goodsSellerId;
  }

  public void setGoodsSellerId(long goodsSellerId) {
    this.goodsSellerId = goodsSellerId;
  }

  public long getGoodsDiscId() {
    return goodsDiscId;
  }

  public void setGoodsDiscId(long goodsDiscId) {
    this.goodsDiscId = goodsDiscId;
  }
}
