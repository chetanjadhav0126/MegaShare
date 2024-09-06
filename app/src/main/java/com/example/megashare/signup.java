package com.example.megashare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class signup extends AppCompatActivity {

    private FirebaseAuth userAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        GoogleSignInOptions gso;

        TextView login = findViewById(R.id.login);
        EditText signup_username = findViewById(R.id.signup_username);
        EditText signup_email = findViewById(R.id.signup_email);
        EditText signup_password = findViewById(R.id.signup_password);
        Button registerbtn = findViewById(R.id.registerbtn);
        Button googlesignin = findViewById(R.id.googlesignin);
        

        
        

//
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent login = new Intent(signup.this, login.class);
//                startActivity(login);
//            }
//        });

//
//        registerbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent registerbtn = new Intent(signup.this, home_layout.class);
//                startActivity(registerbtn);
//            }
//        });
//
//        googlesignin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent googlesignin = new Intent(signup.this, home_layout.class);
//                startActivity(googlesignin);
//            }
//        });
//
//
//        userAuth = FirebaseAuth.getInstance();
//
//        userAuth.createUserWithEmailAndPassword(Objects.requireNonNull(signup_username.getText().toString()), signup_email.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                Toast.makeText(signup.this, "Data Store", Toast.LENGTH_SHORT).show();
//                registerbtn.setClickable(true);
//                startActivity(new Intent(signup.this, login.class));
//                finish();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(signup.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

}