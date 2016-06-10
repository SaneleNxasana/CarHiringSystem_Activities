package com.tp2assignment6.domaindesign.domain.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PreviewActivity extends AppCompatActivity {
    private EditText IDnumber;
    private EditText firstName;
    private EditText lastName;
    private EditText emailAddress;
    private Button prvwButton;
    private Button bckButton;

    public PreviewActivity() {    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        IDnumber = (EditText) findViewById(R.id.prv_idNumber);
        firstName = (EditText) findViewById(R.id.prv_firstName);
        lastName = (EditText) findViewById(R.id.prv_lastName);
        emailAddress = (EditText) findViewById(R.id.prv_email);

        prvwButton = (Button) findViewById(R.id.previewButton);
        bckButton = (Button) findViewById(R.id.backButton);

        assert prvwButton != null;
        prvwButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),ShowActivity.class);
                intent.putExtra("idNumber", IDnumber.getText().toString());
                intent.putExtra("firstName", firstName.getText().toString());
                intent.putExtra("lastName", lastName.getText().toString());
                intent.putExtra("emailAddress", emailAddress.getText().toString());
                startActivity(intent);
            }
        });

        assert bckButton != null;
        bckButton.setOnClickListener(new View.OnClickListener(){
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            public void onClick(View v){
                startActivity(intent);
            }
        });
    }
}
