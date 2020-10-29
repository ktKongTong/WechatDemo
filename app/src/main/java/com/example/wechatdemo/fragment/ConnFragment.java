package com.example.wechatdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wechatdemo.MainActivity;
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
        final List<Conn> connList=new ArrayList<>();
        //获取联系人数据
        Conn conn1 = new Conn("name1eeeeeeeeeeeeee","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3072531546,2743940875&fm=26&gp=0.jpg");
        Conn conn2 = new Conn("name2eeeeeeeeeeeeee","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3072531546,2743940875&fm=26&gp=0.jpg");
        connList.add(conn1);
        connList.add(conn2);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        final ConnRecyclerViewAdapter connRecyclerViewAdapter = new ConnRecyclerViewAdapter(connList,getActivity());
        recyclerView.setAdapter(connRecyclerViewAdapter);
        connRecyclerViewAdapter.setOnItemClickListener(new ConnRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemLongClick(View view, final int pos) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(),view);
                popupMenu.getMenuInflater().inflate(R.menu.menu3,popupMenu.getMenu());
                //弹出式菜单的菜单项点击事件
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.delete) {
                            connList.remove(pos);
                            connRecyclerViewAdapter.notifyItemRemoved(pos);
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }
}