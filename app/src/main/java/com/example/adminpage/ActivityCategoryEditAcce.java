package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityCategoryEditAcce extends AppCompatActivity {

    Toolbar toolbar_edit_acce;
    LinearLayout submit_edit_acce;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_acce);

        toolbar_edit_acce = findViewById(R.id.toolbar_activity);
        submit_edit_acce = findViewById(R.id.submit_edit_acce);

        // Đổi icon menu thành icon back
        toolbar_edit_acce.setNavigationIcon(R.drawable.back_white);

        // Set title cho toolbar
        setTitle("Chỉnh sửa phụ kiện");
        setSupportActionBar(toolbar_edit_acce);

        // Set sự kiện cho nút back của toolbar
        toolbar_edit_acce.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set sự kiện nút submit edit phụ kiện
        submit_edit_acce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityCategoryEditAcce.this, "Test submit edit acce", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
