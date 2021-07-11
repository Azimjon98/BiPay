package uz.bipay.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import uz.bipay.R;
import uz.bipay.data.model.ReserveServiceModel;
import uz.bipay.recyclerView.ReserveCardItem;

public class ReserveCardAdapter extends RecyclerView.Adapter<ReserveCardAdapter.ReserveCardViewHolder> {
    private final ArrayList<ReserveServiceModel> reserveCardList;
    Context context;

    public ReserveCardAdapter(Context context,ArrayList<ReserveServiceModel> reserveCardList){
        this.context = context;
        this.reserveCardList = reserveCardList;
    }

    public void addItems (@NotNull List<ReserveServiceModel> items){
        reserveCardList.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ReserveCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.reserve_cards,parent,false);
        ReserveCardViewHolder cvh = new ReserveCardViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ReserveCardViewHolder holder, int position) {
        ReserveServiceModel currentItem = reserveCardList.get(position);

        holder.onBind(currentItem);

    }

    @Override
    public int getItemCount() {
        return reserveCardList.size();
    }

    class ReserveCardViewHolder extends RecyclerView.ViewHolder{

        public ImageView reserveCardImage;
        public TextView reserveCardName,reserveMoney;

        public ReserveCardViewHolder(@NonNull View itemView) {
            super(itemView);
            reserveCardImage = itemView.findViewById(R.id.reservedCardImage);
            reserveCardName = itemView.findViewById(R.id.reservedCardName);
            reserveMoney = itemView.findViewById(R.id.reservedMoney);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("id",reserveCardList.get(getAdapterPosition()).getToPaymentId());
                    bundle.putString("paymentName",reserveCardList.get(getAdapterPosition()).getToPaymentName());
                    bundle.putString("toLogo",reserveCardList.get(getAdapterPosition()).getToLogo());
                    bundle.putInt("reserveMoney",reserveCardList.get(getAdapterPosition()).getReserve());
                    Navigation.findNavController(itemView).navigate(R.id.,bundle);
                }
            });
        }

        public void onBind(ReserveServiceModel model) {
            Glide.with(itemView.getContext())
                    .load(model.getToLogo())
                    .into(reserveCardImage);
            reserveCardName.setText(model.getToPaymentName());
            reserveMoney.setText(String.valueOf(model.getReserve()));
        }
    }


}
