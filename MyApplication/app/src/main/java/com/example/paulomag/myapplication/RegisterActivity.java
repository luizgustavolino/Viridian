package com.example.paulomag.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.paulomag.myapplication.Classes.User;
import com.example.paulomag.myapplication.Database.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final DatabaseHelper dh = new DatabaseHelper(this);

        Button register = (Button) findViewById(R.id.button3);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TextView txtUser = (TextView) findViewById(R.id.cadUserTxt);
                TextView txtPass = (TextView) findViewById(R.id.cadPassTxt);
                TextView txtConf = (TextView) findViewById(R.id.confPassTxt);

                if(txtPass.getText().toString().equals(txtConf.getText().toString())
                        && txtPass.getText().toString().length() > 3){
                    User us = new User(txtUser.getText().toString(), txtPass.getText().toString());
                    dh.newUser(us);

                    Snackbar.make(view, "Usuário cadastrado com sucesso!", Snackbar.LENGTH_LONG).show();

                    Intent intnt = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intnt);
                }else{
                    Snackbar.make(view, "Digite uma senha com mais de 3 caracteres!", Snackbar.LENGTH_LONG).show();
                }

            }
        } );
        getSupportActionBar().setTitle("ADO 4 - Login DB");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent intnt = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intnt);

        return true;
    }


    @Override
    public void onBackPressed() {
    }
}
