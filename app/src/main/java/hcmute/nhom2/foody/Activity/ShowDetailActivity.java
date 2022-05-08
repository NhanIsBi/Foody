package hcmute.nhom2.foody.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

import hcmute.nhom2.foody.Model.Cart;
import hcmute.nhom2.foody.Model.Food;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;

public class ShowDetailActivity extends AppCompatActivity {

    Button btn1;
    TextView addCart,txtname,txtprice,txtAmount,total;
    ImageView imgHinh,imgPlus,imgMinus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
            return;
        }
        //anhxa
        Food food= (Food) bundle.get("object_Food");
        txtname=findViewById(R.id.titleTxt1);
        txtprice=findViewById(R.id.priceTxt);
        total=findViewById(R.id.totalPriceTxt);
        txtAmount=findViewById(R.id.numberItemTxt);
        imgPlus =findViewById(R.id.plusCardBtn);
        imgMinus=findViewById(R.id.minusCardBtn);
        imgHinh= findViewById(R.id.foodPic);
        btn1=findViewById(R.id.btnBack1);
        addCart=findViewById(R.id.addToCartBtn);
        txtname.setText(food.getName());
        txtprice.setText(String.valueOf(food.getPrice()));
        byte[] hinhanh=food.getImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
        imgHinh.setImageBitmap(bitmap);

        imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(txtAmount.getText().toString());
                num++;
                txtAmount.setText(num+"");
                total.setText(num*food.getPrice()+"");
            }
        });

        imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(txtAmount.getText().toString());
                num--;
                if(num<1)
                    num=1;
                txtAmount.setText(num+"");
                total.setText(num*food.getPrice()+"");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDetailActivity.this, FoodActivity.class);
                startActivity(intent);
            }
        });


        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(StaticArg.user!=null && StaticArg.user.getId()!=-1){
                    Cart cart = new Cart(0, StaticArg.user.getId(), food.getId(), Integer.parseInt(txtAmount.getText().toString().trim()),0);
                    StaticArg.listCart.add(cart);
                    Toast.makeText(ShowDetailActivity.this,"Đã thêm",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ShowDetailActivity.this,"Bạn chưa đăng nhập",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
