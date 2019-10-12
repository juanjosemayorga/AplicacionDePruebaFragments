package com.prueba.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.prueba.app.Fragments.FirstFragment;
import com.prueba.app.Fragments.SecondFragment;
import com.prueba.app.Fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bnv_main_activity);

        final FirstFragment firstFragment = new FirstFragment();
        final SecondFragment secondFragment = new SecondFragment();
        final ThirdFragment thirdFragment = new ThirdFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if(id == R.id.item_one){

                    setFragment(firstFragment);
                    return true;

                }else if(id == R.id.item_two){

                    setFragment(secondFragment);
                    return true;

                }else if(id == R.id.item_three){

                    setFragment(thirdFragment);
                    return true;

                }

                return false;

            }
        });

        bottomNavigationView.setSelectedItemId(R.id.item_one);

    }

    public void setFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_main_activity, fragment);
        fragmentTransaction.commit();

    }

}
