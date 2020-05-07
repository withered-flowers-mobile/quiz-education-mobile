package com.example.standard.quizmobile.POJO;

/**
 * Created by standard on 12/11/17.
 */

public class Student {
  private String _NIM;
  private String _firstName;
  private String _lastName;

  public Student(String nim, String fName, String lName) {
    this.set_NIM(nim);
    this.set_firstName(fName);
    this.set_lastName(lName);
  }

  public String get_NIM() {
    return _NIM;
  }

  private void set_NIM(String _NIM) {
    this._NIM = _NIM;
  }

  public String get_firstName() {
    return _firstName;
  }

  private void set_firstName(String _firstName) {
    this._firstName = _firstName;
  }

  public String get_lastName() {
    return _lastName;
  }

  private void set_lastName(String _lastName) {
    this._lastName = _lastName;
  }
}
