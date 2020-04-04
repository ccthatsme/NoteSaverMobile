package com.hfad.notesaver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomePage extends AppCompatActivity {

    private ListView list;
    private String[] taskItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        taskItems = getResources().getStringArray(R.array.options);
        list = (ListView) findViewById(R.id.startingtask);
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taskItems );

        list.setAdapter(itemAdapter);


       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent;

               if(position == 0){
                   intent = new Intent(HomePage.this, AddNote.class);
                   startActivity(intent);
               }

               if(position == 1){
                   intent = new Intent(HomePage.this, ViewAllNotes.class);
                   startActivity(intent);
               }


           }
       });
    }
}
