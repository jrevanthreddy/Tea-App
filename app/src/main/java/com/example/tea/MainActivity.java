package com.example.tea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=2500;
    Animation text_ani,text_ani2,leaf_anim1,pot_anim,white_leaf_ani;
    TextView txt1,txt2;
    ImageView image1,image2,image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=findViewById(R.id.textView);
        txt2=findViewById(R.id.textView2);
        image1=findViewById(R.id.leaf_image);
        image2=findViewById(R.id.pot_image);
        image3=findViewById(R.id.white_leaf_image);

        text_ani = AnimationUtils.loadAnimation(this,R.anim.animation);
        text_ani2 = AnimationUtils.loadAnimation(this,R.anim.animation_text);
        leaf_anim1 = AnimationUtils.loadAnimation(this,R.anim.leaf_anim);
        pot_anim = AnimationUtils.loadAnimation(this,R.anim.pot_anim);
        white_leaf_ani = AnimationUtils.loadAnimation(this,R.anim.white_leaf_anim);

        txt1.setAnimation(text_ani);
        txt2.setAnimation(text_ani2);
        image1.setAnimation(leaf_anim1);
        image2.setAnimation(pot_anim);
        image3.setAnimation(white_leaf_ani);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, Home.class));
                finish();
            }
        },SPLASH_SCREEN);
    }
}