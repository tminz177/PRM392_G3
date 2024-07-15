package com.example.librarymanage.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.librarymanage.DTO.UserDTO;
import com.example.librarymanage.R;

public class UpdateProfileActivity<Intent> extends AppCompatActivity {

    private EditText etEmail, etPassword, etPhone, etAddress;
    private Button btnUpdate;
    private UserDTO user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);
        btnUpdate = findViewById(R.id.btnUpdate);

        // Assume user data is passed via Intent
        user = (UserDTO) getIntent().getSerializableExtra("user");

        if (user != null) {
            etEmail.setText(user.getUsername());
            etPhone.setText(user.getPhone());
            etAddress.setText(user.getAddress());
            // Note: Do not set the password field with the actual password
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserProfile();
            }
        });
    }

    private void updateUserProfile() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String address = etAddress.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Here you would normally update the user in your database
        user.setUsername(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setAddress(address);

        // Notify user of success
        Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show();

        // Return updated user
        Intent resultIntent = new Intent();
        resultIntent.putExtra("updatedUser", user);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
