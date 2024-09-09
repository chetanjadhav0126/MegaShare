package com.example.megashare;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class account extends Fragment {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    private ImageView profilepicture;
    private TextView nameTextView;
    private TextView emailTextView;
    private Button signOutButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        // Initialize Firebase and Firestore
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        // Initialize views
        profilepicture = view.findViewById(R.id.profilepicture);
        nameTextView = view.findViewById(R.id.nameTextView);
        emailTextView = view.findViewById(R.id.emailTextView);
        signOutButton = view.findViewById(R.id.signOutButton);

        // Load user info from Firebase
        loadUserInfo();

        // Set up sign out button listener
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        return view; // Ensure you return the inflated view
    }

    private void loadUserInfo() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String userName = user.getDisplayName();
            String userEmail = user.getEmail();
            String profilePictureUrl = user.getPhotoUrl() != null ? user.getPhotoUrl().toString() : null;

            nameTextView.setText(userName != null ? userName : "No Name");
            emailTextView.setText(userEmail != null ? userEmail : "No Email");

            if (profilePictureUrl != null) {
                Picasso.get().load(profilePictureUrl).placeholder(R.drawable.account_btn).into(profilepicture);
            } else {
                profilepicture.setImageResource(R.drawable.account_btn); // Fallback image
            }
        }
    }

    private void signOut() {
        mAuth.signOut();
        Intent intent = new Intent(getActivity(), login.class); // Change to your login activity
        startActivity(intent);
        getActivity().finish(); // Use getActivity().finish() instead of finish() in a Fragment
    }

}