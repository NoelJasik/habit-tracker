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

public class RegistrationActivity extends AppCompatActivity {

    private EditText etEmail_reg, etPassword_reg;
    private Button btn_reg;

    private TextView sign_in;
    private ProgressDialog mDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth=FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);

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
                }

                mDialog.setMessage("Processing..");
                mDialog.show();
                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            mDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Rejestracja Complete ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        } else {
                            mDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Rejestracja Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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