package com.example.myapplication.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Class.RecyclerViewAdapter;
import com.example.myapplication.R;

import com.example.myapplication.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ActivityHomeBinding binding;

    private RecyclerView mRecyclerView;
    private ArrayList<String> mList;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        init();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_home, container, false);
    }

    private void init(){
        binding = DataBindingUtil.setContentView(getActivity(), R.layout.activity_home);

        for(int i = 0; i < 5; i++){
            addItem("Test" + i);
        }
    }

    private void addItem(String testName){
        mList.add(testName);
    }
}
