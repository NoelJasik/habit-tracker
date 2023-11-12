package com.example.habittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

    private EditText etEmail_reg, etPassword_reg;
    private Button btn_reg;

    private TextView sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registration();
    }

    private void registration(){
        etEmail_reg = findViewById(R.id.etEmail_reg);
        etPassword_reg = findViewById(R.id.etPassword_reg);
        btn_reg = findViewById(R.id.btn_reg);
        sign_in = findViewById(R.id.sign_in);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail_reg.getText().toString().trim();
                String pass = etPassword_reg.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    etEmail_reg.setError("Musi byc Email");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    etPassword_reg.setError("Musi byc Haslo");
                    return;
                }
            }
        });

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


    }
}