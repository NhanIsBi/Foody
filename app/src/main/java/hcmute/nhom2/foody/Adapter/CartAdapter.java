package hcmute.nhom2.foody.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.nhom2.foody.Model.Cart;
import hcmute.nhom2.foody.Model.Food;
import hcmute.nhom2.foody.Model.Restaurant;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {
    private List<Cart> listCart;
    private Context mcontext;
    public CartAdapter(Context context,List<Cart> listCart) {
        this.mcontext = context;
        this.listCart = listCart;
    }

    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
        return new CartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder holder, int position) {
        Cart cart=listCart.get(position);

        if(cart==null){
            return;
        }
        Cursor cursor = StaticArg.database.GetData("SELECT * FROM Food WHERE Id='"+cart.getFoodId()+"'");
        cursor.moveToNext();
        Food tmp =  new Food(
                cursor.getInt(0),
                cursor.getInt(1),
                cursor.getString(2),
                cursor.getDouble(3),
                cursor.getBlob(4));
        holder.name.setText(tmp.getName());
        holder.price.setText("$"+tmp.getPrice());
        holder.amount.setText(cart.getAmount()+"");
        holder.total.setText("$"+cart.getAmount()*tmp.getPrice());

        byte[] hinhanh=tmp.getImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
        holder.image.setImageBitmap(bitmap);

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(holder.amount.getText().toString());
                num++;
                holder.amount.setText(num+"");
                holder.total.setText("$"+((double)num)*tmp.getPrice()+"");
                cart.setAmount(num);
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(holder.amount.getText().toString());
                num--;
                if(num<1)
                    num=1;
                holder.amount.setText(num+"");
                holder.total.setText("$"+((double)num)*tmp.getPrice()+"");
                cart.setAmount(num);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listCart!=null){
            return listCart.size();
        }
        return 0;
    }

    public class CartHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout layoutItemCart;
        private TextView name;
        private TextView price;
        private TextView amount;
        private TextView total;
        private ImageView image,plus,minus;

        public CartHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemCart = itemView.findViewById(R.id.layout_item_cart);
            name=layoutItemCart.findViewById(R.id.titleFood);
            price=layoutItemCart.findViewById(R.id.feeEachItem);
            amount=layoutItemCart.findViewById(R.id.numberItemTxt);
            total=layoutItemCart.findViewById(R.id.totalEachItem);
            image=layoutItemCart.findViewById(R.id.pic);
            plus=layoutItemCart.findViewById(R.id.plusCardBtn);
            minus=layoutItemCart.findViewById(R.id.minusCardBtn);
        }
    }
}
