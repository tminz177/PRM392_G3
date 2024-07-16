package com.example.librarymanage.Activity.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.librarymanage.DAO.UserDAO;
import com.example.librarymanage.DTO.RoomDB;
import com.example.librarymanage.Entity.User;
import com.example.librarymanage.R;
import com.example.librarymanage.Util.EmailForgotSender;
import com.otpview.OTPListener;
import com.otpview.OTPTextView;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class AfterForgotActivity extends AppCompatActivity {

    private Button btn_submit;
    private TextView title, send_again;
    private OTPTextView input_otp;
    private String email, otp_received;
    private User user;
    private ImageView backArrow;
    private UserDAO userDAO;
    private RoomDB roomDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_after);
        bindingView();
        bindingAction();
    }

    private void bindingView() {
        btn_submit = findViewById(R.id.btn_submit_forgot_otp);
        input_otp = findViewById(R.id.otp_forgot_view);
        title = findViewById(R.id.txt_forgot_title);
        send_again = findViewById(R.id.txt_forgot_send_again);
        backArrow = findViewById(R.id.after_forgot_back_arrow);

        roomDB = RoomDB.getInstance(this);
        userDAO = roomDB.userDAO();
        email = getIntent().getStringExtra("email");
        if (email == null) {
            email = "error-email";
        }

        user = userDAO.getUserByEmail(email);



    }

    private void bindingAction() {
        backArrow.setOnClickListener(v->finish());
        title.setText(String.format("OTP has been sent to %s.", email));
        input_otp.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {
            }

            @Override
            public void onOTPComplete(@NonNull String otp) {
                otp_received = otp;
            }
        });
        send_again.setOnClickListener(this::handleSendAgain);
        btn_submit.setOnClickListener(this::handleSubmit);
    }

    private void handleSubmit(View view) {
        Log.d("otp1" ,user.getOtp());
        Log.d("otp2" ,otp_received);
        if(user != null  && user.getOtp().equals(otp_received)) {
            Toast.makeText(this, "Success .Enter new password", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AfterForgotActivity.this, ResetPasswordActivity.class);
            intent.putExtra("email", email);
            AfterForgotActivity.this.startActivity(intent);
        } else {
            Toast.makeText(this, "Error .OTP incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleSendAgain(View view) {
        String otp = String.format(Locale.US, "%04d", new Random().nextInt(10000));
        user.setOtp(otp);
        userDAO.update(user);
        Toast.makeText(this, "Please wait....", Toast.LENGTH_SHORT).show();
        send_again.setClickable(false);
        send_again.setEnabled(false);
        btn_submit.setClickable(false);
        btn_submit.setEnabled(false);
        new Thread(() -> {
            try {
                EmailForgotSender emailSender = new EmailForgotSender();
                emailSender.sendEmailForgotPassword(AfterForgotActivity.this, email, otp);
            } catch (IOException e) {
                runOnUiThread(() -> Toast.makeText(this, "Error sending email", Toast.LENGTH_SHORT).show());
                e.printStackTrace();
            }
        }).start();
    }
}
