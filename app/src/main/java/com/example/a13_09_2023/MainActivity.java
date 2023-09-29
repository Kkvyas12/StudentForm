package com.example.a13_09_2023;

import static android.R.layout.simple_list_item_1;

import androidx.appcompat.app.AppCompatActivity;

import android.R.layout;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText name,enroll;
RadioGroup gender;
RadioButton male,female,radioButton;
CheckBox sleeping,eating,roaming;
Spinner spinner;
String[] course = {"BSC IT","BSC CS","BSC DS"};
Button submit,btndate;
TextView tvDate;
private int mYear,mMonth,mDay;

String course_name;
String hobby ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edName);
        enroll = findViewById(R.id.edEnrollment);
        gender = findViewById(R.id.radioGroup);
        male = findViewById(R.id.rbMale);
        female = findViewById(R.id.rbFemale);
        sleeping = findViewById(R.id.cbSleeping);
        eating = findViewById(R.id.cbEating);
        roaming = findViewById(R.id.cbRoaming);
        submit = findViewById(R.id.btnSubmit);
        spinner = findViewById(R.id.course_spinner);
        btndate = findViewById(R.id.btnDate);
        tvDate = findViewById(R.id.tvDate);

        btndate.setOnClickListener(this);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                radioButton = findViewById(i);
            }
        });

        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,course);
        spinner.setAdapter(ad);
        Intent intent_it = new Intent(getApplicationContext(), bscit.class);
        Intent intent_cs = new Intent(getApplicationContext(), bsccs.class);
        Intent intent_ds = new Intent(getApplicationContext(), bscds.class);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                course_name = ad.getItem(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hobby = "";
                if (sleeping.isChecked()){
                    hobby = sleeping.getText().toString() + ",";
                }
                if (eating.isChecked()){
                    hobby += eating.getText().toString() + ",";
                }
                if (roaming.isChecked()){
                    hobby += roaming.getText().toString();
                }
                if (course_name.equals(ad.getItem(0).toString())) {
                    intent_it.putExtra("NAME", name.getText().toString());
                    intent_it.putExtra("ENROLL",enroll.getText().toString());
                    intent_it.putExtra("DOB",tvDate.getText().toString());
                    intent_it.putExtra("GENDER",radioButton.getText().toString());
                    intent_it.putExtra("HOBBY",hobby.toString());
                    intent_it.putExtra("COURSE",course_name.toString());
                    startActivity(intent_it);
                }
                else if (course_name.equals(ad.getItem(1).toString())) {
                    intent_cs.putExtra("NAME", name.getText().toString());
                    intent_cs.putExtra("ENROLL",enroll.getText().toString());
                    intent_cs.putExtra("DOB",tvDate.getText().toString());
                    intent_cs.putExtra("GENDER",radioButton.getText().toString());
                    intent_cs.putExtra("HOBBY",hobby.toString());
                    intent_cs.putExtra("COURSE",course_name.toString());
                    startActivity(intent_cs);
                }
                else if (course_name.equals(ad.getItem(2).toString())) {
                    intent_ds.putExtra("NAME", name.getText().toString());
                    intent_ds.putExtra("ENROLL",enroll.getText().toString());
                    intent_ds.putExtra("DOB",tvDate.getText().toString());
                    intent_ds.putExtra("GENDER",radioButton.getText().toString());
                    intent_ds.putExtra("HOBBY",hobby.toString());
                    intent_ds.putExtra("COURSE",course_name.toString());
                    startActivity(intent_ds);
                }
            }
        });
    }
    @Override
    public void onClick(View view) {
        if(view == btndate){
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    tvDate.setText(i2+"-"+(i1+1)+"-"+i);
                }
            },mYear,mMonth,mDay);
            datePickerDialog.show();
        }
    }
}
