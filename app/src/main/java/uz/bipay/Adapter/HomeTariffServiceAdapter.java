package uz.bipay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import uz.bipay.R;
import uz.bipay.data.model.PaymentServiceModel;
import uz.bipay.data.model.ReserveServiceModel;

public class HomeTariffServiceAdapter extends RecyclerView.Adapter<HomeTariffServiceAdapter.HomeCardTariffViewHolder> {

    private final ArrayList<PaymentServiceModel> homeCardTariffList;
    Context context;
    public HomeTariffServiceAdapter(Context context,ArrayList<PaymentServiceModel> homeCardTariffList) {
        this.context = context;
        this.homeCardTariffList = homeCardTariffList;
    }
    public void addItems(@NotNull List<PaymentServiceModel> items) {
        homeCardTariffList.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeCardTariffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reserve_cards,parent,false);
        HomeCardTariffViewHolder hctvh = new HomeCardTariffViewHolder(view);
        return hctvh;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeCardTariffViewHolder holder, int position) {
        PaymentServiceModel currentItem = homeCardTariffList.get(position);
        holder.onBind(currentItem);
    }


    @Override
    public int getItemCount() {
        return homeCardTariffList.size();
    }

     class HomeCardTariffViewHolder extends RecyclerView.ViewHolder {

         ImageView homeReserveCardImage;
         TextView  homeReserveCardName,homeReserveMoney;

         public HomeCardTariffViewHolder (@NonNull View itemView){
             super(itemView);
             homeReserveCardImage = itemView.findViewById(R.id.reservedCardImage);
             homeReserveCardName = itemView.findViewById(R.id.reservedCardName);
             homeReserveMoney = itemView.findViewById(R.id.reservedMoney);

             }
        public void onBind(PaymentServiceModel model) {
            Glide.with(itemView.getContext())
                    .load(model.getLogo())
                    .into(homeReserveCardImage);
            homeReserveCardName.setText(model.getName());
            homeReserveMoney.setText(String.valueOf(model.getReserve()));
        }
    }
}
