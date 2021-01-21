package com.example.adminpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.adminpage.adapter.OrderAdapter;
import com.example.adminpage.adapter.UserAdapter;
import com.example.adminpage.model.Order;
import com.example.adminpage.model.User;
import com.example.adminpage.ultil.Server;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityOrder extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout_ord;
    NavigationView navigationView_ord;
    Toolbar toolbar_ord;
    RecyclerView rcv_order;
    ArrayList<Order> list;
    OrderAdapter orderAdapter;
    TextView tv_numb_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        drawerLayout_ord = findViewById(R.id.drawer_layout_ord);
        navigationView_ord = findViewById(R.id.nav_view);
        toolbar_ord = findViewById(R.id.toolbar_activity);
        rcv_order = findViewById(R.id.rcv_order);
        tv_numb_order = findViewById(R.id.txtV_numbs_order);

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

        orderAdapter = new OrderAdapter(getAllOrder(), new OrderAdapter.IClickItemListener() {
            @Override
            public void onClickEdit(Order order) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("order", order);
                Intent intent = new Intent(getApplicationContext(), ActivityListOrderDetails.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        rcv_order.setAdapter(orderAdapter);
        rcv_order.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

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
                finish();
                break;
            case R.id.nav_user_item:
                Function.goToActivityUser(ActivityOrder.this);
                finish();
                break;
            case R.id.nav_logout_item:
                startActivity(new Intent(ActivityOrder.this, ActivityLogin.class));
                finish();
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

    private ArrayList<Order> getAllOrder() {
        list = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.dataorder, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int id = 0;
                String tenkhachhang = "";
                String email = "";
                String sodienthoai = "";
                String diachi = "";
                String ghichu = "";
                if (response != null) {
                    try {
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenkhachhang = jsonObject.getString("tenkhachhang");
                            email = jsonObject.getString("email");
                            sodienthoai = jsonObject.getString("sodienthoai");
                            diachi = jsonObject.getString("diachi");
                            ghichu = jsonObject.getString("ghichu");
                            list.add(new Order(id, tenkhachhang, email, sodienthoai, diachi, ghichu));
                            tv_numb_order.setText(String.valueOf(list.size()));
                            orderAdapter.notifyDataSetChanged();
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
