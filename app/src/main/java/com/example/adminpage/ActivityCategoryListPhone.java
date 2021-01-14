package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

public class ActivityCategoryListPhone extends AppCompatActivity {

    Function function = new Function();
    Toolbar toolbar_cgr_list_phone;
    RecyclerView rcv_phone;
    ImageView imgV_add_phone;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_list_phone);

        // Ánh xạ
        toolbar_cgr_list_phone = findViewById(R.id.toolbar_have_icon_add);
        rcv_phone = findViewById(R.id.rcv_phone);
        imgV_add_phone = findViewById(R.id.imgV_icon_add);

        // Set title cho toolbar
        setTitle("Danh sách điện thoại");
        setSupportActionBar(toolbar_cgr_list_phone);

        // Set sự kiện cho nút back của toolbar
        toolbar_cgr_list_phone.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set sự kiện cho nút add trên toolbar
        imgV_add_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function.goToActivityCategoryAddPhone(ActivityCategoryListPhone.this);
            }
        });

        productAdapter = new ProductAdapter(getDT(), new ProductAdapter.IClickItemListener() {
            @Override
            public void onClickItem(Product product) {

            }
        });

        rcv_phone.setAdapter(productAdapter);
        rcv_phone.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL, false));
    }

    private ArrayList<Product> getDT() {
        final ArrayList<Product> list = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.duongdandienthoai, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int id = 0;
                    String ten = "";
                    String hinhanh = "";
                    Integer gia = 0;
                    String thongsokithuat = "";
                    String mota = "";
                    int idsanphamdienthoai = 0;
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
                            idsanphamdienthoai = jsonObject.getInt("idsanphamdienthoai");
                            idsanpham = jsonObject.getInt("idsanpham");
                            list.add(new Product(id, ten, hinhanh, gia, thongsokithuat, mota, idsanphamdienthoai, idsanpham));
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
