package com.example.habittracker;

public class Habit {
    private String habitName;
    private int habitAmount;

    public Habit(String habitName, int habitAmount) {
        this.habitName = habitName;
        this.habitAmount = habitAmount;
    }

    public String getHabitName() {
        return habitName;
    }

    public int getHabitAmount() {
        return habitAmount;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public void setHabitAmount(int habitAmount) {
        this.habitAmount = habitAmount;
    }
}
