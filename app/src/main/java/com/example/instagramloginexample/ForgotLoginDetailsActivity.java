package com.example.instagramloginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotLoginDetailsActivity extends AppCompatActivity {

    private EditText editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_login_details);

        editEmail = findViewById(R.id.edit_email);
    }


    public void onNewAccountClicked(View view){
        startActivity(new Intent(ForgotLoginDetailsActivity.this, SignUpActivity.class));
    }

    public void onBackToLoginClicked(View view){
        startActivity(new Intent(ForgotLoginDetailsActivity.this, MainActivity.class));
    }

    public void onSendEmailClicked(View view) {

        String emailAddress = editEmail.getText().toString();
        String msg = "Hi user!\n I am very glad that you are using my app). Hope to see you in my Instagram (@programmer_in). Follow me on Instagram.";
        if(emailAddress.endsWith("@gmail.com")){
            Log.i("Send Email", "");
            String [] TO = {emailAddress};

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");

            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Reset Login Details");
            emailIntent.putExtra(Intent.EXTRA_TEXT, msg);

            try{
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
                finish();
                Log.i("Finished sending email", "");
            }catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(this, "There is no email client installed", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_LONG).show();
        }


    }
}