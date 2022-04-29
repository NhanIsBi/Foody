package hcmute.nhom2.foody;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import hcmute.nhom2.foody.FragmentCustom.CartFragment;
import hcmute.nhom2.foody.FragmentCustom.HomeFragment;
import hcmute.nhom2.foody.R;

public class ShowDetailActivity extends AppCompatActivity {
    ImageView image1,image2;
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

        image1 = findViewById(R.id.imageView5);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        image2 = findViewById(R.id.imageView7);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
