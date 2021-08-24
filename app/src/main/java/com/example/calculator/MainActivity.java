package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText display,result;
    double input1,input2,res;
    boolean add,sub,mul,div,per;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=(EditText)findViewById(R.id.display);
        display.setShowSoftInputOnFocus(false);
        result=(EditText)findViewById(R.id.result);
        result.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }

    }
    public void zero(View v){
        updateText("0");
    }
    public void one(View v){
        updateText("1");
    }
    public void two(View v){
       updateText("2");
    }
    public void three(View v){
        updateText("3");
    }
    public  void four(View v){
        updateText("4");
    }
    public void five(View v){
        updateText("5");
    }
    public void six(View v){
        updateText("6");
    }
    public void seven(View v){
        updateText("7");
    }
    public void eight(View v){
        updateText("8");
    }
    public void nine(View v){
        updateText("9");
    }
    public void add(View v){
        input1 = Float.parseFloat(display.getText().toString());
        add=true;
        updateText("+");
        display.setText("");
    }
    public void sub(View v){
        input1 = Float.parseFloat(display.getText().toString());
        sub=true;
        updateText("-");
        display.setText("");
    }
    public void mul(View v){
        input1 = Float.parseFloat(display.getText().toString());
        mul=true;
        updateText("x");
        display.setText("");
    }
    public void div(View v){
        input1 = Float.parseFloat(display.getText().toString());
        div=true;
        updateText("/");
        display.setText("");
    }
    public void per(View v){
        input1 = Float.parseFloat(display.getText().toString());
        per=true;
        updateText("%");
        display.setText("");
    }
    public void point(View v){
        updateText(".");
    }
    public void clear(View v){
        display.setText("");
        result.setText("");
    }
    public void backspace(View v){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }
    public void equal(View v){
        if (add || sub || mul || div || per){
            input2 = Float.parseFloat(display.getText().toString());
        }
        if (add){
            res=input1+input2;
            result.setText(""+res);
            add=false;
        }
        if (sub){
            res=input1-input2;
            result.setText(""+res);
            sub=false;
        }
        if (mul){
            res=input1*input2;
            result.setText(""+res);
            mul=false;
        }
        if (div){
            if(input2 == 0) {
                result.setText("YOU DUMB? ITS ZERO ERROR");
                div=false;
            }
            else{
                res=input1/input2;
                result.setText(""+res);
                div=false;
            }

        }
        if (per){
            res=(input1/100)*input2;
            result.setText(""+res);
            per=false;
        }
    }
}