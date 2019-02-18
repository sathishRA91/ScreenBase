package com.ralemuriyan.interest_store.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ralemuriyan.interest_store.R;
import com.ralemuriyan.interest_store.contract.InterestContract;
import com.ralemuriyan.interest_store.presenter.InterestPresenter;

public class InterestCalculatorActivity extends AppCompatActivity implements InterestContract {

    private EditText Et_amount, Et_interest, Et_interestMonth;
    private Button Bt_findInterest;
    private LinearLayout Ll_interestCalculate;
    private InterestPresenter presenter;
    private TextView Tv_interestAmount, Tv_totalAmount, Tv_clear;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_calculator);
        presenter = new InterestPresenter(this);
    }

    @Override
    public void initView() {
        Et_amount = findViewById(R.id.Et_amount);
        Et_interest = findViewById(R.id.Et_interest);
        Et_interestMonth = findViewById(R.id.Et_interestMonth);
        Bt_findInterest = findViewById(R.id.Bt_findInterest);
        Ll_interestCalculate = findViewById(R.id.Ll_interestCalculate);
        Tv_interestAmount = findViewById(R.id.Tv_interestAmount);
        Tv_totalAmount = findViewById(R.id.Tv_totalAmount);
        Tv_clear = findViewById(R.id.Tv_clear);

        Bt_findInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validationInterest(Et_amount.getText().toString(), Et_interest.getText().toString(),
                        Et_interestMonth.getText().toString());
            }
        });

        Tv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.clear();
            }
        });
    }

    @Override
    public void calculate(double amount, double percentage, int month) {

        double interestAmount = amount * (percentage / 100) * month;

        double totalAmount = amount + interestAmount;

        Ll_interestCalculate.setVisibility(View.VISIBLE);
        Tv_interestAmount.setText(String.valueOf(interestAmount));
        Tv_totalAmount.setText(String.valueOf(totalAmount));

    }

    @Override
    public boolean validatePrincipalAmount(String principalAmount) {

        if (principalAmount != null && !principalAmount.isEmpty()) {
            Et_amount.setError(null);

            return true;
        } else {
            Et_amount.setError("Invalid Principal amount");
            return false;
        }
    }

    @Override
    public boolean validateInterestRate(String percentageRate) {

        if (percentageRate != null && !percentageRate.isEmpty()) {
            Et_interest.setError(null);

            return true;
        } else {
            Et_interest.setError("Invalid Interest rate ");
            return false;
        }
    }

    @Override
    public boolean validateInterestmonth(String period) {


        if (period != null && !period.isEmpty()) {
            Et_interestMonth.setError(null);

            return true;
        } else {
            Et_interestMonth.setError("Invalid Interest period");
            return false;
        }
    }

    @Override
    public void clear() {
        Et_amount.getText().clear();
        Et_interest.getText().clear();
        Et_interestMonth.getText().clear();
        Ll_interestCalculate.setVisibility(View.GONE);
        Tv_interestAmount.setText("0.0");
        Tv_totalAmount.setText("0.0");
    }


}
