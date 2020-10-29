package com.example.wechatdemo.bean;

import java.util.Date;

public class News {
    private static int topCount = 0;

    public static int getTopCount() {
        return topCount;
    }

    public static void setTopCount(int topCount) {
        News.topCount = topCount;
    }

    // 消息id
    private String newsId;
    // 发送者
    private Conn sender;
    // 接收者
    private Conn receiver;
    //队伍中序列
    private int sequence;
    //是否未读
    private boolean isNews;
    //是否置顶
    private boolean isTop;
    //是否免打扰

    // 最后通信时间
    private Date newsTime;

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public News (Conn sender, Conn receiver, int sequence){
        this.sender=sender;
        this.receiver=receiver;
        this.setTop(false);
        this.setNews(false);
        this.setSequence(sequence);
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public boolean isNews() {
        return isNews;
    }

    public void setNews(boolean news) {
        isNews = news;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public Conn getSender() {
        return sender;
    }

    public void setSender(Conn sender) {
        this.sender = sender;
    }

    public Conn getReceiver() {
        return receiver;
    }

    public void setReceiver(Conn receiver) {
        this.receiver = receiver;
    }
}
