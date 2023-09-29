package com.example.a13_09_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class bscit extends AppCompatActivity {
TextView name,enroll,dob,gender,course,hobby;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bscit);
        name = findViewById(R.id.tvName);
        enroll = findViewById(R.id.tvEnroll);
        dob = findViewById(R.id.tvDOB);
        gender = findViewById(R.id.tvGender);
        hobby = findViewById(R.id.tvHobby);
        course = findViewById(R.id.tvCourse);

        Intent i = getIntent();

        name.setText("Student name is : "+i.getStringExtra("NAME"));
        enroll.setText("Enrollment no is : "+i.getStringExtra("ENROLL"));
        dob.setText("Date of Birth is : "+i.getStringExtra("DOB"));;
        gender.setText(" Gender : "+i.getStringExtra("GENDER"));
        hobby.setText("Hobby : "+i.getStringExtra("HOBBY"));
        course.setText("Course : "+i.getStringExtra("COURSE"));




    }
}