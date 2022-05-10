package hcmute.nhom2.foody.FragmentCustom;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hcmute.nhom2.foody.Activity.LoginActivity;
import hcmute.nhom2.foody.Adapter.CartAdapter;
import hcmute.nhom2.foody.Adapter.FoodAdapter;
import hcmute.nhom2.foody.Adapter.RestaurantAdepter;
import hcmute.nhom2.foody.Model.Cart;
import hcmute.nhom2.foody.Model.Food;
import hcmute.nhom2.foody.Model.Restaurant;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;


public class CartFragment extends Fragment {
    private RecyclerView rcvCart;
    private TextView amountTotal,priceTotal;
    private ConstraintLayout checkOut;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cart, container, false);



        rcvCart = view.findViewById(R.id.rcvCart);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),1);
        rcvCart.setLayoutManager(gridLayoutManager);

        CartAdapter adapter=new CartAdapter(getActivity(), StaticArg.listCart);
        rcvCart.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //anhxa
        amountTotal=view.findViewById(R.id.totalFeeTxt);
        priceTotal=view.findViewById(R.id.totalTxt);
        checkOut=view.findViewById(R.id.CheckOut);
        updateCart();
        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckOut();
                Intent intent = new Intent(getActivity(), getActivity().getClass());
                startActivity(intent);
            }
        });
        return view;
    }

    public Double updateCart(){
        int amount = 0;
        double price=0;
        for(int i = 0;i<StaticArg.listCart.size();i++){
            Cart tmp = StaticArg.listCart.get(i);
            Cursor cursor = StaticArg.database.GetData("SELECT * FROM Food WHERE Id='"+tmp.getFoodId()+"'");
            cursor.moveToNext();
            Double priceTmp = cursor.getDouble(3);

            amount += tmp.getAmount();
            price += (priceTmp*((double)tmp.getAmount()));
        }
        amountTotal.setText(amount+"");
        priceTotal.setText("$"+(price+2));
        return price+2;
    }
    public void CheckOut(){
        if(StaticArg.user!=null && StaticArg.user.getId()!=-1){
            if(StaticArg.listCart.size()==0){
                Toast.makeText(getActivity(), "Chưa có đơn hàng", Toast.LENGTH_SHORT).show();
            }else {
                int orderId = StaticArg.database.Insert_Order(0, updateCart());
                for (int i = 0; i < StaticArg.listCart.size(); i++) {
                    Cart tmp = StaticArg.listCart.get(i);
                    StaticArg.database.Insert_Cart(tmp.getFoodId(), tmp.getAmount(), orderId);
                }
//            for(int i = 0; i< StaticArg.listCart.size();){
//                StaticArg.listCart.remove(0);
//            }
                StaticArg.listCart = new ArrayList<>();
                Toast.makeText(getActivity(), "Đã xuất đơn hàng", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(getActivity(), "Bạn chưa đăng nhập", Toast.LENGTH_SHORT).show();
        }
    }
}
