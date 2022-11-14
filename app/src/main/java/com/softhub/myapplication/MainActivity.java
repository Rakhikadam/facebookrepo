package com.softhub.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
String [] dates = new String[]{"1","2","3","4","5","6","7","8","9"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner=findViewById(R.id.spinner);
        TextView textView=findViewById(R.id.Test1);
        EditText editText=findViewById(R.id.Edit1);
        TextView textView2=findViewById(R.id.Test2);
        TextView dob=findViewById(R.id.dob);
        EditText editText2=findViewById(R.id.Edit2);
        RadioGroup radioGroup=findViewById(R.id.radio);
        RadioButton radioButton1=findViewById(R.id.button1);
        RadioButton radioButton2=findViewById(R.id.button2);
        Button button=findViewById(R.id.button3);
        ImageButton imageButton=findViewById(R.id.image);
        ToggleButton toggleButton=findViewById(R.id.toggle);
        ToggleButton toggleButton1=findViewById(R.id.toggle1);
        CheckBox checkBox=findViewById(R.id.checkbox);
        CheckBox checkBox1=findViewById(R.id.checkbox1);
//        DatePicker datePicker=findViewById(R.id.date);
        TextView date=findViewById(R.id.date);
        ArrayAdapter<String> adapter  = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,dates);
        spinner.setAdapter(adapter);

        dob.setText("select time");
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog= new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.e("tag",hourOfDay+"-"+minute);
                        dob.setText(hourOfDay+"-"+minute);
                    }
                },0,0,true);
                timePickerDialog.show();
            }
        });

        date.setText("select date");
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Log.e("tag","hhgvfv"+year+""+month+"-"+dayOfMonth);
                        date.setText(dayOfMonth+"-"+(month+1));

                    }
                },2022,10,4);
                datePickerDialog.show();

            }
        });



    }
}