package com.example.sharedpref_java_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText person_name,person_age;
    Button save,load;
    TextView person_result;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        person_name=findViewById(R.id.person_name);
        person_age=findViewById(R.id.person_age);
        person_result=findViewById(R.id.person_result);
        save=findViewById(R.id.button);
        load=findViewById(R.id.button2);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String name=  person_name.getText().toString();
              int age= Integer.parseInt(person_age.getText().toString());
              SharedPreferences.Editor editor=preferences.edit();
              editor.putString("person_name",name);
              editor.putInt("person_age",age);
              editor.apply();
              person_name.getText().clear();
              person_age.getText().clear();
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name= preferences.getString("person_name","");
               int age= preferences.getInt("person_age",0);

               person_result.setText(name+" "+age);
            }
        });



        preferences=getSharedPreferences("persons",MODE_PRIVATE);

    }
}