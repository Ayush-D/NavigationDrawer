package com.example.application.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Objects;


public class RequestActivity extends AppCompatActivity {

    private EditText requestTopic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_request);

        actionbar();

        requestTopic = findViewById(R.id.request_topic);
        Button btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //checking if field are filled or not
                String var = requestTopic.getText().toString();

                if(Objects.equals(var, "")){
                    Toast.makeText(RequestActivity.this, "Fill the Required Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Send the feedback
                    Toast.makeText(RequestActivity.this, "Sent Successfully!!", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
            }
        });
    }

    public void actionbar(){
        //for back button in Action Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //for Title in Action Bar
        getSupportActionBar().setTitle("Feedback");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
