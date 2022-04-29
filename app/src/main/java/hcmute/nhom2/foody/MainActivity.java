package hcmute.nhom2.foody;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import hcmute.nhom2.foody.FragmentCustom.AccountFragment;
import hcmute.nhom2.foody.FragmentCustom.CartFragment;
import hcmute.nhom2.foody.FragmentCustom.HomeFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();


        bottomNavigationView.setOnItemSelectedListener(navListener);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,
                    new HomeFragment()).commit();
        }
    }

    protected void AnhXa(){
        bottomNavigationView = findViewById(R.id.bottomNavigate);
    }


    private NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.action_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.action_cart:
                    selectedFragment = new CartFragment();
                    break;
                case R.id.action_account:
                    selectedFragment = new AccountFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_main,
                    selectedFragment).commit();

            return true;        }
    };


}