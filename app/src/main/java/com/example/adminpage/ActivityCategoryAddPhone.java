package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityCategoryAddPhone extends AppCompatActivity {

    Toolbar toolbar_add_phone;
    LinearLayout submit_add_phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_add_phone);

        toolbar_add_phone = findViewById(R.id.toolbar_activity);
        submit_add_phone = findViewById(R.id.submit_add_phone);

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
                Toast.makeText(ActivityCategoryAddPhone.this, "Test submit add phone", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
