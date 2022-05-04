package hcmute.nhom2.foody.FragmentCustom;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import hcmute.nhom2.foody.Activity.AddRestaurantActivity;
import hcmute.nhom2.foody.Activity.HomeActivity;
import hcmute.nhom2.foody.Model.Database;
import hcmute.nhom2.foody.R;

public class HomeFragment extends Fragment {

    ImageView image1,image2;
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
        return view;
    }


}