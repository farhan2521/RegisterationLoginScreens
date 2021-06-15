package com.example.zetamptask1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zetamptask1.database.DbAccessObject;

public class LoginActivity extends AppCompatActivity {
    DbAccessObject dao;
    EditText etEmail;
    EditText etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etLoginPassword);
        btnLogin = findViewById(R.id.btnLogin);
        dao = new DbAccessObject(this);
        dao.openDb();

    }


    public void loginHandler(View view) {
        if (!etEmail.getText().toString().equals("") && !etPassword.getText().toString().equals("")) {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            boolean isEmailPasswordExist = dao.checkEmailPasswordExist(email, password);
            if (isEmailPasswordExist) {
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(LoginActivity.this,"All fields are mandatory",Toast.LENGTH_LONG).show();
        }
    }
}