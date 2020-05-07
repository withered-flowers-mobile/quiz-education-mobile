package com.example.standard.quizmobile.POJO;

/**
 * Created by standard on 12/11/17.
 */

public class StudentScore {
  private int _studentId;
  private int _scoreId;

  public StudentScore(int stuId, int scoId) {
    this.set_studentId(stuId);
    this.set_scoreId(scoId);
  }

  public int get_studentId() {
    return _studentId;
  }

  public void set_studentId(int _studentId) {
    this._studentId = _studentId;
  }

  public int get_scoreId() {
    return _scoreId;
  }

  public void set_scoreId(int _scoreId) {
    this._scoreId = _scoreId;
  }
}
