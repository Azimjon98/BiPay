package uz.bipay.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.bipay.R;
import uz.bipay.recyclerView.ReserveCardItem;

public class ReserveCardAdapter extends RecyclerView.Adapter<ReserveCardAdapter.ReserveCardViewHolder> {
    private final ArrayList<ReserveCardItem> ReserveCardList;

    public static class ReserveCardViewHolder extends RecyclerView.ViewHolder{

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
                    Navigation.findNavController(itemView).navigate(R.id.homeFragment_to_exchangeFragment);
                }
            });
        }
    }

    public ReserveCardAdapter(ArrayList<ReserveCardItem> reserveCardList){
            this.ReserveCardList = reserveCardList;
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
        ReserveCardItem currentItem = ReserveCardList.get(position);

        holder.reserveCardImage.setImageResource(currentItem.getReserveCardImage());
        holder.reserveCardName.setText(currentItem.getReserveCardName());
        holder.reserveMoney.setText(currentItem.getReserveMoney());
    }

    @Override
    public int getItemCount() {
        return ReserveCardList.size();
    }
}
