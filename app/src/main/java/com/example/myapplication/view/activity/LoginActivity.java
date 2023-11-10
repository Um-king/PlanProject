package com.example.myapplication.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.model.object.Users;
import com.example.myapplication.view.Lib.ApplicationClass;
import com.example.myapplication.view.Lib.BackPressControl;
import com.example.myapplication.databinding.LoginBinding; // .LoginBinding으로 명칭이 되는 이유 : Login은 xml의 이름, Binding은 그냥 붙음 즉 바인딩하려는 xml명+Binding
import com.example.myapplication.view.Lib.PreferenceManager;

public class LoginActivity extends AppCompatActivity {

    LoginBinding binding;
    BackPressControl backpressed;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login);
        backpressed = new BackPressControl(this);

        setServiceAddress();
        initEvent();


    }

    private void setServiceAddress(){
//        if(PreferenceManager.getInt(this, "ServiceType")==0){//금강
//            Users.ServiceAddress = ApplicationClass.getResourses().getString(R.string.service_address);
//        }
//        else if(PreferenceManager.getInt(this, "ServiceType")==1){//KKM
//            Users.ServiceAddress = ApplicationClass.getResourses().getString(R.string.service_address_kkm);
//        }
//        else if(PreferenceManager.getInt(this, "ServiceType")==2){//KKV
//            Users.ServiceAddress = ApplicationClass.getResourses().getString(R.string.service_address_kkv);
//        }
//        else{//TEST
//            Users.ServiceAddress = ApplicationClass.getResourses().getString(R.string.service_address_test);
//        }
    }

    private void initEvent() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // 로그인 성공하면 자동로그인 체크 메소드를 쓴다.
    private void GetAutoLoginData(){
        // 자동로그인 처리
        if (binding.checkAuto.isChecked()) {
            PreferenceManager.setBoolean(this, "AutoLogin", true);
            PreferenceManager.setString(this, "ID", binding.edtID.getText().toString());
            PreferenceManager.setString(this, "PW", binding.edtPW.getText().toString());
        }
        else {
            PreferenceManager.setBoolean(this, "AutoLogin", false);
        }

    }

    @Override
    public void onBackPressed() {

        backpressed.onBackPressed();
    }
}
