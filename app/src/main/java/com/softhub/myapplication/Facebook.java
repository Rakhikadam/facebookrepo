package com.softhub.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.util.Calendar;
import java.util.regex.Pattern;

public class Facebook extends AppCompatActivity {
    int day, month1, year1;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    RadioButton radioButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        EditText editText1 = findViewById(R.id.text1);
        EditText editText2 = findViewById(R.id.text2);
        EditText editText3 = findViewById(R.id.text3);
        EditText editText4 = findViewById(R.id.text4);
        TextView textView = findViewById(R.id.date1);
        radioButton1 = findViewById(R.id.button1);
        RadioButton radioButton2 = findViewById(R.id.button2);
        RadioButton radioButton3 = findViewById(R.id.button3);
        Button Button4 = findViewById(R.id.button4);
        sharedPreferences = getSharedPreferences("MyApp",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Button4.setText("Sing Up");
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String first = editText1.getText().toString();
                if (Pattern.matches("[a-zA-Z]{2,20}", first)) {
                    editor.putString("first_name",first);
                    editor.commit();
                } else {
                    Toast.makeText(Facebook.this, "Please enter valid first name.", Toast.LENGTH_LONG).show();
                    return;
                }
                Log.e("Facebook", "first name =" + first);

                String lastname = editText2.getText().toString();
                if (Pattern.matches("[a-zA-Z]{2,20}", lastname)) {
                 editor.putString("lastname",lastname);
                 editor.commit();
                }
                else {
                    Toast.makeText(Facebook.this, "Please enter valid last name", Toast.LENGTH_SHORT).show();
                return;
                }
                Log.e("Facebook", "last name=" + lastname);

                String Email_or_number = editText3.getText().toString();
                if ((Pattern.matches("[a-zA-Z0-9]{2,15}@[gmailredf]{5,7}[.comin]{2,5}", Email_or_number))) {
                    editor.putString("email or number",Email_or_number);
                    editor.commit();

                } else {
                    Toast.makeText(Facebook.this, "Enter valid email", Toast.LENGTH_SHORT).show();
               return;
                }
                Log.e("Facebook", "Email or number=" + Email_or_number);

                String password = editText4.getText().toString();
                if ((Pattern.matches("[[a-z]+[A-Z]+[@#$%&*]+[0-9]+]{8,16}", password))) {
                    editor.putString("password",password);
                    editor.commit();
                } else {
                    Toast.makeText(Facebook.this, "Enter valid password", Toast.LENGTH_SHORT).show();
               return;
                }
                Log.e("Facebook", "password=" + password);

                String date = textView.getText().toString();
                Calendar currentdate = Calendar.getInstance();
                currentdate.set(Calendar.YEAR,year1);
                currentdate.set(Calendar.MONTH,month1);
                currentdate.set(Calendar.DAY_OF_MONTH,day);
                Calendar mindate =Calendar.getInstance();
                mindate.add(Calendar.YEAR,- 18);

                if (currentdate.before(mindate)) {
                    editor.putString("date",date);
                    editor.commit();
                    Log.e("TAG", "onClick: " );
                } else {
                    Toast.makeText(Facebook.this, "Enter valid birthdate", Toast.LENGTH_SHORT).show();
                }
                Log.e("Facebook", "Birth of date" + date);


                String submit = Button4.getText().toString();
                Log.e("Facebook", "submit =" + submit);
                editor.putString("submit",submit);
                editor.commit();

                String Gender = "";
                if (radioButton1.isChecked()) {
                    Gender= "male";
                    Log.e("Facebook", "onClick: Male is selected");
                }
                if (radioButton2.isChecked()) {
                    Gender="female";
                    Log.e("Facebook", "OnClick:Female is selected");
                }
                if (radioButton3.isChecked()) {
                    Gender="Custom";
                    Log.e("Facebook", "OnClick:Custom is selected");
                }
                if (Gender.isEmpty()){
                    Toast.makeText(Facebook.this, "Enter the Gender", Toast.LENGTH_SHORT).show();
                     }
                else{
                    editor.putString("Gender",Gender);
                    editor.commit();
                }
                Intent intent= new Intent(Facebook.this,Feacebook_Profile.class);
                startActivity(intent);

            }
        });

        textView.setText("select Birthdate");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Facebook.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textView.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                        day = dayOfMonth;
                        month1 = month;
                        year1 = year;
                    }
                }, 2022, 11, 4);
                datePickerDialog.show();
            }


        });


    }

    private void NewMethod(){
        radioButton1.setText("");
    }
}