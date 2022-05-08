package hcmute.nhom2.foody.FragmentCustom;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import hcmute.nhom2.foody.Activity.AddFoodActivity;
import hcmute.nhom2.foody.Activity.AddRestaurantActivity;
import hcmute.nhom2.foody.Activity.HomeActivity;
import hcmute.nhom2.foody.Model.Database;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;

public class HomeFragment extends Fragment {

    ImageView image1,image2,image3;
    ConstraintLayout layoutAddRes,layoutAddFood;
    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        image1 = view.findViewById(R.id.pic);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }
        });

        image2 = view.findViewById(R.id.pic1);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddRestaurantActivity.class);
                startActivity(intent);
            }
        });

        image3 = view.findViewById(R.id.pic2);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddFoodActivity.class);
                startActivity(intent);
            }
        });

        layoutAddRes=view.findViewById(R.id.parentAddRes);
        layoutAddFood=view.findViewById(R.id.parentAddFood);
        if(StaticArg.user==null||StaticArg.user.id!=-1){
            layoutAddRes.setVisibility(View.INVISIBLE);
            layoutAddFood.setVisibility(View.INVISIBLE);
        }
        return view;
    }


}