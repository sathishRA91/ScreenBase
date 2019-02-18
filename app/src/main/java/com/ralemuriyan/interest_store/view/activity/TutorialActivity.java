package com.ralemuriyan.interest_store.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ralemuriyan.interest_store.R;
import com.ralemuriyan.interest_store.config.MessageConstant;
import com.ralemuriyan.interest_store.contract.TutorialContract;

public class TutorialActivity extends AppCompatActivity implements TutorialContract
{

    private ViewPager viewPager;
    private TextView Tv_nextDone;
    private MessageConstant messageConstant = new MessageConstant();
    private int skipDone = 0;
    private String userStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_screen);

    }

    @Override
    public void initView() {

    }
}
