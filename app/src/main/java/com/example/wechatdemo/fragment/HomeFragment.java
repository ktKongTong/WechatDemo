package com.example.wechatdemo.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wechatdemo.R;
import com.example.wechatdemo.adapter.ConnRecyclerViewAdapter;
import com.example.wechatdemo.adapter.HomeRecyclerViewAdapter;
import com.example.wechatdemo.bean.Conn;
import com.example.wechatdemo.bean.News;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view = inflater.inflate(R.layout.home_fragment, container, false);
            initRecyclerView();
            return view;
        }
    void initRecyclerView(){
        List<News> newsList=new ArrayList<>();
        //获取联系人数据
        Conn conn1 = new Conn("name1eeeeeeeeeeeeee","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3072531546,2743940875&fm=26&gp=0.jpg");
        Conn conn2 = new Conn("name2eeeeeeeeeeeeee","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3072531546,2743940875&fm=26&gp=0.jpg");
        News news1 =new News(conn1,conn2);
        News news2 =new News(conn2,conn1);
        newsList.add(news2);
        newsList.add(news1);
        recyclerView=(RecyclerView)view.findViewById(R.id.home_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        HomeRecyclerViewAdapter homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(newsList,getActivity());
        recyclerView.setAdapter(homeRecyclerViewAdapter);
    }
}