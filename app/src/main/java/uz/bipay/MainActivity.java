package uz.bipay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.Navigation;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;



public class MainActivity extends AppCompatActivity {
    private final int ID_HOME = 1;
    private final int ID_HISTORY = 2;
    private final int ID_CARDS = 3;
    private final int ID_NOTIFICATIONS = 4;

    private DrawerLayout drawer;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @SuppressLint({"WrongViewCast", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.home_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HISTORY,R.drawable.history_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_CARDS,R.drawable.cards_icon));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_NOTIFICATIONS,R.drawable.notifications_icon));

        bottomNavigation.setOnClickMenuListener(model -> {
            return null;
        });

        bottomNavigation.setOnShowListener(model -> {
            String name;

            switch (model.getId()){
                case ID_HOME: name = "Home";
                    break;

                case ID_HISTORY: name = "History";
                    break;

                case ID_CARDS: name = "Cards";
                    break;

                case ID_NOTIFICATIONS: name = "Notifications";
                    break;

                default: name = "";
            }
            return null;
        });

        bottomNavigation.setCount(ID_NOTIFICATIONS,"4");
        bottomNavigation.show(ID_HOME,true);

        @SuppressLint("ResourceType") ImageView home_icon = findViewById(R.drawable.home_icon);
        @SuppressLint("ResourceType") ImageView history_icon = findViewById(R.drawable.history_icon);
        @SuppressLint("ResourceType") ImageView card_icon = findViewById(R.drawable.cards_icon);
        @SuppressLint("ResourceType") ImageView notification_icon = findViewById(R.drawable.notifications_icon);




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else   {
            super.onBackPressed();
        }
    }
}