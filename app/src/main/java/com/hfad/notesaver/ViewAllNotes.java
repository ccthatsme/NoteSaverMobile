package com.hfad.notesaver;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewAllNotes extends AppCompatActivity {

    private  TextView tv;
    private ArrayList<Note> list = new ArrayList<>();
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

//        if(getIntent().getExtras() != null){
//            Intent intent = getIntent();
//            String detailNote = intent.getExtras().getString("note_parcel");
//
//            tv = findViewById(R.id.note_view);
//            tv.setText(detailNote);
//        }

        if (getIntent().getSerializableExtra("note_parcel") != null) {

            Intent intent = getIntent();
            list = (ArrayList<Note>) intent.getSerializableExtra("list");
            lv = findViewById(R.id.list_view);

           // list.add(note);

            ArrayAdapter<Note> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                    list);

            lv.setAdapter(adapter);

//trying to pass in an arraylist instead of the note, then pass it back to the add note activity so as to keep adding to it
            //did not work on first try

//            //String noteDetail = note.getNote();
//             tv = findViewById(R.id.note_view);
//                tv.setText(noteDetail);
        }
    //wont start from the home screen i think because its not passing in a parcel
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main_for_view_all, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.create_note_action:
                Intent intent2 = new Intent(this, AddNote.class);
                intent2.putExtra("list",list);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
