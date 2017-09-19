package com.example.paulomag.ado5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class blueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue);

        getSupportActionBar().setTitle("Tela Azul");
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
