package com.example.tea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Page extends AppCompatActivity {
    Button button;
    TextView textView,editTextEmail,editTextPassword;
    ImageView imageView,imageView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        button=findViewById(R.id.login);
        textView=findViewById(R.id.onRegisterNew);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        imageView=findViewById(R.id.facebook);
        imageView1=findViewById(R.id.google);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attentLogin();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Page.this, Register_page.class));

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/login/")));
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://mail.google.com/mail/u/0/")));
            }
        });
    }

    private void attentLogin() {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Enter Details", Toast.LENGTH_SHORT).show();
        }else {
            startActivity(new Intent(Login_Page.this,Home.class));
        }
    }
}