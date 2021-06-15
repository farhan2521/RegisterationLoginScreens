package com.example.zetamptask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zetamptask1.database.DbAccessObject;

public class MainActivity extends AppCompatActivity {
    DbAccessObject dao;
    EditText etName;
    EditText etEmail;
    EditText etPassword;
    EditText etConfirmPassword;
    TextView tvLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etTextPersonName);
        etEmail = findViewById(R.id.etTextEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        tvLogin = findViewById(R.id.tvLoginPage);
        btnRegister = findViewById(R.id.btnRegister);
        dao = new DbAccessObject(this);
        dao.openDb();
    }

    public void entryHandler(View view) {
        switch (view.getId()){
            case R.id.btnRegister:
                if (!etName.getText().toString().equals("") && !etEmail.getText().toString().equals("")
                        && !etPassword.getText().toString().equals("") && !etConfirmPassword.getText().toString().equals("")) {
                    String name = etName.getText().toString();
                    String email = etEmail.getText().toString();
                    String password = etPassword.getText().toString();
                    String confirmPassword = etConfirmPassword.getText().toString();
                    //put the data into db
                    //dao.createRow(name, email, password);
                    if(password.equals(confirmPassword)) {
                        Boolean isEmailExist = dao.checkEmailExist(email);
                        if (isEmailExist) {
                            Toast.makeText(MainActivity.this, "Email Id already exists", Toast.LENGTH_LONG).show();
                        } else {
                            dao.createRow(name, email, password);
                            Toast.makeText(MainActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                            etName.setText("");
                            etEmail.setText("");
                            etPassword.setText("");
                            etConfirmPassword.setText("");
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Confirm password mismatch", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this,"All fields are mandatory",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.tvLoginPage:
                Intent i = new Intent (MainActivity.this, LoginActivity.class);
                startActivity(i);
                break;

        }
    }
}