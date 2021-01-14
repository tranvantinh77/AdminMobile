package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityCategoryAddLaptop extends AppCompatActivity {

    Toolbar toolbar_add_lap;
    LinearLayout submit_add_lap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_add_lap);

        toolbar_add_lap = findViewById(R.id.toolbar_activity);
        submit_add_lap = findViewById(R.id.submit_add_laptop);

        // Đổi icon menu thành icon back
        toolbar_add_lap.setNavigationIcon(R.drawable.back_white);

        // Set title cho toolbar
        setTitle("Thêm laptop");
        setSupportActionBar(toolbar_add_lap);

        // Set sự kiện cho nút back của toolbar
        toolbar_add_lap.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit_add_lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityCategoryAddLaptop.this, "Test submit add lap", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
