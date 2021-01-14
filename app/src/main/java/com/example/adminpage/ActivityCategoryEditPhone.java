package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityCategoryEditPhone extends AppCompatActivity {

    Toolbar toolbar_edit_phone;
    LinearLayout submit_edit_phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_phone);

        toolbar_edit_phone = findViewById(R.id.toolbar_activity);
        submit_edit_phone = findViewById(R.id.submit_edit_phone);

        // Đổi icon menu thành icon back
        toolbar_edit_phone.setNavigationIcon(R.drawable.back_white);

        // Set title cho toolbar
        setTitle("Chỉnh sửa điện thoại");
        setSupportActionBar(toolbar_edit_phone);

        // Set sự kiện cho nút back của toolbar
        toolbar_edit_phone.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set sự kiện nút submit edit điện thoại
        submit_edit_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityCategoryEditPhone.this, "Test submit edit phone", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
