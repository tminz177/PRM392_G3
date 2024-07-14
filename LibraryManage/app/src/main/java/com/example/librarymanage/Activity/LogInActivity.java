package com.example.librarymanage.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.librarymanage.DAO.UserDAO;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.User;
import com.example.librarymanage.R;

public class LogInActivity extends AppCompatActivity {

    private EditText email, password;
    private Button login_btn;
    private TextView sign_up_field,tv_forgot;
    private ImageView back_arrow;

    private UserDAO userDAO;
    private RoomDB roomDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        bindingView();
        bindingAction();
    }

    private void bindingView() {
        email = findViewById(R.id.input_login_email);
        password = findViewById(R.id.input_login_password);
        login_btn = findViewById(R.id.btn_login_login);
        sign_up_field = findViewById(R.id.login_sign_up_btn);
        back_arrow = findViewById(R.id.login_back_arrow);
        tv_forgot = findViewById(R.id.tv_login_forgot);

        roomDB = RoomDB.getInstance(this);
        userDAO = roomDB.userDAO();
    }

    private void bindingAction() {
        login_btn.setOnClickListener(this::handleLogin);
        sign_up_field.setOnClickListener(this::handleStartSignUp);
        back_arrow.setOnClickListener(this::handleBack);
        tv_forgot.setOnClickListener(this::handleForgot);
    }

    private void handleForgot(View view) {
        Intent intent = new Intent(this, PreForgotActivity.class);
        startActivity(intent);
    }

    private void handleLogin(View view) {
        String emailInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();
        Log.d("Logined User" , emailInput);
        new Thread(() -> {
            User user = userDAO.getUserByEmail(emailInput);
            if (user != null && user.getPassword().equals(passwordInput)) {
                runOnUiThread(() -> Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show());
                //redirect by
            } else {
                runOnUiThread(() -> Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }

    private void handleStartSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private void handleBack(View view) {
        Intent intent = new Intent(this, BeginPageActivity.class);
        startActivity(intent);
    }
}
