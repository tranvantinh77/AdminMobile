package com.example.adminpage;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityCategoryAdd extends AppCompatActivity {

//    Function function = new Function();
    Toolbar toolbar_cgr_add;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_add);

        toolbar_cgr_add = findViewById(R.id.toolbar_activity);

        toolbar_cgr_add.setNavigationIcon(R.drawable.back_white);
        setTitle("Thêm danh mục");
        setSupportActionBar(toolbar_cgr_add);

        toolbar_cgr_add.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
