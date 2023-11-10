package com.example.myapplication.view.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.view.Lib.BackPressControl;
import com.example.myapplication.view.fragment.CalendarFragment;
import com.example.myapplication.view.fragment.HomeFragment;
import com.example.myapplication.view.fragment.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BackPressControl backpressed;

    /*프래그먼트 변수 추가*/
    HomeFragment homeFragment;
    SettingFragment settingFragment;
    CalendarFragment calendarFragment;

    /*하단 탭 매뉴 변수*/
    BottomNavigationView bottomNavigationView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        backpressed = new BackPressControl(this);

        /*초기화*/
        init();
        /*데이터 호출*/
        GetData();
    }

    private void init(){

        homeFragment = new HomeFragment();
        settingFragment = new SettingFragment();
        calendarFragment = new CalendarFragment();

        /* 초기화면 설정 */
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, homeFragment).commit();

         /* 선택 리스너 등록
            - 하단 탭 선택 시 화면 전환
            - 탭 아이콘 선택 시 해당 Fragment 페이지를 가져오는데 페이지 id를 통해 화면 전환
            - main_layout: 해당 레이아웃에 선택된 정보의 Fragment 페이지를 출력한다.
        */
        bottomNavigationView = findViewById(R.id.bottomNavigationView); // 하단탭 설정
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.tab_home:
                                getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, homeFragment).commit(); // main_layout에 보이겠다.
                                return true;

                            case R.id.tab_calendar:
                                getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, calendarFragment).commit();
                                return true;

                            case R.id.tab_setting:
                                getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, settingFragment).commit();
                                return true;
                        }

                        return false;
                    }
                }
        );

        /* 맨 처음 시작할 탭 설정 */
        bottomNavigationView.setSelectedItemId(R.id.tab_home);
    }

    private  void GetData(){

    }

    @Override
    public void onBackPressed() {

        backpressed.onBackPressed();
    }
}
