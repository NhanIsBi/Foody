package hcmute.nhom2.foody.FragmentCustom;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hcmute.nhom2.foody.Activity.LoginActivity;
import hcmute.nhom2.foody.Activity.MainActivity;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;


public class AccountFragment extends Fragment {


    Button buttonGoLogin,btnLogOut;

    public AccountFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);
        buttonGoLogin = view.findViewById(R.id.btnGoLogin);
        btnLogOut = view.findViewById(R.id.btnLogOut);

        if(StaticArg.user != null) {
            buttonGoLogin.setVisibility(View.INVISIBLE);
            btnLogOut.setVisibility(View.VISIBLE);
        }
        else {
            buttonGoLogin.setVisibility(View.VISIBLE);
            btnLogOut.setVisibility(View.INVISIBLE);
        }
        buttonGoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StaticArg.user=null;
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}