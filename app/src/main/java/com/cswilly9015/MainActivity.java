package com.cswilly9015;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cswilly9015.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//    private EditText edWeight;
//    private EditText edHeight;
//    private TextView result;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);
//        findViews();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.help)
                        .setMessage(getString(R.string.bmi_info))
                        .setPositiveButton(R.string.ok, null)
                        .show();
            }
        });
    }

//    private void findViews() {
//        edWeight = findViewById(R.id.weight);
//        edHeight = findViewById(R.id.height);
//        result = findViewById(R.id.result);
//    }

    public void bmi(View view) {
//        String w = edWeight.getText().toString();
        String w = binding.weight.getText().toString();
//        String h = edHeight.getText().toString();
        String h = binding.height.getText().toString();

        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height * height);

        Log.d("MainActivity", "BMI : " + bmi);
        Toast.makeText(this, getString(R.string.your_bmi_is) + bmi, Toast.LENGTH_LONG).show();

//        result.setText("Your BMI is :" + bmi);
        binding.result.setText(getString(R.string.your_bmi_is) + bmi);

        /*new AlertDialog.Builder(this)
                .setTitle("BMI")
                .setMessage(getString(R.string.your_bmi_is) + bmi)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        binding.weight.setText("");
                        binding.height.setText("");
                        binding.result.setText("");
                    }
                })
                .show();*/

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("BMI", bmi);
        startActivity(intent);
    }
}