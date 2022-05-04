package hcmute.nhom2.foody.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import hcmute.nhom2.foody.Adapter.RestaurantAdepter;
import hcmute.nhom2.foody.FragmentCustom.HomeFragment;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Model.Restaurant;
import hcmute.nhom2.foody.Static.StaticArg;


public class HomeActivity extends AppCompatActivity {
    private RecyclerView rcvRes;
    List<Restaurant> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rcvRes=findViewById(R.id.rcvRes);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rcvRes.setLayoutManager(gridLayoutManager);

        RestaurantAdepter adepter=new RestaurantAdepter(this,R.layout.activity_add_restaurant,getListRestaurant());
        rcvRes.setAdapter(adepter);
        adepter.notifyDataSetChanged();

    }

    private List<Restaurant> getListRestaurant() {
        list=new ArrayList<>();
        Cursor cursor = StaticArg.database.GetData("SELECT * FROM QuanAn");
        while (cursor.moveToNext()){
            list.add(new Restaurant(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getBlob(2)
            ));
        }
        return list;
    }
}