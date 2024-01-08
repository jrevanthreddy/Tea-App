package com.example.tea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;
    TextView txt1, txt2;
    Button shop_btn;
    Animation anim1, anim2, menu_anim;
    RelativeLayout relativeLayout;
    ImageView imageView;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ConstraintLayout contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txt1 = findViewById(R.id.textView1);
        txt2 = findViewById(R.id.textView2);
        shop_btn = findViewById(R.id.shop_Btn);
        relativeLayout = findViewById(R.id.relativelayout);
        imageView = findViewById(R.id.menu_image);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigtion_view);
        contentView = findViewById(R.id.layout_context);

        anim1 = AnimationUtils.loadAnimation(this, R.anim.animation);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.animation_text);
        menu_anim = AnimationUtils.loadAnimation(this, R.anim.leaf_anim);

        txt1.setAnimation(anim1);
        txt2.setAnimation(anim2);
        relativeLayout.setAnimation(anim1);
        imageView.setAnimation(menu_anim);

        NavigationDrawer();
        AnimationNavigationDrawer();

        shop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "shop", Toast.LENGTH_SHORT).show();
            }
        });
    }


    //Navigation Drawer functions
    private void NavigationDrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void AnimationNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);
                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //Home
        if (item.getItemId() == R.id.nav_main_home) {
            Toast.makeText(this, "Main Home", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.nav_shop_home) {
            Toast.makeText(this, "Shop Home", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.nav_dark_home_tea_room) {
            Toast.makeText(this, "Dark Home Tea Room", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.nav_metro_matcha) {
            Toast.makeText(this, "Metro Matcha", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.nav_verticl_shoecases) {
            Toast.makeText(this, "Vertical Shoecases", Toast.LENGTH_SHORT);
        }
        //Page
        else if (item.getItemId() == R.id.nav_about_us) {
            showToast("About Us");
        } else if (item.getItemId() == R.id.nav_our_history) {
            showToast("Our History");
        } else if (item.getItemId() == R.id.nav_our_process) {
            showToast("Our Process");
        } else if (item.getItemId() == R.id.nav_restaurant_menu) {
            showToast("Restaurant Menu");
        } else if (item.getItemId() == R.id.nav_booking_table) {
            showToast("Booking Table");
        } else if (item.getItemId() == R.id.nav_our_team) {
            showToast("Our Team");
        } else if (item.getItemId() == R.id.nav_price_plan) {
            showToast("Price Plan");
        } else if (item.getItemId() == R.id.nav_faqs) {
            showToast("FAQs");
        } else if (item.getItemId() == R.id.nav_contact_us) {
            showToast("Contact Us");
        } else if (item.getItemId() == R.id.nav_404_error_page) {
            showToast("404 Error Page");
        } else if (item.getItemId() == R.id.nav_Coming_soon) {
            showToast("Coming Soon");
        }

        // SHOP
        else if (item.getItemId() == R.id.nav_shop_layout) {
            showToast("Shop Layout");
        } else if (item.getItemId() == R.id.nav_product_layout) {
            showToast("Product Layouts");
        } else if (item.getItemId() == R.id.nav_product_types) {
            showToast("Product Types");
        } else if (item.getItemId() == R.id.nav_shop_pages) {
            showToast("Shop Pages");
        }

        // GALLERY
        else if (item.getItemId() == R.id.nav_gallery_2_columns) {
            showToast("Gallery 2 Columns");
        } else if (item.getItemId() == R.id.nav_gallery_3_columns) {
            showToast("Gallery 3 Columns");
        } else if (item.getItemId() == R.id.nav_gallery_4_columns) {
            showToast("Gallery 4 Columns");
        } else if (item.getItemId() == R.id.nav_gallery_mixed_style) {
            showToast("Gallery Mixed Style");
        }

        // BLOG
        else if (item.getItemId() == R.id.nav_no_sidebar) {
            showToast("NO Slidebar");
        } else if (item.getItemId() == R.id.nav_right_sidebar) {
            showToast("Right Sidebar");
        } else if (item.getItemId() == R.id.nav_left_sidebar) {
            showToast("Left Sidebar");
        } else if (item.getItemId() == R.id.nav_single_post_types) {
            showToast("Single Post Types");
        } else if (item.getItemId() == R.id.nav_standard_post) {
            showToast("Standard Post");
        } else if (item.getItemId() == R.id.nav_quote_post) {
            showToast("Quote Post");
        } else if (item.getItemId() == R.id.nav_link_post) {
            showToast("Link Post");
        } else if (item.getItemId() == R.id.nav_audio_post) {
            showToast("Audio Post");
        } else if (item.getItemId() == R.id.nav_gallery_post) {
            showToast("Gallery Post");
        } else if (item.getItemId() == R.id.nav_video_post) {
            showToast("Video Post");
        } else if (item.getItemId() == R.id.nav_no_side_bar_post) {
            showToast("No Sidebar Post");
        } else {
            return super.onOptionsItemSelected(item);
        }
        return false;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}