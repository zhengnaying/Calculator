package com.example.calculate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    private Button add, sub, div, mul, reset, cancel, percent, point, calculate;
    private Button square, cube, cm, cm3, sin, cos, tan, log, ln, help, factorial, dao, left, right, sqrt, s;

    private String str = "0";
    final double pi = 3.1415926;
    private boolean clear_flag = false;
    String result;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //获取屏幕方向
        int orientation = getResources().getConfiguration().orientation;
        Log.d("--------", "" + orientation);
        int mCurrentOrientation = getResources().getConfiguration().orientation;


        if (mCurrentOrientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.i("INFO", "portrait"); //竖屏
            initView_por();   //竖屏初始化
            initEvent_por();
        } else if (mCurrentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.i("INFO", "landscape");
            initView_por();
            initView_land();
            initEvent_land();

            initEvent_por();
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
        cm3 = (Button) findViewById(R.id.b_cm3);
        help = (Button) findViewById(R.id.b_help);
        s = (Button) findViewById(R.id.b_switch);


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
        s.setOnClickListener(this);
        help.setOnClickListener(this);
        cm.setOnClickListener(this);
        cm3.setOnClickListener(this);
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

        Log.v("tag", text.toString());

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
     * @param v 点击事件
     */
    @Override
    public void onClick(View v) {
        str = text.getText().toString();
        switch (v.getId()) {
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
                str += ((Button) v).getText();
                text.setText(str);
                break;
             /*
             删除:若长度为1或0 直接清零；若长度大于1则删除最后一位
              */
            case R.id.b_DEL:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    text.setText(str);
                }
                if (str != null && !str.equals("")) {
                    text.setText(str.substring(0, str.length() - 1));
                }
                break;
            /*
            清除
             */
            case R.id.b_C:
                clear_flag = false;
                str = "";
                text.setText(str);
                break;
             /*
             百分号
              */
            case R.id.b_per:
                if (str.length() != 0) {
                    result = Double.toString((Double.parseDouble(str)) / 100.0);
                    clear_flag = false;
                } else {
                    result = "error!";
                    return;
                }
                text.setText(result);
                break;
             /*
             等号
              */
            case R.id.b_equals:
                str += ((Button) v).getText();
                getResult();
                break;
            /*
            平方
             */
            case R.id.b_square:
                if (str.length() != 0) {
                    double t = Double.parseDouble(str);
                    result = Double.toString(t * t);
                } else {
                    result = "error!";
                    return;
                }
                text.setText(result);
                break;
             /*
            立方
             */
            case R.id.b_cube:
                if (str.length() != 0) {
                    double t = Double.parseDouble(str);
                    result = Double.toString(t * t * t);
                } else {
                    result = "error!";
                    return;
                }
                text.setText(result);
                break;
             /*
             开方
              */
            case R.id.b_sqrt:
                if (str.length() != 0) {
                    double t = Double.parseDouble(str);
                    result = Double.toString(Math.sqrt(t));
                } else result = "0";
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    text.setText(str);
                }
                text.setText(result);
                break;
            case R.id.b_sin:
            case R.id.b_cos:
            case R.id.b_tan:
            case R.id.b_ln:
            case R.id.b_lg:
            case R.id.b_left:
            case R.id.b_right:
            case R.id.b_switch:
            case R.id.b_factory:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    text.setText(str);
                }
                str += ((Button) v).getText();
                text.setText(str);
                break;
                /*
                换算
                 */
            case R.id.b_cm:
                if (str.length() != 0) {
                    double t = Double.parseDouble(str);
                    result = Double.toString(t / 100);
                } else result = "0";
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    text.setText(str);
                }
                text.setText(result);
                break;
            case R.id.b_cm3:
                if (str.length() != 0) {
                    double t = Double.parseDouble(str);
                    result = Double.toString(t / 1000000);
                } else result = "0";
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    text.setText(str);
                }
                text.setText(result);
                break;
             /*
             倒数
              */
            case R.id.b_dao:
                if (str.length() != 0) {
                    double t = 1 / Double.parseDouble(str);
                    t = (double) Math.round(t * 100) / 100;  //保留两位小数
                    result = Double.toString(t);
                } else {
                    result = "error!";
                }
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    text.setText("");
                }
                text.setText(result);
                break;
        }

    }

    private void getResult() {
        /*
        若存在符号则进行运算，没有则直接返回；
         */
        if (str == null || str.equals(""))
            return;
        if ('-' == str.charAt(0)) {// 开头为负数，如-1，改为0-1
            str = 0 + str;
        }
        clear_flag = true;
        // 校验格式
        if (!MyUtils.checkFormat(str)) {
            text.setText("表达式错误！");
        }
        // 处理表达式，改为标准表达式
        str = MyUtils.change2StandardFormat(str);
        // 拆分字符和数字
        String[] nums = str.split("[^.0-9]");
        ArrayList numList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (!"".equals(nums[i])) {
                numList.add(Double.parseDouble(nums[i]));
            }
        }
        String symStr = str.replaceAll("[.0-9]", "");

        doCalculate(symStr, numList);
    }

    private void doCalculate(String symStr, ArrayList numList) {
        LinkedList<Character> symStack = new LinkedList<>();// 符号栈
        LinkedList<Double> numStack = new LinkedList<>();// 数字栈
        double result = 0;
        int i = 0;// numList的标志位
        int j = 0;// symStr的标志位
        char sym;// 符号
        double num1, num2;// 符号前后两个数
        while (symStack.isEmpty() || !(symStack.getLast() == '='&& symStr.charAt(j) == '=')){
            if (symStack.isEmpty()) {
                symStack.add('=');
                numStack.add((Double) numList.get(i++));
            }
            if (MyUtils.symLvMap.get(symStr.charAt(j)) > MyUtils.symLvMap.get(symStack.getLast())) {// 比较符号优先级，若当前符号优先级大于前一个则压栈
                if (symStr.charAt(j) == '(') {
                    symStack.add(symStr.charAt(j++));
                    continue;
                }
                numStack.add((Double) numList.get(i++));
                symStack.add(symStr.charAt(j++));
            }else {// 当前符号优先级小于等于前一个符号的优先级
                if (symStr.charAt(j) == ')' && symStack.getLast() == '(') {// 若（）之间没有符号，则“（”出栈
                    j++;
                    symStack.removeLast();
                    continue;
                }
                if (symStack.getLast() == '(') {// “（”直接压栈
                    numStack.add((Double) numList.get(i++));
                    symStack.add(symStr.charAt(j++));
                    continue;
                }
                num2 = numStack.removeLast();
                num1 = numStack.removeLast();
                sym = symStack.removeLast();
                switch (sym) {
                    case '+':
                        numStack.add(num1+num2);
                        break;
                    case '-':
                        numStack.add(num1-num2);
                        break;
                    case '×':
                        numStack.add(num1*num2);
                        break;
                    case '÷':
                        if (num2 == 0) {// 除数为0
                            text.setText("错误");
                            return ;
                        }
                        numStack.add(num1/num2);
                        break;
                }
            }
        }
        String string =  numStack.removeLast() + "";
        text.setText(string);
    }
}


