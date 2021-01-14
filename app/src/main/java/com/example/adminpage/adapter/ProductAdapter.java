package com.example.adminpage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminpage.Function;
import com.example.adminpage.R;
import com.example.adminpage.model.Product;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemHolder>{

    private ArrayList<Product> arrayList;
    private IClickItemListener mIClickItemListener;

    public interface IClickItemListener {
        void onClickEdit(Product product);
        void onClickRemove(Product product);
    }

    public ProductAdapter(ArrayList<Product> arrayList, IClickItemListener mIClickItemListener) {
        this.arrayList = arrayList;
        this.mIClickItemListener = mIClickItemListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final Product product = arrayList.get(position);
        holder.txt_product_name.setText(product.getTen());
        holder.txt_product_name.setLines(2);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txt_product_price.setText("Giá : "+ decimalFormat.format(product.getGia())+ " Đ");
        Picasso.get()
                .load(product.getHinhanh())
                .fit()
                .into(holder.imgV_product);

        holder.imgB_icon_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIClickItemListener.onClickEdit(product);
            }
        });

        holder.imgB_icon_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIClickItemListener.onClickRemove(product);
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
         ImageView imgV_product;
         TextView txt_product_name, txt_product_price;
         ImageButton imgB_icon_edit, imgB_icon_delete;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            imgV_product = itemView.findViewById(R.id.imgV_product);
            txt_product_name = itemView.findViewById(R.id.txt_product_name);
            txt_product_price = itemView.findViewById(R.id.txt_product_price);
            imgB_icon_edit = itemView.findViewById(R.id.imgB_icon_edit);
            imgB_icon_delete = itemView.findViewById(R.id.imgB_icon_delete);
            imgV_product = itemView.findViewById(R.id.imgV_product);

        }
    }
}
