package com.example.myapplication.navigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;

import com.example.myapplication.R;
import com.example.myapplication.databinding.NavigationActivityBindingImpl;

public class NavigationActivity extends AppCompatActivity implements LifecycleOwner {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity);
    }

}
