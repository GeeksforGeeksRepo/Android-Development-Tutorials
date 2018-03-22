package in.snotes.sharedprefstutorial;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt_input_key, edt_input_value, edt_output_key;
    private Button btn_save_data, btn_get_data;
    private TextView tv_output_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_input_key = findViewById(R.id.edt_input_key);
        edt_input_value = findViewById(R.id.edt_input_value);
        edt_output_key = findViewById(R.id.edt_output_key);

        btn_save_data = findViewById(R.id.btn_save_data);
        btn_get_data = findViewById(R.id.btn_get_data);

        tv_output_data = findViewById(R.id.tv_output_data);

        final SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);

        btn_save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = edt_input_key.getText().toString().trim();
                String value = edt_input_value.getText().toString().trim();

                prefs.edit()
                        .putString(key,value)
                        .apply();

                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();

            }
        });

        btn_get_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String key = edt_output_key.getText().toString().trim();
                String value = prefs.getString(key,"N/A");
                tv_output_data.setText(value);

            }
        });


    }
}
