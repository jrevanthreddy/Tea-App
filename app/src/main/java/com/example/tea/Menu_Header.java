package com.example.tea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Menu_Header extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_header);

        imageView=findViewById(R.id.logo_menu);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Menu_Header.this, "Logo", Toast.LENGTH_SHORT).show();
              //  startActivity(new Intent(Menu_Header.this, Home.class));
            }
        });

    }
}