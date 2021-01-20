package com.example.instagramloginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private DBAdapter adapter;
    private EditText number, fullname, username, password;
    private Button signupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        number = findViewById(R.id.edit_email);
        fullname = findViewById(R.id.edit_fillname);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_password);
        signupBtn = findViewById(R.id.signup_button);

        adapter = new DBAdapter(this);

    }

    private void writeToDatabase(){

        //Get info from EditText
        String mNumber = number.getText().toString();
        String mFullname = fullname.getText().toString();
        String mUsername = username.getText().toString();
        String mPassword = password.getText().toString();

        try{
            SQLiteDatabase database = adapter.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DBContract.Entry.COL_USERNAME, mUsername);
            values.put(DBContract.Entry.COL_PASSWORD, mPassword);
            values.put(DBContract.Entry.COL_NAME, mFullname);
            values.put(DBContract.Entry.COL_NUMBER, mNumber);

            database.insert(DBContract.Entry.TABLE_NAME, null, values);
        }catch (SQLiteException e){
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSignUpClicked(View view){
        writeToDatabase();
        if(username.length() > 1) {
            Toast.makeText(this, "User Registered!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Please enter your username or password", Toast.LENGTH_LONG).show();
        }
    }
}