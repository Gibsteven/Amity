package com.stvdev.amity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.stvdev.amity.Adapters.AdapterViewPager;
import com.stvdev.amity.Frag.CommutyFragment;
import com.stvdev.amity.Frag.ExploreFragment;
import com.stvdev.amity.Frag.HomeFragment;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private ViewPager2 viewPager2;

    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_vue);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        viewPager2 = findViewById(R.id.fragment_container);
        // Réactiver le défilement horizontal du ViewPager2
        viewPager2.setUserInputEnabled(true);

        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new ExploreFragment());
        fragmentArrayList.add(new CommutyFragment());

        AdapterViewPager adapterViewPager = new AdapterViewPager(this, fragmentArrayList);
        viewPager2.setAdapter(adapterViewPager);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.nav_home);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.nav_explore);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.nav_commuty);
                        break;
                }
                super.onPageSelected(position);
            }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int ItemId = item.getItemId();
            if (ItemId == R.id.nav_home) {
                viewPager2.setCurrentItem(0);
                return true;
            }
            if (ItemId == R.id.nav_explore) {
                viewPager2.setCurrentItem(1);
                return true;
            }
            if (ItemId == R.id.nav_commuty) {
                viewPager2.setCurrentItem(2);
                return true;
            }
            return false;
        });

        // Enable immersive mode
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

}