package com.example.mygrocery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, Confirm_password;
    Button SignIn, Register;
    Databasehelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new Databasehelper(this);
        username = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.pass);
        Confirm_password = (EditText) findViewById(R.id.Conpass);
        SignIn = (Button) findViewById(R.id.sigin);
        Register = (Button) findViewById(R.id.reg);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regi = new Intent(MainActivity.this, Register.class);
                startActivity(regi);
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);
                if(res == true){
                    Intent go = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(go);
                    Toast.makeText(MainActivity.this,"Successfull login in", Toast.LENGTH_LONG).show();


                }
                else{
                    Toast.makeText(MainActivity.this,"fail login in", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
