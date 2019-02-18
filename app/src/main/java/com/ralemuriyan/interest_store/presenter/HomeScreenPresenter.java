package com.ralemuriyan.interest_store.presenter;

import android.view.View;

import com.ralemuriyan.interest_store.contract.HomescreenContract;

public class HomeScreenPresenter {

    private HomescreenContract view;

    public HomeScreenPresenter(HomescreenContract view) {
        this.view = view;
        initPresenter();
    }

    private void initPresenter() {

        view.initView();
    }


    public void navigateInterestCalucator()
    {
        view.navigateScreen();
    }
}
