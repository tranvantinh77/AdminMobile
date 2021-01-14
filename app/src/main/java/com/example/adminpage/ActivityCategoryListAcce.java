package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityCategoryListAcce extends AppCompatActivity {

    Function function = new Function();
    Toolbar toolbar_cgr_list_accessories;
    RecyclerView rcv_accessories;
    ImageView imgV_add_acce;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_list_acce);

        // Ánh xạ
        toolbar_cgr_list_accessories = findViewById(R.id.toolbar_have_icon_add);
        rcv_accessories = findViewById(R.id.rcv_phone);
        imgV_add_acce = findViewById(R.id.imgV_icon_add);

        // Set title cho toolbar
        setTitle("Danh sách phụ kiện");
        setSupportActionBar(toolbar_cgr_list_accessories);

        // Set sự kiện cho nút back của toolbar
        toolbar_cgr_list_accessories.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set sự kiện cho nút add trên toolbar
        imgV_add_acce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function.goToActivityCategoryAddAcce(ActivityCategoryListAcce.this);
            }
        });
    }
}
