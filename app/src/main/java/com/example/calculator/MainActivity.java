package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    //member variables
    private EditText resultEditText;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    private Button clearBtn, decimalBtn, addBtn, subBtn, multiBtn, divBtn, equalsBtn;

    // enum to decide which operation is the current
    private CurrentOperation currentOperationEnum;
    // boolean to decide weather to let user enter another decimal or not.
    private boolean decimalPresent = false;
    // the two values or operands.
    private double value1, value2;

    // boolean to check weather user pressed equals or clear
    // before entering multiple operators in expression
    private boolean clearRequired = false;


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
        multiBtn = findViewById(R.id.btn_multiplication);
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
                //check if decimal already present in the value..
                if (!decimalPresent) {
                    resultEditText.setText(resultEditText.getText() + ".");
                    decimalPresent = true;
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickClear();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if clear is required (if the user is trying to enter multiple operators
                // in the expression)
                if (clearRequired) {
                    showSnackBar(v);
                    return;
                }
                onClickAddition();
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if clear is required (if the user is trying to enter multiple operators
                // in the expression)
                if (clearRequired) {
                    showSnackBar(v);
                    return;
                }
                onClickSubtract();
            }
        });

        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if clear is required (if the user is trying to enter multiple operators
                // in the expression)
                if (clearRequired) {
                    showSnackBar(v);
                    return;
                }
                onClickMultiply();
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if clear is required (if the user is trying to enter multiple operators
                // in the expression)
                if (clearRequired) {
                    showSnackBar(v);
                    return;
                }
                onClickDivide();
            }
        });
        equalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickEquals(v);
            }
        });
    }


    private void onClickClear() {
        //clear th variables when clear button is pressed.
        resultEditText.setText("");
        decimalPresent = false;
        clearRequired = false;
        value1 = 0;
        value2 = 0;
    }

    private void onClickEquals(View v) {
        String expression = resultEditText.getText().toString();
        // call function to get the second value from the expression.
        if (currentOperationEnum == null) {
            resultEditText.setText(resultEditText.getText());
            return;
        }
        value2 = getSecondValue(expression);
        if (value2 == 0) {
            if (currentOperationEnum == CurrentOperation.DIVISION) {
                resultEditText.setText(resultEditText.getText());
                Snackbar.make(v, "Cannot divide by 0", Snackbar.LENGTH_LONG).show();
                return;
            } else {
                resultEditText.setText(resultEditText.getText());
                return;
            }
        }
        double result = evaluateExpression(value1, value2, currentOperationEnum);
        resultEditText.setText(String.format("%s", result));
        // decimal cannot be further added as result is double ..
        decimalPresent = true;
        // no clear required as the result is shown.
        clearRequired = false;
        value1 = 0;
        value2 = 0;
    }

    private void onClickDivide() {
        String in = resultEditText.getText().toString();
        if (TextUtils.isEmpty(in)) {
            return;
        }
        value1 = Double.parseDouble(in);
        currentOperationEnum = CurrentOperation.DIVISION;
        //change  boolean to false as a new value will be entered. decimal is allowed now

        decimalPresent = false;
        resultEditText.setText(resultEditText.getText() + getResources().getString(R.string.btn_divide));
        // change boolean that a clear/equals is required now before entering more operators
        clearRequired = true;
    }

    private void onClickMultiply() {
        String in = resultEditText.getText().toString();
        if (TextUtils.isEmpty(in)) {
            return;
        }
        value1 = Double.parseDouble(in);
        currentOperationEnum = CurrentOperation.MULTIPLICATION;
        //change  boolean to false as a new value will be entered. decimal is allowed now

        decimalPresent = false;
        resultEditText.setText(resultEditText.getText() + getResources().getString(R.string.btn_multiply));
        // change boolean that a clear/equals is required now before entering more operators

        clearRequired = true;
    }

    private void onClickSubtract() {
        String in = resultEditText.getText().toString();
        if (TextUtils.isEmpty(in)) {
            return;
        }
        value1 = Double.parseDouble(in);
        currentOperationEnum = CurrentOperation.SUBTRACTION;
        //change  boolean to false as a new value will be entered. decimal is allowed now

        decimalPresent = false;
        resultEditText.setText(resultEditText.getText() + getResources().getString(R.string.btn_minus));
        // change boolean that a clear/equals is required now before entering more operators

        clearRequired = true;
    }

    private void onClickAddition() {
        String in = resultEditText.getText().toString();
        if (TextUtils.isEmpty(in)) {
            return;
        }
        value1 = Double.parseDouble(in);
        currentOperationEnum = CurrentOperation.ADDITION;
        //change  boolean to false as a new value will be entered. decimal is allowed now
        decimalPresent = false;

        resultEditText.setText(resultEditText.getText() + getResources().getString(R.string.btn_plus));
        // change boolean that a clear/equals is required now before entering more operators
        clearRequired = true;
    }

    private double evaluateExpression(double input1, double input2, CurrentOperation operation) {
        double result = 0f;
        // calculate the result based on the inputs and the current operation.
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
        // round the result to 4 decimal places...
        result = (double)Math.round(result * 10000d) / 10000d;
        return result;
    }

    private double getSecondValue(String expression) {
        String operation = "";
        // splitting the expression in the basis of the current operator
        // and returning the second value from the expression.
        if (currentOperationEnum == null) {
            return 0f;
        }
        switch (currentOperationEnum) {
            case DIVISION:
                operation = "÷";
                break;
            case SUBTRACTION:
                operation = "-";
                break;
            case ADDITION:
                operation = "\\+";
                break;
            case MULTIPLICATION:
                operation = "×";
                break;
            default:
                operation = "";

        }
        String[] values = expression.split(operation);
        if (values.length >= 2) {
            double secondVal = Double.parseDouble(values[1]);
            return secondVal;
        }
        return 0;
    }

    private void showSnackBar(View v) {
        Snackbar.make(v, R.string.clear_message, Snackbar.LENGTH_LONG)
                .setAction(R.string.clearLabel, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClickClear();
                    }
                })
                .setActionTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.white))
                .show();
    }
}