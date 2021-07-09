package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    //member variables
    private EditText resultEditText;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private Button clearBtn, decimalBtn, addBtn, subBtn, multBtn, divBtn, equalsBtn;

    private CurrentOperation currentOperationEnum;
    private boolean decimalPresent = false;

    private float value1, value2;
    private  boolean clearRequired = false;


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
                if (!decimalPresent) {
                    resultEditText.setText(resultEditText.getText() + ".");
                    decimalPresent = true;
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultEditText.setText("");
                decimalPresent = false;
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearRequired){
                    Snackbar.make(v,"Use CLear or equals first",Snackbar.LENGTH_LONG).show();
                    return;
                }
                String in = resultEditText.getText().toString();
                value1 = Float.parseFloat(in);
                currentOperationEnum = CurrentOperation.ADDITION;
                decimalPresent = false;

                resultEditText.setText(resultEditText.getText() + "+");
                clearRequired = true;
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearRequired){
                    Snackbar.make(v,"Use CLear or equals first",Snackbar.LENGTH_LONG).show();
                    return;
                }
                String in = resultEditText.getText().toString();
                value1 = Float.parseFloat(in);
                currentOperationEnum = CurrentOperation.SUBTRACTION;
                decimalPresent = false;
                resultEditText.setText(resultEditText.getText() + "-");
                clearRequired = true;
            }
        });

        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearRequired){
                    Snackbar.make(v,"Use CLear or equals first",Snackbar.LENGTH_LONG).show();
                    return;
                }
                String in = resultEditText.getText().toString();
                value1 = Float.parseFloat(in);
                currentOperationEnum = CurrentOperation.MULTIPLICATION;
                decimalPresent = false;
                resultEditText.setText(resultEditText.getText() + "*");
                clearRequired = true;
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearRequired){
                    Snackbar.make(v,"Use CLear or equals first",Snackbar.LENGTH_LONG).show();
                    return;
                }
                String in = resultEditText.getText().toString();
                value1 = Float.parseFloat(in);
                currentOperationEnum = CurrentOperation.DIVISION;
                decimalPresent = false;
                resultEditText.setText(resultEditText.getText() + "/");
                clearRequired = true;
            }
        });
        equalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = resultEditText.getText().toString();
                value2 = getSecondValue(expression);
                float result = evaluateExpression(value1, value2, currentOperationEnum);
                resultEditText.setText(String.format("%s", result));
                clearRequired = false;
            }
        });
    }

    private float evaluateExpression(float input1, float input2, CurrentOperation operation) {
        float result = 0f;
        switch (operation) {
            case ADDITION:
                result = input1 + input2;
                break;
            case SUBTRACTION:
                result = input1 - input2;
                break;
            case MULTIPLICATION:
                result = input1 * input2;
                break;
            case DIVISION:
                result = input1 / input2;
                break;
        }
        return result;
    }

    private float getSecondValue(String expression) {
        String operation = "";

        switch (currentOperationEnum) {
            case DIVISION:
                operation = "/";
                break;
            case SUBTRACTION:
                operation = "-";
                break;
            case ADDITION:
                operation = "\\+";
                break;
            case MULTIPLICATION:
                operation = "\\*";
                break;
            default:
                operation = "";

        }
        String[] vals = expression.split(operation);
        if (vals.length >= 2) {
            float secondVal = Float.parseFloat(vals[1]);
            return secondVal;
        }
        return 0;
    }
}