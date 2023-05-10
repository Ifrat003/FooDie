package com.example.foodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.foodie.chefFoodPanel.ChefHomeFragment;
import com.example.foodie.chefFoodPanel.ChefOrderFragment;
import com.example.foodie.chefFoodPanel.ChefPendingOrderFragment;
import com.example.foodie.chefFoodPanel.ChefPostdishesFragment;


public class ChefFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_food_panel__bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.chef_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.chefhome :
                fragment = new ChefHomeFragment();
                break;
            case R.id.pendingOrders :
                fragment=new ChefPendingOrderFragment();
                break;
            case R.id.orders :
                fragment=new ChefOrderFragment();
                break;
            case R.id.postDish :
                fragment=new ChefPostdishesFragment();
                break;
        }
        return loadcheffragment(fragment);
    }

    private boolean loadcheffragment(Fragment fragment) {

        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
            return true;
        }
        return false;
    }
}