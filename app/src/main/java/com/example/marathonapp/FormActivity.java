package com.example.marathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class FormActivity extends AppCompatActivity {

    //private TextView greetingText;
    private EditText firstNameInput;
    private EditText lastNameInput;
    private EditText emailInput;
    private EditText phoneInput;
    private Button submitButton;

    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        firstNameInput = findViewById(R.id.et_first_name);
        lastNameInput = findViewById(R.id.et_last_name);
        emailInput = findViewById(R.id.et_email);
        phoneInput = findViewById(R.id.et_phone);
        submitButton = findViewById(R.id.btn_submit);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.et_first_name,
                RegexTemplate.NOT_EMPTY,R.string.invalid_first_name);
        awesomeValidation.addValidation(this,R.id.et_last_name,
                RegexTemplate.NOT_EMPTY,R.string.invalid_last_name);
        awesomeValidation.addValidation(this,R.id.et_phone,
                "[0-9]{2}[0-9]{8}",R.string.invalid_phone);
        awesomeValidation.addValidation(this,R.id.et_email,
                Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext()
                            , "Form Validate Successfully...",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Validation Failed"
                            ,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}