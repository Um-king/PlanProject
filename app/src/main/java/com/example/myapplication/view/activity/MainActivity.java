package com.example.myapplication.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.view.Lib.BackPressControl;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BackPressControl backpressed;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        backpressed = new BackPressControl(this);
    }


    @Override
    public void onBackPressed() {

        backpressed.onBackPressed();
    }
}
