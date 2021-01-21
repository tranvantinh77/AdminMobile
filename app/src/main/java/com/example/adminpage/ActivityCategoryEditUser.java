package com.example.adminpage;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.adminpage.model.Product;
import com.example.adminpage.model.User;
import com.example.adminpage.ultil.Server;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class ActivityCategoryEditUser extends AppCompatActivity {

    Toolbar toolbar_edit_user;
    LinearLayout submit_edit_user;
    TextInputEditText txtIL_id_user, txtIL_user_name, txtIL_user_email, txtIL_user_phone, txtIL_user_role;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        anhXa();

        // Đổi icon menu thành icon back
        toolbar_edit_user.setNavigationIcon(R.drawable.back_white);

        // Set title cho toolbar
        setTitle("Chỉnh sửa người dùng");
        setSupportActionBar(toolbar_edit_user);

        // Set sự kiện cho nút back của toolbar
        toolbar_edit_user.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nhanDuLieu();

        // Set sự kiện nút submit edit điện thoại
        submit_edit_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProduct();
            }
        });


    }

    public void nhanDuLieu() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            User user = (User) bundle.getSerializable("user");
            if (user != null) {
                txtIL_id_user.setText(String.valueOf(user.getID()));
                txtIL_user_name.setText(user.getFullname());
                txtIL_user_email.setText(user.getEmail());
                txtIL_user_phone.setText(user.getPhone());
                txtIL_user_role.setText(String.valueOf(user.getRole()));

                txtIL_id_user.setEnabled(false);
                txtIL_user_name.setEnabled(false);
                txtIL_user_email.setEnabled(false);
                txtIL_user_phone.setEnabled(false);
            }
        }
    }

    public void editProduct() {
        final String id = txtIL_id_user.getText().toString().trim();
        final String fullname = txtIL_user_name.getText().toString().trim();
        final String email = txtIL_user_email.getText().toString().trim();
        final String phone = txtIL_user_phone.getText().toString().trim();
        final String role = txtIL_user_role.getText().toString().trim();

        if (id.length() > 0 && fullname.length() > 0 && email.length() > 0 && phone.length() > 0 && role.length() > 0) {

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.suaaccount, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (!response.equals("")) {
                        finish();
                        Toast.makeText(getApplicationContext(), "Sửa người dùng thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Sửa người dùng thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> param = new HashMap<String, String>();
                    param.put("id", id);
                    param.put("fullname", fullname);
                    param.put("email", email);
                    param.put("phone", phone);
                    param.put("role", role);

                    return param;
                }
            };
            requestQueue.add(stringRequest);
        }
    }

    public void anhXa() {
        toolbar_edit_user = findViewById(R.id.toolbar_activity);
        submit_edit_user = findViewById(R.id.submit_edit_user);

        txtIL_id_user = findViewById(R.id.txtIL_id_user);
        txtIL_user_name = findViewById(R.id.txtIL_user_name_edit);
        txtIL_user_email = findViewById(R.id.txtIL_user_email_edit);
        txtIL_user_phone = findViewById(R.id.txtIL_user_phone_edit);
        txtIL_user_role = findViewById(R.id.txtIL_user_role_edit);

    }
}
