package com.example.adminpage;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class ActivityCategory extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Function function = new Function();
    DrawerLayout drawerLayout_cgr;
    NavigationView navigationView_cgr;
    Toolbar toolbar_cgr;
    CardView cardV_allCategory, cardV_addCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr);

        drawerLayout_cgr = findViewById(R.id.drawer_layout_cgr);
        navigationView_cgr = findViewById(R.id.nav_view);
        toolbar_cgr = findViewById(R.id.toolbar_activity);
        cardV_allCategory = findViewById(R.id.cardV_all_category);
        cardV_addCategory = findViewById(R.id.cardV_add_category);

        setTitle("Quản lý danh mục");
        setSupportActionBar(toolbar_cgr);

        // Set MenuItem "Quản lý danh mục" được check và uncheck phần còn lại
        setCategoryChecked();

        // Kích hoạt NavigationView
        navigationView_cgr.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout_cgr, toolbar_cgr, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout_cgr.addDrawerListener(toggle);
        toggle.syncState();
        navigationView_cgr.setNavigationItemSelectedListener(this);

        // Chuyển đến các Activity con
        cardV_allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function.goToActivityCategoryList(ActivityCategory.this);
            }
        });

        cardV_addCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function.goToActivityCategoryAdd(ActivityCategory.this);
            }
        });

    }

    public void setCategoryChecked() {
        Menu menu = navigationView_cgr.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            if (menu.getItem(i).isChecked()) {
                menu.getItem(i).setChecked(false);
            }
        }
        menu.getItem(2).setChecked(true);
    }


//    public void goToFragmentCategory_List() {
//        FragmentCategoryList fragmentCategoryList = new FragmentCategoryList();
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.fragment_container_cgr, fragmentCategoryList);
//        ft.addToBackStack(FragmentCategoryList.TAG);
//        ft.commit();
//        drawerLayout_cgr.setVisibility(View.INVISIBLE);
//    }

//    public void goToFragmentCategory_Add() {
//        FragmentCategoryAdd fragmentCategoryAdd = new FragmentCategoryAdd();
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.fragment_container_cgr, fragmentCategoryAdd);
//        ft.addToBackStack(FragmentCategoryAdd.TAG);
//        ft.commit();
//        drawerLayout_cgr.setVisibility(View.INVISIBLE);
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home_item:
                finish();
                break;
            case R.id.nav_order_item:
                function.goToActivityOrder(ActivityCategory.this);
                finish();
                break;
            case R.id.nav_category_item:
                drawerLayout_cgr.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_user_item:
                function.goToActivityUser(ActivityCategory.this);
                finish();
                break;
            case R.id.nav_logout_item:
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        int backStackEntryCount = this.getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount > 0) {
            if (backStackEntryCount == 1) {
                drawerLayout_cgr.setVisibility(View.VISIBLE);
            }
            getSupportFragmentManager().popBackStack();
        } else {
            if (drawerLayout_cgr.isDrawerOpen(GravityCompat.START)) {
                drawerLayout_cgr.closeDrawer(GravityCompat.START);
            } else {
                finish();
            }
        }
    }

}
