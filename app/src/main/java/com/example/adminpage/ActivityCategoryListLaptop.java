package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.adminpage.adapter.ProductAdapter;
import com.example.adminpage.model.Product;
import com.example.adminpage.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityCategoryListLaptop extends AppCompatActivity {

    Function function = new Function();
    Toolbar toolbar_cgr_list_laptop;
    RecyclerView rcv_laptop;
    ImageView imgV_add_lap;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_list_lap);

        // Ánh xạ
        toolbar_cgr_list_laptop = findViewById(R.id.toolbar_have_icon_add);
        rcv_laptop = findViewById(R.id.rcv_laptop);
        imgV_add_lap = findViewById(R.id.imgV_icon_add);

        // Set title cho toolbar
        setTitle("Danh sách laptop");
        setSupportActionBar(toolbar_cgr_list_laptop);

        // Set sự kiện cho nút back của toolbar
        toolbar_cgr_list_laptop.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set sự kiện cho nút add trên toolbar
        imgV_add_lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function.goToActivityCategoryAddLaptop(ActivityCategoryListLaptop.this);
            }
        });

        productAdapter = new ProductAdapter(getLT(), new ProductAdapter.IClickItemListener() {
            @Override
            public void onClickItem(Product product) {

            }
        });

        rcv_laptop.setAdapter(productAdapter);
        rcv_laptop.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL, false));
    }

    private ArrayList<Product> getLT() {
        final ArrayList<Product> list = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.duongdanlaptop, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int id = 0;
                    String ten = "";
                    String hinhanh = "";
                    Integer gia = 0;
                    String thongsokithuat = "";
                    String mota = "";
                    int idsanphamlaptop = 0;
                    int idsanpham = 0;
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            ten = jsonObject.getString("ten");
                            hinhanh = jsonObject.getString("hinhanh");
                            gia = jsonObject.getInt("gia");
                            thongsokithuat = jsonObject.getString("thongsokithuat");
                            mota = jsonObject.getString("mota");
                            idsanphamlaptop = jsonObject.getInt("idsanphamlaptop");
                            idsanpham = jsonObject.getInt("idsanpham");
                            list.add(new Product(id, ten, hinhanh, gia, thongsokithuat, mota, idsanphamlaptop, idsanpham));
                            productAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
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
