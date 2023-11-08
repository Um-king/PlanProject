package com.example.myapplication.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
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

        // fragment에서 findViewById는 Fragment의 view가 inflate하기전에 컴포넌트를 호출하기 때문에 return 하기전에 해줘야한다.
        View v = inflater.inflate(R.layout.activity_home, container, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext(), RecyclerView.HORIZONTAL, false);
        mRecyclerView = v.findViewById(R.id.countriesList0);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL), linearLayoutManager.getOrientation());

        init();

        // Inflate the layout for this fragment
        return v;
    }

    private void init(){

        mList = new ArrayList<>();


        for(int i = 0; i < 5; i++){
            addItem("Test" + i);
        }

        mRecyclerViewAdapter = new RecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

    }

    private void addItem(String testName){
        mList.add(testName);
    }
}
