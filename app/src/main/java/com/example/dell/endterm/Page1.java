package com.example.dell.endterm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class Page1 extends AppCompatActivity {

    EditText email, password;

    CardView crd1, crd2;
    AwesomeValidation awesomeValidation =new AwesomeValidation(ValidationStyle.BASIC);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        crd1 = (CardView) findViewById(R.id.login);
        crd2 = (CardView) findViewById(R.id.createaccount);


        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        awesomeValidation.addValidation(Page1.this, R.id.email, android.util.Patterns.EMAIL_ADDRESS, R.string.Email);
        awesomeValidation.addValidation(Page1.this, R.id.password, regexPassword, R.string.Password);
        crd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  intent.putExtra("name", nm);
                intent.putExtra("Mobno", num);
                intent.putExtra("email", eml);
                intent.putExtra("Blood", bg);
                          */
           if(awesomeValidation.validate())
           {
               Toast.makeText(getApplicationContext(),"Data Recived Succesfully",Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(Page1.this, MainActivity.class);
               startActivity(intent);

           }
           else
           {
               Toast.makeText(getApplicationContext(),"Data Not Recived Succesfully",Toast.LENGTH_SHORT).show();
           }

              //  finish();

            }
        });

        crd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page1.this, Page2.class);
                startActivity(intent);
            }
        });


      /*  register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Page1.this, MainActivity.class);
                intent.putExtra("name", nm);
                intent.putExtra("Mobno", num);
                intent.putExtra("email", eml);
                intent.putExtra("Blood", bg);
                startActivity(intent);
                finish();
            }
        });*/
    }
}


   /*
    For drop down options

    Spinner spinner;
        spinner = (Spinner)findViewById(R.id.bloodgrp);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bloodgroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);*/
   /*
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_LONG);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}*/
