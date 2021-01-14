package com.example.adminpage;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityCategoryAddLaptop extends AppCompatActivity {

//    Function function = new Function();
    Toolbar toolbar_cgr_add_lap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_add_lap);

        toolbar_cgr_add_lap = findViewById(R.id.toolbar_activity);

        // Đổi icon menu thành icon back
        toolbar_cgr_add_lap.setNavigationIcon(R.drawable.back_white);

        // Set title cho toolbar
        setTitle("Thêm laptop");
        setSupportActionBar(toolbar_cgr_add_lap);

        // Set sự kiện cho nút back của toolbar
        toolbar_cgr_add_lap.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