class MyUtils {

    public static final Map<Character, Integer> symLvMap = new HashMap<Character, Integer>();// 符号优先级map

    static {
        symLvMap.put('=', 0);
        symLvMap.put('-', 1);
        symLvMap.put('+', 1);
        symLvMap.put('×', 2);
        symLvMap.put('÷', 2);
        symLvMap.put('(', 3);
        symLvMap.put(')', 1);

    }
    /*
检查表达式格式是否正确
 */
    public static boolean checkFormat(String str){
        // 校验开头是否为数字或者“(”
        if (!(isCharNum(str.charAt(0)) || str.charAt(0) == '(')) {
            return false;
        }
        for(int i=1;i<str.length()-1;i++) {
            char c;
            c=str.charAt(i);
            if (!(isCharNum(c))) {
                if (c == '-' || c == '+' || c == '×' || c == '÷') {
                    if (c == '-' && str.charAt(i - 1) == '(') {// 1*(-2+3)的情况
                        continue;
                    }
                    if (!(isCharNum(str.charAt(i - 1)) || str.charAt(i - 1) == ')')) {// 若符号前一个不是数字或者“）”时
                        return false;
                    }
                }
                if (c == '.') {
                    if (!isCharNum(str.charAt(i - 1)) || !isCharNum(str.charAt(i + 1))) {// 校验“.”的前后是否为数字
                        return false;
                    }
                }
            }
        }
        return isBracketCouple(str);// 校验括号是否配对
    }
/*
处理表达式格式为标准格式，如2(-1+2)(3+4)改为2*(0-1+2)*(3+4)
 */
    public static String change2StandardFormat(String str) {
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (i != 0 && c == '(' && (isCharNum(str.charAt(i - 1)) || str.charAt(i - 1) == ')')) {
                sb.append("×(");
                continue;
            }
            if (c == '-' && str.charAt(i - 1) == '(') {
                sb.append("0-");
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

/*
判断括号是否配对
 */
    private static boolean isBracketCouple(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.removeLast();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    /*
    判断是否为数字
     */
    public static boolean isCharNum(Character c) {
    if (c >= '0' && c <= '9') {
        return true;
    }
    return false;
    }
}

