package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.adminpage.ultil.Server;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ActivityCategoryAddProduct extends AppCompatActivity {
    Toolbar toolbar_add_phone;
    TextInputEditText txtIL_phone_name_add, txtIL_phone_img_url1_add, txtIL_phone_img_url2_add, txtIL_phone_img_url3_add,
            txtIL_phone_img_url4_add, txtIL_phone_price_add, txtIL_phone_details_add, txtIL_phone_description_add, id_loai_sanpham_add,
            id_sanpham_add, status_add;
    LinearLayout submit_add_phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_add_product);

        anhxa();

        // Đổi icon menu thành icon back
        toolbar_add_phone.setNavigationIcon(R.drawable.back_white);

        // Set title cho toolbar
        setTitle("Thêm điện thoại");
        setSupportActionBar(toolbar_add_phone);

        // Set sự kiện cho nút back của toolbar
        toolbar_add_phone.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit_add_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });

    }

    public void addProduct() {
        final String ten = txtIL_phone_name_add.getText().toString().trim();
        final String hinhanh = txtIL_phone_img_url1_add.getText().toString().trim();
        final String hinhanh2 = txtIL_phone_img_url2_add.getText().toString().trim();
        final String hinhanh3 = txtIL_phone_img_url3_add.getText().toString().trim();
        final String hinhanh4 = txtIL_phone_img_url4_add.getText().toString().trim();
        final String gia = txtIL_phone_price_add.getText().toString().trim();
        final String thongsokithuat = txtIL_phone_details_add.getText().toString().trim();
        final String mota = txtIL_phone_description_add.getText().toString().trim();
        final String idloaisanpham = id_loai_sanpham_add.getText().toString().trim();
        final String idsanpham = id_sanpham_add.getText().toString().trim();
        final String status = status_add.getText().toString().trim();

        if (ten.length() > 0 && hinhanh.length() > 0 && hinhanh2.length() > 0 && hinhanh3.length() > 0
                && hinhanh4.length() > 0 && gia.length() > 0 && thongsokithuat.length() > 0 && mota.length() > 0
                && idloaisanpham.length() > 0 && idsanpham.length() > 0 && status.length() > 0) {

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.themsanpham, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (!response.equals("")) {
                        finish();
                        Toast.makeText(getApplicationContext(), "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Thêm sản phẩm thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> param = new HashMap<String, String>();
                    param.put("ten", ten);
                    param.put("hinhanh", hinhanh);
                    param.put("hinhanh2", hinhanh2);
                    param.put("hinhanh3", hinhanh3);
                    param.put("hinhanh4", hinhanh4);
                    param.put("gia", gia);
                    param.put("thongsokithuat", thongsokithuat);
                    param.put("mota", mota);
                    param.put("idloaisanpham", idloaisanpham);
                    param.put("idsanpham", idsanpham);
                    param.put("status", status);

                    return param;
                }
            };
            requestQueue.add(stringRequest);
        }
    }

    public void anhxa() {
        toolbar_add_phone = findViewById(R.id.toolbar_activity);
        submit_add_phone = findViewById(R.id.submit_add_phone);
        txtIL_phone_name_add = findViewById(R.id.txtIL_phone_name_add);
        txtIL_phone_img_url1_add = findViewById(R.id.txtIL_phone_img_url1_add);
        txtIL_phone_img_url2_add = findViewById(R.id.txtIL_phone_img_url2_add);
        txtIL_phone_img_url3_add = findViewById(R.id.txtIL_phone_img_url3_add);
        txtIL_phone_img_url4_add = findViewById(R.id.txtIL_phone_img_url4_add);
        txtIL_phone_price_add = findViewById(R.id.txtIL_phone_price_add);
        txtIL_phone_details_add = findViewById(R.id.txtIL_phone_details_add);
        txtIL_phone_description_add = findViewById(R.id.txtIL_phone_description_add);
        id_loai_sanpham_add = findViewById(R.id.id_loai_sanpham_add);
        id_sanpham_add = findViewById(R.id.id_sanpham_add);
        status_add = findViewById(R.id.status_add);

    }
}
