package com.example.myapplication.databinding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserBeanViewModel extends ViewModel {
    private MutableLiveData<UserBean> userLiveData = new MutableLiveData<>();
    public LiveData getUser(){
        //获取数据
        loadData();
        return userLiveData;
    }
    private void loadData(){
        new Thread(){
            @Override
            public void run() {
                userLiveData.postValue(new UserBean());
            }
        }.start();
    }
    public LiveData getDatas(){
        return userLiveData;
    }
    public void updateUser(){
        loadData();
    }
}
