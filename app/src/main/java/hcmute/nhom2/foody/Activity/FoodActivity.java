package hcmute.nhom2.foody.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hcmute.nhom2.foody.Adapter.FoodAdapter;
import hcmute.nhom2.foody.Model.Food;
import hcmute.nhom2.foody.Model.Restaurant;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;


public class FoodActivity extends AppCompatActivity {
    private RecyclerView rcvRes;
    List<Food> list;
    Restaurant restaurant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
            restaurant = StaticArg.currentRes;
        }else {
            restaurant = (Restaurant) bundle.get("object_Restaurant");
        }
        int prevRes = -1;
        if(StaticArg.currentRes != null)
            prevRes = StaticArg.currentRes.getId();
        StaticArg.currentRes = restaurant;
        if(prevRes == StaticArg.currentRes.getId())
            StaticArg.isNew = false;
        else
            StaticArg.isNew = true;
        Log.d("AAAA: ", StaticArg.isNew+"    "+StaticArg.currentRes.getId()+"    "+prevRes);
        rcvRes=findViewById(R.id.rcvRes);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rcvRes.setLayoutManager(gridLayoutManager);

        FoodAdapter adepter=new FoodAdapter(this,getListFood());
        rcvRes.setAdapter(adepter);
        adepter.notifyDataSetChanged();
    }

    private List<Food> getListFood() {
        list=new ArrayList<>();
        Cursor cursor = StaticArg.database.GetData("SELECT * FROM Food WHERE ResId='"+restaurant.getId()+"'");
        while (cursor.moveToNext()){
            list.add(new Food(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getBlob(4)
            ));
        }
        return list;
    }
}