package com.example.wechatdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wechatdemo.adapter.ConnRecyclerViewAdapter;
import com.example.wechatdemo.bean.Conn;
import com.example.wechatdemo.R;
import java.util.ArrayList;
import java.util.List;

/**
 * 联系人首页
 */
public class ConnFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.conn_fragment, container, false);
        initRecyclerView();
        return view;
    }

    void initRecyclerView(){
        List<Conn> connList=new ArrayList<>();
        //获取联系人数据
        Conn conn1 = new Conn("name1eeeeeeeeeeeeee","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3072531546,2743940875&fm=26&gp=0.jpg");
        Conn conn2 = new Conn("name2eeeeeeeeeeeeee","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3072531546,2743940875&fm=26&gp=0.jpg");
        connList.add(conn1);
        connList.add(conn2);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ConnRecyclerViewAdapter connRecyclerViewAdapter = new ConnRecyclerViewAdapter(connList,getActivity());
        recyclerView.setAdapter(connRecyclerViewAdapter);
    }
}