package hcmute.nhom2.foody.FragmentCustom;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hcmute.nhom2.foody.Adapter.CartAdapter;
import hcmute.nhom2.foody.Adapter.FoodAdapter;
import hcmute.nhom2.foody.Model.Food;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;


public class CartFragment extends Fragment {
    private RecyclerView rcvCart;



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
        Log.d("AAAA: ", StaticArg.listCart.size()+"");
        CartAdapter adapter=new CartAdapter(getActivity(), StaticArg.listCart);
        rcvCart.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }


}