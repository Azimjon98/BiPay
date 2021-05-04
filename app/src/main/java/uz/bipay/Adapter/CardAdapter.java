package uz.bipay.Adapter;

import android.content.Context;
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

        public ImageView CardImage;
        public TextView CardName;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            CardImage = itemView.findViewById(R.id.cardImage);
            CardName =  itemView.findViewById(R.id.cardName);
        }
    }
    public CardAdapter( ArrayList<CardItem> cardList){
        this.CardList = cardList;

    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_items,parent,false);
        CardViewHolder cvh = new CardViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem currentItem = CardList.get(position);
        holder.CardImage.setImageResource(currentItem.getCardImage());
        holder.CardName.setText(currentItem.getCardName());
        holder.CardImage.setImageResource(CardList.get(position).getCardImage());
        holder.CardName.setText(CardList.get(position).getCardName());
    }

    @Override
    public int getItemCount() {
        return CardList.size();
    }
}
