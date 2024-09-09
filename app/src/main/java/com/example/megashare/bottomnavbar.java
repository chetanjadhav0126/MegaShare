package com.example.megashare;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bottomnavbar extends AppCompatActivity {

    private BottomNavigationView bottomnavbar;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bottomnavbar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bottomnavbar = findViewById(R.id.bottomnavbar);
        frameLayout = findViewById(R.id.framelayout);



        bottomnavbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.individual){
                    loadFragment(new individual(), false);

                } else if (itemId == R.id.group) {
                    loadFragment(new group(), false);

                } else if (itemId == R.id.files) {
                    loadFragment(new files(), false);

                } else if(itemId == R.id.account) {
                    loadFragment(new account(), false);

                }


                return true;
            }
        });
        loadFragment(new individual(), true);
    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized){
        if (isAppInitialized){
            getSupportFragmentManager().beginTransaction().add(R.id.framelayout, fragment).commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, fragment).commit();
        }
    }
}