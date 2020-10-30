package com.example.wechatdemo.bean;

import java.util.Date;
import java.util.Random;

public class News {
    private static int topCount = 0;
    private Random random= new Random();
    public static int getTopCount() {
        return topCount;
    }

    public static void setTopCount(int topCount) {
        News.topCount = topCount;
    }
    public News(Conn sender,Conn receiver,Date newsTime){
        this.setSender(sender);
        this.setReceiver(receiver);
        this.setTop(false);
        this.setNews(false);
        this.setDisturb(false);
        this.setNewsTime(newsTime);
    }
    public News(Conn sender,Conn receiver,Date newsTime,boolean isDisturb){
        this.setSender(sender);
        this.setReceiver(receiver);
        this.setTop(false);
        this.setNews(false);
        this.setDisturb(isDisturb);
        this.setNewsTime(newsTime);
        this.setNewsContent(String.valueOf(random.nextInt(10)));
    }
    // 消息id
    private String newsId;
    // 发送者
    private Conn sender;
    // 接收者
    private Conn receiver;
    //是否未读
    private boolean isNews;
    //是否置顶
    private boolean isTop;
    //是否免打扰
    private boolean isDisturb;
    // 最后通信时间
    private Date newsTime;
    //最后通信内容
    private String newsContent;
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

    public boolean isDisturb() {
        return isDisturb;
    }

    public void setDisturb(boolean disturb) {
        isDisturb = disturb;
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}
