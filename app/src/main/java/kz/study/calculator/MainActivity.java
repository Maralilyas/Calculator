package kz.study.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button7, button8, button9, button4, button5, button6, button1, button2, button3, button0;
    Button btnOshiru, btnPlusMinus, btnPlus, btnMinus, btnX, btnBolu, btnTen;
    TextView text, text2;
    String birinshiSan, ekisnshiSan, znak, zapisText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        sandarMethods();
        oshiruPlusMinusMethod();
        functionMethod();
    }

    public void initViews(){
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button0 = findViewById(R.id.btn0);
        btnOshiru = findViewById(R.id.btnC);
        btnPlusMinus = findViewById(R.id.btn10);
        btnPlus = findViewById(R.id.btn15);
        btnMinus = findViewById(R.id.btn14);
        btnX = findViewById(R.id.btnx);
        btnBolu = findViewById(R.id.btn12);
        btnTen = findViewById(R.id.btn16);
        text = findViewById(R.id.text);
        text2 = findViewById(R.id.text2);
    }
    public void sandarMethods(){
        View.OnClickListener buttonSan = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aldingiSan = text.getText().toString();
                String basilganSan = "";
                String result = "";
                switch (v.getId()) {
                    case R.id.btn7:
                        basilganSan = "7";
                        break;
                    case R.id.btn8:
                        basilganSan = "8";
                        break;
                    case R.id.btn9:
                        basilganSan = "9";
                        break;
                    case R.id.btn4:
                        basilganSan = "4";
                        break;
                    case R.id.btn5:
                        basilganSan = "5";
                        break;
                    case R.id.btn6:
                        basilganSan = "6";
                        break;
                    case R.id.btn1:
                        basilganSan = "1";
                        break;
                    case R.id.btn2:
                        basilganSan = "2";
                        break;
                    case R.id.btn3:
                        basilganSan = "3";
                        break;
                    case R.id.btn0:
                        basilganSan = "0";
                        break;
                }
                if (!aldingiSan.equals("0")) result = aldingiSan + basilganSan;
                else result = basilganSan;
                text.setText(result);
            }
        };
        button7.setOnClickListener(buttonSan);
        button8.setOnClickListener(buttonSan);
        button9.setOnClickListener(buttonSan);
        button4.setOnClickListener(buttonSan);
        button5.setOnClickListener(buttonSan);
        button6.setOnClickListener(buttonSan);
        button1.setOnClickListener(buttonSan);
        button2.setOnClickListener(buttonSan);
        button3.setOnClickListener(buttonSan);
        button0.setOnClickListener(buttonSan);
    }
    public void oshiruPlusMinusMethod(){

        View.OnClickListener buttonOwiruPlusMinus = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnC:

                        text.setText("0");
                        text2.setText("");
                        break;

                    case R.id.btn10:

                        String sanText = text.getText().toString();
                        int san = Integer.parseInt(sanText);

                        if(san > 0) text.setText("-"+sanText);
                        else{
                            san = san * (-1);
                            text.setText(""+san);
                        }
                        break;

                }
            }
        };

        btnOshiru.setOnClickListener(buttonOwiruPlusMinus);
        btnPlusMinus.setOnClickListener(buttonOwiruPlusMinus);
    }
    public void functionMethod(){
        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                birinshiSan = text.getText().toString();

                switch (v.getId()){

                    case R.id.btn15:
                        znak = "+";
                        break;

                    case R.id.btn14:
                        znak = "-";
                        break;
                    case R.id.btnx:
                        znak = "*";
                        break;

                    case R.id.btn12:
                        znak = "/";
                        break;
                }
                zapisText = birinshiSan + znak;
                text2.setText(zapisText);
                text.setText("0");
            }
        };

        btnPlus.setOnClickListener(btnFunctions);
        btnMinus.setOnClickListener(btnFunctions);
        btnX.setOnClickListener(btnFunctions);
        btnBolu.setOnClickListener(btnFunctions);

        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ekisnshiSan = text.getText().toString();
                int san1 = Integer.parseInt(birinshiSan);
                int san2 = Integer.parseInt(ekisnshiSan);
                int res = 0;

                if(znak.equals("+")){
                    res = san1 + san2;
                }else if(znak.equals("-")){
                    res = san1 - san2;
                }else if(znak.equals("*")){
                    res = san1 * san2;
                }else if(znak.equals("/")){
                    res = san1 / san2;
                }

                zapisText = birinshiSan + znak + ekisnshiSan + " = "+res;

                text2.setText(zapisText);
                text.setText(""+res);
            }
        });
    }
}