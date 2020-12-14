package com.example.inuapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.inuapp.MainActivity;
import com.example.inuapp.R;
import com.example.inuapp.admin.AdminActivity;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void goToUser(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void goToAdmin(View view) {
        startActivity(new Intent(this, AdminActivity.class));
    }
}