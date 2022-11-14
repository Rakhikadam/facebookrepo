package com.softhub.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Feacebook_Profile extends AppCompatActivity {

    TextView text,text1,text2,text3,text4,text5;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ImageView image;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feacebook_profile);
        text=findViewById(R.id.text);
        text1=findViewById(R.id.text1);
        text2=findViewById(R.id.text2);
        text3=findViewById(R.id.text3);
        text4=findViewById(R.id.text4);
        text5=findViewById(R.id.text5);
        image = findViewById(R.id.profile);
        ImageView edit_profile = findViewById(R.id.edit_profile);

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Feacebook_Profile.this);
                dialog.setContentView(R.layout.popup);
                ImageView cammera = dialog.findViewById(R.id.cammera);
                ImageView gallary = dialog.findViewById(R.id.gallary);

                cammera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent("android.media.action.IMAGE_CAPTURE");
                        startActivityForResult(intent,1);
                        Toast.makeText(Feacebook_Profile.this, "open cammera", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                gallary.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        startActivityForResult(intent,2);
                        Toast.makeText(Feacebook_Profile.this, "open gallary", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


        sharedPreferences = getSharedPreferences("MyApp",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        text.setText(sharedPreferences.getString("first_name",null));
        text1.setText(sharedPreferences.getString("lastname",null));
        text2.setText(sharedPreferences.getString("email or number",null));
        text3.setText(sharedPreferences.getString("password",null));
        text4.setText(sharedPreferences.getString("select Birthdate",null));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            switch (requestCode){
                case 1:
                    Log.e("TAG","onActivityResut"+data.getExtras().get("data"));
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    image.setImageBitmap(bitmap);
                    break;
                case 2:
                    Log.e("TAG","onActivityResult"+data.getData());
                    image.setImageURI(data.getData());
                    break;

            }
        }
        else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}