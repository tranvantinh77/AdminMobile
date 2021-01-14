package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityCategoryEditLaptop extends AppCompatActivity {

    Toolbar toolbar_edit_lap;
    LinearLayout submit_edit_lap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_laptop);

        toolbar_edit_lap = findViewById(R.id.toolbar_activity);
        submit_edit_lap = findViewById(R.id.submit_edit_lap);

        // Đổi icon menu thành icon back
        toolbar_edit_lap.setNavigationIcon(R.drawable.back_white);

        // Set title cho toolbar
        setTitle("Chỉnh sửa laptop");
        setSupportActionBar(toolbar_edit_lap);

        // Set sự kiện cho nút back của toolbar
        toolbar_edit_lap.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set sự kiện nút submit edit laptop
        submit_edit_lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityCategoryEditLaptop.this, "Test submit edit laptop", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
