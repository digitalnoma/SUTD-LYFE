package com.example.hamburgermenu;

import static androidx.navigation.Navigation.findNavController;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.design_navigation_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment.getNavController();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menuHome:
                    {
                        navController.navigate(R.id.HomeFragment);
                        break;
                    }
                    case R.id.menuFood:
                    {
                        navController.navigate(R.id.FoodFragment);
                        break;
                    }
                    case R.id.menuMarketplace:
                    {
                        navController.navigate(R.id.MarketplaceFragment);
                        break;
                    }
                    case R.id.menuNews:
                    {
                        navController.navigate(R.id.menuNews);
                        break;
                    }
                    case R.id.menuWeather:
                    {
                        navController.navigate(R.id.menuWeather);
                        break;
                    }
                    case R.id.Privacy:
                    {
                        Toast.makeText(MainActivity.this, "Market Selected", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.Notifications:
                    {
                        Toast.makeText(MainActivity.this, "Settings Selected", Toast.LENGTH_SHORT).show();
                        break;
                    }

                }
                return false;
            }
        });


    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}