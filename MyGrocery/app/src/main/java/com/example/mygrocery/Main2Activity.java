package com.example.mygrocery;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView boal1, rui1, pangas1, hilsha1, katla1, orange1, banana1, mango1, pineapple1, apple1, chicken1, beef1, mutton1, koyel1, butter1, cheese1, egg1, milk1, chilli1, daruchini1, elachi1, kalojira1;
    private Button showItem;

    MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myDatabaseHelper = new MyDatabaseHelper(this);
        SQLiteDatabase sqLiteOpenHelper = myDatabaseHelper.getWritableDatabase();

        boal1 = (ImageView) findViewById(R.id.boal);
        rui1 = (ImageView) findViewById(R.id.rui);
        pangas1 = (ImageView) findViewById(R.id.pangas);
        hilsha1 = (ImageView) findViewById(R.id.hilsha);
        katla1 = (ImageView) findViewById(R.id.katla);

        orange1 = (ImageView) findViewById(R.id.orange);
        banana1 = (ImageView) findViewById(R.id.banana);
        mango1 = (ImageView) findViewById(R.id.mango);
        pineapple1 = (ImageView) findViewById(R.id.pineapple);
        apple1 = (ImageView) findViewById(R.id.apple);

        chicken1 = (ImageView) findViewById(R.id.chicken);
        beef1 = (ImageView) findViewById(R.id.beef);
        mutton1 = (ImageView) findViewById(R.id.mutton);
        koyel1 = (ImageView) findViewById(R.id.koyel);

        butter1 = (ImageView) findViewById(R.id.butter);
        cheese1 = (ImageView) findViewById(R.id.cheese);
        egg1 = (ImageView) findViewById(R.id.egg);
        milk1 = (ImageView) findViewById(R.id.milk);

        chilli1 = (ImageView) findViewById(R.id.chilli);
        daruchini1 = (ImageView) findViewById(R.id.daruchini);
        elachi1 = (ImageView) findViewById(R.id.elachi);
        kalojira1 = (ImageView) findViewById(R.id.kalojira);

        showItem = (Button) findViewById(R.id.showIT);

        boal1.setOnClickListener(this);
        rui1.setOnClickListener(this);
        pangas1.setOnClickListener(this);
        hilsha1.setOnClickListener(this);
        katla1.setOnClickListener(this);

        showItem.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.boal) {
            String item = "boal";
            int price = 200;
            myDatabaseHelper.insert(item, price);
            Toast.makeText(Main2Activity.this, "Boal", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.rui) {
            String item = "rui";
            int price = 310;
            myDatabaseHelper.insert(item, price);
            Toast.makeText(Main2Activity.this, "Rui", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.pangas) {
            String item = "pangas";
            int price = 150;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.hilsha) {
            String item = "hilsha";
            int price = 600;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.katla) {
            String item = "katla";
            int price = 300;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.orange) {
            String item = "orange";
            int price = 180;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.banana) {
            String item = "banana";
            int price = 100;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.mango) {
            String item = "mango";
            int price = 230;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.pineapple) {
            String item = "pineapple";
            int price = 60;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.apple) {
            String item = "apple";
            int price = 220;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.chicken) {
            String item = "chicken";
            int price = 200;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.beef) {
            String item = "beef";
            int price = 550;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.mutton) {
            String item = "mutton";
            int price = 700;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.koyel) {
            String item = "koyel";
            int price = 300;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.butter) {
            String item = "butter";
            int price = 170;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.cheese) {
            String item = "cheese";
            int price = 150;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.egg) {
            String item = "egg";
            int price = 120;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.milk) {
            String item = "milk";
            int price = 65;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.chilli) {
            String item = "chilli";
            int price = 50;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.daruchini) {
            String item = "daruchini";
            int price = 50;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.elachi) {
            String item = "elachi";
            int price = 100;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.kalojira) {
            String item = "kalojira";
            int price = 30;
            myDatabaseHelper.insert(item, price);
        } else if (v.getId() == R.id.showIT) {
            Intent regi = new Intent(Main2Activity.this, showItem.class);
            startActivity(regi);
            Toast.makeText(Main2Activity.this, "Items showed", Toast.LENGTH_SHORT).show();

        }

    }
}