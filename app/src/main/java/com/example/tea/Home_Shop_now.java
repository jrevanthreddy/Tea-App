package com.example.tea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tea.Adapter.Home_Shop_Recycler_Adapter;
import com.example.tea.Model.Home_Shop_Recycler_Model;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Home_Shop_now extends AppCompatActivity {

    TextView latest_products, Featured_products, best_seller;
    ImageView menu_image;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_shop_now);

        latest_products = findViewById(R.id.latest_products);
        Featured_products = findViewById(R.id.Featured_products);
        best_seller = findViewById(R.id.best_seller);
        menu_image = findViewById(R.id.menu_image12);

        best_seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Best_seller bestSeller = new Best_seller();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_recycler, bestSeller).commit();

                animatioinForProducts(best_seller);
            }
        });
        Featured_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Featured_Products featuredProducts = new Featured_Products();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_recycler, featuredProducts).commit();
                animatioinForProducts(Featured_products);
            }
        });
        latest_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Latest_Products latestProducts = new Latest_Products();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_recycler, latestProducts).commit();
                animatioinForProducts(latest_products);
            }
        });
    }

            private void animatioinForProducts(final TextView textView) {

                Animation animation = AnimationUtils.loadAnimation(this, R.anim.shop_layout);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
//                textView.setTextColor(Color.BLACK);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
//                textView.setTextColor(Color.BLACK);
                    }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        textView.startAnimation(animation);

        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}