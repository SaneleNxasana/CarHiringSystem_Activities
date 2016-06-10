package com.tp2assignment6.domaindesign.domain.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tp2assignment6.domaindesign.domain.repository.user.Impl.UserRepositoryImpl;

public class DisplayActivity extends AppCompatActivity {
    UserRepositoryImpl userRepository;
    private EditText idNum;
    private EditText fn;
    private EditText ln;
    private EditText em;

    private Button hmButton;
    private Button dsplyButton;

    public DisplayActivity() {    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        idNum = (EditText) findViewById(R.id.prv_email);
        fn = (EditText) findViewById(R.id.prv_firstName);
        ln = (EditText) findViewById(R.id.prv_lastName);
        em = (EditText) findViewById(R.id.prv_email);

        hmButton = (Button) findViewById(R.id.homeButton);
        dsplyButton = (Button) findViewById(R.id.displayButton);

        assert hmButton != null;
        hmButton.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            public void onClick(View v){
                startActivity(intent);
            }
        });
        viewAll();
    }

    public void viewAll(){
        dsplyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Cursor rslt = userRepository.getAllData();
                if (rslt.getCount() == 0){
                    showMessage("Error", "No Data Found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(rslt.moveToNext()){
                    buffer.append(rslt.getString(0) + "\n");
                    buffer.append(rslt.getString(1) + "\n");
                    buffer.append(rslt.getString(2) + "\n");
                    buffer.append(rslt.getString(3) + "\n");
                    buffer.append(rslt.getString(4) + "\n");
                }
                showMessage("Data: ", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
