package com.example.librarymanage.Activity;// MainActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.librarymanage.DTO.UserDTO;
import com.example.librarymanage.R;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_UPDATE_PROFILE = 1;
    private UserDTO user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        // Giả sử bạn đã khởi tạo user từ database hoặc nguồn khác
        user = new UserDTO(1, "username", "password", "fullname", "phone", "address", "role", new Date(), user.getEmail());

        Button btnOpenUpdateProfile = findViewById(R.id.btnUpdate);
        btnOpenUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.librarymanage.UpdateProfileActivity);
                intent.putExtra("user", user); // truyền đối tượng user
                startActivityForResult(intent, REQUEST_CODE_UPDATE_PROFILE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_UPDATE_PROFILE && resultCode == RESULT_OK) {
            UserDTO updatedUser = (UserDTO) data.getSerializableExtra("updatedUser");
            // Cập nhật UI hoặc cơ sở dữ liệu với thông tin người dùng được cập nhật
            if (updatedUser != null) {
                user = updatedUser;
                // Ví dụ: cập nhật TextView hoặc các phần tử giao diện người dùng khác
            }
        }
    }
}
