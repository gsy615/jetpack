package com.example.myapplication.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class UserBean extends BaseObservable {

    private String id;
    private String name;
    private String phoneNum;

    @Bindable
    public String getId() {
        return name;
    }
    @Bindable
    public String getName() {
        return name;
    }
    @Bindable
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
