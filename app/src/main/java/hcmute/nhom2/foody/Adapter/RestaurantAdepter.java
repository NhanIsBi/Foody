package hcmute.nhom2.foody.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.nhom2.foody.FoodActivity;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Restaurant;

public class RestaurantAdepter extends RecyclerView.Adapter<RestaurantAdepter.RestaurantHolder>{
    private List<Restaurant> listRes;
    private Context mcontext;
    public RestaurantAdepter(Context context,List<Restaurant> listRes) {
        this.mcontext=context;
        this.listRes = listRes;
    }

    @NonNull
    @Override
    public RestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant,parent,false);
        return new RestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantHolder holder, int position) {
        Restaurant res=listRes.get(position);
        if(res==null){
            return;
        }
        holder.imgRes.setImageResource(res.getImage());
        holder.nameRes.setText(res.getName());

        holder.layoutItemRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clickItemRestaurant.onClickItemRestaurent(res);
                onClickGoToDetail(res);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listRes!=null){
            return listRes.size();
        }
        return 0;
    }
    private void onClickGoToDetail(Restaurant restaurant){
        Intent intent=new Intent(mcontext, FoodActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("object_Restaurant", restaurant);
        intent.putExtras(bundle);
        mcontext.startActivity(intent);
    }
    public class RestaurantHolder extends RecyclerView.ViewHolder{
        private RelativeLayout layoutItemRes;
        private ImageView imgRes;
        private TextView nameRes;
        public RestaurantHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemRes=itemView.findViewById(R.id.layout_item_res);
            imgRes=itemView.findViewById(R.id.img1);
            nameRes=itemView.findViewById(R.id.textview1);
        }
    }
}
