package com.example.wechatdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wechatdemo.ConnDetailActivity;
import com.example.wechatdemo.bean.Conn;
import com.example.wechatdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ConnRecyclerViewAdapter extends RecyclerView.Adapter<ConnRecyclerViewAdapter.ViewHolder>{
    private List<Conn> connList = new ArrayList<>();
    private Context context;
    public ConnRecyclerViewAdapter(List<Conn> connList,Context context){
        this.connList=connList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conn_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final Conn conn = this.connList.get(position);
        Glide.with(context)
                .load(conn.getAvatar())
                .into(holder.connAvatar);
        holder.connName.setText(conn.getName());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,connList.get(position).name,Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(view.getContext(), ConnDetailActivity.class);
//                view.getContext().startActivity(intent);
//            }
//        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d("LONG","LONGCLICKTEST");
                Toast.makeText(view.getContext(),"test",Toast.LENGTH_SHORT).show();
                onItemClickListener.onItemLongClick(holder.itemView,position);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.connList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView connAvatar;
        TextView connName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            connAvatar = (ImageView) itemView.findViewById(R.id.conn_avatar);
            connName = (TextView) itemView.findViewById(R.id.conn_name);
        }
    }
    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onItemLongClick(View view , int pos);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
