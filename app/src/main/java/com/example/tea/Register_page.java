package com.example.tea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Register_page extends AppCompatActivity {
    Button button;
    TextView textView,editTextName,editTextEmail,editTextMobile,editTextPassword;
    ImageView imageView,imageView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        button=findViewById(R.id.register);
        textView=findViewById(R.id.LoginAlready);
        imageView=findViewById(R.id.facebook_image);
        imageView1=findViewById(R.id.google_image);
        editTextName=findViewById(R.id.editTextName);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextMobile=findViewById(R.id.editTextMobile);
        editTextPassword=findViewById(R.id.editTextPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register_page.this,Login_Page.class));
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

    private void register() {
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String mobile = editTextMobile.getText().toString();
        String password = editTextPassword.getText().toString();

        if (name.isEmpty() || email.isEmpty() || mobile.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Fill Details", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(Register_page.this, Login_Page.class));
            Toast.makeText(Register_page.this, "Register Successfully", Toast.LENGTH_SHORT).show();
        }
    }
}