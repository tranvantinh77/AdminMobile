package com.example.adminpage;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.example.adminpage.adapter.ProductAdapter;
import com.example.adminpage.model.Product;
import com.example.adminpage.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActivityCategoryListAcce extends AppCompatActivity {

    Dialog dialog;
    Toolbar toolbar_cgr_list_accessories;
    RecyclerView rcv_accessories;
    ImageView imgV_add_acce;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgr_list_acce);

        // Ánh xạ
        toolbar_cgr_list_accessories = findViewById(R.id.toolbar_have_icon_add);
        rcv_accessories = findViewById(R.id.rcv_accessories);
        imgV_add_acce = findViewById(R.id.imgV_icon_add);

        // Set title cho toolbar
        setTitle("Danh sách phụ kiện");
        setSupportActionBar(toolbar_cgr_list_accessories);

        // Set sự kiện cho nút back của toolbar
        toolbar_cgr_list_accessories.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set sự kiện cho nút add trên toolbar
        imgV_add_acce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Function.goToActivityAddProduct(ActivityCategoryListAcce.this);
            }
        });

        productAdapter = new ProductAdapter(getPK(), new ProductAdapter.IClickItemListener() {
            @Override
            public void onClickEdit(Product product) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("product", product);
                Intent intent = new Intent(getApplicationContext(), ActivityCategoryEditProduct.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void onClickRemove(final Product product) {
                dialog = new Dialog(ActivityCategoryListAcce.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.show();

                TextView tv_message = dialog.findViewById(R.id.txt_message_dialog);

                tv_message.setText("Bạn có chắc muốn xoá ?");

                Button btn_yes = dialog.findViewById(R.id.btn_yes_dialog);
                Button btn_no = dialog.findViewById(R.id.btn_no_dialog);

                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String id = String.valueOf(product.getID());
                        if (id.length() > 0) {
                            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                            StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.xoasanpham, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    if (!response.equals("")) {
                                        finish();
                                        Toast.makeText(getApplicationContext(), "Xoá sản phẩm thành công", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Xoá sản phẩm thất bại", Toast.LENGTH_SHORT).show();
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
                                    return param;
                                }
                            };
                            requestQueue.add(stringRequest);
                        }
                    }
                });
                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

        rcv_accessories.setAdapter(productAdapter);
        rcv_accessories.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL, false));
    }

    private ArrayList<Product> getPK() {
        final ArrayList<Product> list = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.datasanpham, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String ten = "";
                String hinhanh = "";
                String hinhanh2 = "";
                String hinhanh3 = "";
                String hinhanh4 = "";
                Integer gia = 0;
                String thongsokithuat = "";
                String mota = "";
                int idloaisanpham = 0;
                int idsanpham = 0;
                int status = 0;
                if (response != null) {
                    try {
                        JSONArray jsonArray =new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            ten = jsonObject.getString("ten");
                            hinhanh = jsonObject.getString("hinhanh");
                            hinhanh2 = jsonObject.getString("hinhanh2");
                            hinhanh3 = jsonObject.getString("hinhanh3");
                            hinhanh4 = jsonObject.getString("hinhanh4");
                            gia = jsonObject.getInt("gia");
                            thongsokithuat = jsonObject.getString("thongsokithuat");
                            mota = jsonObject.getString("mota");
                            idloaisanpham = jsonObject.getInt("idloaisanpham");
                            idsanpham = jsonObject.getInt("idsanpham");
                            status = jsonObject.getInt("status");
                            list.add(new Product(id,ten,hinhanh,hinhanh2, hinhanh3, hinhanh4,gia,thongsokithuat,mota,idloaisanpham,idsanpham,status));
                            productAdapter.notifyDataSetChanged();
                        }
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
                param.put("idsanpham", String.valueOf(3));
                return param;
            }
        };

        requestQueue.add(stringRequest);
        return list;
    }
}
