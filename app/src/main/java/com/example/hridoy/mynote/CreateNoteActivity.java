package com.example.hridoy.mynote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNoteActivity extends AppCompatActivity {

    EditText titleEditText, descriptionEditText;

    DBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        titleEditText = findViewById(R.id.title_et);
        descriptionEditText = findViewById(R.id.description_et);

        myDBHelper = new DBHelper(CreateNoteActivity.this);



    }

    public void saveBtnClick(View view) {

        String titleString = titleEditText.getText().toString();
        String descriptionString = descriptionEditText.getText().toString();

        if (titleString.equals("") || descriptionString.equals("")){
            Toast.makeText(this, "Please insert a note", Toast.LENGTH_SHORT).show();
        }else{

            myDBHelper.addData(titleString,descriptionString);

            Intent intent = new Intent(CreateNoteActivity.this,MainActivity.class);
            startActivity(intent);

        }


    }
}
