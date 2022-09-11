package com.example.mygrocery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class showItem extends AppCompatActivity {


    private ListView listItems;
    private ListView listPrice;
    Button ADD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);
        final MyDatabaseHelper db = new MyDatabaseHelper(this);

        final ArrayList array_itemlist = db.viewItem();
        final ArrayList array_list = db.viewPrice();
        ADD = (Button) findViewById(R.id.add);
        listItems = findViewById(R.id.items);
        listPrice = findViewById(R.id.price);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(showItem.this,android.R.layout.simple_list_item_1,array_itemlist);
        final ArrayAdapter array2Adapter = new ArrayAdapter(showItem.this,android.R.layout.simple_list_item_1,array_list);
        listItems.setAdapter(arrayAdapter);
        listPrice.setAdapter(array2Adapter);

        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(showItem.this, Main2Activity.class);
                startActivity(go);

            }
        });

        listItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = parent.getItemAtPosition(position).toString();
                array_itemlist.remove(position);
                arrayAdapter.notifyDataSetChanged();
                array_list.remove(position);
                array2Adapter.notifyDataSetChanged();
                db.deleteEntry(name);
            }
        });



    }

}

