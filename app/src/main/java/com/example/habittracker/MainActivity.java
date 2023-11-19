package com.example.habittracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail , etPass;
    private Button btnLogin;

    private TextView tvForgetPass, tvSingup;

    private ProgressDialog mDialog;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginIn();
        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);
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

                mDialog.setMessage("Processing...");
                mDialog.show();
                mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()){
                          mDialog.dismiss();
                          startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                          Toast.makeText(getApplicationContext(), "Login Successful..", Toast.LENGTH_SHORT).show();
                      } else {
                          mDialog.dismiss();
                          Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                      }
                    }
                });
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