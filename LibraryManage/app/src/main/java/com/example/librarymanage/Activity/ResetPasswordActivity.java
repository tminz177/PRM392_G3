package com.example.librarymanage.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.librarymanage.DAO.UserDAO;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.User;
import com.example.librarymanage.R;

public class ResetPasswordActivity extends AppCompatActivity {

    private String email;
    private ImageView backArrow;
    private EditText password, re_password; 
    private Button btn_submit;
    private UserDAO userDAO;
    private RoomDB roomDB;
    private User user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);

        bindingView();
        bindingAction();
    }

    private void bindingView() {
        backArrow = findViewById(R.id.reset_password_back_arrow);
        password = findViewById(R.id.reset_password_password);
        re_password = findViewById(R.id.reset_password_re_password);
        btn_submit = findViewById(R.id.reset_password_btn_submit);
        email = getIntent().getStringExtra("email");
        roomDB = RoomDB.getInstance(this);
        userDAO = roomDB.userDAO();
        if (email == null) {
            email = "error-email";
        }

        user = userDAO.getUserByEmail(email);
    }
    private void bindingAction() {
        backArrow.setOnClickListener(v -> finish());
        btn_submit.setOnClickListener(this::handleSubmit);
    }

    private void handleSubmit(View view) {
        String passwordInput = password.getText().toString().trim();
        String rePasswordInput = re_password.getText().toString().trim();
        if (TextUtils.isEmpty(passwordInput) || TextUtils.isEmpty(rePasswordInput)) {
            Toast.makeText(this, "Password and re password is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!passwordInput.equals(rePasswordInput)) {
            Toast.makeText(this, "Password and re password must be the same", Toast.LENGTH_SHORT).show();
            return;
        }
        user.setPassword(passwordInput);
        userDAO.update(user);
        Toast.makeText(this, "Update successfully", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ResetPasswordActivity.this, LogInActivity.class);
        ResetPasswordActivity.this.startActivity(intent);
    }


}
