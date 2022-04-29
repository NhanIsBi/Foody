package hcmute.nhom2.foody;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import hcmute.nhom2.foody.Adapter.RestaurantAdepter;


public class HomeActivity extends AppCompatActivity {
    private RecyclerView rcvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rcvRes=findViewById(R.id.rcvRes);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rcvRes.setLayoutManager(gridLayoutManager);

        RestaurantAdepter adepter=new RestaurantAdepter(this,getListRestaurant());
        rcvRes.setAdapter(adepter);

    }

    private List<Restaurant> getListRestaurant() {
        List<Restaurant> list=new ArrayList<>();
        list.add(new Restaurant(R.drawable.images,"Phở",Restaurant.TYPE_FOOD));
        list.add(new Restaurant(R.drawable.restaurant1,"Phở1",Restaurant.TYPE_FOOD));
        list.add(new Restaurant(R.drawable.restaurant2,"Phở2",Restaurant.TYPE_FOOD));
        list.add(new Restaurant(R.drawable.restaurant3,"Phở3",Restaurant.TYPE_FOOD));
        list.add(new Restaurant(R.drawable.restaurant4,"Phở4",Restaurant.TYPE_FOOD));
        list.add(new Restaurant(R.drawable.restaurant5,"Phở5",Restaurant.TYPE_FOOD));
        list.add(new Restaurant(R.drawable.restaurant6,"Phở6",Restaurant.TYPE_FOOD));
        list.add(new Restaurant(R.drawable.restaurant16,"Phở7",Restaurant.TYPE_FOOD));
        list.add(new Restaurant(R.drawable.restaurant17,"Phở8",Restaurant.TYPE_FOOD));
        list.add(new Restaurant(R.drawable.restaurant18,"Phở9",Restaurant.TYPE_FOOD));

        list.add(new Restaurant(R.drawable.lotteria,"Drink1",Restaurant.TYPE_DRINK));
        list.add(new Restaurant(R.drawable.restaurant10,"Drink2",Restaurant.TYPE_DRINK));
        list.add(new Restaurant(R.drawable.restaurant7,"Drink3",Restaurant.TYPE_DRINK));
        list.add(new Restaurant(R.drawable.restaurant8,"Drink4",Restaurant.TYPE_DRINK));
        list.add(new Restaurant(R.drawable.restaurant9,"Drink5",Restaurant.TYPE_DRINK));
        list.add(new Restaurant(R.drawable.restaurant11,"Drink6",Restaurant.TYPE_DRINK));
        list.add(new Restaurant(R.drawable.restaurant12,"Drink7",Restaurant.TYPE_DRINK));
        list.add(new Restaurant(R.drawable.restaurant13,"Drink8",Restaurant.TYPE_DRINK));
        list.add(new Restaurant(R.drawable.restaurant14,"Drink9",Restaurant.TYPE_DRINK));
        list.add(new Restaurant(R.drawable.restaurant15,"Drink10",Restaurant.TYPE_DRINK));

        return list;
    }
}