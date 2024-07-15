package com.example.librarymanage.Activity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.librarymanage.DAO.UserDAO;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.User;
import com.example.librarymanage.R;


public class SignUpActivity extends AppCompatActivity {
    private EditText fullname,email, password,re_password;
    private Button sign_up_btn;
    private TextView sign_in_field;
    private ImageView back_arrow;

    private UserDAO userDAO;
    private RoomDB roomDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        bindingView();
        bindingAction();
    }

    private void bindingView() {
        fullname = findViewById(R.id.input_create_account_fullname);
        email = findViewById(R.id.input_create_account_email);
        password = findViewById(R.id.input_create_account_password);
        re_password = findViewById(R.id.input_create_account_re_password);
        sign_up_btn = findViewById(R.id.btn_create_account_sign_up);
        sign_in_field = findViewById(R.id.btn_create_account_sign_in);
        back_arrow = findViewById(R.id.sign_up_back_arrow);

        roomDB = RoomDB.getInstance(this);
        userDAO = roomDB.userDAO();
    }

    private void bindingAction() {
        sign_up_btn.setOnClickListener(this::handleSignUp);
        sign_in_field.setOnClickListener(view -> finish());
        back_arrow.setOnClickListener(view -> finish());
    }

    private void handleSignUp(View view) {
        String fullnameInput = fullname.getText().toString().trim();
        String emailInput = email.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();
        String rePasswordInput = re_password.getText().toString().trim();

        if (fullnameInput.isEmpty() || emailInput.isEmpty() || passwordInput.isEmpty() || rePasswordInput.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!passwordInput.equals(rePasswordInput)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        new Thread(() -> {
            User existingUser = userDAO.getUserByEmail(emailInput);
            if (existingUser != null) {
                runOnUiThread(() -> Toast.makeText(this, "Email already exists", Toast.LENGTH_SHORT).show());
            } else {
                User newUser = new User();
                newUser.setFullname(fullnameInput);
                newUser.setEmail(emailInput);
                newUser.setPassword(passwordInput);
                userDAO.insert(newUser);
                runOnUiThread(() -> {
                    Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
                    finish();
                });
            }
        }).start();
    }
}
