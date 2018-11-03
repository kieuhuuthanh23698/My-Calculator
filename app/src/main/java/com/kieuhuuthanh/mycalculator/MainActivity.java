package com.kieuhuuthanh.mycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.KeyEvent;
import android.view.Gravity;
import android.view.View;
//import android.view.inputmethod.BaseInputConnection;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

//import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{

    private TextView input;

    private TextView ketqua;

    private Button b0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;

    private Button bcong;
    private Button btru;
    private Button bnhan;
    private Button bchia;
    private Button bDel;
    private Button bAC;
    private Button bphay;
    private Button bbang;

    public final static ArrayList<String> historycalculator=new ArrayList<>();
    String hc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KhoiTaoWidget();
        SuKienClick();
    }
    public void KhoiTaoWidget(){
        input=(TextView) findViewById(R.id.textViewINPUT);
        input.setTextSize(50);

        ketqua=(TextView)findViewById(R.id.textViewRESULT);
        ketqua.setTextSize(50);

        b0=(Button)findViewById(R.id.button0);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button7);
        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9);

        bcong=(Button)findViewById(R.id.buttoncong);
        btru=(Button)findViewById(R.id.buttontru);
        bnhan=(Button)findViewById(R.id.buttonnhan);
        bchia=(Button)findViewById(R.id.buttonchia);

        bphay=(Button)findViewById(R.id.buttonphay);
        bbang=(Button)findViewById(R.id.buttonbang);
        bDel=(Button)findViewById(R.id.buttondel);
        bAC=(Button)findViewById(R.id.buttonAC);
    }


    public void SuKienClick(){
        input.setOnClickListener(this);
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

        bphay.setOnClickListener(this);
        bbang.setOnClickListener(this);
        bAC.setOnClickListener(this);
        bDel.setOnClickListener(this);

        bchia.setOnClickListener(this);
        bnhan.setOnClickListener(this);
        bcong.setOnClickListener(this);
        btru.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(input.getText().toString().length() == 10)
            input.setTextSize(25);
        if(input.getText().toString().length() == 21)
            input.setTextSize((float) 18);
        switch (view.getId())
        {
            case R.id.textViewINPUT:
                Intent act2 = new Intent(this,Main2Activity.class);
                act2.putStringArrayListExtra("history",historycalculator);
                startActivity(act2);
                break;
            case R.id.textViewRESULT:
                Intent act3 = new Intent(this,Main2Activity.class);
                act3.putStringArrayListExtra("history",historycalculator);
                startActivity(act3);
            break;
            case R.id.button0:
                input.append("0");
                break;
            case R.id.button1:
                input.append("1");
                break;
            case R.id.button2:
                input.append("2");
                break;
            case R.id.button3:
                input.append("3");
                break;
            case R.id.button4:
                input.append("4");
                break;
            case R.id.button5:
                input.append("5");
                break;
            case R.id.button6:
                input.append("6");
                break;
            case R.id.button7:
                input.append("7");
                break;
            case R.id.button8:
                input.append("8");
                break;
            case R.id.button9:
                input.append("9");
                break;

            case R.id.buttoncong:
                input.append("+");
                break;
            case R.id.buttontru:
                input.append("-");
                break;
            case R.id.buttonnhan:
                input.append("*");
                break;
            case R.id.buttonchia:
                input.append(":");
                break;

            case R.id.buttonphay:
                input.append(".");
                break;
            case R.id.buttonbang:
               // int numbeA=Integer.parseInt(String.valueOf(input.getText()));
                if(input.getText().toString().equals("0000") == true)
                {
                    input.setText("My fisrt application !\nKiều Hữu Thành\n07DHTH2 ");
                    input.setTextSize(15);
                    input.setGravity(0);
                    break;
                }
                ThemKiTuTinhToanTuChuoiVaoMang(input.getText().toString());
                ThemSoTuChuoiVaoMang(input.getText().toString());
                //Tinh Toan Bieu Thuc
                DecimalFormat df=new DecimalFormat("###.####");
                if(kitutinhtoan.size() == 0 && so.size() == 1 || so.size() == 0 || (kitutinhtoan.size()>=so.size()))
                    break;
                else {
                    double result = 0;
                    for (int i = 0; i < (so.size() - 1); i++)
                        switch (kitutinhtoan.get(i)) {
                            case "+":
                                if (i == 0)
                                    result = so.get(i) + so.get(i + 1);
                                else
                                    result = result + so.get(i + 1);
                                break;
                            case "-":
                                if (i == 0)
                                    result = so.get(i) - so.get(i + 1);
                                else
                                    result = result - so.get(i + 1);
                                break;
                            case "*":
                                if (i == 0)
                                    result = so.get(i) * so.get(i + 1);
                                else
                                    result = result * so.get(i + 1);
                                break;
                            case ":":
                                if (i == 0)
                                    result = so.get(i) / so.get(i + 1);
                                else
                                    result = result / so.get(i + 1);
                                break;
                            default:
                                break;
                        }
                    ketqua.setText(df.format(result) + "");
                    if(Double.toString(result).length() == 10)
                        ketqua.setTextSize(25);
                    if(Double.toString(result).length() == 21)
                        ketqua.setTextSize((float) 18);
                    hc = input.getText().toString() + " = " + ketqua.getText().toString();
                    historycalculator.add(hc);
                }
                break;
            case R.id.buttondel:
                if(input.getText().length()!=0)
                     input.setText(Del(input.getText().toString()));
                break;
            case R.id.buttonAC:
                input.setText("");
                input.setTextSize(50);
                input.setGravity(Gravity.END);
                ketqua.setText("");
                break;
            default:
                break;
        }
    }
    public String Del(String number) {
        int n=number.length();
        String kq=number.substring(0,n-1);
        return kq;
    }
    public ArrayList<String> kitutinhtoan;
    public ArrayList<Double> so;
    public void ThemKiTuTinhToanTuChuoiVaoMang(String input) {
        kitutinhtoan =new ArrayList<>();
        char[] cArray=input.toCharArray();
        for(int i=0;i<cArray.length;i++)
            switch (cArray[i]) {
                case '+':
                    kitutinhtoan.add(cArray[i] + "");
                    break;
                case '-':
                    kitutinhtoan.add(cArray[i] + "");
                    break;
                case '*':
                    kitutinhtoan.add(cArray[i] + "");
                    break;
                case ':':
                    kitutinhtoan.add(cArray[i] + "");
                    break;
                default:
                    break;

            }
    }
    public void ThemSoTuChuoiVaoMang(String input) {
        so =new ArrayList<>();
        Pattern regex=Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher=regex.matcher(input);
        while (matcher.find())
        {
            so.add(Double.valueOf(matcher.group(1)));
        }
    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.textViewINPUT:
                Intent act2 = new Intent(this, Main2Activity.class);
                act2.putStringArrayListExtra("history", historycalculator);
                startActivity(act2);
                break;
            case R.id.textViewRESULT:
                Intent act3 = new Intent(this, Main2Activity.class);
                act3.putStringArrayListExtra("history", historycalculator);
                startActivity(act3);
                break;
            case R.id.button0:
                input.append("0");
                break;
            case R.id.button1:
                input.append("1");
                break;
            case R.id.button2:
                input.append("2");
                break;
            case R.id.button3:
                input.append("3");
                break;
            case R.id.button4:
                input.append("4");
                break;
            case R.id.button5:
                input.append("5");
                break;
            case R.id.button6:
                input.append("6");
                break;
            case R.id.button7:
                input.append("7");
                break;
            case R.id.button8:
                input.append("8");
                break;
            case R.id.button9:
                input.append("9");
                break;

            case R.id.buttoncong:
                input.append("+");
                break;
            case R.id.buttontru:
                input.append("-");
                break;
            case R.id.buttonnhan:
                input.append("*");
                break;
            case R.id.buttonchia:
                input.append(":");
                break;

            case R.id.buttonphay:
                input.append(".");
                break;
        }
        return  true;
    }
}
