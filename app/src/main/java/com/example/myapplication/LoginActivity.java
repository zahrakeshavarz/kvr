package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button loginn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        loginn=findViewById(R.id.logbtn);
        loginn.setOnClickListener(view -> {
            String usr = username.getText().toString();
            String pass = password.getText().toString();
            databaseAccess databaseAccess = new databaseAccess(LoginActivity.this);
            Cursor c = databaseAccess.getDb().rawQuery("SELECT * from user WHERE userName=? ", new String[]{usr});
            c.moveToFirst();
            if (c.isAfterLast()) {
                Toast toast = new Toast(LoginActivity.this);
                toast.makeText(LoginActivity.this, "This user is not available!",
                        Toast.LENGTH_LONG).show();
            } else {
                if (pass.equals(c.getString(4))) {
                    user newuser = new user(c.getString(1), c.getString(2), c.getString(3), c.getString(4));
                    Intent intent = new Intent(this, firstPage.class);
                    startActivity(intent);
                } else {
                    Toast toast = new Toast(LoginActivity.this);
                    toast.makeText(LoginActivity.this, "password is not correct",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

