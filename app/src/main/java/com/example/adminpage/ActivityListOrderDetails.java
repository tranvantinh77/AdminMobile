package com.example.adminpage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.adminpage.adapter.OrderDetailsAdapter;
import com.example.adminpage.model.Order;
import com.example.adminpage.model.OrderDetails;
import com.example.adminpage.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityListOrderDetails extends AppCompatActivity {

    Toolbar toolbar_list_order_details;
    RecyclerView rcv_order_details;
    ArrayList<OrderDetails> list = new ArrayList<>();
    OrderDetailsAdapter orderDetailsAdapter;
    TextView txtV_total;
    int id;
    long total = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        // Ánh xạ
        toolbar_list_order_details = findViewById(R.id.toolbar_activity);
        rcv_order_details = findViewById(R.id.rcv_order_details);
        txtV_total = findViewById(R.id.txtV_total);

        // Đổi icon menu thành icon back
        toolbar_list_order_details.setNavigationIcon(R.drawable.back_white);

        // Set title cho toolbar
        setTitle("Chi tiết đơn hàng");
        setSupportActionBar(toolbar_list_order_details);

        // Set sự kiện cho nút back của toolbar
        toolbar_list_order_details.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nhanDuLieu();

        // Set sự kiện cho nút edit và nút xoá của từng sản phẩm
        orderDetailsAdapter = new OrderDetailsAdapter(getOrderDetails());

        rcv_order_details.setAdapter(orderDetailsAdapter);
        rcv_order_details.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL, false));
    }

    private ArrayList<OrderDetails> getOrderDetails() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.dataorderdetails, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                int madonhang = 0;
                int masanpham = 0;
                String tensanpham = "";
                String hinhanhsanpham = "";
                int giasanpham = 0;
                int soluongsanpham = 0;
                if (response != null) {
                    try {
                        JSONArray jsonArray =new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            madonhang = jsonObject.getInt("madonhang");
                            masanpham = jsonObject.getInt("masanpham");
                            tensanpham = jsonObject.getString("tensanpham");
                            hinhanhsanpham = jsonObject.getString("hinhanhsanpham");
                            giasanpham = jsonObject.getInt("giasanpham");
                            soluongsanpham = jsonObject.getInt("soluongsanpham");
                            list.add(new OrderDetails(id, madonhang, masanpham, tensanpham, hinhanhsanpham, giasanpham, soluongsanpham));
                            orderDetailsAdapter.notifyDataSetChanged();
                        }
                        for (OrderDetails orderDetails : list) {
                            total += orderDetails.getGiasanpham();
                        }
                        txtV_total.setText(String.valueOf(total));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("madonhang", String.valueOf(id));
                return param;
            }
        };

        requestQueue.add(stringRequest);

        return list;
    }

    public void nhanDuLieu() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Order order = (Order) bundle.getSerializable("order");
            if (order != null) {
                id = order.getID();
            }
        }
    }
}
