package com.example.colombopizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button btnSignUp;

    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        repassword = (EditText)findViewById(R.id.repassword);

        btnSignUp = (Button)findViewById(R.id.btnSignUp);

        myDB = new DBHelper(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals("")) {

                    Toast.makeText(RegisterActivity.this, "Fill all the Fields", Toast.LENGTH_SHORT).show();
                }

                else {

                    if(pass.equals(repass)) {

                        Boolean userCheckResult = myDB.checkusername(user);

                        if(userCheckResult == false) {

                            Boolean regResult = myDB.insertData(user,pass);
                            if (regResult == true) {

                                Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            } else {

                                Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {

                            Toast.makeText(RegisterActivity.this, "User Already Exists", Toast.LENGTH_SHORT).show();

                        }
                    }

                    else {

                        Toast.makeText(RegisterActivity.this, "Password Not Match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}