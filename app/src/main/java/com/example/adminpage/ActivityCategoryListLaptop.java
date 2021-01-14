package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityCategoryListLaptop extends AppCompatActivity {

    Function function = new Function();
    Toolbar toolbar_cgr_list_laptop;
    RecyclerView rcv_laptop;
    ImageView imgV_add_lap;

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
    }
}
