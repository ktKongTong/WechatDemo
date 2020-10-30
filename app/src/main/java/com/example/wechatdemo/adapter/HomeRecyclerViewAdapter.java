package com.example.wechatdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.wechatdemo.R;
import com.example.wechatdemo.SendMessageActivity;
import com.example.wechatdemo.bean.News;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>{
    private List<News> newsList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public HomeRecyclerViewAdapter(List<News> newsList,Context context){
        this.newsList=newsList;
        this.context = context;
    }
//    点击/长按监听接口
    public interface OnItemClickListener{
        void onItemLongClick(View view, int pos);
        void onItemClick(View view, int pos);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        News news = this.newsList.get(position);
        Glide.with(context)
                .load(news.getReceiver().getAvatar())
                .into(holder.newsAvatar);
        holder.newsTime.setText(String.valueOf(news.getNewsTime().getTime()));
        holder.newsName.setText(news.getReceiver().getName());
        holder.newsContent.setText(news.getNewsContent());
        // 是否置顶，更改背景颜色
        if(news.isTop()){
            holder.newsItem.setBackgroundColor(Color.GRAY);
        }else{
            holder.newsItem.setBackgroundColor(Color.WHITE);
        }
        // 是否已读，小红点
        if(news.isNews()){
            holder.newsDot.setVisibility(View.VISIBLE);
        }else{
            holder.newsDot.setVisibility(View.INVISIBLE);
        }
        // 是否免打扰,免打扰图标
        if(news.isDisturb()){
            holder.newsNoDisturb.setVisibility(View.VISIBLE);
        }else{
            holder.newsNoDisturb.setVisibility(View.INVISIBLE);
        }
        // 监听单击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(holder.itemView,position);
            }
        });
        // 监听长按事件
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onItemClickListener.onItemLongClick(holder.itemView,position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.newsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View newsItem;
        TextView newsName;
        TextView newsTime;
        TextView newsContent;
        ImageView newsAvatar;
        ImageView newsDot;
        ImageView newsNoDisturb;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsItem = itemView.findViewById(R.id.home_item);
            newsName = itemView.findViewById(R.id.news_name);
            newsTime = itemView.findViewById(R.id.news_time);
            newsContent = itemView.findViewById(R.id.news_content);
            newsAvatar = itemView.findViewById(R.id.news_avatar);
            newsDot = itemView.findViewById(R.id.news_dot);
            newsNoDisturb = itemView.findViewById(R.id.news_no_disturb);
        }
    }




}
