package com.cswilly9015;

import androidx.appcompat.app.AppCompatActivity;

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
        Toast.makeText(this, "Your BMI is :" + bmi, Toast.LENGTH_LONG).show();

//        result.setText("Your BMI is :" + bmi);
        binding.result.setText("Your BMI is : " + bmi);
    }
}