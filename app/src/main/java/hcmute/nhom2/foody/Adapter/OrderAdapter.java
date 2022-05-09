package hcmute.nhom2.foody.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hcmute.nhom2.foody.Activity.ShowDetailActivity;
import hcmute.nhom2.foody.Model.Cart;
import hcmute.nhom2.foody.Model.Food;
import hcmute.nhom2.foody.Model.Order;
import hcmute.nhom2.foody.Model.Restaurant;
import hcmute.nhom2.foody.R;
import hcmute.nhom2.foody.Static.StaticArg;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder>{
    private List<Cart> listCart;
    private List<Order> listorder;
    private Context mcontext;
    public OrderAdapter(Context context, List<Order> listorder) {
        this.mcontext=context;
        this.listorder = listorder;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_history,parent,false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        Order order=listorder.get(position);
        if(order==null){
            return;
        }
        listCart=new ArrayList<>();
        Cursor cursorCart = StaticArg.database.GetData("SELECT * FROM Cart WHERE UserId='"+StaticArg.user.getId()+"' and OrderId='"+order.getID()+"'");
        while (cursorCart.moveToNext()){
            listCart.add(new Cart(
                    cursorCart.getInt(0),
                    cursorCart.getInt(1),
                    cursorCart.getInt(2),
                    cursorCart.getInt(3),
                    cursorCart.getInt(4)
            ));
        }
        int amountTotal=0;
        for (int i=0;i<listCart.size();i++){
            amountTotal+=listCart.get(i).getAmount();
        }
        Cursor cursorRes = StaticArg.database.GetData("SELECT * FROM QuanAn WHERE Id='"+order.getResID()+"'");
        cursorRes.moveToNext();
        Restaurant restaurant=new Restaurant(
                    cursorRes.getInt(0),
                    cursorRes.getString(1),
                    cursorRes.getBlob(2));
        if(order.getStatus()==0 && StaticArg.user!=null){
            holder.Status.setText("Đang giao");
        }else{
            holder.Status.setText("Đã giao");
        }
        holder.nameRes.setText(restaurant.getName());
        holder.amountItem.setText(amountTotal+"");
        holder.totalPrice.setText(order.getPriceTotal()+"");

        byte[] hinhanh=restaurant.getImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(hinhanh,0,hinhanh.length);
        holder.imgRes.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        if(listorder!=null){
            return listorder.size();
        }
        return 0;
    }
    public class OrderHolder extends RecyclerView.ViewHolder{
        private ConstraintLayout layoutItemHis;
        private ImageView imgRes;
        private TextView nameRes,amountItem,totalPrice,Status;
        public OrderHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemHis=itemView.findViewById(R.id.layout_item_history);
            imgRes=itemView.findViewById(R.id.picRes);
            nameRes=itemView.findViewById(R.id.titleRes);
            amountItem=itemView.findViewById(R.id.amountItem);
            totalPrice=itemView.findViewById(R.id.totalPrice);
            Status=itemView.findViewById(R.id.Status);
        }
    }
}
