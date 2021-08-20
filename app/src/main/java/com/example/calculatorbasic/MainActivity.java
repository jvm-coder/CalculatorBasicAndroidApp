package com.example.calculatorbasic;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private TextView disp;
    double val1=0.0, val2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disp = (TextView) findViewById(R.id.Display);
    }

    public void one(View view) {
        disp.setText(disp.getText()+Integer.toString(1));
    }
    public void two(View view) {
        disp.setText(disp.getText()+Integer.toString(2));
    }
    public void three(View view) {
        disp.setText(disp.getText()+Integer.toString(3));
    }
    public void four(View view) {
        disp.setText(disp.getText()+Integer.toString(4));
    }
    public void five(View view) {
        disp.setText(disp.getText()+Integer.toString(5));
    }
    public void six(View view) {
        disp.setText(disp.getText()+Integer.toString(6));
    }
    public void seven(View view) {
        disp.setText(disp.getText()+Integer.toString(7));
    }
    public void eight(View view) {
        disp.setText(disp.getText()+Integer.toString(8));
    }
    public void nine(View view) {
        disp.setText(disp.getText()+Integer.toString(9));
    }
    public void zero(View view) {
        disp.setText(disp.getText()+Integer.toString(0));
    }
    public void clear(View view) {
        disp.setText("");
    }
    public void zero2(View view) {
        disp.setText(disp.getText()+"00");
    }
    public void equal(View view)
    {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> op  = new Stack<Integer>();
        Stack<Double> val = new Stack<Double>();
        Stack<Integer> optmp  = new Stack<Integer>();
        Stack<Double> valtmp = new Stack<Double>();
        String input = (String)disp.getText();
        input = "0" + input;

        input = input.replaceAll("-","+-");
        String temp = "";
        for (int i = 0;i < input.length();i++)
        {
            char ch = input.charAt(i);
            if (ch == '-')
                temp = "-" + temp;
            else if (ch != '+' &&  ch != '*' && ch != '/')
                temp = temp + ch;
            else
            {
                val.push(Double.parseDouble(temp));
                op.push((int)ch);
                temp = "";
            }
        }
        val.push(Double.parseDouble(temp));
        char operators[] = {'/','*','+'};
        for (int i = 0; i < 3; i++)
        {
            boolean it = false;
            while (!op.isEmpty())
            {
                int optr = op.pop();
                double v1 = val.pop();
                double v2 = val.pop();
                if (optr == operators[i])
                {
                    if (i == 0)
                    {
                        valtmp.push(v2 / v1);
                        it = true;
                        break;
                    }
                    else if (i == 1)
                    {
                        valtmp.push(v2 * v1);
                        it = true;
                        break;
                    }
                    else if (i == 2)
                    {
                        valtmp.push(v2 + v1);
                        it = true;
                        break;

                    }
                }
                else
                {
                    valtmp.push(v1);
                    val.push(v2);
                    optmp.push(optr);
                }
            }
            while (!valtmp.isEmpty())
                val.push(valtmp.pop());
            while (!optmp.isEmpty())
                op.push(optmp.pop());
            if (it)
                i--;
        }
        disp.setText(Double.toString(val.pop()));
    }

    public void add(View view) {
        disp.setText(disp.getText()+"+");
    }

    public void sub(View view) {
        disp.setText(disp.getText()+"-");
    }

    public void pro(View view) {
        disp.setText(disp.getText()+"*");
    }

    public void div(View view) {
        disp.setText(disp.getText()+"/");
    }

    public void point(View view) {
        disp.setText(disp.getText()+".");
    }

    public void clrOne(View view) {
        disp.setText(((String)disp.getText()).substring(0,disp.getText().length()-1));
    }
}