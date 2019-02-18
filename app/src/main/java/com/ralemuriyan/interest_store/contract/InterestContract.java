package com.ralemuriyan.interest_store.contract;

public interface InterestContract
{

    void initView();

    void calculate(double amount,double percentage,int month);

    boolean validatePrincipalAmount(String principalAmount);

    boolean validateInterestRate(String percentageRate);

    boolean validateInterestmonth(String period);

    void clear();

}
