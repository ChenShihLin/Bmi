package com.cswilly9015;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cswilly9015.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        float bmi = getIntent().getFloatExtra("BMI", 0);
        binding.result2.setText(getString(R.string.your_bmi_is) + bmi);
    }
}