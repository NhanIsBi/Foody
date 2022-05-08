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

import hcmute.nhom2.foody.Activity.ShowDetailActivity;
import hcmute.nhom2.foody.Model.Food;
import hcmute.nhom2.foody.Model.Order;
import hcmute.nhom2.foody.R;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder>{
    private List<Order> listOrder;
    private Context mcontext;
    public OrderAdapter(Context context, List<Order> listOrder) {
        this.mcontext=context;
        this.listOrder = listOrder;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(listOrder!=null){
            return listOrder.size();
        }
        return 0;
    }
    private void onClickGoToDetail(Food food){
        Intent intent=new Intent(mcontext, ShowDetailActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("object_Food",food);
        intent.putExtras(bundle);
        mcontext.startActivity(intent);
    }
    public class OrderHolder extends RecyclerView.ViewHolder{
        private RelativeLayout layoutItemFood;
        private ImageView imgfood;
        private TextView namefood;
        private TextView pricefood;
        public OrderHolder(@NonNull View itemView) {
            super(itemView);
            layoutItemFood=itemView.findViewById(R.id.layout_item_food);
            imgfood=itemView.findViewById(R.id.imgF1);
            namefood=itemView.findViewById(R.id.textviewF1);
            pricefood=itemView.findViewById(R.id.textviewF2);
        }
    }
}
