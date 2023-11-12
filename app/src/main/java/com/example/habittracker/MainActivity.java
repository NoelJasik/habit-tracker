package com.example.habittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail , etPass;
    private Button btnLogin;

    private TextView tvForgetPass, tvSingup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginIn();
    }

    private void LoginIn(){
        etEmail = findViewById(R.id.etEmail_log);
        etPass = findViewById(R.id.etPassword_log);
        btnLogin = findViewById(R.id.btn_login);
        tvForgetPass = findViewById(R.id.forget_password);
        tvSingup = findViewById(R.id.sign_up);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String pass = etPass.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    etEmail.setError("Musi byc Email");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    etPass.setError("Musi byc Haslo");
                    return;
                }
            }
        });

        tvSingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });

        tvForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ResetActivity.class));
            }
        });
    }
}