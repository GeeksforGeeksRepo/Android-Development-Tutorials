package com.sriram.voter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button pepsiBtn;
    Button cokeBtn;

    TextView pepsiText;
    TextView cokeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cokeText = findViewById(R.id.tv_coke_count);

        pepsiText = findViewById(R.id.tv_pepsi_count);


        cokeBtn = findViewById(R.id.btn_coke_vote);
        pepsiBtn = findViewById(R.id.btn_pepsi_vote);
    }

    public void onCokeClicked(View v){
        String cokeCount = cokeText.getText().toString().trim();
        int count = Integer.parseInt(cokeCount);
        count++;
        cokeText.setText(String.valueOf(count));
    }

    public void onPepsiClicked(View v){
        String pepsiCount = pepsiText.getText().toString().trim();
        int count = Integer.parseInt(pepsiCount);
        count++;
        pepsiText.setText(String.valueOf(count));
    }

}
