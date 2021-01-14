package com.example.adminpage;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ActivityOrder extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout_ord;
    NavigationView navigationView_ord;
    Toolbar toolbar_ord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        drawerLayout_ord = findViewById(R.id.drawer_layout_ord);
        navigationView_ord = findViewById(R.id.nav_view);
        toolbar_ord = findViewById(R.id.toolbar_activity);

        setTitle("Quản lý đơn hàng");
        setSupportActionBar(toolbar_ord);

        // Set MenuItem "Quản lý đơn hàng" được check và uncheck phần còn lại
        setOrderChecked();

        // Kích hoạt NavigationView
        navigationView_ord.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout_ord, toolbar_ord, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout_ord.addDrawerListener(toggle);
        toggle.syncState();
        navigationView_ord.setNavigationItemSelectedListener(this);

        // Chuyển đến các Fragment

    }

    public void setOrderChecked() {
        Menu menu = navigationView_ord.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            if (menu.getItem(i).isChecked()) {
                menu.getItem(i).setChecked(false);
            }
        }
        menu.getItem(1).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home_item:
                finish();
                break;
            case R.id.nav_order_item:
                drawerLayout_ord.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_category_item:
                Function.goToActivityCategory(ActivityOrder.this);
                break;
            case R.id.nav_user_item:
                Function.goToActivityUser(ActivityOrder.this);
                break;
            case R.id.nav_logout_item:
                break;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout_ord.isDrawerOpen(GravityCompat.START)) {
            drawerLayout_ord.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }

}
