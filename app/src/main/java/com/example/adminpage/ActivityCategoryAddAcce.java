package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityCategoryAddAcce extends AppCompatActivity {

    Toolbar toolbar_add_acce;
    LinearLayout submit_add_acce;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_add_acce);

        toolbar_add_acce = findViewById(R.id.toolbar_activity);
        submit_add_acce = findViewById(R.id.submit_add_acce);

        // Đổi icon menu thành icon back
        toolbar_add_acce.setNavigationIcon(R.drawable.back_white);

        // Set title cho toolbar
        setTitle("Thêm phụ kiện");
        setSupportActionBar(toolbar_add_acce);

        // Set sự kiện cho nút back của toolbar
        toolbar_add_acce.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit_add_acce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityCategoryAddAcce.this, "Test submit add acce", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
