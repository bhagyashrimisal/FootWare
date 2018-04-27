package com.example.rohini.footware;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registration extends AppCompatActivity {
    EditText editTextUserName;                       //Declaration EditTexts
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextUserAddress;
    EditText editTextUserMobile;
    TextInputLayout textInputLayoutUserName;       //Declaration TextInputLayout
    TextInputLayout textInputLayoutUserAddress;       //Declaration TextInputLayout
    TextInputLayout textInputLayoutUserMobile;       //Declaration TextInputLayout
    TextInputLayout textInputLayoutEmail;
    TextInputLayout textInputLayoutPassword;
    Button buttonRegister;                          //Declaration Button
    DatabaseConnection databaseConnection;        //Declaration SqliteHelper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        databaseConnection = new DatabaseConnection(this);
        initTextViewLogin();
        initViews();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    String UserName = editTextUserName.getText().toString();
                    String Email = editTextEmail.getText().toString();
                    String Password = editTextPassword.getText().toString();
                    String UserAddress = editTextUserAddress.getText().toString();
                    String UserMobile = editTextUserMobile.getText().toString();

                    //Check in the database is there any user associated with  this email
                    if (!databaseConnection.isEmailExists(Email)) {

                        //Email does not exist now add new user to database
                        databaseConnection.addUser(new User(null, UserName, UserAddress, UserMobile, Email, Password));
                        Snackbar.make(buttonRegister, "User created successfully! Please Login ", Snackbar.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        }, Snackbar.LENGTH_LONG);
                    }else {

                        //Email exists with email input provided so show error user already exist
                        Snackbar.make(buttonRegister, "User already exists with same email ", Snackbar.LENGTH_LONG).show();
                    }


                }
            }
        });
    }

    //this method used to set Login TextView click event
    private void initTextViewLogin() {
        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(Registration.this,MainActivity.class);
                startActivity(ii);
                finish();
            }
        });
    }

    //this method is used to connect XML views to its Objects
    private void initViews() {
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextUserAddress = (EditText) findViewById(R.id.editTextUserAddress);
        editTextUserMobile = (EditText) findViewById(R.id.editTextUserMobile);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        textInputLayoutUserName = (TextInputLayout) findViewById(R.id.textInputLayoutUserName);
        textInputLayoutUserAddress = (TextInputLayout) findViewById(R.id.textInputLayoutUserAddress);
        textInputLayoutUserMobile = (TextInputLayout) findViewById(R.id.textInputLayoutUserMobile);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

    }

    //This method is used to validate input given by user
    public boolean validate() {
        boolean valid = false;
        String UserName = editTextUserName.getText().toString();//Get values from EditText fields
        String UserAddress = editTextUserAddress.getText().toString();//Get values from EditText fields
        String UserMobile = editTextUserMobile.getText().toString();//Get values from EditText fields
        String Email = editTextEmail.getText().toString();
        String Password = editTextPassword.getText().toString();

        //Handling validation for UserName field
        if (UserName.isEmpty()) {
            valid = false;
            textInputLayoutUserName.setError("Please enter valid username!");
        } else {
            if (UserName.length() > 3) {
                valid = true;
                textInputLayoutUserName.setError(null);
            } else {
                valid = false;
                textInputLayoutUserName.setError("Username should be > 3!");
            }
        }

        if (UserAddress.isEmpty()) {
            valid = false;
            textInputLayoutUserAddress.setError("Please enter valid address!");
        } else {
            if (UserAddress.length() > 5) {
                valid = true;
                textInputLayoutUserAddress.setError(null);
            } else {
                valid = false;
                textInputLayoutUserAddress.setError("User Address is > 5!");
            }
        }

        if (UserMobile.isEmpty()) {
            valid = false;
            textInputLayoutUserMobile.setError("Please enter valid mobile!");
        } else {
            if (UserMobile.length() != 8) {
                valid = true;
                textInputLayoutUserMobile.setError(null);
            } else {
                valid = false;
                editTextUserMobile.setError("Mobile no have 8 nos");
            }
        }

        //Handling validation for Email field
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            valid = false;
            textInputLayoutEmail.setError("Please enter valid email!");
        } else {
            valid = true;
            textInputLayoutEmail.setError(null);
        }

        //Handling validation for Password field
        if (Password.isEmpty()) {
            valid = false;
            textInputLayoutPassword.setError("Please enter valid password!");
        } else {
            if (Password.length() > 5) {
                valid = true;
                textInputLayoutPassword.setError(null);
            } else {
                valid = false;
                textInputLayoutPassword.setError("Password should > 5!");
            }
        }


        return valid;
    }
}
