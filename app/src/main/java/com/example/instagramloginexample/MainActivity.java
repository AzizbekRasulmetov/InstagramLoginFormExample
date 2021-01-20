package com.example.instagramloginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText username, password;
    private DBAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new DBAdapter(this);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_password);
        loginBtn = findViewById(R.id.login_button);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verifyLogin(username.getText().toString(), password.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Successfully Loged.", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid username or password!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onSignUpClicked(View view){
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }

    public boolean verifyLogin(String username, String password){
        if(username.length() < 1 || password.length() < 1){
            return false;
        }
        SQLiteDatabase database = adapter.getReadableDatabase();
        Cursor cursor = database.query(DBContract.Entry.TABLE_NAME, new String[]{DBContract.Entry.COL_USERNAME, DBContract.Entry.COL_PASSWORD}, DBContract.Entry.COL_USERNAME + "= ?", new String[]{username}, null, null, null);
        if(cursor.moveToFirst()){
            if(cursor.getString(0).equals(username) && cursor.getString(1).equals(password)){
                cursor.close();
                database.close();
                return true;
            }else {
                return false;
            }
        }
        cursor.close();
        database.close();
        return false;
    }

    public void onForgotDetailsClicked(View view){
        startActivity(new Intent(MainActivity.this, ForgotLoginDetailsActivity.class));
    }

}