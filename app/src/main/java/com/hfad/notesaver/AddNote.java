package com.hfad.notesaver;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class AddNote extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Note> list = new ArrayList<Note>();
    private ImageButton imageButton;
    private TextView textDate;
    private TextView viewNote;
    private Button button;
    private ListView lv;

    private int year;
    private int month;
    private int day;

    final Calendar c = Calendar.getInstance();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        imageButton = findViewById(R.id.calendar_icon);
        textDate = findViewById(R.id.date);
        button = findViewById(R.id.save);
        viewNote = findViewById(R.id.view);

        imageButton.setOnClickListener(this);
        button.setOnClickListener(this);

        if (getIntent().getSerializableExtra("list") != null) {

            Intent intent = getIntent();
            list = (ArrayList<Note>) intent.getSerializableExtra("list");
            lv = findViewById(R.id.list_view);



        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.view_note_action:
                Intent intent = new Intent(this, ViewAllNotes.class);
                startActivity(intent);
                return true;

             default:
                 return super.onOptionsItemSelected(item);

        }
    }



    @Override
    public void onClick(View v) {

        if (v == imageButton) {
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                textDate.setText((month+1) + "/" + dayOfMonth + "/" + year);
                }
            },year, month, day);
            datePickerDialog.show();
        }

        if (v == button) {
            View viewNoteDetails = findViewById(R.id.note_box);
            EditText noteDetails = findViewById(R.id.note_box);
            String noteText = noteDetails.getText().toString();

            View viewDate = findViewById(R.id.date);
            TextView dateDetails = findViewById(R.id.date);
            String dateText = dateDetails.getText().toString();

            Note note = new Note(dateText, noteText);
           // viewNote.setText(note.toString());
            list.add(note);

            Intent intent = new Intent(this, ViewAllNotes.class);
            intent.putExtra("note_parcel", list);

        startActivity(intent);
        }

    }

//    public void onClickAdd(View view){
//        TextView tv = view.findViewById(R.id.view);
//        View viewNoteDetails = findViewById(R.id.note_box);
//        EditText noteDetails = findViewById(R.id.note_box);
//        String noteText = noteDetails.getText().toString();
//
//        View viewDate = findViewById(R.id.date);
//        TextView dateDetails = findViewById(R.id.date);
//        String dateText = dateDetails.getText().toString();
//
//        Note note = new Note(dateText, noteText);

    //    tv.setText(note.toString());
//
//        list.add(note);
//        String noteDetail = list.toString();
//
//
//        Intent intent = new Intent(this, ViewAllNotes.class);
//        intent.putExtra("note_parcel", "test");
//
//        startActivity(intent);
    //}

}
