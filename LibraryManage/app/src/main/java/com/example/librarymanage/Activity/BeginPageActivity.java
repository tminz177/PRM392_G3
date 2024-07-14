package com.example.librarymanage.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.librarymanage.R;

public class BeginPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begin_page);
        Button login_btn = findViewById(R.id.btn_login);

        login_btn.setOnClickListener(this::onLoginBtnClick);
    }

    private void onLoginBtnClick(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }
}