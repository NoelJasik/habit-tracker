package com.example.habittracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateHabitActivity extends AppCompatActivity {

    EditText etHabitName,etHabitAmount;
    Button btnCreateHabit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_habit);

        etHabitName = findViewById(R.id.habitName);
        etHabitAmount = findViewById(R.id.habitAmount);
        btnCreateHabit = findViewById(R.id.submit);

        btnCreateHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String habitName = etHabitName.getText().toString();
                int habitAmount = Integer.parseInt(etHabitAmount.getText().toString());

                Habit habit = new Habit(habitName,habitAmount);

                Toast.makeText(CreateHabitActivity.this,habit.getHabitName()+" "+habit.getHabitAmount(),Toast.LENGTH_SHORT).show();
//                finish();
            }
        });

    }
}