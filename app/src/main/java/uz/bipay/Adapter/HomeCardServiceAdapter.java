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
import uz.bipay.data.model.PaymentServiceModel;

public class HomeCardServiceAdapter extends RecyclerView.Adapter<HomeCardServiceAdapter.CardViewHolder> {
    Context context;
    //CardItem emas PaymentServiceModel qilsan arraylistni ichidami paymentservicemodel? ha
    private final ArrayList<PaymentServiceModel> cardList;

    private ImageView recycleImage;


    public HomeCardServiceAdapter(Context context, ArrayList<PaymentServiceModel> paymentServiceModels) {
        this.context = context;
        cardList = paymentServiceModels;

    }



    public void addItems(@NotNull List<PaymentServiceModel> items) {
        cardList.addAll(items);
        notifyDataSetChanged();
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
        PaymentServiceModel currentItem = cardList.get(position);
        //view ga data berish viewholder ni ichida qilish kere
        holder.onBind(currentItem);
    }

    //item qushadigan metod bulishi kerak serverdan malumot keganda


    @Override
    public int getItemCount() {
        return cardList.size();
    }

    //bu nimaga
    public interface OnItemClickListener {
        public void onItemClick(int position);
    }

    //Keyin ichki klasslar oxirida bulishi kerak eng pastda
    class CardViewHolder extends RecyclerView.ViewHolder{

        public ImageView cardImage;
        public TextView cardName;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImage = itemView.findViewById(R.id.cardImage);
            cardName =  itemView.findViewById(R.id.cardName);
            //itemview ga emas cardview ga click listener qil hozr cardimage yoki cardname bosa reserveFragmentga utadida
            //keyin id sini ham yuborishing kerak Johon ham suragandiku bir bundle qilib
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("id",cardList.get(getAdapterPosition()).getId());
                    bundle.putString("logo",cardList.get(getAdapterPosition()).getLogo());
                    bundle.putString("name",cardList.get(getAdapterPosition()).getName());
                    Navigation.findNavController(itemView).navigate(R.id.homeFragment_to_reserveFragment,bundle);
                }
            });

        }
//
        public void onBind(PaymentServiceModel model){
            //uzgaruvchilar birinhci harfi kichkina buladi
            //bunda glide ni ishlatasan glide nima ga ishlatiladi urldan kelotgan narsani set qilib berishga ishlatiladimi?
            Glide.with(itemView.getContext())
                    .load(model.getLogo())
                    .into(cardImage);
            cardName.setText(model.getName());
        }

    }
}
