package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity_jinzhi extends AppCompatActivity  implements View.OnClickListener  {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,b_a,b_b,b_c,b_d,b_e,b_f,b_back,cancel,reset,b_change;
    private String str1 = "0",str2 = "0";
    TextView text1,text2;
    Spinner s1,s2;
    String s1_selected,s2_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jinzhi);
        initView();
        initEvent();


    }

    @Override
    public void onClick(View v) {
        str1 = text1.getText().toString();
        str2 = text2.getText().toString();
        switch (v.getId()){
            case R.id.b_0:
            case R.id.b_1:
            case R.id.b_2:
            case R.id.b_3:
            case R.id.b_4:
            case R.id.b_5:
            case R.id.b_6:
            case R.id.b_7:
            case R.id.b_8:
            case R.id.b_9:
                str1 += ((Button) v).getText();
                text1.setText(str1);
                break;
            case R.id.b_DEL:

                if (str1 != null && !str1.equals("")) {
                    text1.setText(str1.substring(0, str1.length() - 1));
                }
                break;
            /*
            清除
             */
            case R.id.b_C:
                str1 = "";
                text1.setText(str1);
                break;
            case R.id.b_return:
                Intent intent = new Intent(MainActivity_jinzhi.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.change:
                Double n1 = Double.parseDouble(str1);

        }


    }
    private void testSpinner(){


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
        b_change = (Button) findViewById(R.id.change);

        text1 = (TextView) findViewById(R.id.t2);
        text2 = (TextView) findViewById(R.id.t3) ;
        s1 =(Spinner) findViewById(R.id.s1);
        s2 = (Spinner) findViewById(R.id.s2);
        s1.setSelection(0);
        s2.setSelection(2);
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
        b_change.setOnClickListener(this);
        s1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                s1_selected = s1.getSelectedItem().toString();


            }
        });

    }
}