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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.standard.quizmobile.POJO.Score;
import com.example.standard.quizmobile.POJO.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  DatabaseHandler db;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    db = new DatabaseHandler(this);

    ArrayList<Student> students = new ArrayList<Student>(db.getAllStudents(db.getReadableDatabase()));

    ListAdapterMain adp = new ListAdapterMain(this, students);

    ListView lvw = (ListView) findViewById(R.id.main_listview);
    lvw.setAdapter(adp);

    lvw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Student student = (Student) adapterView.getItemAtPosition(position);

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ScoringActivity.class);
        intent.putExtra("student_nim", student.get_NIM());
        intent.putExtra("student_fname", student.get_firstName());
        intent.putExtra("student_lname", student.get_lastName());

        startActivity(intent);
      }
    });
  }

  public class ListAdapterMain extends ArrayAdapter<Student> {
    public ListAdapterMain(Context ctx, ArrayList<Student> students) {
      super(ctx, 0, students);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      Student student = getItem(position);

      if(convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_main, parent, false);
      }

      TextView tvHeader = (TextView) convertView.findViewById(R.id.textview_Header);
      TextView tvContent = (TextView) convertView.findViewById(R.id.textview_Content);

      assert student != null;
      tvHeader.setText(student.get_NIM());
      tvContent.setText(student.get_firstName() + " " + student.get_lastName());

      return convertView;
    }
  }
}
