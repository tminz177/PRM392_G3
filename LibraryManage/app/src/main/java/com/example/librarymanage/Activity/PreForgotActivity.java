package com.example.librarymanage.Activity;

import android.os.Bundle;
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
import com.example.librarymanage.Util.EmailForgotSender;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class PreForgotActivity extends AppCompatActivity {
    private EditText email;
    private Button sendOtp;
    private ImageView backArrow;

    private UserDAO userDAO;
    private RoomDB roomDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_pre);


        bindingView();
        bindingAction();
    }

    private void bindingView() {
        email = findViewById(R.id.input_forgot_email);
        sendOtp = findViewById(R.id.btn_forgot_send_otp);
        backArrow = findViewById(R.id.forgot_back_arrow);

        roomDB = RoomDB.getInstance(this);
        userDAO = roomDB.userDAO();
    }

    private void bindingAction() {
        sendOtp.setOnClickListener(this::handleSendOtp);
        backArrow.setOnClickListener(view -> finish());
    }

    private void handleSendOtp(View view) {
        String emailInput = email.getText().toString().trim();
        if (emailInput.isEmpty()) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        User user = userDAO.getUserByEmail(emailInput);
        if (user == null) {
            Toast.makeText(this, "Your email doesn't exist in system", Toast.LENGTH_SHORT).show();
            return;
        }
        String otp = String.format(Locale.US, "%04d", new Random().nextInt(10000));
        user.setOtp(otp);
        userDAO.update(user);
        sendOtp.setEnabled(false);
        Toast.makeText(this, "Email is sending,please wait...", Toast.LENGTH_SHORT).show();
        new Thread(() -> {
            try {
                EmailForgotSender emailSender = new EmailForgotSender();
                emailSender.sendEmailForgotPassword(PreForgotActivity.this, emailInput, otp);
            } catch (IOException e) {
                runOnUiThread(() -> Toast.makeText(this, "Error sending email", Toast.LENGTH_SHORT).show());
                e.printStackTrace();
            }
        }).start();
    }

}
