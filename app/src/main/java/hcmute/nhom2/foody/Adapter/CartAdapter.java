package hcmute.nhom2.foody.Adapter;

import android.content.Context;
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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {
    private List<Food> listFood;
    public CartAdapter(@NonNull Context context) {
        this.listFood = listFood;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
        return new CartAdapter.CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
//        Food food=listFood.get(position);
//        if(food==null){
//            return;
//        }
//        holder.imgfood.setImageResource(food.getImage());
//        holder.namefood.setText(food.getName());
//        holder.pricefood.setText(food.getPrice());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CartHolder extends RecyclerView.ViewHolder{
        private RelativeLayout layoutItemFood;
        private ImageView imgfood;
        private TextView namefood;
        private TextView pricefood;
        public CartHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemFood=itemView.findViewById(R.id.layout_item_food);
            imgfood=itemView.findViewById(R.id.imgF1);
            namefood=itemView.findViewById(R.id.textviewF1);
            pricefood=itemView.findViewById(R.id.textviewF2);
        }
    }
}
