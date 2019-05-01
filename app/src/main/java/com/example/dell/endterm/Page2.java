package com.example.dell.endterm;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.common.collect.Range;

import java.util.Calendar;

public class Page2 extends AppCompatActivity {

    private static final String TAG = "Date";
    EditText Name, email, password, confrimpass, Mobno;
    TextView dateofbirth;
    CardView register;
    DatePickerDialog.OnDateSetListener dateSetListener;

    AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        Name = (EditText) findViewById(R.id.name);
        dateofbirth = (TextView) findViewById(R.id.textView2);
        email = (EditText) findViewById(R.id.email);
        Mobno = (EditText) findViewById(R.id.phoneno);
        password = (EditText) findViewById(R.id.pass);
        confrimpass = (EditText) findViewById(R.id.cpass);
        register = (CardView) findViewById(R.id.register);

       dateofbirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int date = cal.get(Calendar.DATE);

                DatePickerDialog dialog = new DatePickerDialog(Page2.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener, year, month, date);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                month = month + 1;
                Log.d(TAG, "OnDateSet :dd/mm/yy" + date + "/" + month + "/" + year);
                String DOB = date + "/" + month + "/" + year;
                dateofbirth.setText(DOB);
            }
        };

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        awesomeValidation.addValidation(Page2.this, R.id.name, "[a-zA-Z\\s]+", R.string.Name);
        //  awesomeValidation.addValidation(Page2.this, R.id.dob, Range.closed(2002, Calendar.getInstance().get(Calendar.YEAR)), R.string.DateOfBirth);
        awesomeValidation.addValidation(Page2.this, R.id.email, android.util.Patterns.EMAIL_ADDRESS, R.string.Email);
        awesomeValidation.addValidation(Page2.this, R.id.phoneno, RegexTemplate.TELEPHONE, R.string.Number);
        awesomeValidation.addValidation(Page2.this, R.id.pass, regexPassword, R.string.EPassword);
        awesomeValidation.addValidation(Page2.this, R.id.cpass, R.id.pass, R.string.ConfirmPass);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate())
                {
                    Intent intent = new Intent(Page2.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Details are Valid",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Detail are missing",Toast.LENGTH_SHORT).show();
                }

                //     finish();
            }
        });

    }

}
