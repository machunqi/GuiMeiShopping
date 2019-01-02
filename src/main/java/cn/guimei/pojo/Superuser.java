package cn.guimei.pojo;

import java.io.Serializable;

/**
 * @Program: 贵美商城
 * @ClassName: Superuser
 * @Auther: machunqi
 * @Date: 2018-12-28 11:17
 * @Description:超级管理员
 * @Version 1.0
 */

public class Superuser implements Serializable {

  private long id;
  private String userName;
  private String userLoginName;
  private String userPassword;
  private String userSex;
  private String userId;
  private String userImage;
  private long userStatus;


  public Superuser(String userName, String userLoginName, String userPassword, String userSex, String userId, String userImage, long userStatus) {
    this.userName = userName;
    this.userLoginName = userLoginName;
    this.userPassword = userPassword;
    this.userSex = userSex;
    this.userId = userId;
    this.userImage = userImage;
    this.userStatus = userStatus;
  }

  public Superuser() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserLoginName() {
    return userLoginName;
  }

  public void setUserLoginName(String userLoginName) {
    this.userLoginName = userLoginName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserSex() {
    return userSex;
  }

  public void setUserSex(String userSex) {
    this.userSex = userSex;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserImage() {
    return userImage;
  }

  public void setUserImage(String userImage) {
    this.userImage = userImage;
  }

  public long getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(long userStatus) {
    this.userStatus = userStatus;
  }
}
