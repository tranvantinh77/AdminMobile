package com.example.adminpage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminpage.R;
import com.example.adminpage.model.User;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ItemHolder>{

    private ArrayList<User> arrayList;
    private UserAdapter.IClickItemListener myIClickItemListener;

    public interface IClickItemListener {
        void onClickEdit(User user);
    }

    public UserAdapter(ArrayList<User> arrayList, IClickItemListener myIClickItemListener) {
        this.arrayList = arrayList;
        this.myIClickItemListener = myIClickItemListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,null);
        ItemHolder itemHolder = new ItemHolder(view);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final User user = arrayList.get(position);
        holder.txt_user_name.setText(user.getFullname());
        holder.txt_user_email.setText(user.getEmail());
        holder.txt_user_phone.setText(user.getPhone());

        if (user.getRole() == 1) {
            holder.txt_user_role.setText("Quyền: tài khoản người dùng.");
        }
        if (user.getRole() == 2) {
            holder.txt_user_role.setText("Quyền: tài khoản admin.");
        }
        if (user.getRole() == 0) {
            holder.txt_user_role.setText("Quyền: tài khoản đã bị khóa.");
        }


        holder.imgB_icon_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIClickItemListener.onClickEdit(user);
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
        ImageButton imgB_icon_edit;
        TextView txt_user_name, txt_user_phone, txt_user_email, txt_user_role;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            txt_user_name = itemView.findViewById(R.id.txt_user_name);
            txt_user_phone = itemView.findViewById(R.id.txt_user_phone);
            txt_user_email = itemView.findViewById(R.id.txt_user_email);
            txt_user_role = itemView.findViewById(R.id.txt_user_role);
            imgB_icon_edit = itemView.findViewById(R.id.imgB_icon_edit_user);
        }
    }
}
