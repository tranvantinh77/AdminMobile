package com.example.adminpage;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ActivityUser extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout_user;
    NavigationView navigationView_user;
    Toolbar toolbar_user;
    CardView cardV_allUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        drawerLayout_user = findViewById(R.id.drawer_layout_user);
        navigationView_user = findViewById(R.id.nav_view);
        toolbar_user = findViewById(R.id.toolbar_activity);
        cardV_allUser = findViewById(R.id.cardV_all_user);

        setTitle("Quản lý người dùng");
        setSupportActionBar(toolbar_user);

        // Set MenuItem "Quản lý người dùng" được check và uncheck phần còn lại
        setUserChecked();

        // Kích hoạt NavigationView
        navigationView_user.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout_user, toolbar_user, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout_user.addDrawerListener(toggle);
        toggle.syncState();
        navigationView_user.setNavigationItemSelectedListener(this);

        // Chuyển đến các Fragment
        cardV_allUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void setUserChecked() {
        Menu menu = navigationView_user.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            if (menu.getItem(i).isChecked()) {
                menu.getItem(i).setChecked(false);
            }
        }
        menu.getItem(3).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home_item:
                finish();
                break;
            case R.id.nav_order_item:
                Function.goToActivityOrder(ActivityUser.this);
                finish();
                break;
            case R.id.nav_category_item:
                Function.goToActivityUser(ActivityUser.this);
                finish();
                break;
            case R.id.nav_user_item:
                drawerLayout_user.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_logout_item:
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout_user.isDrawerOpen(GravityCompat.START)) {
            drawerLayout_user.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }
}
