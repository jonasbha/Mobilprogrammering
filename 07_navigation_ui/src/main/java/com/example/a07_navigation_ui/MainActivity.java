package com.example.a07_navigation_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        assert navHostFragment != null;
        NavController controller = navHostFragment.getNavController();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        NavigationUI.setupWithNavController(bottomNav, controller);

        NavigationView navView = findViewById(R.id.navigation_view);
        NavigationUI.setupWithNavController(navView, controller);

        Toolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        // This will make sure that we don't get a back/up-arrow on the top level destinations
        AppBarConfiguration configuration = new AppBarConfiguration.Builder(R.id.homeFragment, R.id.searchFragment, R.id.collectionFragment)
                // This makes the app bar be able to open the navigation drawer
                .setOpenableLayout(drawerLayout).build();
        NavigationUI.setupWithNavController(toolbar, controller, configuration);


        // The following activates the navigation drawer.

        // Connect with navigation controller for automatic navigation (menu ids must match destination ids)
        // and UI updates
        NavigationUI.setupWithNavController(navView, controller);
        // Simple explicit navigation
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                NavigationUI.onNavDestinationSelected(menuItem, controller);
                //controller.navigate(menuItem.getItemId());
                //menuItem.setChecked(true);
                //drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}