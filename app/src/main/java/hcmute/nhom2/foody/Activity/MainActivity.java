package hcmute.nhom2.foody.Activity;
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
import hcmute.nhom2.foody.Model.Database;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StaticArg.database=new Database(MainActivity.this,"QuanLyQuanAn.sqlite",null,1);

//        StaticArg.database.QueryData("DROP TABLE  User");
//        StaticArg.database.QueryData("DROP TABLE  Food");
//        StaticArg.database.QueryData("DROP TABLE  Cart");
//        StaticArg.database.QueryData("DROP TABLE  Orders");

        StaticArg.database.QueryData("CREATE TABLE IF NOT EXISTS QuanAn(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(150), Hinh BLOB)");
        StaticArg.database.QueryData("CREATE TABLE IF NOT EXISTS User(Id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR(150), pass VARCHAR(150),name VARCHAR(150))");
        StaticArg.database.QueryData("CREATE TABLE IF NOT EXISTS Food(Id INTEGER PRIMARY KEY AUTOINCREMENT,ResId INTEGER, Ten VARCHAR(150), Price INTEGER, Hinh BLOB)");
        StaticArg.database.QueryData("CREATE TABLE IF NOT EXISTS Cart(Id INTEGER PRIMARY KEY AUTOINCREMENT, UserId INTEGER, FoodId INTEGER, Amount INTEGER, OrderId INTEGER)");
        StaticArg.database.QueryData("CREATE TABLE IF NOT EXISTS Orders(Id INTEGER PRIMARY KEY AUTOINCREMENT,UserId INTEGER, Status INTEGER, TotalPrice INTEGER)");

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