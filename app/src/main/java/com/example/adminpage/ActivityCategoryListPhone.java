package com.example.adminpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.adminpage.adapter.ProductAdapter;
import com.example.adminpage.model.Product;
import com.example.adminpage.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityCategoryListPhone extends AppCompatActivity {

    Toolbar toolbar_cgr_list_phone;
    RecyclerView rcv_phone;
    ImageView imgV_add_phone;
    ArrayList<Product> list = new ArrayList<>();
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
                Function.goToActivityAddProduct(ActivityCategoryListPhone.this);
            }
        });

        // Set sự kiện cho nút edit và nút xoá của từng sản phẩm
        productAdapter = new ProductAdapter(getDT(), new ProductAdapter.IClickItemListener() {
            @Override
            public void onClickEdit(Product product) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("product", product);
                Intent intent = new Intent(getApplicationContext(), ActivityCategoryEditProduct.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void onClickRemove(Product product) {
                String message = "Bạn có chắc muốn xoá ?";
                MyCustomDialog myCustomDialog = new MyCustomDialog(ActivityCategoryListPhone.this, message);
                myCustomDialog.show();
            }
        });

        rcv_phone.setAdapter(productAdapter);
        rcv_phone.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL, false));
    }

    private ArrayList<Product> getDT() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.datasanpham, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String ten = "";
                String hinhanh = "";
                String hinhanh2 = "";
                String hinhanh3 = "";
                String hinhanh4 = "";
                Integer gia = 0;
                String thongsokithuat = "";
                String mota = "";
                int idloaisanpham = 0;
                int idsanpham = 0;
                int status = 0;
                if (response != null) {
                    try {
                        JSONArray jsonArray =new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            ten = jsonObject.getString("ten");
                            hinhanh = jsonObject.getString("hinhanh");
                            hinhanh2 = jsonObject.getString("hinhanh2");
                            hinhanh3 = jsonObject.getString("hinhanh3");
                            hinhanh4 = jsonObject.getString("hinhanh4");
                            gia = jsonObject.getInt("gia");
                            thongsokithuat = jsonObject.getString("thongsokithuat");
                            mota = jsonObject.getString("mota");
                            idloaisanpham = jsonObject.getInt("idloaisanpham");
                            idsanpham = jsonObject.getInt("idsanpham");
                            status = jsonObject.getInt("status");
                            list.add(new Product(id,ten,hinhanh,hinhanh2, hinhanh3, hinhanh4,gia,thongsokithuat,mota,idloaisanpham,idsanpham,status));
                            productAdapter.notifyDataSetChanged();
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
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("idsanpham", String.valueOf(1));
                return param;
            }
        };

        requestQueue.add(stringRequest);

        return list;
    }
}
