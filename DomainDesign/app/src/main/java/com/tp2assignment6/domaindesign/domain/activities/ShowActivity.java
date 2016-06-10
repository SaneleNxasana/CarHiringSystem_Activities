package com.tp2assignment6.domaindesign.domain.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tp2assignment6.domaindesign.domain.repository.user.Impl.UserRepositoryImpl;

public class ShowActivity extends AppCompatActivity {
    UserRepositoryImpl userRepository;
    TextView txtViewID;
    TextView txtViewFN;
    TextView txtViewLN;
    TextView txtViewEM;

    private Button sbmtButton;

    public ShowActivity() {    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        userRepository = new UserRepositoryImpl(this);

        txtViewID = (TextView) findViewById(R.id.shw_idNumber);
        txtViewFN = (TextView) findViewById(R.id.shw_firstName);
        txtViewLN = (TextView) findViewById(R.id.shw_lastName);
        txtViewEM = (TextView) findViewById(R.id.shw_email);
        sbmtButton = (Button) findViewById(R.id.submitButton);

        Intent intent = getIntent();
        String idNum = intent.getStringExtra("userId");
        String fn = intent.getStringExtra("firstName");
        String ln = intent.getStringExtra("lastName");
        String mail = intent.getStringExtra("email");

        txtViewID.setText("ID Number: " + idNum);
        txtViewFN.setText("First Name: " + fn);
        txtViewLN.setText("Last Name: " + ln);
        txtViewEM.setText("Email Address: " + mail);

        addData();
    }

    public void addData(){
        assert sbmtButton != null;
        sbmtButton.setOnClickListener(
                new View.OnClickListener(){
                    Intent intent = new Intent (getApplicationContext(), DisplayActivity.class);

                    @Override
                    public void onClick(View v) {
                        boolean isInserted = userRepository.insertData(
                                Long.valueOf(txtViewID.getText().toString()),
                                txtViewFN.getText().toString(),
                                txtViewLN.getText().toString(),
                                txtViewEM.getText().toString());
                        if (isInserted == true){
                            Toast.makeText(getApplicationContext(), "Insert Successful", Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(getApplicationContext(), "Insert Failed", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
