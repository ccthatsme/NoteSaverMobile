package com.hfad.notesaver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomePage extends Activity {

    private ListView list;
    private String[] taskItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        taskItems = getResources().getStringArray(R.array.options);
        list = (ListView) findViewById(R.id.startingtask);
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, taskItems );

        list.setAdapter(itemAdapter);

        //need to finish this method
       // list.setOnItemClickListener();
    }
}
