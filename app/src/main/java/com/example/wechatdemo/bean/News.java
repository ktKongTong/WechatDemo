package com.example.wechatdemo.bean;

public class News {
    // 消息id
    private String newsId;
    // 发送者
    private Conn sender;
    // 接收者
    private Conn receiver;

    public News (Conn sender,Conn receiver){
        this.sender=sender;
        this.receiver=receiver;
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
