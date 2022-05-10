package hcmute.nhom2.foody.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        btn1=(Button) findViewById(R.id.btnBackListFood);
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



        rcvRes=findViewById(R.id.rcvFood);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rcvRes.setLayoutManager(gridLayoutManager);

        FoodAdapter adepter=new FoodAdapter(this,getListFood());
        rcvRes.setAdapter(adepter);
        adepter.notifyDataSetChanged();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FoodActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
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