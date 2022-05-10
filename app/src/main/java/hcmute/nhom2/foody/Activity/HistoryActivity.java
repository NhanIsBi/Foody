package hcmute.nhom2.foody.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import hcmute.nhom2.foody.Adapter.OrderAdapter;
import hcmute.nhom2.foody.Adapter.RestaurantAdepter;
import hcmute.nhom2.foody.Model.Food;
import hcmute.nhom2.foody.Model.Order;
import hcmute.nhom2.foody.Model.Restaurant;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;

public class HistoryActivity extends AppCompatActivity {
    Button btnBack;
    private RecyclerView rcvHisOrder;
    List<Order> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        rcvHisOrder=findViewById(R.id.rcvHisOrder);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
        rcvHisOrder.setLayoutManager(gridLayoutManager);

        OrderAdapter adepter=new OrderAdapter(this,getListOrder());
        rcvHisOrder.setAdapter(adepter);
        adepter.notifyDataSetChanged();
    }
    private List<Order> getListOrder() {
        list=new ArrayList<>();
        Cursor cursor = StaticArg.database.GetData("SELECT * FROM Orders WHERE UserId='"+StaticArg.user.getId()+"'");
        while (cursor.moveToNext()){
            list.add(new Order(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    cursor.getDouble(4)
            ));
        }
        return list;
    }
}