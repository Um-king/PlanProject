package com.example.myapplication.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Class.RecyclerViewAdapter;
import com.example.myapplication.R;

import com.example.myapplication.databinding.ActivityHomeV2Binding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ActivityHomeV2Binding binding;

    private RecyclerView userRecyclerView;
    private RecyclerViewAdapter userRecyclerViewAdapter;
    private ArrayList<String> userList;


    private ArrayList<String> todayList;
    private RecyclerViewAdapter todayRecyclerViewAdapter;
    private RecyclerView todayRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = ActivityHomeV2Binding.inflate(inflater);


        // fragment에서 findViewById는 Fragment의 view가 inflate하기전에 컴포넌트를 호출하기 때문에 return 하기전에 해줘야한다.
        View v = inflater.inflate(R.layout.activity_home_v2, container, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext(), RecyclerView.HORIZONTAL, false);
        userRecyclerView = v.findViewById(R.id.list0);
        userRecyclerView.setLayoutManager(linearLayoutManager);

        todayRecyclerView = v.findViewById(R.id.list1);
        todayRecyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        init();

        // Inflate the layout for this fragment
        return v;
    }

    private void init(){

        // user 내역 생성
        userList = new ArrayList<>();

        for(int i = 0; i < 30; i++){
            userList.add("Test" + i);
        }

        userRecyclerViewAdapter = new RecyclerViewAdapter(userList);
        userRecyclerView.setAdapter(userRecyclerViewAdapter);



        // 오늘 할일 생성
        todayList = new ArrayList<>();
        for(int i = 0; i < 30; i++){
            todayList.add("Test" + i);
        }

        todayRecyclerViewAdapter = new RecyclerViewAdapter(todayList);
        todayRecyclerView.setAdapter(todayRecyclerViewAdapter);
    }
}
