package uz.bipay.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.bipay.R;
import uz.bipay.recyclerView.CardItem;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private ArrayList<CardItem>CardList;
    public static class CardViewHolder extends RecyclerView.ViewHolder{

        public ImageView cardImage;
        public TextView cardName;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
            cardName =  itemView.findViewById(R.id.cardName);
        }
    }
    public CardAdapter(ArrayList<CardItem> cardList){
        CardList = cardList;
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_items,parent,false);
        CardViewHolder cvh = new CardViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem currentItem = CardList.get(position);
        holder.cardImage.setImageResource(currentItem.getCardImage());
        holder.cardName.setText(currentItem.getCardName());
    }

    @Override
    public int getItemCount() {
        return CardList.size();
    }
}
