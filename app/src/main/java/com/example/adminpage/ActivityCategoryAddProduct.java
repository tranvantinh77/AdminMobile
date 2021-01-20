package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

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
                addphone();
            }
        });

    }

    public void addphone() {
        final String ten = txtIL_phone_name_add.getText().toString().trim();
        final String hinhanh = txtIL_phone_img_url1_add.getText().toString().trim();
        final String hinhanh2 = txtIL_phone_img_url2_add.getText().toString().trim();
        final String hinhanh3 = txtIL_phone_img_url3_add.getText().toString().trim();
        final String hinhanh4 = txtIL_phone_img_url4_add.getText().toString().trim();
        final String gia = txtIL_phone_price_add.getText().toString().trim();
        final String thongsokithuat = txtIL_phone_details_add.getText().toString().trim();
        final String mota = txtIL_phone_description_add.getText().toString().trim();
        final String idloaisanphamdienthoai = id_loai_sanpham_add.getText().toString().trim();
        final String idsanpham = id_sanpham_add.getText().toString().trim();
        final String status = status_add.getText().toString().trim();


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
