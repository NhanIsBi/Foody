package hcmute.nhom2.foody.FragmentCustom;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hcmute.nhom2.foody.R;


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

        return view;
    }
}