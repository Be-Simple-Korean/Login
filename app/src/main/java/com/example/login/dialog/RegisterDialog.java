package com.example.login.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;

import com.example.login.data.UserInfo;
import com.example.login.database.AppDataBase;
import com.example.login.databinding.DialogRegisterBinding;

/**
 * 회원가입 다이얼로그
 */
public class RegisterDialog extends Dialog {
    AppDataBase db;
    public RegisterDialog(@NonNull Context context, AppDataBase db) {
        super(context);
        this.db=db;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DialogRegisterBinding binding=DialogRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window=getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        binding.flReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        binding.llRegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.btnRegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = binding.etRegInputId.getText().toString();
                String pwd = binding.etRegInputPwd.getText().toString();
                //TODO PWD MD5
                db.userInfoDAO().insert(new UserInfo(id,pwd));

                Log.e("data",db.userInfoDAO().getAll().toString());
            }
        });
    }
}
