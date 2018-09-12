package com.example.hridoy.mynote;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView noteListView;
    DBHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteListView = findViewById(R.id.note_list_view);

        mDBHelper = new DBHelper(MainActivity.this);

        ArrayList<String> theTitleList = new ArrayList<>();
        ArrayList<String> theDescriptionList = new ArrayList<>();

        Cursor data = mDBHelper.getListContents();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theTitleList.add(data.getString(1));
                theDescriptionList.add(data.getString(2));
                NoteAdapter listAdapter = new NoteAdapter(MainActivity.this,theTitleList,theDescriptionList);
                noteListView.setAdapter(listAdapter);
            }
        }



    }

    public void createBtnClick(View view) {

        Intent intent = new Intent(MainActivity.this,CreateNoteActivity.class);
        startActivity(intent);

    }
}
