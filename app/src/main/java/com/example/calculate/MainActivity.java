package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    private Button add, sub, div, mul, reset, cancel, percent, point, calculate;
    private Button square, cube, cm,m,cm2, m2, sin, cos, tan, log, ln, help, factorial, hex,dao,bin,dec,oct,left,right,sqrt;

    private String str = "0";
    private boolean clear_flag = false;
    String result;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取屏幕方向
        int orientation=getResources().getConfiguration().orientation;
        Log.d("--------",""+orientation);
        int mCurrentorientation = getResources().getConfiguration().orientation;
        if(mCurrentorientation == Configuration.ORIENTATION_PORTRAIT){
            Log.i("INFO","portrait"); //竖屏
            initView_por();   //竖屏初始化
            initEvent_por();
        }
        if(mCurrentorientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.i("INFO","landscape");
            initView_por();
            initView_land();
            initEvent_por();
            initEvent_land();
        }

    }


    //横屏初始化组件
    private void initView_land() {
        left = (Button) findViewById(R.id.b_left);
        right = (Button) findViewById(R.id.b_right);
        ln = (Button) findViewById(R.id.b_ln);
        log = (Button) findViewById(R.id.b_lg);
        dao = (Button) findViewById(R.id.b_dao);
        square = (Button) findViewById(R.id.b_square);
        sqrt = (Button) findViewById(R.id.b_sqrt);
        cube = (Button) findViewById(R.id.b_cube);
        factorial = (Button) findViewById(R.id.b_factory);
        sin = (Button) findViewById(R.id.b_sin);
        cos = (Button) findViewById(R.id.b_cos);
        tan = (Button) findViewById(R.id.b_tan);
        cm = (Button) findViewById(R.id.b_cm);
        m = (Button) findViewById(R.id.b_m);
        cm2 = (Button) findViewById(R.id.b_cm2);
        m2 = (Button) findViewById(R.id.b_m2);
        help = (Button) findViewById(R.id.b_help);
        oct = (Button) findViewById(R.id.b_oct);
        bin = (Button) findViewById(R.id.b_bin);
        dec = (Button) findViewById(R.id.b_dec);
        hex = (Button) findViewById(R.id.b_hex);

        text = (TextView) findViewById(R.id.t1);

    }
    //横屏监听器
    private void initEvent_land() {
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        ln.setOnClickListener(this);
        log.setOnClickListener(this);
        dao.setOnClickListener(this);
        square.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        cube.setOnClickListener(this);
        factorial.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        oct.setOnClickListener(this);
        bin.setOnClickListener(this);
        dec.setOnClickListener(this);
        hex.setOnClickListener(this);
        help.setOnClickListener(this);
        cm.setOnClickListener(this);
        cm2.setOnClickListener(this);
        m.setOnClickListener(this);
        m2.setOnClickListener(this);
    }

    //竖屏初始化组件
    private void initView_por() {
        //初始化数字按钮
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

        //初始化运算符按钮
        add = (Button) findViewById(R.id.b_add);
        sub = (Button) findViewById(R.id.b_sub);
        mul = (Button) findViewById(R.id.b_mul);
        div = (Button) findViewById(R.id.b_div);
        reset = (Button) findViewById(R.id.b_C);
        cancel = (Button) findViewById(R.id.b_DEL);
        percent = (Button) findViewById(R.id.b_per);
        calculate = (Button) findViewById(R.id.b_equals);
        point = (Button) findViewById(R.id.b_point);

        text = (TextView) findViewById(R.id.t1);

    }

    //竖屏监听器
    private void initEvent_por() {
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
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        percent.setOnClickListener(this);
        point.setOnClickListener(this);
        cancel.setOnClickListener(this);
        calculate.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    /**
     *
     * @param v 点击事件
     */
    @Override
    public void onClick(View v) {
        str = text.getText().toString();
        switch (v.getId()){
            /*
            数字
             */
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
            case R.id.b_point:
                str += ((Button) v).getText();
                text.setText(str);
                break;
            /*
            实现连续计算
             */
            case R.id.b_add:
            case R.id.b_sub:
            case R.id.b_mul:
            case R.id.b_div:
                str += " "+((Button) v).getText()+" ";
                text.setText(str);
                break;
             /*
             删除:若长度为1或0 直接清零；若长度大于1则删除最后一位
              */
            case R.id.b_DEL:
                if(clear_flag){
                    clear_flag = false;
                    str="";
                    text.setText(str);
                }
                if(str != null && !str.equals("")){
                    text.setText(str.substring(0,str.length()-1));
                }
                break;
            /*
            清除
             */
            case R.id.b_C:
                clear_flag = false;
                str="";
                text.setText(str);
                break;
             /*
             百分号
              */
            case R.id.b_per:
                if(str.length()!=0){
                    result = Double.toString((Double.parseDouble(str))/100.0);
                    clear_flag = false;
                }
                else {
                    result="error!";
                    return;
                }
                break;
             /*
             等号
              */
            case R.id.b_equals:
                getResult();
                break;
            /*
            平方
             */
            case R.id.square:
                if(str.length()!=0){
                    double t = Double.parseDouble(str);
                    result = Double.toString(t*t);
                }
                else {
                    result="error!";
                    return;
                }
                text.setText(result);
                break;
             /*
            立方
             */
            case R.id.b_cube:
                if(str.length()!=0){
                    double t = Double.parseDouble(str);
                    result = Double.toString(t*t*t);
                }
                else {
                    result="error!";
                    return;
                }
                text.setText(result);
                break;
             /*
             开方
              */
            case R.id.b_sqrt:
                if(str.length()!=0){
                    double t = Double.parseDouble(str);
                    result = Double.toString(Math.sqrt(t));
                }
                else result = "0";
        }

    }

    private void getResult() {
    }
}