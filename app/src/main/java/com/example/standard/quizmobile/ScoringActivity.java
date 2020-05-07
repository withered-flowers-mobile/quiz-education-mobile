package com.example.standard.quizmobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.standard.quizmobile.POJO.Score;

import java.util.ArrayList;

public class ScoringActivity extends AppCompatActivity {

  DatabaseHandler db;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scoring);

    db = new DatabaseHandler(this);

    if (this.getIntent() != null) {
      Intent intent = getIntent();
      String studentNIM = intent.getStringExtra("student_nim");
      String studentName = intent.getStringExtra("student_fname") + " " + intent.getStringExtra("student_lname");

      TextView tvNIM = (TextView) findViewById(R.id.scoring_textview01);
      TextView tvName = (TextView) findViewById(R.id.scoring_textview02);

      tvNIM.setText(studentNIM);
      tvName.setText(studentName);

      if (db != null) {
        ArrayList<Score> scores = new ArrayList<>(db.getStudentScoreByNIM(db.getReadableDatabase(), studentNIM));

        ListAdapterScoring adp = new ListAdapterScoring(this, scores);

        ListView lvwScoring = (ListView) findViewById(R.id.scoring_listview);
        lvwScoring.setAdapter(adp);
      }
    }
  }

  public class ListAdapterScoring extends ArrayAdapter<Score> {
    public ListAdapterScoring(Context ctx, ArrayList<Score> scores) {
      super(ctx, 0, scores);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      Score score = getItem(position);

      if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_scoring, parent, false);
      }

      TextView tvHeader = convertView.findViewById(R.id.textview_Header);
      TextView tvContent01 = convertView.findViewById(R.id.textview_Content01);
      TextView tvContent02 = convertView.findViewById(R.id.textview_Content02);
      TextView tvContent03 = convertView.findViewById(R.id.textview_Content03);

      assert score != null;
      tvHeader.setText(score.get_mataKuliah());
      tvContent01.setText("TGS: " + String.valueOf(score.get_scoreTugas()));
      tvContent02.setText("UTS: " + String.valueOf(score.get_scoreUTS()));
      tvContent03.setText("UAS: " + String.valueOf(score.get_scoreUAS()));

      return convertView;
    }
  }
}
