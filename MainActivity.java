package edu.tamu.ece.mp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static String input = "";
    static String input2 = "";
    static boolean OneTrue = true;
    static boolean TwoTrue = false;
    static boolean add = false;
    static boolean subtract = false;
    static boolean multiply = false;
    static double result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = findViewById(R.id.button);
        setContentView(R.layout.activity_main);

    }

    public void onButtonClick(View view) {
        TextView text = findViewById(R.id.textID);
        EditText edit = findViewById(R.id.editText);
        text.setText(edit.getText());
        edit.setText("");
    }

    public void onButtonMath(View view) {
        Button buttonCalc = null;
        if(view.getId() ==  R.id.button0){
           buttonCalc = findViewById(R.id.button0);

        } else if(view.getId() == R.id.button1){
            buttonCalc = findViewById(R.id.button1);

        } else if(view.getId() == R.id.button2){
            buttonCalc = findViewById(R.id.button2);

        } else if(view.getId() == R.id.button3){
            buttonCalc = findViewById(R.id.button3);

        } else if(view.getId() == R.id.button4){
            buttonCalc = findViewById(R.id.button4);

        } else if(view.getId() == R.id.button5){
            buttonCalc = findViewById(R.id.button5);

        } else if(view.getId() == R.id.button6){
            buttonCalc = findViewById(R.id.button6);

        } else if(view.getId() == R.id.button7){
            buttonCalc = findViewById(R.id.button7);

        } else if(view.getId() == R.id.button8){
            buttonCalc = findViewById(R.id.button8);

        } else if(view.getId() == R.id.button9){
            buttonCalc = findViewById(R.id.button9);

        } else if(view.getId() == R.id.buttonDecimal){
            buttonCalc = findViewById(R.id.buttonDecimal);

        }

        if(OneTrue){
            input+= buttonCalc.getText();
        } else if (TwoTrue){
          input2+= buttonCalc.getText();
        }

    }

    public void onButtonAdd(View view) {
        Button buttonCalc_plus = findViewById(R.id.button_plus);
        add = true;
        if(OneTrue){
            OneTrue = false;
            TwoTrue = true;
        } else if (TwoTrue){
            TwoTrue = false;
            OneTrue = true;
        }

    }

    public void onButtonMinus(View view) {
        Button buttonCalc_plus = findViewById(R.id.button_minus);
        subtract = true;
        if(OneTrue){
            OneTrue = false;
            TwoTrue = true;
        } else if (TwoTrue){
            TwoTrue = false;
            OneTrue = true;
        }
    }

    public void onButtonMult(View view) {
        Button buttonCalc_mult = findViewById(R.id.button_mult);
        multiply = true;
        if(OneTrue){
            OneTrue = false;
            TwoTrue = true;
        } else if (TwoTrue){
            TwoTrue = false;
            OneTrue = true;
        }
    }

    public void onButtonBack(View view) {
        result = 0;
        TextView answer = (TextView) (findViewById(R.id.textID));
        answer.setText(Double.toString(result));
        OneTrue = true;
        TwoTrue = false;
    }

    public void onButtonEqual(View view) {
        TextView answer = (TextView) (findViewById(R.id.textID));
        if(input2.length() > 0 && input.length() == 0){
            CharSequence temp = answer.getText();
            if (add) {
                result = Double.valueOf(input2) + Double.valueOf((String)temp);
                add = false;
            } else if (subtract) {
                result = Double.valueOf((String)temp) - Double.valueOf(input2);
                subtract = false;
            } else if (multiply) {
                result = Double.valueOf(input2) * Double.valueOf((String)temp);
                multiply = false;
            }
            answer.setText(Double.toString(result));
        } else {
            if (add) {
                result = Double.valueOf(input2) + Double.valueOf(input);
                add = false;
            } else if (subtract) {
                result = Double.valueOf(input) - Double.valueOf(input2);
                subtract = false;
            } else if (multiply) {
                result = Double.valueOf(input) * Double.valueOf(input2);
                multiply = false;
            }
            answer.setText(Double.toString(result));
        }
        input = "";
        input2 = "";
        OneTrue = true;
        TwoTrue = false;
        result = 0;
    }
}
