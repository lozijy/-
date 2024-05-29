package com.example.demo.pojo;


public class User {

  private long id;
  private String username;
  private String password;
  private String gender;
  private Long age;
  private String name;
  private String mibao;
  private String mibaoanswer;
  private String isAdmin;
  private String confirmPassword;
  private String newPassword;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public Long getAge() {
    return age;
  }

  public void setAge(Long age) {
    this.age = age;
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMibao() {
        return mibao;
    }

    public void setMibao(String mibao) {
        this.mibao = mibao;
    }

    public String getMibaoanswer() {
        return mibaoanswer;
    }

    public void setMibaoanswer(String mibaoanswer) {
        this.mibaoanswer = mibaoanswer;
    }

  public String getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(String isAdmin) {
    this.isAdmin = isAdmin;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  @Override
  public String toString() {
    return "Yonghu{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", gender='" + gender + '\'' +
            ", age=" + age +
            ", name='" + name + '\'' +
            ", mibao='" + mibao + '\'' +
            ", mibaoanswer='" + mibaoanswer + '\'' +
            ", isAdmin='" + isAdmin + '\'' +
            ", confirmPassword='" + confirmPassword + '\'' +
            ", newPassword='" + newPassword + '\'' +
            '}';
  }
}
