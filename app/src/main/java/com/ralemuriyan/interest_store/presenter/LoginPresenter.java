package com.ralemuriyan.interest_store.presenter;

import com.ralemuriyan.interest_store.contract.LoginContract;
import com.ralemuriyan.interest_store.model.LoginModel;

public class LoginPresenter {

    private LoginContract view;
    private LoginModel model;

    public LoginPresenter(LoginContract view) {
        this.view = view;
        initPresenter();
    }


    private void initPresenter() {
        this.model = new LoginModel();
        view.initView();
    }

    public void mobileNumberPresent(String number)
    {

        model.setMobileNumber(number);
        boolean check= view.validationMobileNumber(model.getMobileNumber());

       if(check)
       {
           view.onclick();
       }

    }

}
