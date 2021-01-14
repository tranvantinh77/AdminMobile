package com.example.adminpage.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.adminpage.R;

public class MyCustomDialog extends Dialog implements View.OnClickListener {

    Context context;
    Button btn_yes, btn_no;
    TextView txtV_message;
    String message;

    public MyCustomDialog(@NonNull Context context, String message) {
        super(context);
        this.context = context;
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);

        txtV_message = findViewById(R.id.txt_message_dialog);
        btn_yes = findViewById(R.id.btn_yes_dialog);
        btn_no = findViewById(R.id.btn_no_dialog);

        txtV_message.setText(this.message);
        btn_yes.setOnClickListener(this);
        btn_no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes_dialog:
                Toast.makeText(context, "Yes", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_no_dialog:
                Toast.makeText(context, "No", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        dismiss();
    }
}
