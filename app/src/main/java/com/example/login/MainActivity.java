package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;

import com.example.login.database.AppDataBase;
import com.example.login.databinding.ActivityMainBinding;
import com.example.login.dialog.RegisterDialog;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AppDataBase db = Room.databaseBuilder(this,AppDataBase.class,"user").allowMainThreadQueries().build();
        binding.btnMainRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterDialog registerDialog=new RegisterDialog(MainActivity.this,db);
                registerDialog.show();
            }
        });
    }
}