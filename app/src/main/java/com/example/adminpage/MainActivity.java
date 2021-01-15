package com.example.adminpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout_main;
    NavigationView navigationView_main;
    Toolbar toolbar_main;
    CardView cardV_category, cardV_user, cardV_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout_main = findViewById(R.id.drawer_layout_main);
        navigationView_main = findViewById(R.id.nav_view);
        toolbar_main = findViewById(R.id.toolbar_activity);
        cardV_order = findViewById(R.id.cardv_order);
        cardV_category = findViewById(R.id.cardV_category);
        cardV_user = findViewById(R.id.cardV_user);

        setTitle("Trang chủ");
        setSupportActionBar(toolbar_main);

        // Set MenuItem "Trang chủ" được check
        setHomeChecked();

        // Kích hoạt NavigationView
        navigationView_main.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout_main, toolbar_main, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout_main.addDrawerListener(toggle);
        toggle.syncState();
        navigationView_main.setNavigationItemSelectedListener(this);

        // Chuyển đến các Activity khác
        cardV_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Function.goToActivityOrder(MainActivity.this);
            }
        });

        cardV_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Function.goToActivityCategory(MainActivity.this);
            }
        });

        cardV_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Function.goToActivityUser(MainActivity.this);
            }
        });

    }

    // Set MenuItem "Trang chủ" được check và uncheck các MenuItem còn lại
    public void setHomeChecked() {
        Menu menu = navigationView_main.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            if (menu.getItem(i).isChecked()) {
                menu.getItem(i).setChecked(false);
            }
        }
        menu.getItem(0).setChecked(true);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_home_item:
                break;
            case R.id.nav_order_item:
                Function.goToActivityOrder(MainActivity.this);
                break;
            case R.id.nav_category_item:
                Function.goToActivityCategory(MainActivity.this);
                break;
            case R.id.nav_user_item:
                Function.goToActivityUser(MainActivity.this);
                break;
            case R.id.nav_logout_item:
                break;
        }
        drawerLayout_main.closeDrawer(GravityCompat.START);
        return true;
    }

    // Xử lý nút back của smartphone
    @Override
    public void onBackPressed() {
        if (drawerLayout_main.isDrawerOpen(GravityCompat.START)) {
            drawerLayout_main.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        setHomeChecked();
        super.onResume();
    }
}