package com.example.adminpage;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class ActivityCategoryList extends AppCompatActivity {

    Function function = new Function();
    Toolbar toolbar_cgr_list;
    CardView cardV_cgr_phone, cardV_cgr_lap, cardV_cgr_accessories;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_list);

        // Ánh xạ
        toolbar_cgr_list = findViewById(R.id.toolbar_activity);
        cardV_cgr_phone = findViewById(R.id.cardV_cgr_phone);
        cardV_cgr_lap = findViewById(R.id.cardV_cgr_laptop);
        cardV_cgr_accessories = findViewById(R.id.cardV_cgr_accessories);

        // Đổi icon menu thành icon back
        toolbar_cgr_list.setNavigationIcon(R.drawable.back_white);

        // Set title cho toolbar
        setTitle("Danh sách danh mục");
        setSupportActionBar(toolbar_cgr_list);

        // Set sự kiện cho nút back của toolbar
        toolbar_cgr_list.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cardV_cgr_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function.goToActivityCategoryListPhone(ActivityCategoryList.this);
            }
        });

        cardV_cgr_lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function.goToActivityCategoryListLaptop(ActivityCategoryList.this);
            }
        });

        cardV_cgr_accessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function.goToActivityCategoryListAccessories(ActivityCategoryList.this);
            }
        });
    }
}
