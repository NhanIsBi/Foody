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

import hcmute.nhom2.foody.Food;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Activity.ShowDetailActivity;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder>{
    private List<Food> listFood;
    private Context mcontext;
    public FoodAdapter(Context context, List<Food> listFood) {
        this.mcontext=context;
        this.listFood = listFood;
    }

    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        return new FoodHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        Food food=listFood.get(position);
        if(food==null){
            return;
        }
        holder.imgfood.setImageResource(food.getImage());
        holder.namefood.setText(food.getName());
        holder.pricefood.setText(food.getPrice());

        holder.layoutItemFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clickItemRestaurant.onClickItemRestaurent(res);
                onClickGoToDetail(food);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listFood!=null){
            return listFood.size();
        }
        return 0;
    }
    private void onClickGoToDetail(Food food){
        Intent intent=new Intent(mcontext, ShowDetailActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("object_Food", food);
        intent.putExtras(bundle);
        mcontext.startActivity(intent);
    }
    public class FoodHolder extends RecyclerView.ViewHolder{
        private RelativeLayout layoutItemFood;
        private ImageView imgfood;
        private TextView namefood;
        private TextView pricefood;
        public FoodHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemFood=itemView.findViewById(R.id.layout_item_food);
            imgfood=itemView.findViewById(R.id.imgF1);
            namefood=itemView.findViewById(R.id.textviewF1);
            pricefood=itemView.findViewById(R.id.textviewF2);
        }
    }
}
