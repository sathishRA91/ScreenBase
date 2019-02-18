package com.ralemuriyan.interest_store.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ralemuriyan.interest_store.R;
import com.ralemuriyan.interest_store.contract.LoginContract;
import com.ralemuriyan.interest_store.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract {

    private Button Bt_agree;
    private EditText Et_mobileNumber;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);
    }

    @Override
    public void initView() {
        Bt_agree = findViewById(R.id.Bt_agree);
        Et_mobileNumber = findViewById(R.id.Et_mobileNumber);


        Bt_agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validate();
            }
        });

    }

    @Override
    public boolean validationMobileNumber(String number) {

        if (number != null && number.length() == 10) {
            Et_mobileNumber.setError(null);
            return true;
        } else {
            Et_mobileNumber.setError("Invalid Mobile Number");
            return false;
        }

    }


    @Override
    public void onclick()
    {

        Intent homeNavigation=new Intent(LoginActivity.this,HomeScreenActivity.class);
        startActivity(homeNavigation);
    }


    private void validate() {
        presenter.mobileNumberPresent(Et_mobileNumber.getText().toString());
    }
}
