package com.example.wechatdemo.bean;

public class Conn {
    public Conn (String name,String avatar){
        this.avatar=avatar;
        this.name=name;
    }
    // 名称
    public String name;
    // 微信id
    public String weChatId;
    // 电话号码
    public String phoneNumber;
    // 个性签名
    public String signature;
    // 头像链接
    public String avatar;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeChatId() {
        return weChatId;
    }

    public void setWeChatId(String weChatId) {
        this.weChatId = weChatId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
