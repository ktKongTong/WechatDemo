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
    private List<News> newsList = new ArrayList<>();
    private Context context;
    public HomeRecyclerViewAdapter(List<News> newsList,Context context){
        this.newsList=newsList;
        this.context = context;
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
        holder.newsName.setText(news.getReceiver().getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"SendTo:"+newsList.get(position).getReceiver().name,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(view.getContext(), SendMessageActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        if(news.isTop()){
//            holder.newsTime.setVisibility(View.INVISIBLE);
            holder.homeItemView.setBackgroundColor(Color.GRAY);
        }else{
            holder.homeItemView.setBackgroundColor(Color.WHITE);
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(view.getContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();
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
        ImageView newsAvatar;
        TextView newsName;
        TextView newsTime;
        View homeItemView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsAvatar = (ImageView) itemView.findViewById(R.id.news_avatar);
            newsName = (TextView) itemView.findViewById(R.id.news_name);
            newsTime = itemView.findViewById(R.id.news_time);
            homeItemView = itemView.findViewById(R.id.home_item);

        }
    }

    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onItemLongClick(View view, int pos);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


}
