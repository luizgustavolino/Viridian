package com.example.paulomag.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String username = getIntent().getExtras().getString("username");
        TextView txtv = (TextView) findViewById(R.id.txtWelcome);
        txtv.setText("Bem vindo, " + username + "!");

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
