package com.example.standard.quizmobile.POJO;

/**
 * Created by standard on 12/11/17.
 */

public class Score {
  private String _mataKuliah;
  private int _scoreTugas;
  private int _scoreUTS;
  private int _scoreUAS;

  public Score(String maKuliah, int sTugas, int sUts, int sUas) {
    this.set_mataKuliah(maKuliah);
    this.set_scoreTugas(sTugas);
    this.set_scoreUTS(sUts);
    this.set_scoreUAS(sUas);
  }

  public String get_mataKuliah() {
    return _mataKuliah;
  }

  public void set_mataKuliah(String _mataKuliah) {
    this._mataKuliah = _mataKuliah;
  }

  public int get_scoreTugas() {
    return _scoreTugas;
  }

  public void set_scoreTugas(int _scoreTugas) {
    this._scoreTugas = _scoreTugas;
  }

  public int get_scoreUTS() {
    return _scoreUTS;
  }

  public void set_scoreUTS(int _scoreUTS) {
    this._scoreUTS = _scoreUTS;
  }

  public int get_scoreUAS() {
    return _scoreUAS;
  }

  public void set_scoreUAS(int _scoreUAS) {
    this._scoreUAS = _scoreUAS;
  }
}
