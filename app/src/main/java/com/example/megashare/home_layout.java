package com.example.megashare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class home_layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton individualbtnimg = findViewById(R.id.individualbtnimg);
        individualbtnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent individualbtnimg = new Intent(home_layout.this, home_layout.class);
                startActivity(individualbtnimg);
            }
        });

        ImageButton groupbtnimg = findViewById(R.id.groupbtnimg);
        groupbtnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent groupbtnimg = new Intent(home_layout.this, group_share.class);
                startActivity(groupbtnimg);
            }
        });

        ImageButton accountbtnimg = findViewById(R.id.accountbtnimg);
        accountbtnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accountbtnimg = new Intent(home_layout.this, account.class);
                startActivity(accountbtnimg);
            }
        });

        ImageButton filesbtnimg = findViewById(R.id.filesbtnimg);
        filesbtnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent filesbtnimg = new Intent(home_layout.this, files.class);
                startActivity(filesbtnimg);
            }
        });

    }
}