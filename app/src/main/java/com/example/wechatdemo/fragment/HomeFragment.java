package com.example.wechatdemo.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wechatdemo.R;
import com.example.wechatdemo.adapter.ConnRecyclerViewAdapter;
import com.example.wechatdemo.adapter.HomeRecyclerViewAdapter;
import com.example.wechatdemo.bean.Conn;
import com.example.wechatdemo.bean.News;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息首页
 */
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
        final List<News> newsList=new ArrayList<>();
        //获取联系人数据
        Conn conn1 = new Conn("name1eeeeeeeeeeeeee","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3072531546,2743940875&fm=26&gp=0.jpg");
        Conn conn2 = new Conn("name2eeeeeeeeeeeeee","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3072531546,2743940875&fm=26&gp=0.jpg");
        Conn conn3 = new Conn("name3eeeeeeeeeeeeee","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3072531546,2743940875&fm=26&gp=0.jpg");
        Conn conn4 = new Conn("name4eeeeeeeeeeeeee","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3072531546,2743940875&fm=26&gp=0.jpg");
        News news1 =new News(conn1,conn1,1);
        News news2 =new News(conn2,conn2,2);
        News news3 =new News(conn3,conn3,3);
        News news4 =new News(conn4,conn4,4);
        newsList.add(news1);
        newsList.add(news2);
        newsList.add(news3);
        newsList.add(news4);
        recyclerView=(RecyclerView)view.findViewById(R.id.home_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        final HomeRecyclerViewAdapter homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(newsList,getActivity());
        recyclerView.setAdapter(homeRecyclerViewAdapter);

        homeRecyclerViewAdapter.setOnItemClickListener(new HomeRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemLongClick(final View view, final int pos) {
                PopupMenu popupMenu = new PopupMenu(view.getContext(),view);
                popupMenu.getMenuInflater().inflate(R.menu.menu3,popupMenu.getMenu());
                //弹出式菜单的菜单项点击事件
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()==R.id.delete) {
                            newsList.remove(pos);
                            homeRecyclerViewAdapter.notifyItemRangeChanged(pos,newsList.size()-pos);
                        }
                        if(item.getItemId()==R.id.to_top) {
                            News news = newsList.get(pos);
                            News.setTopCount(News.getTopCount()+1);
                            news.setTop(true);
                            newsList.remove(pos);
                            newsList.add(0,news);
                            homeRecyclerViewAdapter.notifyItemRangeChanged(0,pos+1);
                        }
                        if(item.getItemId()==R.id.cancel_to_top) {
                            News news = newsList.get(pos);
                            news.setTop(false);
                            newsList.remove(pos);
                            News.setTopCount(News.getTopCount()-1);
                            int i = News.getTopCount();
                            while (i>=0){
                                // 没有置顶的为0项
                                if(newsList.size()-i==0){
                                    newsList.add(i,news);
                                    break;
                                }
                                if(newsList.get(i).getNewsTime().before(news.getNewsTime())){
                                    newsList.add(i,news);
                                    break;
                                }
                                i++;
                            }
                            homeRecyclerViewAdapter.notifyItemRangeChanged(pos,i-pos+1);

                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }
}