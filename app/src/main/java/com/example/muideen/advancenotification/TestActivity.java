package com.example.muideen.advancenotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {
    public static final String ACTION_CALL="call";
    public static final String ACTION_VIDEO_CALL="video call";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        String action=getIntent().getAction();
        if(action.equals(ACTION_CALL)){
            displayView(getString(R.string.msg_call));
        }else if(action.equals(ACTION_VIDEO_CALL)){
            displayView(getString(R.string.msg_video));
        }

        Button back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void displayView(String msg){
        TextView view=(TextView)findViewById(R.id.msg);
        view.setText(msg);
    }
}
