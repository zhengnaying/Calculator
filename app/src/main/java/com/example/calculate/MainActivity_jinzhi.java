package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity_jinzhi extends AppCompatActivity  implements View.OnClickListener  {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,b_a,b_b,b_c,b_d,b_e,b_f,b_back,cancel,reset;
    private String str1 = "0",str2 = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jinzhi);
        initView();
        initEvent();


    }

    @Override
    public void onClick(View v) {

    }
    private void initView() {
        //初始化按钮
        b0 = (Button) findViewById(R.id.b_0);
        b1 = (Button) findViewById(R.id.b_1);
        b2 = (Button) findViewById(R.id.b_2);
        b3 = (Button) findViewById(R.id.b_3);
        b4 = (Button) findViewById(R.id.b_4);
        b5 = (Button) findViewById(R.id.b_5);
        b6 = (Button) findViewById(R.id.b_6);
        b7 = (Button) findViewById(R.id.b_7);
        b8 = (Button) findViewById(R.id.b_8);
        b9 = (Button) findViewById(R.id.b_9);
        b_a= (Button) findViewById(R.id.b_a);
        b_b= (Button) findViewById(R.id.b_b);
        b_c= (Button) findViewById(R.id.b_c);
        b_d= (Button) findViewById(R.id.b_d);
        b_e= (Button) findViewById(R.id.b_e);
        b_f= (Button) findViewById(R.id.b_f);
        reset = (Button) findViewById(R.id.b_C);
        cancel = (Button) findViewById(R.id.b_DEL);
        b_back = (Button) findViewById(R.id.b_return);

        TextView text1 = (TextView) findViewById(R.id.t2);
        TextView text2 = (TextView) findViewById(R.id.t3) ;
    }
    //监听器
    private void initEvent() {
        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b_a.setOnClickListener(this);
        b_b.setOnClickListener(this);
        b_c.setOnClickListener(this);
        b_d.setOnClickListener(this);
        b_e.setOnClickListener(this);
        b_f.setOnClickListener(this);
        b_back.setOnClickListener(this);
        cancel.setOnClickListener(this);
        reset.setOnClickListener(this);

    }
}