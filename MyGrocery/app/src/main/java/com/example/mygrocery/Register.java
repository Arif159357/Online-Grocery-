package com.example.mygrocery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText username, password, Confirm_password;
    Button  Register;
    Databasehelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new Databasehelper(this);
        username = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.pass);
        Confirm_password = (EditText) findViewById(R.id.Conpass);
        Register = (Button) findViewById(R.id.reg);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString().trim();
                String pwd  = password.getText().toString().trim();
                String cnf_pwd = Confirm_password.getText().toString().trim();
                if(pwd.equals(cnf_pwd)){
                    db.addUser(user,pwd);

                    Toast.makeText(Register.this,"You have registered ",Toast.LENGTH_LONG).show();
                    Intent signIn = new Intent(Register.this, MainActivity.class);
                    startActivity(signIn);


                }
                else{
                    Toast.makeText(Register.this,"Password is not matched ",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
