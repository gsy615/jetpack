package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.databinding.MainActivityBindingImpl;
import com.example.myapplication.databinding.UserBean;
import com.example.myapplication.databinding.UserBeanViewModel;
import com.example.myapplication.lifecycle.ActivityLifeObserver;
import com.example.myapplication.navigation.NavigationActivity;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {
    private static final String TAG ="MainActivity" ;
    private LifecycleRegistry registry;
    private MainActivityBindingImpl binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO databinding test
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        UserBean user = new UserBean();
        user.setId("1111");
        user.setName("2222");
        user.setPhoneNum("3333");
        binding.setUser(user);
        //TODO databinding 刷新绑定
        UserBeanViewModel userBeanViewModel = ViewModelProviders.of(this).get(UserBeanViewModel.class);
        userBeanViewModel.getDatas().observeForever(new Observer<UserBean>() {
            @Override
            public void onChanged(@Nullable final UserBean user) {
                // 根据数据库或者网络请求获取的数据，通过databinding界面更新
                binding.setUser(user);
            }
        });

        binding.setMain(this);
        binding.setBol(true);

        //TODO Lifecycle test
        registry = new LifecycleRegistry(this);
        registry.addObserver(new ActivityLifeObserver());

    }

    public void onClickFragment(View view) {
        Log.e(TAG,"onClickFragment");
        startActivity(new Intent(this, NavigationActivity.class));
    }

    public void changeUi(View view,Boolean ischange){
        if (ischange) {
            view.setVisibility(View.INVISIBLE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }
}
