package com.example.adminpage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminpage.R;
import com.example.adminpage.model.OrderDetails;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.ItemHolder>{

    private ArrayList<OrderDetails> arrayList;

    public OrderDetailsAdapter(ArrayList<OrderDetails> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_details,null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final OrderDetails orderDetails = arrayList.get(position);
        holder.txt_product_name_od.setText(orderDetails.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txt_product_price_od.setText(decimalFormat.format(orderDetails.getGiasanpham()) + " Đ");
        holder.txt_product_quantity.setText(String.valueOf(orderDetails.getSoluongsanpham()));
        holder.txt_product_code.setText(String.valueOf(orderDetails.getMasanpham()));
        holder.txt_order_code.setText(String.valueOf(orderDetails.getMadonhang()));
        Picasso.get()
                .load(orderDetails.getHinhanhsanpham())
                .fit()
                .into(holder.imgV_product_od);
    }

    @Override
    public int getItemCount() {
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        ImageView imgV_product_od;
        TextView txt_product_name_od, txt_product_price_od, txt_product_quantity, txt_product_code, txt_order_code;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            imgV_product_od = itemView.findViewById(R.id.imgV_product_od);
            txt_product_name_od = itemView.findViewById(R.id.txt_product_name_od);
            txt_product_price_od = itemView.findViewById(R.id.txt_product_price_od);
            txt_product_quantity = itemView.findViewById(R.id.txt_product_quantity);
            txt_product_code = itemView.findViewById(R.id.txt_product_code);
            txt_order_code = itemView.findViewById(R.id.txt_order_code);
        }
    }
}
