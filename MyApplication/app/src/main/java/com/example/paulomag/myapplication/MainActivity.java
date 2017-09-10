package com.example.paulomag.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.paulomag.myapplication.Classes.User;
import com.example.paulomag.myapplication.Database.DatabaseHelper;

import static com.example.paulomag.myapplication.R.layout.activity_register;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper dh = new DatabaseHelper(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button signup = (Button) findViewById(R.id.btnSignup);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent x = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(x);
            }
        });

        Button signin = (Button) findViewById(R.id.btnLogin);
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                TextView user = (TextView) findViewById(R.id.username);
                TextView password = (TextView) findViewById(R.id.password);

                if(!user.getText().toString().equals("") && !password.getText().toString().equals("")) {
                    User login = new User(user.getText().toString(), password.getText().toString());

                    DatabaseHelper dh = new DatabaseHelper(MainActivity.this);

                    if (dh.userExists(login)) {

                        Snackbar.make(view, "Você entrou como " + user.getText().toString() + ".",
                                Snackbar.LENGTH_LONG).show();

                        Intent intnt = new Intent(getApplicationContext(),MenuActivity.class);
                        intnt.putExtra("username",user.getText().toString());
                        startActivity(intnt);
                    } else {
                        Snackbar.make(view, "Usuário ou senha incorretos.", Snackbar.LENGTH_LONG).show();
                    }
                }else{
                    Snackbar.make(view, "Insira o usuário e a senha para entrar!", Snackbar.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
