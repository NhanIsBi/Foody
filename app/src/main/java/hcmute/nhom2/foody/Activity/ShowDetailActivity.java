package hcmute.nhom2.foody.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hcmute.nhom2.foody.Food;
import hcmute.nhom2.foody.R;

public class ShowDetailActivity extends AppCompatActivity {

    Button btn1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
            return;
        }
        Food food= (Food) bundle.get("object_Food");
        TextView txtname=findViewById(R.id.titleTxt1);
        txtname.setText(food.getName());
        TextView txtprice=findViewById(R.id.priceTxt);
        txtprice.setText(food.getPrice());
        ImageView imgfood=findViewById(R.id.foodPic);
        imgfood.setImageResource(food.getImage());

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn1=findViewById(R.id.btnBack1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDetailActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });
    }
}
