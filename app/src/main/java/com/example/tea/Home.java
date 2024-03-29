package com.example.tea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codebyashish.autoimageslider.AutoImageSlider;
import com.codebyashish.autoimageslider.Enums.ImageScaleType;
import com.codebyashish.autoimageslider.ExceptionsClass;
import com.codebyashish.autoimageslider.Models.ImageSlidesModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;
    TextView txt1, txt2,txt3,txt4,txt5,txt6,txt7;
    Button shop_btn,learn_btn,shop_btn1;
    Animation anim1, anim2, menu_anim,leaf_anim1;
    ImageView imageView,imageView1,imageView2;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    LinearLayout contentView,linearlayout_shop;
    TextView about_us,wholesale_inquiries,coperation_gifts,our_history,careers,charities, support,shipping_returns,faqs,store_location,my_account,privacy_policy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txt1 = findViewById(R.id.textView1);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView5);
        txt4 = findViewById(R.id.textView6);
        txt5 = findViewById(R.id.experience);
        txt6 = findViewById(R.id.story_behind);
        txt7 = findViewById(R.id.specilize);
        shop_btn = findViewById(R.id.shop_Btn);
        learn_btn = findViewById(R.id.learn_more);
        shop_btn1 = findViewById(R.id.shop_Btn1);
        linearlayout_shop = findViewById(R.id.linear_layout_shop);
        imageView = findViewById(R.id.menu_image);
        imageView1 = findViewById(R.id.cart_image);
        imageView2 = findViewById(R.id.white_leaf_image1);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigtion_view);
        contentView = findViewById(R.id.convert_view_linearlayout);
        about_us=findViewById(R.id.home_about_us);
        wholesale_inquiries=findViewById(R.id.home_whole_sale_inquiries);
        coperation_gifts=findViewById(R.id.home_coperation_gifts);
        our_history=findViewById(R.id.home_our_history);
        careers=findViewById(R.id.home_careers);
        charities=findViewById(R.id.home_charities);
        support=findViewById(R.id.home_support);
        shipping_returns=findViewById(R.id.home_shipping_returns);
        faqs=findViewById(R.id.home_home_faqs);
        store_location=findViewById(R.id.home_store_locator);
        my_account=findViewById(R.id.home_my_account);
        privacy_policy=findViewById(R.id.home_privacy_policy);


        anim1 = AnimationUtils.loadAnimation(this, R.anim.animation);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.animation_text);
        menu_anim = AnimationUtils.loadAnimation(this, R.anim.leaf_anim);
        leaf_anim1 = AnimationUtils.loadAnimation(this,R.anim.leaf_anim);

        txt1.setAnimation(anim1);
        txt2.setAnimation(anim2);
        linearlayout_shop.setAnimation(anim1);
//        imageView.setAnimation(menu_anim);
//        imageView1.setAnimation(menu_anim);
        txt3.setAnimation(anim1);
        txt4.setAnimation(anim2);
        imageView2.setAnimation(leaf_anim1);
        txt5.setAnimation(anim1);
        txt6.setAnimation(anim1);
        txt7.setAnimation(anim1);
        learn_btn.setAnimation(anim1);


        NavigationDrawer();
        AnimationNavigationDrawer();
        AutoImageSliders();


        shop_btn.setOnClickListener(v -> startActivity(new Intent(Home.this, Shop.class)));

        shop_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Shop.class));
            }
        });
    }

    private void AutoImageSliders() {

        AutoImageSlider autoImageSlider = findViewById(R.id.autoImageSlider);

        ArrayList<ImageSlidesModel> imageSlidesModels = new ArrayList<>();

        try {

            imageSlidesModels.add(new ImageSlidesModel("https://images.unsplash.com/photo-1625033405953-f20401c7d848?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8Y2hhaXxlbnwwfHwwfHx8MA%3D%3D","Chai Teas"));
            imageSlidesModels.add(new ImageSlidesModel("https://plus.unsplash.com/premium_photo-1677528573563-44ac31cd3b7e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8Y2hhaXxlbnwwfHwwfHx8MA%3D%3D","Tea"));
            imageSlidesModels.add(new ImageSlidesModel("https://images.unsplash.com/photo-1536514888772-a269c6a8a198?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTR8fGNoYWl8ZW58MHx8MHx8fDA%3D","Single Estate"));
            imageSlidesModels.add(new ImageSlidesModel("https://images.unsplash.com/photo-1614221724928-a0ee7470a1f3?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fGNoYWl8ZW58MHx8MHx8fDA%3D","Japanese Matcha"));

            autoImageSlider.setImageList(imageSlidesModels, ImageScaleType.CENTER_CROP);
            autoImageSlider.setDefaultAnimation();
        }
        catch (ExceptionsClass e){
            throw new RuntimeException(e);
        }
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
//            Toast.makeText(this, "Main Home", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(Home.this, Home.class));


        } else if (item.getItemId() == R.id.nav_shop_home) {
//            Toast.makeText(this, "Shop Home", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(Home.this, Home_Shop_now.class));


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