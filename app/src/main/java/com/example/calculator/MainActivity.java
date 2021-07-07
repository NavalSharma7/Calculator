package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    //member variables
    private EditText resultEditText;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private Button clearBtn, decimalBtn,addBtn,subBtn,multBtn,divBtn,equalsBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // calling the init method to initialize the views
        init();
        // set the listeners to the buttons and edit text
        setListeners();
    }

    private void init() {
        resultEditText = findViewById(R.id.et_result);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);
        clearBtn = findViewById(R.id.btn_clear);
        decimalBtn = findViewById(R.id.btn_decimal);
        addBtn = findViewById(R.id.btn_plus);
        subBtn = findViewById(R.id.btn_minus);
        multBtn = findViewById(R.id.btn_multiplication);
        divBtn = findViewById(R.id.btn_divide);
        equalsBtn = findViewById(R.id.btn_equals);
    }

    private void setListeners() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "0");
            }
        });

        decimalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + ".");
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText("");
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "+");
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "-");
            }
        });

        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "*");
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText(resultEditText.getText() + "/");
            }
        });

    }
}