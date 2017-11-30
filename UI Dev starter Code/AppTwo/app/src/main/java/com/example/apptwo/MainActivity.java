package com.example.apptwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateAnswer();

            }
        });

    }

    private void calculateAnswer() {

        EditText numOne = findViewById(R.id.edt_num_one);
        EditText numTwo = findViewById(R.id.edt_num_two);

        RadioButton add = findViewById(R.id.add);
        RadioButton sub = findViewById(R.id.sub);
        RadioButton multiply = findViewById(R.id.multiply);
        RadioButton divide = findViewById(R.id.divide);

        TextView answer = findViewById(R.id.solution);

        float numone = Integer.parseInt(numOne.getText().toString());
        float numtwo = Integer.parseInt(numTwo.getText().toString());

        float solution = 0;

        if (add.isChecked()){
            solution = numone + numtwo;
        }else if (sub.isChecked()){
            solution = numone - numtwo;
        }else if (multiply.isChecked()){
            solution = numone * numtwo;
        }else{
            if (numtwo == 0){
                Toast.makeText(this, "Number Two Cannot be zero. Try again..", Toast.LENGTH_SHORT).show();
                return;
            }
            solution = numone / numtwo;
        }

        answer.setText("The answer is "+ solution);

    }
}
