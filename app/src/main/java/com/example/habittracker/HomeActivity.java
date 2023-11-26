package com.example.habittracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity  {


    MaterialToolbar bottomAppBar;

    List<Habit> habitList = new ArrayList<>();




    private static final int REQUEST_CODE_CREATE_HABIT = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        toolbar.setTitle("Habit Tracker");


        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.naviagtion_drawer_open,R.string.navigation_drawer_close
        );

        bottomAppBar = findViewById(R.id.bottomNavigationBarToolbar);

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.task)
                {
                    Intent intent = new Intent(HomeActivity.this,CreateHabitActivity.class);
                    startActivityForResult(intent, REQUEST_CODE_CREATE_HABIT);
                }
                return false;
            }
        });


        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CREATE_HABIT && resultCode == RESULT_OK) {
            String habitName = data.getStringExtra("habitName");
            int habitAmount = data.getIntExtra("habitAmount", 0);
            Toast.makeText(this, "Habit Name: " + habitName + " Habit Amount: " + habitAmount, Toast.LENGTH_SHORT).show();
            Habit habit = new Habit(habitName, habitAmount);
            habitList.add(habit);
        }
    }

}