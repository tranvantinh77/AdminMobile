package com.example.adminpage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.adminpage.ultil.Server;
import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class ActivityCategoryAddPhone extends AppCompatActivity {
    Toolbar toolbar_add_phone;
    TextInputEditText txtIL_phone_name_add, txtIL_phone_img_url1_add, txtIL_phone_img_url2_add, txtIL_phone_img_url3_add,
            txtIL_phone_img_url4_add, txtIL_phone_price_add, txtIL_phone_details_add, txtIL_phone_description_add, id_loai_sanpham_add,
            id_sanpham_add, status_add;
    LinearLayout submit_add_phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_add_phone);

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


        if (!ten.equals("") && !hinhanh.equals("") && !hinhanh2.equals("") && !hinhanh3.equals("")
                && !hinhanh4.equals("") && !gia.equals("") && !thongsokithuat.equals("")
                && !mota.equals("") && !idloaisanphamdienthoai.equals("") && !idsanpham.equals("") && !status.equals("")) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    String[] field = new String[11];
                    field[0] = "ten";
                    field[1] = "hinhanh";
                    field[2] = "hinhanh2";
                    field[3] = "hinhanh3";
                    field[4] = "hinhanh4";
                    field[5] = "gia";
                    field[6] = "thongsokithuat";
                    field[7] = "mota";
                    field[8] = "idloaisanphamdienthoai";
                    field[9] = "idsanpham";
                    field[10] = "status";
                    //Creating array for data
                    String[] data = new String[11];
                    data[0] = ten;
                    data[1] = hinhanh;
                    data[2] = hinhanh2;
                    data[3] = hinhanh3;
                    data[4] = hinhanh4;
                    data[5] = gia;
                    data[6] = thongsokithuat;
                    data[7] = mota;
                    data[8] = idloaisanphamdienthoai;
                    data[9] = idsanpham;
                    data[10] = status;
                    PutData putData = new PutData(Server.addphone , "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            String result = putData.getResult();
                            if (result.equals("Add Phone Success")){
                                Toast.makeText(getApplicationContext(),"Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
                               finish();
                                Log.d("a","ok");
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Thêm sản phẩm thất bại", Toast.LENGTH_LONG).show();
                                Log.d("b","not");
                            }
                        }
                    }
                }
            });
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
