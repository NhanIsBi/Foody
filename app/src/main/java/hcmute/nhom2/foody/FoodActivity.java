package hcmute.nhom2.foody;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hcmute.nhom2.foody.Adapter.FoodAdapter;


public class FoodActivity extends AppCompatActivity {
    private RecyclerView rcvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
            return;
        }
//        Food food= (Food) bundle.get("object_Restaurant");
//        TextView textname=findViewById(R.id.titleTxt1);
//        textname.setText(food.getName());

        rcvRes=findViewById(R.id.rcvRes);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rcvRes.setLayoutManager(gridLayoutManager);

        FoodAdapter adepter=new FoodAdapter(this,getListFood());
        rcvRes.setAdapter(adepter);

    }

    private List<Food> getListFood() {
        List<Food> list=new ArrayList<>();
        list.add(new Food(R.drawable.burger,"Buger1","15$",Food.TYPE_FOOD));
        list.add(new Food(R.drawable.food1,"món 2","5$",Food.TYPE_FOOD));
        list.add(new Food(R.drawable.food2,"món 3","1$",Food.TYPE_FOOD));
        list.add(new Food(R.drawable.food3,"món 4","4$",Food.TYPE_FOOD));
        list.add(new Food(R.drawable.food4,"món 5","7$",Food.TYPE_FOOD));

        list.add(new Food(R.drawable.drink1,"nước 1","11$",Food.TYPE_DRINK));
        list.add(new Food(R.drawable.drink4,"nước 2","9$",Food.TYPE_DRINK));
        list.add(new Food(R.drawable.drink8,"nước 3","15$",Food.TYPE_DRINK));
        list.add(new Food(R.drawable.drink9,"nước 4","5$",Food.TYPE_DRINK));
        list.add(new Food(R.drawable.drink11,"nước 5","13$",Food.TYPE_DRINK));

        return list;
    }
}