package com.tp2assignment6.domaindesign.domain.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText userID;
    private EditText firstName;
    private EditText lastname;
    private EditText emailAddress;
    private Button login;
    private Button createAcc;
    String id, email;
    Context ctx = this;

    public LoginActivity() {    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailAddress = (EditText) findViewById(R.id.shw_idNumber);
        userID = (EditText) findViewById(R.id.pass);

        login = (Button) findViewById(R.id.loginButton);
        createAcc = (Button) findViewById(R.id.accountButton);

        assert createAcc != null;
        createAcc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), PreviewActivity.class);
                startActivity(intent);
            }
        });
    }
}
