package com.ralemuriyan.interest_store.presenter;

import com.ralemuriyan.interest_store.contract.InterestContract;

public class InterestPresenter {

private InterestContract view;

    public InterestPresenter(InterestContract view)
    {
        this.view=view;
        initPresenter();
    }

    private void initPresenter()
    {
        view.initView();
    }


    public void validationInterest(String amount,String percentage,String period)
    {
        if(view.validatePrincipalAmount(amount)&&view.validateInterestRate(percentage)&&view.validateInterestmonth(period))
        {

            double toAmount=Double.parseDouble(amount);
            double toPercentage=Double.parseDouble(percentage);
            int toPeriod=Integer.parseInt(period);
            view.calculate(toAmount,toPercentage,toPeriod);
        }
    }


    public void clear()
    {
        view.clear();
    }
}
