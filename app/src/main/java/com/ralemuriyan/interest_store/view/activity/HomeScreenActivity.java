package com.ralemuriyan.interest_store.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.ralemuriyan.interest_store.R;
import com.ralemuriyan.interest_store.contract.HomescreenContract;
import com.ralemuriyan.interest_store.presenter.HomeScreenPresenter;


public class HomeScreenActivity extends AppCompatActivity implements HomescreenContract, View.OnClickListener {

    private LinearLayout Ll_interest_calculator;
    private HomeScreenPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        presenter=new HomeScreenPresenter(this);
    }

    @Override
    public void initView() {
        Ll_interest_calculator = findViewById(R.id.Ll_interest_calculator);

        Ll_interest_calculator.setOnClickListener(this);
    }

    @Override
    public void navigateScreen()
    {
        Intent navigateInterest = new Intent(HomeScreenActivity.this, InterestCalculatorActivity.class);
        startActivity(navigateInterest);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Ll_interest_calculator)
        {
            presenter.navigateInterestCalucator();
        }

    }
}
