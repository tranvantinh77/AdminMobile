package com.example.adminpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.adminpage.adapter.UserAdapter;
import com.example.adminpage.model.Product;
import com.example.adminpage.model.User;
import com.example.adminpage.ultil.Server;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityUser extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout_user;
    NavigationView navigationView_user;
    Toolbar toolbar_user;
    CardView cardV_allUser;
    RecyclerView rcv_user;
    ArrayList<User> list;
    UserAdapter userAdapter;
    TextView tv_numb_user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        drawerLayout_user = findViewById(R.id.drawer_layout_user);
        navigationView_user = findViewById(R.id.nav_view);
        toolbar_user = findViewById(R.id.toolbar_activity);
        cardV_allUser = findViewById(R.id.cardV_all_user);
        rcv_user = findViewById(R.id.rcv_user);
        tv_numb_user = findViewById(R.id.txtV_numbs_user);

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

        userAdapter = new UserAdapter(getAllUser(), new UserAdapter.IClickItemListener() {
            @Override
            public void onClickEdit(User user) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("user", user);
                Intent intent = new Intent(getApplicationContext(), ActivityCategoryEditUser.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        rcv_user.setAdapter(userAdapter);
        rcv_user.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

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
                startActivity(new Intent(ActivityUser.this, ActivityLogin.class));
                finish();
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

    private ArrayList<User> getAllUser() {
        list = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.datauser, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int id = 0;
                String fullname = "";
                String email = "";
                String phone = "";
                int role = 0;
                if (response != null) {
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            fullname = jsonObject.getString("fullname");
                            email = jsonObject.getString("email");
                            phone = jsonObject.getString("phone");
                            role = jsonObject.getInt("role");
                            list.add(new User(id, fullname, email, phone, role));
                            tv_numb_user.setText(String.valueOf(list.size()));
                            userAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonArrayRequest);

        return list;
    }
}
