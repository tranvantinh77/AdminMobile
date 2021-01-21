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
import com.example.adminpage.model.Product;
import com.example.adminpage.ultil.Server;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class ActivityCategoryEditProduct extends AppCompatActivity {

    Toolbar toolbar_edit_phone;
    LinearLayout submit_edit_phone;
    TextInputEditText txtIL_id_edit, txtIL_phone_name_edit, txtIL_phone_img_url1_edit, txtIL_phone_img_url2_edit,
            txtIL_phone_img_url3_edit, txtIL_phone_img_url4_edit,txtIL_phone_price_edit,txtIL_phone_details_edit,
            txtIL_phone_description_edit, id_loai_sanpham_edit, id_sanpham_edit,status_edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);

        anhXa();

        // Đổi icon menu thành icon back
        toolbar_edit_phone.setNavigationIcon(R.drawable.back_white);

        // Set title cho toolbar
        setTitle("Chỉnh sửa sản phẩm");
        setSupportActionBar(toolbar_edit_phone);

        // Set sự kiện cho nút back của toolbar
        toolbar_edit_phone.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nhanDuLieu();

        // Set sự kiện nút submit edit điện thoại
        submit_edit_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProduct();
            }
        });


    }

    public void nhanDuLieu() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Product product = (Product) bundle.getSerializable("product");
            if (product != null) {
                txtIL_id_edit.setText(String.valueOf(product.getID()));
                txtIL_phone_name_edit.setText(product.getTen());
                txtIL_phone_img_url1_edit.setText(product.getHinhanh());
                txtIL_phone_img_url2_edit.setText(product.getHinhanh2());
                txtIL_phone_img_url3_edit.setText(product.getHinhanh3());
                txtIL_phone_img_url4_edit.setText(product.getHinhanh4());
                txtIL_phone_price_edit.setText(String.valueOf(product.getGia()));
                txtIL_phone_details_edit.setText(product.getThongsokithuat());
                txtIL_phone_description_edit.setText(product.getMota());
                id_loai_sanpham_edit.setText(String.valueOf(product.getIDloaisanpham()));
                id_sanpham_edit.setText(String.valueOf(product.getIDsanpham()));
                status_edit.setText(String.valueOf(product.getStatus()));

                txtIL_id_edit.setEnabled(false);
            }
        }
    }

    public void editProduct() {
        final String id = txtIL_id_edit.getText().toString().trim();
        final String ten = txtIL_phone_name_edit.getText().toString().trim();
        final String hinhanh = txtIL_phone_img_url1_edit.getText().toString().trim();
        final String hinhanh2 = txtIL_phone_img_url2_edit.getText().toString().trim();
        final String hinhanh3 = txtIL_phone_img_url3_edit.getText().toString().trim();
        final String hinhanh4 = txtIL_phone_img_url4_edit.getText().toString().trim();
        final String gia = txtIL_phone_price_edit.getText().toString().trim();
        final String thongsokithuat = txtIL_phone_details_edit.getText().toString().trim();
        final String mota = txtIL_phone_description_edit.getText().toString().trim();
        final String idloaisanpham = id_loai_sanpham_edit.getText().toString().trim();
        final String idsanpham = id_sanpham_edit.getText().toString().trim();
        final String status = status_edit.getText().toString().trim();

        if (id.length() > 0 && ten.length() > 0 && hinhanh.length() > 0 && hinhanh2.length() > 0 && hinhanh3.length() > 0
                && hinhanh4.length() > 0 && gia.length() > 0 && thongsokithuat.length() > 0 && mota.length() > 0
                && idloaisanpham.length() > 0 && idsanpham.length() > 0 && status.length() > 0) {

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.suasanpham, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (!response.equals("")) {
                        finish();
                        Toast.makeText(getApplicationContext(), "Sửa sản phẩm thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Sửa sản phẩm thất bại", Toast.LENGTH_SHORT).show();
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
                    param.put("id", id);
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

    public void anhXa() {
        toolbar_edit_phone = findViewById(R.id.toolbar_activity);
        submit_edit_phone = findViewById(R.id.submit_edit_phone);

        txtIL_id_edit = findViewById(R.id.txtIL_id_edit);
        txtIL_phone_name_edit = findViewById(R.id.txtIL_phone_name_edit);
        txtIL_phone_img_url1_edit = findViewById(R.id.txtIL_phone_img_url1_edit);
        txtIL_phone_img_url2_edit = findViewById(R.id.txtIL_phone_img_url2_edit);
        txtIL_phone_img_url3_edit = findViewById(R.id.txtIL_phone_img_url3_edit);
        txtIL_phone_img_url4_edit = findViewById(R.id.txtIL_phone_img_url4_edit);
        txtIL_phone_price_edit = findViewById(R.id.txtIL_phone_price_edit);
        txtIL_phone_details_edit = findViewById(R.id.txtIL_phone_details_edit);
        txtIL_phone_description_edit = findViewById(R.id.txtIL_phone_description_edit);
        id_loai_sanpham_edit = findViewById(R.id.id_loai_sanpham_edit);
        id_sanpham_edit = findViewById(R.id.id_sanpham_edit);
        status_edit = findViewById(R.id.status_edit);

    }
}
