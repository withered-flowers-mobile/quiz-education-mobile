package com.example.standard.quizmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.standard.quizmobile.POJO.Score;
import com.example.standard.quizmobile.POJO.StudentScore;
import com.example.standard.quizmobile.POJO.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by standard on 12/11/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
  private static final int DATABASE_VERSION = 1;

  private static final String DATABASE_NAME = "University";

  public DatabaseHandler(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {
    String CREATE_TABLE_STUDENT =
        "CREATE TABLE student (" +
            "    student_id  INTEGER PRIMARY KEY," +
            "    first_name  TEXT NOT NULL," +
            "    last_name   TEXT NOT NULL," +
            "    NIM         TEXT NOT NULL UNIQUE" +
            ");";

    String CREATE_TABLE_SCORE =
        "CREATE TABLE score (" +
            "    score_id    INTEGER PRIMARY KEY," +
            "    mata_kuliah TEXT NOT NULL," +
            "    score_tugas INTEGER NOT NULL," +
            "    score_uts   INTEGER NOT NULL," +
            "    score_uas   INTEGER NOT NULL" +
            ");";

    String CREATE_TABLE_STUDENT_SCORE =
        "CREATE TABLE student_score (" +
            "    student_id  INTEGER," +
            "    score_id    INTEGER," +
            "    PRIMARY KEY (student_id, score_id)," +
            "    FOREIGN KEY (student_id) REFERENCES student (student_id)" +
            "    ON DELETE CASCADE ON UPDATE NO ACTION," +
            "    FOREIGN KEY (score_id) REFERENCES score (score_id)" +
            "    ON DELETE CASCADE ON UPDATE NO ACTION" +
            ");";

    sqLiteDatabase.execSQL(CREATE_TABLE_STUDENT);
    sqLiteDatabase.execSQL(CREATE_TABLE_SCORE);
    sqLiteDatabase.execSQL(CREATE_TABLE_STUDENT_SCORE);

    insertStudent(sqLiteDatabase, new Student("32354271309", "Kane", "Lowe"));
    insertStudent(sqLiteDatabase, new Student("29929740003", "Yoshio", "Franks"));
    insertStudent(sqLiteDatabase, new Student("53101226196", "Florence", "Oliver"));
    insertStudent(sqLiteDatabase, new Student("63469379893", "Glenna", "Gilliam"));
    insertStudent(sqLiteDatabase, new Student("95890164280", "Zorita", "Cardenas"));

    insertScore(sqLiteDatabase, new Score("Algoritma", 89, 33, 54));
    insertScore(sqLiteDatabase, new Score("E-Business", 86, 75, 70));
    insertScore(sqLiteDatabase, new Score("Kalkulus", 36, 42, 31));
    insertScore(sqLiteDatabase, new Score("Sistem Basis Data", 80, 61, 68));
    insertScore(sqLiteDatabase, new Score("Pemrograman Visual", 49, 72, 30));
    insertScore(sqLiteDatabase, new Score("Akuntansi", 92, 83, 68));


    insertScore(sqLiteDatabase, new Score("Algoritma", 96, 80, 73));
    insertScore(sqLiteDatabase, new Score("E-Business", 61, 34, 79));
    insertScore(sqLiteDatabase, new Score("Kalkulus", 98, 82, 64));
    insertScore(sqLiteDatabase, new Score("Sistem Basis Data", 51, 97, 79));
    insertScore(sqLiteDatabase, new Score("Pemrograman Visual", 45, 66, 95));
    insertScore(sqLiteDatabase, new Score("Akuntansi", 42, 83, 88));

    insertScore(sqLiteDatabase, new Score("Algoritma", 48, 38, 86));
    insertScore(sqLiteDatabase, new Score("E-Business", 54, 92, 31));
    insertScore(sqLiteDatabase, new Score("Kalkulus", 83, 78, 59));
    insertScore(sqLiteDatabase, new Score("Sistem Basis Data", 80, 86, 32));
    insertScore(sqLiteDatabase, new Score("Pemrograman Visual", 69, 59, 75));
    insertScore(sqLiteDatabase, new Score("Akuntansi", 81, 76, 62));

    insertScore(sqLiteDatabase, new Score("Algoritma", 87, 73, 45));
    insertScore(sqLiteDatabase, new Score("E-Business", 76, 32, 71));
    insertScore(sqLiteDatabase, new Score("Kalkulus", 47, 86, 93));
    insertScore(sqLiteDatabase, new Score("Sistem Basis Data", 41, 38, 61));
    insertScore(sqLiteDatabase, new Score("Pemrograman Visual", 62, 55, 48));
    insertScore(sqLiteDatabase, new Score("Akuntansi", 67, 42, 65));

    insertScore(sqLiteDatabase, new Score("Algoritma", 57, 77, 85));
    insertScore(sqLiteDatabase, new Score("E-Business", 59, 80, 71));
    insertScore(sqLiteDatabase, new Score("Kalkulus", 36, 42, 31));
    insertScore(sqLiteDatabase, new Score("Sistem Basis Data", 93, 40, 44));
    insertScore(sqLiteDatabase, new Score("Pemrograman Visual", 69, 42, 73));
    insertScore(sqLiteDatabase, new Score("Akuntansi", 70, 74, 47));

    insertStudentScore(sqLiteDatabase, new StudentScore(1, 1));
    insertStudentScore(sqLiteDatabase, new StudentScore(1, 2));
    insertStudentScore(sqLiteDatabase, new StudentScore(1, 3));
    insertStudentScore(sqLiteDatabase, new StudentScore(1, 4));
    insertStudentScore(sqLiteDatabase, new StudentScore(1, 5));
    insertStudentScore(sqLiteDatabase, new StudentScore(1, 6));

    insertStudentScore(sqLiteDatabase, new StudentScore(2, 7));
    insertStudentScore(sqLiteDatabase, new StudentScore(2, 8));
    insertStudentScore(sqLiteDatabase, new StudentScore(2, 9));
    insertStudentScore(sqLiteDatabase, new StudentScore(2, 10));
    insertStudentScore(sqLiteDatabase, new StudentScore(2, 11));
    insertStudentScore(sqLiteDatabase, new StudentScore(2, 12));

    insertStudentScore(sqLiteDatabase, new StudentScore(3, 13));
    insertStudentScore(sqLiteDatabase, new StudentScore(3, 14));
    insertStudentScore(sqLiteDatabase, new StudentScore(3, 15));
    insertStudentScore(sqLiteDatabase, new StudentScore(3, 16));
    insertStudentScore(sqLiteDatabase, new StudentScore(3, 17));
    insertStudentScore(sqLiteDatabase, new StudentScore(3, 18));

    insertStudentScore(sqLiteDatabase, new StudentScore(4, 19));
    insertStudentScore(sqLiteDatabase, new StudentScore(4, 20));
    insertStudentScore(sqLiteDatabase, new StudentScore(4, 21));
    insertStudentScore(sqLiteDatabase, new StudentScore(4, 22));
    insertStudentScore(sqLiteDatabase, new StudentScore(4, 23));
    insertStudentScore(sqLiteDatabase, new StudentScore(4, 24));

    insertStudentScore(sqLiteDatabase, new StudentScore(5, 25));
    insertStudentScore(sqLiteDatabase, new StudentScore(5, 26));
    insertStudentScore(sqLiteDatabase, new StudentScore(5, 27));
    insertStudentScore(sqLiteDatabase, new StudentScore(5, 28));
    insertStudentScore(sqLiteDatabase, new StudentScore(5, 29));
    insertStudentScore(sqLiteDatabase, new StudentScore(5, 30));
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS student");
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS score");
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS student_score");

    onCreate(sqLiteDatabase);
  }

  void insertStudent(SQLiteDatabase db, Student student) {
    ContentValues values = new ContentValues();
    values.put("NIM", student.get_NIM());
    values.put("first_name", student.get_firstName());
    values.put("last_name", student.get_lastName());

    db.insert("student", null, values);
  }

  void insertScore(SQLiteDatabase db, Score score) {
    ContentValues values = new ContentValues();
    values.put("mata_kuliah", score.get_mataKuliah());
    values.put("score_tugas", score.get_scoreTugas());
    values.put("score_uts", score.get_scoreUTS());
    values.put("score_uas", score.get_scoreUAS());

    db.insert("score", null, values);
  }

  void insertStudentScore(SQLiteDatabase db, StudentScore studentScore) {
    ContentValues values = new ContentValues();
    values.put("student_id", studentScore.get_studentId());
    values.put("score_id", studentScore.get_scoreId());

    db.insert("student_score", null, values);
  }

  List<Student> getAllStudents(SQLiteDatabase db) {
    List<Student> students = new ArrayList<Student>();

    String sqlQuery = "SELECT NIM, first_name, last_name FROM student";

    Cursor cursor = db.rawQuery(sqlQuery, null);

    if (cursor.moveToFirst()) {
      do {
        Student student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2));
        students.add(student);
      }
      while (cursor.moveToNext());

      cursor.close();
    }

    return students;
  }

  List<Score> getStudentScoreByNIM(SQLiteDatabase db, String nim) {
    List<Score> scores = new ArrayList<Score>();

    String sqlQuery =
        "SELECT * " +
        "FROM   student a, score b, student_score c " +
        "WHERE  a.nim = '" + nim + "' " +
        "AND    a.student_id = c.student_id " +
        "AND    b.score_id = c.score_id;";

    Cursor cursor = db.rawQuery(sqlQuery, null);

    if(cursor.moveToFirst()) {
      do {
        Score score = new Score(
          cursor.getString(cursor.getColumnIndex("mata_kuliah")),
          cursor.getInt(cursor.getColumnIndex("score_tugas")),
          cursor.getInt(cursor.getColumnIndex("score_uts")),
          cursor.getInt(cursor.getColumnIndex("score_uas"))
        );
        scores.add(score);
      }
      while (cursor.moveToNext());

      cursor.close();
    }

    return scores;
  }
}
