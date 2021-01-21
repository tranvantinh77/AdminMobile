package com.example.adminpage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminpage.R;
import com.example.adminpage.model.Order;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ItemHolder>{

    private ArrayList<Order> arrayList;
    private OrderAdapter.IClickItemListener myIClickItemListener;

    public interface IClickItemListener {
        void onClickEdit(Order order);
    }

    public OrderAdapter(ArrayList<Order> arrayList, IClickItemListener myIClickItemListener) {
        this.arrayList = arrayList;
        this.myIClickItemListener = myIClickItemListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order,null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final Order order = arrayList.get(position);
        holder.txt_user_name_ord.setText(order.getTenkhachhang());
        holder.txt_user_email_ord.setText(order.getEmail());
        holder.txt_user_phone_ord.setText(order.getSodienthoai());
        holder.txt_user_address_ord.setText(String.valueOf(order.getDiachi()));
        holder.txt_user_note_ord.setText(String.valueOf(order.getGhichu()));

        holder.btn_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIClickItemListener.onClickEdit(order);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        Button btn_details;
        TextView txt_user_name_ord, txt_user_phone_ord, txt_user_email_ord, txt_user_address_ord, txt_user_note_ord;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            txt_user_name_ord = itemView.findViewById(R.id.txt_user_name_ord);
            txt_user_phone_ord = itemView.findViewById(R.id.txt_user_phone_ord);
            txt_user_email_ord = itemView.findViewById(R.id.txt_user_email_ord);
            txt_user_address_ord = itemView.findViewById(R.id.txt_user_address_ord);
            txt_user_note_ord = itemView.findViewById(R.id.txt_user_note_ord);
            btn_details = itemView.findViewById(R.id.btn_details);
        }
    }
}
