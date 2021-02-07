package com.example.idfrange;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;


import com.example.idfrange.R;

import java.lang.reflect.Array;
import java.util.*;


public class rangesActivity extends AppCompatActivity {
    Button newRangeButton,startRangeButton2;
    EditText rangeInput;
    TextView tvRange,titleRange;
    String[] ranges,newNames;
    String newRangeString;
    int rangesCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranges);


        //Initial work
        tvRange=findViewById(R.id.scrollRangesView);
        tvRange.setMovementMethod(new ScrollingMovementMethod());
        rangeInput=findViewById(R.id.rangeEditText);
        newRangeButton= findViewById(R.id.saveRangeButton);
        startRangeButton2=findViewById(R.id.startRangeButton2);
        titleRange=findViewById(R.id.rangeTextView);


        ranges=new String[11];
        newNames=new String[40];
        rangesCounter=0;

        Bundle extras = getIntent().getExtras();
        final String[] newNames= extras.getStringArray("nameList");

        //Bundle extras = getIntent().getExtras();
        //int[] newNames= extras.getIntArray("nameList");


        //Intent i=getIntent();
        //nameCounter=i.getIntExtra("nameCount",0);


//        for(int j=0;j<newNames.length;j++){
//            if(newNames[j]!=null){
//            tvRange.append(newNames[j]+"\n");}
//        }


        newRangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newRangeString=rangeInput.getText().toString();
                tvRange.append(newRangeString+"\n");
                rangeInput.setText("");

                ranges[rangesCounter]=newRangeString;
                rangesCounter++;
            }
        });
        startRangeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(rangesActivity.this,scoresActivity.class);
                intent.putExtra("nameList",newNames);
                intent.putExtra("rangeList",ranges);
                startActivity(intent);
            }
        });


    }
}
