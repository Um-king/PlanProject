package com.example.myapplication.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.view.Lib.BackPressControl;
import com.example.myapplication.databinding.LoginBinding; // .LoginBinding으로 명칭이 되는 이유 : Login은 xml의 이름, Binding은 그냥 붙음 즉 바인딩하려는 xml명+Binding

public class LoginActivity extends AppCompatActivity {

    LoginBinding binding;
    BackPressControl backpressed;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login);
        backpressed = new BackPressControl(this);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



    @Override
    public void onBackPressed() {

        backpressed.onBackPressed();
    }
}
